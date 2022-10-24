package book_list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Kürk Mantolu Madonna", 160, "Sabahattin Ali", 2022));
        bookList.add(new Book("Şeker Portakalı", 182, "Jose Mauro De Vasconcelos", 2019));
        bookList.add(new Book("1984", 352, "George Orwell", 2019));
        bookList.add(new Book("Kırmızı Pazartesi", 120, "Gabriel Garcia Marquez", 2019));
        bookList.add(new Book("Kuyucaklı Yusuf", 221, "Sabahattin Ali", 2019));
        bookList.add(new Book("Simyacı", 184, "Paulo Coelho", 2021));
        bookList.add(new Book("Küçük Prens", 96, "Antoine De Saint Exupery", 2017));
        bookList.add(new Book("Aklından Bir Sayı Tut", 480, "John Verdon", 2011));
        bookList.add(new Book("Yabancı", 111, "Albert Camus", 2019));
        bookList.add(new Book("Saatleri Ayarlama Enstitüsü", 382, "Ahmet Hamdi Tanpınar ", 2017));
        bookList.add(new Book("Aşkın Gözyaşları / Tebrizli Şems", 248, "Sinan Yağmur", 2016));

        Map<String,String> bookMap = new HashMap<>();
        bookList.stream().forEach(book -> bookMap.put(book.getName(), book.getAuthor()));

        for (String s: bookMap.keySet()) {
            System.out.println("Kitap adı: " + s + " Yazar: " + bookMap.get(s));

        }

        System.out.println("----------------------------------------");
        List<Book> list = bookList.stream().filter(book -> book.getPageNumber() > 100).toList();
        list.stream().forEach(book -> System.out.println("Kitap Adı: " + book.getName() +
                ", Sayfa Sayısı: " + book.getPageNumber() +
                ", Yazar: " + book.getAuthor() +
                " Basım Tarihi: " + book.getPublisingYear()));
    }
}
