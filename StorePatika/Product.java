package StorePatika;

import java.util.HashSet;
import java.util.Scanner;

public abstract class Product {

    static HashSet<Brand> brands=new HashSet<>();
    protected Scanner scanner=new Scanner(System.in);

    private int id;
    private String name;
    private int price;
    private int discountRate ;
    private int stock;
    private Brand brand;
    private int memory;
    private int ram;
    private double screenSize;

    public abstract void menu();
    public abstract void addItem();
    public abstract void getProduct();
    public abstract void deteleItem();

    public Product(int id, String name, int price, int discountRate, int stock, Brand brand, int memory, int ram, double screenSize) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discountRate = discountRate;
        this.stock = stock;
        this.brand = brand;
        this.memory = memory;
        this.ram = ram;
        this.screenSize = screenSize;
    }

    public Product(){

    }

    public static HashSet<Brand> getBrands() {
        return brands;
    }

    public static void setBrands(HashSet<Brand> brands) {
        Product.brands = brands;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }
}
