import java.io.*;
import java.util.*;

public class filemanager {
    static String filename = "items.txt";

    public static void saveItems(ArrayList<item> items) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(filename));
            for (item i : items) {
                pw.println(i.toString());
            }
            pw.close();
        } catch (Exception e) {
            System.out.println("Error saving file.");
        }
    }

    public static ArrayList<item> loadItems() {
        ArrayList<item> items = new ArrayList<>();
        try {
            File file = new File(filename);
            if (!file.exists()) return items;

            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");
                items.add(new item(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2]),
                        Double.parseDouble(data[3])
                ));
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error loading file.");
        }
        return items;
    }
}