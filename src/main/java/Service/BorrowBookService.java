package Service;
import Model.Book;
import Model.BorrowBook;
import Model.User;
import Utils.CSVUtils;
import Utils.DateUtils;

import javax.swing.plaf.PanelUI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BorrowBookService implements IBorrowBookService{
    static String filename="data/borrowbook.csv";
    public static String path = "data/book.csv";
    List<BorrowBook> list = new ArrayList<>();
    BookService bookService = new BookService();
    @Override
    public List<BorrowBook> getBorrowBook() {
        List<BorrowBook> borrowBookList = new ArrayList<>();
        List<String> reads = CSVUtils.read(filename);
        for (String read : reads){
            String[] borrowBook = read.split(",");
            borrowBookList.add(new BorrowBook(
                    Integer.parseInt(borrowBook[0]),
                    borrowBook[1],
                    Integer.parseInt(borrowBook[2]),
                    LocalDate.parse(borrowBook[3]),
                    LocalDate.parse(borrowBook[4]),
                    borrowBook[5]
            ));
        }
        return borrowBookList;
    }

    public BorrowBook getBorrowBookDetail(int borrowbookid){
        list = getBorrowBook();
        for (BorrowBook borrowBook: list){
            if (borrowBook.getId() == borrowbookid){
                return borrowBook;
            }
        }
        return null;
    }

   public void borrowBook(int id,int quanity, String name,int date,String nameBook ){
        List<Book> books =bookService.getBook();
        list = getBorrowBook();
        LocalDate localDate = LocalDate.now();
        for (Book book : books){
            if (book.getId()==id){
                book.setQuantity(book.getQuantity()-quanity);
                BorrowBook borrowBook = new BorrowBook();
                borrowBook.setId(book.getId());
                book.getBookName();
                borrowBook.setName(name);
                borrowBook.setBookid(quanity);
                borrowBook.setBorrowdate(localDate);
                borrowBook.setExpDate(localDate.plusDays(date));
                borrowBook.setNameBook(nameBook);
                list.add(borrowBook);
            }
        }
        CSVUtils.write(filename,list);
        CSVUtils.write(path,books);
   }

   public boolean checkcontinue(int number){
        if (number == 1){
            return true;
        } else
            return false;
   }
   public boolean checkexitsname(String name){

       List<BorrowBook> borrowBookList = getBorrowBook();
        for (BorrowBook borrowBook: borrowBookList){
            if (borrowBook.getName().equals(name)){
                return true;
            }
        }
        return false;
   }
   public int checkexitsIDBorrowBook(int id, String name){
       List<BorrowBook> borrowBookList = getBorrowBook();
       for (BorrowBook borrowBook : borrowBookList){
           if (borrowBook.getId()!=id){
               return 1; // 1 là id không trùng
           }
           if (!borrowBook.getName().equalsIgnoreCase(name)) {
               return 2;
           }
           if(borrowBook.getId()==id && borrowBook.getName().equalsIgnoreCase(name)) {
               return 0;
           }
       } return -1;
   }
}

