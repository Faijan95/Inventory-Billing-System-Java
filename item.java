public class item {
    int id;
    String name;
    int quantity;
    double price;

    public item(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return id + "," + name + "," + quantity + "," + price;
    }
}