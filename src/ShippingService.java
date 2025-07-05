import java.util.Map;
public class ShippingService
{
    static public double process(Map<Shippable, Integer> shippedProducts)
    {
        double totalWeight = 0;
        System.out.println("** Shipment notice **");
        for (Map.Entry<Shippable, Integer> ShippedItem : shippedProducts.entrySet())
        {
            Shippable shipped = ShippedItem.getKey();
            int quantity = ShippedItem.getValue();
            double itemWeight = shipped.getWeight()*quantity;
            System.out.println(quantity + "X " + shipped.getShippedName() + "    " + itemWeight + "g");
            totalWeight += quantity * shipped.getWeight();
        }
        totalWeight = totalWeight / 1000;
        System.out.println("Total package weight " + totalWeight+ "Kg");
        return totalWeight;
    }

}
