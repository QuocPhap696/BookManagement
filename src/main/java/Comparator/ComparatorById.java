package Comparator;

import Model.Book;

import java.util.Comparator;

public class ComparatorById implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        if (o1.getId()>o2.getId()){
            return 1;
        } else if (o1.getId()==o2.getId()) {
            return 0;
        } else {
            return -1;
        }
    }
}
