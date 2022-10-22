package io;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File dosya = new File("patika.txt");
        try {
            if (dosya.createNewFile()) {
                System.out.println(dosya.getName() + " dosyası oluşturuldu");
            } else {
                System.out.println(dosya.getName() + " dosyası zaten mevcut");
            }
            dosya.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
