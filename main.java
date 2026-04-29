import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        inventory inv = new inventory();

        while (true) {
            System.out.println("\n===== INVENTORY BILLING SYSTEM =====");
            System.out.println("1. Add Item");
            System.out.println("2. View Items");
           System.out.println("3. Generate Bill");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Item ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Item Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    inv.addItem(new item(id, name, qty, price));
                    break;

                case 2:
                    inv.viewItems();
                    break;

                case 3:
                    System.out.print("Enter Item ID to purchase: ");
                    int billid = sc.nextInt();

                    System.out.print("Enter Quantity to purchase: ");
                    int buyqty = sc.nextInt();

                    inv.generateBill(billid, buyqty);
                    break;

                case 4:
                    System.out.println("Thank You.");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}