package mianxiangduixiang;

import java.util.Objects;

public class Book {
    private int id;
    private String name;
    private String author;
    private double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Book(int id, String name, String author, double price){
        this.id=id;
        this.name=name;
        this.author=author;
        this.price=price;
    }

    @Override
    public String toString() {
        return ""+id+'\t'+name+'\t'+author+'\t'+price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
