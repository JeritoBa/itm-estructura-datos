public class app {
    public static void main(String[] args) {
        System.out.println("Hello world");

        // Creating obj matrix
        Product store[][] = new Product[3][3];

        // Filling matrix
        for (int i = 0; i < store.length; i++) {
            for (int j = 0; j < store[i].length; j++) {
                String name = i + "product" + j;
                int quantity = i+j;

                store[i][j] = new Product(name, quantity);
            }
        }

        System.out.println("Total stock in store is: " + totalStock(store));
    }

    public static int totalStock(Product store[][]) {
        int total = 0;

        for (int i = 0; i < store.length; i++) {
            for (int j = 0; j < store[i].length; j++) {
                total = total + store[i][j].getQuantity();
            }
        }

        return total;
    }
}