package StorePatika;

import java.util.*;

public class Notebook extends Product{

    Scanner input = new Scanner(System.in);

    private static int idNotebook = 1;
    private static ArrayList<Notebook> notebooks = new ArrayList<>();

    public Notebook(String name, int price, int discountRate, int stock, Brand brand, int memory, int ram, double screenSize) {
        super(idNotebook, name, price, discountRate, stock, brand, memory, ram, screenSize);

        idNotebook ++;
    }

    public Notebook(){

    }

    @Override
    public void menu() {
        System.out.println();
        System.out.println("1 - Add notebook \n" +
                           "2 - List notebook \n" +
                           "3 - Remove notebook \n" +
                           "4 - Filter notebooks as id\n" +
                           "5 - Filter notebooks as brand");
        System.out.println();
        System.out.print("Please choose an option : ");
        int select = input.nextInt();
        if (select == 1){
            addItem();
        }
        if (select == 2){
            getProduct();
        }
        if (select == 3){
            deteleItem();
        }
        if (select == 4){
            getProduct();
        }
        if (select == 5){
            filterBrands();
        }
    }

    @Override
    public void addItem() {
        System.out.print("Name : ");
        input.nextLine();
        String nameNb = input.nextLine();
        System.out.print("Price : ");
        int priceNb = input.nextInt();
        System.out.print("Discount rate : ");
        int dcNb= input.nextInt();
        System.out.print("Stock : ");
        int stockNb = input.nextInt();
        System.out.print("Memory : ");
        int memoryNb = input.nextInt();
        System.out.print("Screen size : ");
        double ssNb = input.nextDouble();
        System.out.print("Ram : ");
        int ram = input.nextInt();
        Brand.printBrands();
        System.out.print("Brand : ");
        Brand brand = Brand.getBrand(input.nextInt());
        Notebook notebook = new Notebook(nameNb,priceNb,dcNb,stockNb,brand,memoryNb,ram,ssNb);
        notebooks.add(notebook);
        System.out.println("The added notebooks id : " + notebook.getId());
    }

    @Override
    public void getProduct() {
        printItem(null);
    }


    public  void printItem(ArrayList<Notebook> notebookList){
        if (notebookList == null) notebookList = this.notebooks;
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("| ID |       NAME         |   PRICE   |   BRAND   |  STOCK  | DISCOUNT RATE | RAM | SCREEN SIZE | MEMORY |");
        System.out.println("----------------------------------------------------------------------------------------------------------");

        for (Notebook n:notebookList){
            System.out.printf("| %-2s | %-18s | %-9s | %-9s | %-7s | %-13s | %-3s | %-11s | %-6s | \n",
                    n.getId(),n.getName(),n.getPrice(),n.getBrand().getName(),n.getStock(),
                    n.getDiscountRate(),n.getRam(),n.getScreenSize(),n.getMemory());
        }
    }

    @Override
    public void deteleItem() {
        getProduct();
        System.out.print("Please enter item id that you want to delete :");
        int idItem = input.nextInt();
        notebooks.remove(idItem-1); //index -1
        System.out.println("You have deleted the item.Updated list is below");
        System.out.println();
        getProduct();
    }

    public void filterBrands(){
        input.nextLine();
        System.out.println("Please enter item id that you want to filter");
        String filterBrand = input.nextLine();
        ArrayList<Notebook> filterNotebook = new ArrayList<>();
        for (Notebook nb : filterNotebook){
            if (filterBrand.equals(nb.getBrand().getName())){
                filterNotebook.add(nb);
            }
        }
        printItem(filterNotebook);
    }

    public static int getIdNotebook() {
        return idNotebook;
    }
}
