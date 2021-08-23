package mianxiangduixiang;

public class test {
    public static void main(String[] args) {
        Book b1 = new Book(1,"a","",1.3);
        Book b2 = new Book(1,"ab","3414",4.4);
        Library.addBook(b1);
        Library.addBook(b2);
    }
}
