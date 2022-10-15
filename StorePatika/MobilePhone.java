package StorePatika;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone extends Product{

    Scanner input = new Scanner(System.in);

    private static int idMobilePhone =1;
    private int battery;
    private String color;
    private static ArrayList<MobilePhone> mobilePhones= new ArrayList<>();


    public MobilePhone(){

    }

    public MobilePhone(String name, int price, int discountRate, int stock, Brand brand,
                       int memory, int ram, double screenSize, int battery, String color) {
        super(idMobilePhone, name, price, discountRate, stock, brand, memory, ram, screenSize);
        idMobilePhone ++;
        this.battery = battery;
        this.color = color;
    }

    @Override
    public void menu() {
        System.out.println();
        System.out.println("1 - Add mobilephone \n" +
                "2 - List mobilephone \n" +
                "3 - Remove mobilephone \n" +
                "4 - Filter mobilephone as id\n" +
                "5 - Filter mobilephone as brand");
        System.out.println();
        System.out.print("Please choose an option : ");
        int select = input.nextInt();

        if (select == 1) addItem();
        if (select == 2) getProduct();
        if (select == 3) deteleItem();
        if (select == 4) getProduct();
        if (select == 5) filterBrands();
    }

    @Override
    public void addItem() {
        System.out.print("Price : ");
        int priceMp = input.nextInt();
        System.out.print("Name : ");
        input.nextLine();
        String nameMp = input.nextLine();
        System.out.print("Discount rate : ");
        int dcMp= input.nextInt();
        System.out.print("Stock : ");
        int stockMp = input.nextInt();
        System.out.print("Ram : ");
        int ramMp = input.nextInt();
        System.out.print("Screen size : ");
        double ssMp = input.nextDouble();
        System.out.print("Memory : ");
        int memoryMp = input.nextInt();
        System.out.print("Battery : ");
        int batteryMp = input.nextInt();
        input.nextLine();
        System.out.print("Color : ");
        String colorMp = input.nextLine();
        Brand.printBrands();
        System.out.print("Brand : ");
        Brand brand = Brand.getBrand(input.nextInt());
        MobilePhone mobilePhone = new MobilePhone(nameMp,priceMp,dcMp,stockMp,brand,memoryMp,ramMp,ssMp,batteryMp,colorMp);
        mobilePhones.add(mobilePhone);
        System.out.println("The added mobilephone id "+ mobilePhone.getId());
    }

    @Override
    public void getProduct() {
        printItem(null);
    }

    public void printItem(ArrayList<MobilePhone> mobilePhoneList){
        if (mobilePhoneList == null) mobilePhoneList = this.mobilePhones;
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID |       NAME         |   PRICE   |   BRAND   |  STOCK  | DISCOUNT RATE | RAM | SCREEN SIZE | MEMORY | BATTERY | COLOR |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");

        for (MobilePhone mp :mobilePhoneList){
            System.out.printf("| %-2s | %-18s | %-9s | %-9s | %-7s | %-13s | %-3s | %-11s | %-6s | %-7s | %-6s | \n",
                        mp.getId(),mp.getName(),mp.getPrice(),mp.getBrand(),mp.getStock(),mp.getDiscountRate(),
                        mp.getRam(),mp.getScreenSize(),mp.getMemory(),mp.getBattery(),mp.getColor());

        }
    }

    @Override
    public void deteleItem() {
        getProduct();
        System.out.print("Please enter item id that you want to delete :");
        int idItem = input.nextInt();
        mobilePhones.remove(idItem-1);
        System.out.println("You have deleted the item.Updated list is below");
        System.out.println();
        getProduct();
    }


    public void filterBrands(){
        input.nextLine();
        System.out.println("Please enter item id that you want to filter");
        String filterBrand = input.nextLine();
        ArrayList<MobilePhone> filterMobilePhone = new ArrayList<>();
        for (MobilePhone mp : filterMobilePhone){
            if (filterBrand.equals(mp.getBrand().getName())){
                filterMobilePhone.add(mp);
            }
        }
        printItem(filterMobilePhone);
    }

    public static int getIdMobilePhone() {
        return idMobilePhone;
    }

    public int getBattery() {
        return battery;
    }

    public String getColor() {
        return color;
    }
}
