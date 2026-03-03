public class app {
    public static void main(String[] args) {
        System.out.println("Hello World");

        // Creating matrix
        Seat[][] theater = new Seat[5][6];

        // Filling matrix
        int totalSeats = 0;

        for (int i = 0; i < theater.length; i++) {
            for (int j = 0; j < theater[i].length; j++) {
                Double price = (i+j) * 5000.0;
                int row = i + 1;

                theater[i][j] = new Seat(price, row, totalSeats);

                totalSeats = totalSeats + 1;
            }
        }

        // Ordering matrix
        orderSeats(theater);

        // Showing matrix

    }

    public static Seat[][] orderSeats(Seat[][] theater) {
        for (int i = 0; i < theater.length; i++) {
            for (int j = 0; j < theater[i].length; j++) {
                if(theater[i][j].getPrice() < theater[j + 1][i].getPrice()) {
                    Seat mostValuedSeat = theater[i][j];

                    theater[i][j] = theater[j][i];
                    theater[j][i] = mostValuedSeat;
                }
            }
        }

        return theater;
    }
}