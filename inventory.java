import java.util.*;

public class inventory {
    ArrayList<item> items = filemanager.loadItems();

    public void addItem(item i) {
        items.add(i);
        filemanager.saveItems(items);
        System.out.println("Item Added Successfully.");
    }

    public void viewItems() {
        if (items.size() == 0) {
            System.out.println("No Items Available.");
            return;
        }

        for (item i : items) {
            System.out.println("ID: " + i.id);
            System.out.println("Name: " + i.name);
            System.out.println("Quantity: " + i.quantity);
            System.out.println("Price: " + i.price);
            System.out.println("---------------------");
        }
    }

    public void generateBill(int id, int qty) {
        for (item i : items) {
            if (i.id == id) {
                if (i.quantity >= qty) {
                    double total = qty * i.price;
                    i.quantity -= qty;
                    filemanager.saveItems(items);
                    System.out.println("Bill Generated Successfully.");
                    System.out.println("Item: " + i.name);
                    System.out.println("Quantity Purchased: " + qty);
                    System.out.println("Total Amount: Rs." + total);
                    return;
                } else {
                    System.out.println("Insufficient Stock.");
                    return;
                }
            }
        }
        System.out.println("Item Not Found.");
    }
}