import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Customer
{
    private double balance;
    private Map<Product, Integer> cart;
    public double getBalance() {return balance;}
    Customer(double balance) {
        this.balance = balance;
        cart = new HashMap<>();
    }
    public boolean addToCart(Product product, int quantity){
        if (quantity>0){
            cart.put(product, quantity);
            return true;
        }
        return false;
    }
    public void checkOut()
    {
        System.out.println("**Shipment notice**");
        Map<Shippable, Integer> shippedProducts = new HashMap<>();
        double subTotal = 0;
        for (Map.Entry<Product, Integer> cartItem : cart.entrySet())
        {
            Product product = cartItem.getKey();
            int quantity = cartItem.getValue();
            if (quantity > product.getQuantity())
            {
                System.out.println("ordered quantity isn't available");
                return;
            }
            if (product instanceof Shippable)
            {
                Shippable shippable = (Shippable) product;
                shippedProducts.put(shippable, quantity);
            }

        }
        double shippingTotal = 0;
        //shipping cost is 5$ per kg
        if (!shippedProducts.isEmpty()) shippingTotal = 5 * ShippingService.process(shippedProducts);
        System.out.println("** Checkout receipt **");
        for (Map.Entry<Product, Integer> cartItem : cart.entrySet())
        {
            Product product = cartItem.getKey();
            int quantity = cartItem.getValue();
            subTotal = subTotal + quantity * product.getPrice();
            System.out.println(quantity + "X    " + product.getName() + "    "+ quantity * product.getPrice());
        }
        if (subTotal + shippingTotal > balance) {
            System.out.println("balance isn't sufficient");
            return;
        }
        double amount = subTotal + shippingTotal;
        System.out.println("----------------------");
        System.out.println("Subtotal    " + subTotal);
        System.out.println("Shipping    " + shippingTotal);
        System.out.println("Amount    " + amount);
    }
}
