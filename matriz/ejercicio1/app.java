
import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        System.out.println("Hola");

        // Creating Matrix.
        Product[][] store = new Product[6][5];

        // Filling it.
        for (int i = 0; i < store.length; i++) {
            for (int j = 0; j < store[i].length; j++) {
                String name = "product" + i + j;
                Double price = (i+j)*1000.0;
                int quantity = i+j;

                // I'm burning dates for do it faster.
                store[i][j] = new Product(name, price, quantity);
            }
        }

        while (true) { 
            System.out.println(searchProduct(store));
        }
    }

    public static String searchProduct(Product[][] store) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Type the product name: ");
        String productName = keyboard.nextLine();

        for (int i = 0; i < store.length; i++) {
            for (int j = 0; j < store[i].length; j++) {
                    if(store[i][j].getName().equalsIgnoreCase(productName)) {
                        return "Position: " + i + " " + j;
                    }
            }
        }

        // If the product wasn't found
        return "The product " + productName + " doesn't exists";
    }
}