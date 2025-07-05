public class Main {
    public static void main(String[] args) {
    Customer customer = new Customer(1000);
    Cheese cheese = new Cheese("holand cheese", 10, 2 ,java.time.LocalDate.of(2025, 7, 5));
    TV tv = new TV("myTV", 100, 3, 50);
    customer.addToCart(tv,2);
    customer.addToCart(cheese, 2);
    customer.checkOut();
    }
}