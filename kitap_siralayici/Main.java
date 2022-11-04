package kitap_siralayici;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        TreeSet<Book> books=new TreeSet<Book>();

        Book book1=new Book("Kürk Mantolu Madonna", 160, "Sabahattin Ali", 2022);
        Book book2=new Book("Şeker Portakalı", 182, "Jose Mauro De Vasconcelos", 2019);
        Book book3=new Book("1984", 352, "George Orwell", 2019);
        Book book4=new Book("Kırmızı Pazartesi", 120, "Gabriel Garcia Marquez", 2019);
        Book book5=new Book("Kuyucaklı Yusuf", 221, "Sabahattin Ali", 2019);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        System.out.println("Ada göre sıralama : ");
        for(Book book:books){

            System.out.println("Kitap Adı : "+book.getName()+
                    ",\t Sayfa Sayısı : "+book.getPage()+
                    ",\t Yazarın İsmi : "+book.getAuthor()+
                    ",\t Yayın Tarihi : "+ book.getReleaseDate());
        }


        TreeSet<Book> books2=new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPage() - o2.getPage();
            }
        });
        books2.add(book1);
        books2.add(book2);
        books2.add(book3);
        books2.add(book4);
        books2.add(book5);
        System.out.println("----------------------------------");
        System.out.println("Sayfa sayısına göre sıralama :");
        for (Book book:books2) {
            System.out.println("Kitap adı : " + book.getName() +
                    ",\t Sayfa Sayısı : " + book.getPage() +
                    ",\t Yazarın İsmi : " + book.getAuthor() +
                    ",\t Yayın Tarihi : " + book.getReleaseDate());
        }
    }
}
