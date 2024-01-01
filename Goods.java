
import java.util.ArrayList;
import java.util.Scanner;

public class Goods {
    private String name;
    private float price;

    public Goods(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
}

class Basket {
    private ArrayList<Goods> goodsList;

    public Basket() {
        goodsList = new ArrayList<>();
    }

    public void addGoods(Goods goods) {
        goodsList.add(goods);
    }

    public ArrayList<Goods> getAllGoods() {
        return goodsList;
    }

    public boolean isEmpty() {
        return goodsList.isEmpty();
    }

    public void clear() {
        goodsList.clear();
    }

    public float getTotalPrice() {
        float totalPrice = 0;
        for (Goods goods : goodsList) {
            totalPrice += goods.getPrice();
        }
        return totalPrice;
    }
}

class Store {
    private static final Goods[] GOODS = {
            new Goods("Bread", 1.0f),
            new Goods("Cocacola", 1.0f),
            new Goods("Beer", 1.0f),
            new Goods("Chocalate", 1.0f),
            new Goods("Pencil", 0.5f),
            new Goods("Notebook", 3.0f),
    };

    private static Basket basket = new Basket();
    private static final String MESSAGE_HEADER = "*********************************************************\n"
            + "Welcome  to  XiaoFang  Convenience  Store\n"
            + "*********************************************************";
    private static final String MESSAGE_FOOTER = "-------------------------------------------------------------------";
    private static final String MESSAGE_TOTAL = "\n==========CHECK  OUT=================\n";
    private static final String MESSAGE_THANKS = "=====================================\n"
            + "TOTAL:   $%.2f\n"
            + "THANKS！";

    private static void exit() {
        System.out.println(MESSAGE_FOOTER);
        System.exit(0);
    }

    private static void checkOut() {
        System.out.println(MESSAGE_TOTAL);
        ArrayList<Goods> goodsList = basket.getAllGoods();
        for (Goods goods : goodsList) {
            System.out.println(goods.getName() + "\t\t" + goods.getPrice());
        }
        float totalPrice = basket.getTotalPrice();
        System.out.printf(MESSAGE_THANKS, totalPrice);
    }

    private static void invalidInput() {
        System.out.println("Invalid input. Please try again.");
    }

    private static void addGoods(int choice) {
        if (choice < 1 || choice > GOODS.length) {
            invalidInput();
            return;
        }

        Goods goods = GOODS[choice - 1];
        basket.addGoods(goods);
        System.out.println("You have selected [" + goods.getName() + "], $" + goods.getPrice());
    }

    private static void printMenu() {
        System.out.println("\n" + MESSAGE_HEADER);
        System.out.println();
        for (int i = 0; i < GOODS.length; i++) {
            System.out.println("<" + (i + 1) + ">" + GOODS[i].getName() + "\t\t" + GOODS[i].getPrice());
        }
        System.out.println();
        System.out.println("<9>CHECK OUT");
        System.out.println("<0>EXIT");
        System.out.println(MESSAGE_FOOTER);
        System.out.print("PLEASE SELECT A NUMBER: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                exit();
            } else if (choice == 9) {
                checkOut();
                basket.clear();
                System.out.print("\nPress any key to continue shopping...");
                scanner.nextLine();
            } else {
                addGoods(choice);
            }
        }
    }
}

