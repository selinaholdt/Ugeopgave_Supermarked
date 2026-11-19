import java.util.Objects;

public class Vare {
    private String id;
    private String name;
    private String date;
    private double price;
    private double quantity;
    private String unit;
    private double saved = 0;

    public Vare(String id, String name, String date, double price, double quantity, String unit) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
    }


    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        }else {
            Vare o1 = (Vare) o;
            if (o1.id.equals(this.id)){
                return true;
            }
        }
        return false;
    }


    @Override
    public int hashCode(){
        return Objects.hash(this.id);
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public double getSaved() {
        return saved;
    }

    public void setSaved(double saved) {
        this.saved = saved;
    }
}