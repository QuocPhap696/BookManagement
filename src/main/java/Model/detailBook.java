package Model;

public class detailBook {
    private int id;
    private int idBook;
    private int quantity;

    public void ReturnBook() {
    }

    public void ReturnBook(int id, int idBook, int quantity) {
        this.id = id;
        this.idBook = idBook;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void ReturnBook(String read){
        String[] strings = read.split(",");
        this.id=Integer.parseInt(strings[0]);
        this.idBook=Integer.parseInt(strings[1]) ;
        this.quantity= Integer.parseInt(strings[2]);
    }

    @Override
    public String toString() {
        return  id +
                ", " + idBook +
                "," + quantity
               ;
    }
}
