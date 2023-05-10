package Views;

import Model.Book;
import Model.BorrowBook;
import Model.Status;
import Service.BookService;
import Service.BorrowBookService;
import Utils.CSVUtils;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;

public class BookView {
    public List<Book> books;
    DecimalFormat format = new DecimalFormat("###,###,###" + "đ");
    Scanner scanner = new Scanner(System.in);
    Menu  menu = new Menu();
    BookService bookService = new BookService();
    BorrowBookService borrowBookService = new BorrowBookService();

    static String filename="data/borrowbook.csv";
    public static String path = "data/book.csv";
    public static String nameBook;
    public BookView(){}

    public void addBookByBoss(){
        int id = 0;
        boolean checkID = false;
        do {
            System.out.println("Nhập ID sách");
            System.out.println("=>");
            try {
                id = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("*** Vui lòng nhập số, không nhập ký tự ***");
                checkID = false;
            }
            if (id > 0) {
                if (bookService.exitsProductId(id)){
                    System.out.println("*** ID đã tồn tại ***");
                    checkID = false;
                } else {
                    checkID = true;
                }
            } else {
                System.out.println("*** ID phải lớn hơn 0 ***");
                checkID = false;
            }
        } while (!checkID);
        String name;
        while (true){
            System.out.println("Nhập tên sách");
            System.out.println("=>");
            String check = scanner.nextLine();
            if (bookService.exitsProductName(check)){
                System.out.println("*** Tên này đã tồn tại xin nhập tên khác ***");
            } else {
                name = check;
                break;
            }
        }
       int quantity;
        while (true){
            System.out.println("Nhập số lượng sách");
            System.out.println("=>");
            try {
                quantity = Integer.parseInt(scanner.nextLine());
                if (quantity > 0){
                    break;
                }
                System.out.println("*** Số lượng phải lớn 0 ***");
            } catch (Exception e) {
                System.out.println("*** Vui lòng nhập số, không nhập ký tự ***");
                System.out.println();
            }
        }
        System.out.println("Nhập loại sách");
        System.out.println("=>");
        String category = scanner.nextLine();

        System.out.println("Nhập mô tả sách");
        System.out.println("=>");
        String description = scanner.nextLine();

        System.out.println("Nhập tác giả");
        System.out.println("=>");
        String author = scanner.nextLine();

        System.out.println("Nhập công ty xuất bản");
        System.out.println("=>");
        String publishingCompany = scanner.nextLine();
        Status status = Status.INSTOCK;
        Book book = new Book(id,name,quantity,category,description,author, publishingCompany, status);
        bookService.add(book);
        System.out.println("----------------------------------");
        System.out.println("     Bạn đã thêm sách thành công  ");
        System.out.println("----------------------------------");
        menu.boss();
    }

    public void showBook(){
        List<Book> books = bookService.getBook();
        System.out.println("Danh sách ");
        System.out.println();
        System.out.println("\t\t\t\t=========================================================================================================================================================================================================");
        System.out.printf("\t\t\t\t\t%-10s %-25s %-15s %-20s %-55s %-25s %-25s %-25s\n","ID","Tên sách","Số Lượng","Loại","Mô Tả","Tác Giả","NXB","Trạng Thái");
        for (Book book : books){
            System.out.printf("\t\t\t\t\t%-10s %-25s %-15s %-20s %-55s %-25s %-25s %-25s\n", book.getId(), book.getBookName(),book.getQuantity(),
                    book.getCategory(),book.getDescription(),book.getAuthor(),book.getPublishingCompany(),book.getStatus());
        }
        System.out.println("\t\t\t\t======================================================================================================================================================================================================\n\n");
        menu.boss();
    }

    public void showBookBoss(){
        List<Book> books = bookService.getBook();
        System.out.println("Danh sách ");
        System.out.println();
        System.out.println("=======================================================================================================================================================================================================");
        System.out.printf("\t%-10s %-25s %-15s %-20s %-55s %-25s %-25s %-25s\n","ID","Tên sách","Số Lượng","Loại","Mô Tả","Tác Giả","NXB","Trạng Thái");
        System.out.println("");
        for (Book book : books){
            System.out.printf("\t%-10s %-25s %-15s %-20s %-55s %-25s %-25s %-25s\n", book.getId(), book.getBookName(),book.getQuantity(),
                    book.getCategory(),book.getDescription(),book.getAuthor(),book.getPublishingCompany(),book.getStatus());
        }
        System.out.println("=======================================================================================================================================================================================================\n\n");
        menu.boss();
    }

