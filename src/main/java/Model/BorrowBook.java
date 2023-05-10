package Model;

import Utils.DateUtils;

import java.time.LocalDate;
import java.util.Date;

public class BorrowBook {
    private int id;
    private String name;

    private int bookid;
    private LocalDate borrowdate;
    private LocalDate expDate;
    private String nameBook ;

    public BorrowBook() {
    }

    public BorrowBook(int id, String name, int bookid, LocalDate borrowdate, LocalDate expDate , String nameBook) {
        this.id = id;
        this.name = name;
        this.bookid = bookid;
        this.borrowdate = borrowdate;
        this.expDate = expDate;
        this.nameBook = nameBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public LocalDate getBorrowdate() {
        return borrowdate;
    }

    public void setBorrowdate(LocalDate borrowdate) {
        this.borrowdate = borrowdate;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public BorrowBook(String read) {
        String[] strings = read.split(",");
        this.id = Integer.parseInt(strings[0]);
        this.name = strings[1];
        this.bookid = Integer.parseInt(strings[2]);
        this.borrowdate = LocalDate.parse(strings[3]);
        this.expDate = LocalDate.parse(strings[4]);
        this.nameBook = strings[5];


    }

    @Override
    public String toString() {
        return  id +
                "," + name +
                "," + bookid +
                "," + borrowdate +
                "," + expDate+
                "," + nameBook
                ;
    }
}


