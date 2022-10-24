package book_list;

public class Book {
    private String name;
    private int pageNumber;
    private String author;
    private int publisingYear;

    public Book(String name, int pageNumber, String author, int publisingDate) {
        this.name = name;
        this.pageNumber = pageNumber;
        this.author = author;
        this.publisingYear = publisingDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublisingYear() {
        return publisingYear;
    }

    public void setPublisingYear(int publisingYear) {
        this.publisingYear = publisingYear;
    }
}
