package Service;

import Model.Book;
import Model.Status;
import Utils.CSVUtils;
import jdk.jfr.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookService implements IBookService{
    static List<Book> bookList = new ArrayList<>();
    public static String path = "data/book.csv";
    static {
        List<String> reads = CSVUtils.read(path);
        for (String read : reads){
            String[] book = read.split(",");

            bookList.add(new Book(
                    Integer.parseInt(book[0]),
                    book[1],
                    Integer.parseInt(book[2]),
                    book[3],book[4],book[5],book[6],
                    Status.valueOf(book[7])

            ));
        }

    }

    @Override
    public void add(Book newBook) {
    bookList.add(newBook);
        CSVUtils.write(path,bookList);
    }

    @Override
    public void update(int id, Book updateBook) {
        getBook();
        for (int i = 0; i< bookList.size();i++){
            if (bookList.get(i).getId()==id){
                bookList.set(i,updateBook);
                CSVUtils.write(path,bookList);
            }
        }
    }

    @Override
    public List<Book> getBook() {
        List<Book> newBookList = new ArrayList<>();
        List<String> reads =CSVUtils.read(path);
        for (String read : reads){
            newBookList.add(new Book(read));
        }
        return bookList = newBookList;
    }



    @Override
    public void updatQuantity(int id, int quantity) {
    getBook();
    for (int i = 0; i < bookList.size();i++){
        if (bookList.get(i).getId() == id){
            bookList.get(i).setQuantity(quantity);
            CSVUtils.write(path,bookList);
        }
    }
    }

    @Override
    public Book getBookDetail(int bookid) {
        bookList = getListBook();
        for (Book book:bookList){
            if (book.getId() == bookid){
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> getListBook() {
        return bookList;
    }


    public boolean getQuantity(int id, int quantity){
        getBook();
        Book book = getBookDetail(id);
        int soluong = 0;
            if (book.getQuantity() < quantity){
                return false;

        }

        return true;
    }

    public boolean exitsProductName(String name){
        getBook();
        for (Book book:bookList){
            if (book.getBookName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public boolean exitsProductId(int id){
        getBook();
        for (Book book:bookList){
            if (book.getId() == id){
                return true;
            }
        } return false;
    }

    public Book findProductByID(int id){
        getBook();
        for (Book book : bookList){
            if (book.getId()==id) {
                return book;
            }
        }
        System.out.println("Không tìm thấy sản phẩm này");
        return null;
    }

    public  int findQuantity(int id){
        getBook();
        for (Book book : bookList){
            if (id == book.getId()){
                return book.getQuantity();
            }
        }
        System.out.println("Không tìm thấy số lượng này");
        return 0;
    }


    public void checkExits(){
        getBook();
        for (Book book:bookList){
            if (book.getQuantity() ==0){
                book.setStatus(Status.OUTSTOCK);
                CSVUtils.write(path,bookList);
            } else
                book.setStatus(Status.INSTOCK);
            CSVUtils.write(path,bookList);
        }
    }

    public boolean exitsProduct(int id){
        getBook();
        for (Book book:bookList){
            if (book.getId()==id){
                return true;
            }
        }
        return false;
    }

    public Book findProductById(int id){
        getBook();
        for (Book book : bookList){
            if (book.getId()==id){
                return book;
            }
        }
        System.out.println("Không tìm thấy ID này");
        return null;
    }



    public void deleteBookByID(int id){
        for (int i= 0; i < bookList.size();i++){
            if (Objects.equals(id,bookList.get(i).getId())){
                bookList.remove(i);
            }
        }

        CSVUtils.write(path,bookList);
    }
}
