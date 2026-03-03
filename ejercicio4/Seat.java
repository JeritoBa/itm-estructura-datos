public class Seat {
    private int seatId;
    private int row;
    private Double price;

    public Seat() {
    }

    public Seat(Double price, int row, int seatId) {
        this.price = price;
        this.row = row;
        this.seatId = seatId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}