    public void showBookGuest(){
            List<Book> books = bookService.getBook();
            System.out.println("Danh sách ");
            System.out.println();
            System.out.println("\t\t\t=================================================================================================================================================");
            System.out.printf("\t\t\t\t%-10s %-25s %-15s %-20s %-25s %-25s %-25s\n","ID","Tên sách","Số Lượng","Loại","Tác Giả","NXB","Trạng Thái");
            System.out.println("");
            for (Book book : books){
                System.out.printf("\t\t\t\t%-10s %-25s %-15s %-20s %-25s %-25s %-25s\n", book.getId(), book.getBookName(),book.getQuantity(),
                        book.getCategory(),book.getAuthor(),book.getPublishingCompany(),book.getStatus());
            }
            System.out.println("\t\t\t==================================================================================================================================================\n\n");
        menu.guest();
    }

    public void findBookByNameBoss(){
        System.out.println("Nhập tên sách cần tìm");
        String name = scanner.nextLine().toUpperCase();
        boolean found = false;
        List<Book> b = bookService.getBook();
        System.out.println("Danh sách sách cần tìm");
        System.out.println("\t\t\t\t============================================================================================================\n");
        System.out.printf("\t\t\t\t\t%-10s %-25s %-25s %-25s %-25s", "ID","Tên Sách","Tác Giả","NXB","Trạng Thái");
        System.out.println("");
        for (Book book: b){
            if (book.getBookName().toUpperCase().contains(name)){
                System.out.println("");
                System.out.printf("\t\t\t\t\t%-10s %-25s %-25s %-25s %-25s\n",book.getId(),book.getBookName(),book.getAuthor(),book.getPublishingCompany(),book.getStatus());
            found = true;
            }
        }
        if (!found){
            System.out.println("*** Không tìm thấy tên sách này ***");
        }
        System.out.printf("\t\t\t\t============================================================================================================\n");
        menu.boss();
    }

    public void findBookByNameGuest(){
        System.out.println("Nhập tên sách cần tìm");
        String name = scanner.nextLine().toUpperCase();
        boolean found = false;
        List<Book> b = bookService.getBook();
        System.out.println("Danh sách sách cần tìm");
        System.out.println("========================================================================================================================");
        System.out.printf("\t\t%-10s %-25s %-25s %-25s %-25s","ID","Tên Sách","NXB","Tác Giả","Trạng Thái");
        System.out.println("");
        for (Book book : b) {
            if (book.getBookName().toUpperCase().contains(name)) {
                System.out.println("");
                System.out.printf("\t\t%-10s %-25s %-25s %-25s %-25s", book.getId(), book.getBookName(), book.getPublishingCompany(), book.getAuthor(),book.getStatus());
                found = true;
            }
        }

        System.out.println("\t\t\t\t\n========================================================================================================================\n");
        if (!found) {
            System.out.println("*** Không tìm thấy tên sách này ***");
            System.out.println("");
        }
        menu.guest();
    }

    public void updateBook(){
    int id = 0;
    Book update = null;
    while (true){
        System.out.println("Nhập ID sách mới");
        System.out.println("=>");
        try {
            id = Integer.parseInt(scanner.nextLine());
            if (id > 0){
                if (bookService.exitsProduct(id)){
                    update = bookService.findProductByID(id);
                    break;
                } else {
                    System.out.println("*** ID này không tồn tại ***");
                    break;
                }
            } else {
                System.out.println("*** ID phải lớn hơn 0 ***");
                System.out.println();
            }
            }catch (Exception e){
            System.out.println("*** ID phải là 1 số ***");
            System.out.println();
        }
        }
    boolean action = true;
    while (action){
        System.out.println("Nhâp tên sách cần sửa");
        System.out.println("=>");
        String name = scanner.nextLine();
        if (!name.equals("-1")){
            if (bookService.exitsProductName(name)){
                System.out.println("*** Tên này đã tồn tại, xin hãy nhập tên khác ***");
            } else {
                update.setBookName(name);
            }
        } else
            break;
        action = false;
    }


    while (true){
        System.out.println("Nhập số lượng sách");
        System.out.println("=>");
        try {
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!(quantity == -1)){
                if (quantity >=0){
                update.setQuantity(quantity);
                break;
            }
            System.out.println("*** Số lượng phải lớn hơn 0 ***");
            System.out.println();
        } else {
                break;
            }
            }catch (Exception e) {
            System.out.println("*** Số lượng phai là 1 số ***");
        }
    }

