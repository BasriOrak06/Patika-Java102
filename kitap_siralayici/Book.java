package kitap_siralayici;

public class Book implements Comparable<Book>{
    private String name;
    private int page;
    private String author;
    private int releaseDate;

    public Book(String name,int page,String author,int releaseDate){
        this.name=name;
        this.page=page;
        this.author=author;
        this.releaseDate= releaseDate;
        //compareTo(new Book(name,page,author,releaseDate));
    }

    public String getName() {
        return name;
    }

    public int getPage() {
        return page;
    }

    public String getAuthor() {
        return author;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    @Override
    public int compareTo(Book b) {
        return getName().compareTo(b.getName());
    }
}
