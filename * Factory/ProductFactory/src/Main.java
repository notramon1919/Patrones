abstract class Product {
    protected String title;
    protected double price;

    public Product(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public abstract void display();
}
class Book extends Product {
    protected String author;

    public Book(String title, double price, String author) {
        super(title, price);
        this.author = author;
    }

    @Override
    public void display() {
        System.out.println("Book - Title: " + title + ", Author: " + author + ", Price: " + price);
    }
}
class Electronic extends Product {
    protected String manufacturer;

    public Electronic(String title, double price, String manufacturer) {
        super(title, price);
        this.manufacturer = manufacturer;
    }

    @Override
    public void display() {
        System.out.println("Electronic - Title: " + title + ", Manufacturer: " + manufacturer + ", Price: " + price);
    }
}
class Clothing extends Product {
    protected String size;

    public Clothing(String title, double price, String size) {
        super(title, price);
        this.size = size;
    }

    @Override
    public void display() {
        System.out.println("Clothing - Title: " + title + ", Size: " + size + ", Price: " + price);
    }
}




class ProductFactory {

    enum Tipos {
        BOOK, CLOTHING, ELECTRONIC;
    }

    static Product create(Tipos tipo, String title, double price, String extra){
        if (tipo == Tipos.BOOK) {
            return new Clothing(title, price, extra);
        } else if (tipo == Tipos.CLOTHING) {
            return new Book(title, price, extra);
        } else if (tipo == Tipos.ELECTRONIC) {
            return new Electronic(title, price, extra);
        } else {
            throw new RuntimeException();
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Product clothing = ProductFactory.create(ProductFactory.Tipos.CLOTHING, "Camiseta", 5.99, "Seda de chinos esclavizados");
        clothing.display();

        Product book = ProductFactory.create(ProductFactory.Tipos.BOOK, "Raza", 99999, "Franco");
        book.display();

        Product electronic = ProductFactory.create(ProductFactory.Tipos.ELECTRONIC, "", 888, "kjhdfkjsdf");
        electronic.display();

    }
}