    while (true){
        System.out.println("Nhập loại");
        System.out.println("=>");
        String category = scanner.nextLine();
        if (!category.equals("-1")){
            update.setCategory(category);
            break;
        } else
            break;
    }


    while (true){
        System.out.println("Nhập tác giả");
        System.out.println("=>");
        String author = scanner.nextLine();
        if (!author.equals("-1")){
            update.setAuthor(author);
            break;
        } else
            break;
    }

    while (true){
        System.out.println("Nhập mô tả");
        System.out.println("=>");
        String description = scanner.nextLine();
        if (!description.equals("-1")){
            update.setDescription(description);
            break;
        } else
            break;
    }


    while (true){
        System.out.println("Nhập NXB");
        System.out.println("=>");
        String publishingCompany = scanner.nextLine();
        if (!publishingCompany.equals("-1")){
            update.setPublishingCompany(publishingCompany);
            break;
        } else
            break;
    }
    bookService.update(id,update);
        System.out.println("--------------------------------------------");
        System.out.println("         Bạn đã cập nhật thành công         ");
        System.out.println("--------------------------------------------");
        bookService.checkExits();
        menu.boss();
    }


//    public void setStatus(){
//        Book book = null;
//        System.out.println("====== SET STATUS =====");
//        System.out.println("|     1. INSTOCK      |");
//        System.out.println("|     2. OUT OF STOCK |");
//        System.out.println("=======================");
//        int options;
//        do {
//            System.out.println("Chọn Status");
//            try {
//                options = Integer.parseInt(scanner.nextLine());
//                switch (options){
//                    case 1:
//                        book.setStatus(Status.INSTOCK);
//                        continue;
//                    case 2:
//                        book.setStatus(Status.OUTSTOCK);
//                        continue;
//                    default:
//                        System.out.println("*** Nhập sai, vui lòng nhập lại ***");
//                        setStatus();
//                }
//            } catch (Exception e){
//                System.out.println("*** Lựa chọn phải là 1 số ***");
//                setStatus();
//
//            }
//        }while (true);
//    }
    public void deleteById(){
        boolean checkID= false;
        int id = 0;
        do {
            System.out.println("Nhập ID mà bạn muốn xoá");
            System.out.println("=>");
            try {
                id = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("*** ID là 1 số ***");
                id = 0;
                continue;
            }
            boolean checkIdAvaible = bookService.exitsProduct(id);
            if (checkIdAvaible){
                bookService.deleteBookByID(id);
                System.out.println("*** Đã xoá thành công ***");
                showBook();
                checkID = true;
            } else {
                System.out.println("*** Không tìm thấy id, vui lòng nhập lại ***");
                checkID = false;
            }
        }
        while (!checkID);
    }
    //mượn sách theo id
    public void borrowBook() {
        int id = 0;
        do {
            System.out.println("Nhập id sách mượn");
            try {
                id = Integer.parseInt(scanner.nextLine());
                List<Book> books = bookService.getBook();
                for(Book book : books){
                    if(book.getId() == id){
                         nameBook = book.getBookName();
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("*** Nhập số, không được nhập ký tự ***");
                continue;
            }
            if (id < 0) {
                System.out.println("*** ID phải lớn hơn 0 ***");
                continue;
            }
            if (!bookService.exitsProductId(id)) {
                System.out.println("*** ID này ko tồn tại ***");
            }
        }

        while (!bookService.exitsProductId(id));
        String name = "";
        boolean isValidName = false;
        do {
            System.out.println("Nhập tên người mượn");
            name = scanner.nextLine();
            if (name.matches("[a-zA-Z]+") && !name.matches(".*\\d.*")) {
                isValidName = true;
            } else {
                System.out.println("Tên không hợp lệ vui lòng nhập lại");
            }
        } while (!isValidName);

        int quantity = 0;
        do {
            System.out.println("Nhập số lượng mượn");
            try {
                quantity = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("*** Nhập số, không được nhập ký tự ***");
                continue;
            }
            if (quantity < 0) {
                System.out.println("*** Số lượng phải lớn hơn 0 ***");
                continue;
            }
            if (!bookService.getQuantity(id, quantity)) {
                System.out.println("*** Số lượng này không tồn tại ***");
                continue;
            }
            break;
        }
        while (true);

        int date = 0;
        do {
            System.out.println("Nhập số ngày mượn");
            try {
                date = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("*** Nhập số, không được nhập ký tự ***");
                continue;
            }
            if (date < 0) {
                System.out.println("*** Ngày không được nhỏ hơn 0 ***");
                continue;
            }
            break;
        } while (true);

        borrowBookService.borrowBook(id, quantity, name, date,nameBook);
        System.out.println("--- Đã mượn sách thành công ---");
        List<BorrowBook> b = borrowBookService.getBorrowBook();
        List<Book> books = bookService.getBook();
        System.out.println("\t========================================================================================================================================");
        System.out.printf("\t\t%-10s %-25s %-25s %-25s %-25s %-25s ", "ID", "Số lượng", "Tên sách", "Tên", "Ngày mượn", "Ngày trả");
        System.out.println("");
        for (BorrowBook borrowBook : b) {
            for (Book book : books) {
                if (book.getId() == id) {
                    System.out.printf("\t\t%-10s %-25s %-25s %-25s %-25s %-25s\n", borrowBook.getId(), borrowBook.getBookid(), borrowBook.getNameBook(), borrowBook.getName(), borrowBook.getBorrowdate(), borrowBook.getExpDate());
                }
            }
        }
        System.out.println("\t========================================================================================================================================");
        CSVUtils.write(filename, b);
        CSVUtils.write(path, books);
        menu.guest();
    }

    public void showborrowBook(){
        List<BorrowBook> b = borrowBookService.getBorrowBook();
        List<Book> books = bookService.getBook();
        System.out.println("Danh sách hiển thị");
        System.out.println("\t=================================================================================================================");
        System.out.printf("\t\t%-10s %-25s %-25s %-25s %-25s ","ID","Số lượng","Tên sách","Ngày mượn","Ngày trả");
        System.out.println("");
        for (BorrowBook borrowBook: b){

               System.out.printf("\t\t%-10s %-25s %-25s %-25s %-25s\n", borrowBook.getId(), borrowBook.getBookid(),borrowBook.getName(), borrowBook.getBorrowdate(), borrowBook.getExpDate());

        }
        System.out.println("\t==================================================================================================================");
        menu.guest();
    }

//    trả sách theo id
    public void returnBook(){
        int id =0;
        do {
            System.out.println("Nhập id sách mượn");
            try {
                id = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e){
                System.out.println("*** Nhập số, không được nhập ký tự ***");
                continue;
            }
            if (id < 0){
                System.out.println("*** ID phải lớn hơn 0 ***");
                continue;
            }
            if (!bookService.exitsProductId(id)){
                System.out.println("*** ID này ko tồn tại ***");
            }
        }
        while (!bookService.exitsProductId(id));
        List<BorrowBook> borrowBookList = new ArrayList<>();
        List<BorrowBook> b = borrowBookService.getBorrowBook();
        List<Book> books = bookService.getBook();
        System.out.println("--- Đã trả sách thành công ---");
        System.out.println("\t========================================================================================================================");
        System.out.printf("\t\t%-10s %-25s %-25s %-25s %-25s ","ID","Số lượng","Tên sách","Tên","Ngày trả");
        System.out.println("");
        for (BorrowBook borrowBook: b){
            for (Book book :books){
                if (book.getId()==id){
                    System.out.printf("\t\t%-10s %-25s %-25s %-25s %-25s\n",borrowBook.getId(), borrowBook.getBookid(),book.getBookName(),borrowBook.getName(), borrowBook.getExpDate());
                }}
        }
        System.out.println("\t=========================================================================================================================");
        int quantity = 0;
        for (BorrowBook returnBook1: b){
                if (returnBook1.getId()==id){
                    quantity = returnBook1.getBookid();
                }else {
                    borrowBookList.add(returnBook1);
                }
        }
        for (Book book1 : books){
            if (book1.getId()== id){
                book1.setQuantity(quantity + book1.getQuantity());
            }
        }
        CSVUtils.write(filename,borrowBookList);
        CSVUtils.write(path,books);
        menu.guest();
    }
}
