package ejercicio4;

public class Asiento {
    private int id;
    private int row;
    private Double price;
    
    public Asiento() {
    }

    public Asiento(int id, int row, Double price) {
        this.id = id;
        this.row = row;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
