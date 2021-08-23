package mianxiangduixiang;

import java.util.HashSet;

public class Library {
    private static HashSet<Book> set = new HashSet<Book>();

    public static void addBook(Book book){
        set.add(book);
    }
}
