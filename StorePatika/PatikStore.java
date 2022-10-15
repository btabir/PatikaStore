package StorePatika;

import java.util.Scanner;

public class PatikStore {



    public static void run(){
        while (true){
            Scanner input = new Scanner(System.in);

            System.out.println();
            System.out.println("Welcome to the Patika Store,please select an option below");
            System.out.println();
            System.out.println("1 - Notebooks \n" +
                    "2 - Mobilephones \n" +
                    "3 - List the brands \n" +
                    "4 - Exit");

            int select = input.nextInt();
            switch (select){
                case 1:
                    Notebook notebook = new Notebook();
                    notebook.menu();
                    break;
                case 2:
                    MobilePhone mobilePhone = new MobilePhone();
                    mobilePhone.menu();
                    break;
                case 3:
                    Brand.printBrands();
                    break;
                case 4:
                    System.out.println("Exiting..");
                    System.exit(4);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }


}
