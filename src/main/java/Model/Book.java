package Model;

public class Book {
    private int id;
    private String bookName;
    private int quantity;
    private String category;
    private String description;
    private String author;
    private String publishingCompany;
    private Status Status;
    private boolean isAvailable;
    public Book() {
    }

    public Book(int id, String bookName,int quantity, String category, String description, String author, String publishingCompany, Model.Status status) {
        this.id = id;
        this.bookName = bookName;
        this.quantity= quantity;
        this.category = category;
        this.description = description;
        this.author = author;
        this.publishingCompany = publishingCompany;
        this.Status = status;
    }

    public Book(String read) {
        String [] strings = read.split(",");
        this.id = Integer.parseInt(strings[0]);
        this.bookName = strings[1];
        this.quantity = Integer.parseInt(strings[2]);
        this.category= strings[3];
        this.description= strings[4];
        this.author= strings[5];
        this.publishingCompany= strings[6];
        this.Status=Model.Status.getStatus(strings[7]);

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public Model.Status getStatus() {
        return Status;
    }

    public void setStatus(Model.Status status) {
        Status = status;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return  id +"," +
                bookName +"," +
                quantity +"," +
                category +"," +
                description + "," +
                author +"," +
                publishingCompany +"," +Status;
    }
}
