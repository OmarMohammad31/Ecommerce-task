import java.time.LocalDate;
public class Cheese extends Product implements Expirable
{
    private LocalDate expirationDate;

    @Override
    public LocalDate getExpirationDate() {return expirationDate;}
    public void setExpirationDate(LocalDate expirationDate) {this.expirationDate = expirationDate;}
    Cheese(String name, double price, int quantity, LocalDate expirationDate){
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }
}
