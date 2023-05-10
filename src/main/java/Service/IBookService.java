package Service;

import Model.Book;

import java.util.List;

public interface IBookService {
    void add(Book newBook);
    void update(int id, Book updateBook);
    List<Book> getBook();
    void updatQuantity(int id, int quantity);
    Book getBookDetail(int bookid);
    List<Book> getListBook();
}
