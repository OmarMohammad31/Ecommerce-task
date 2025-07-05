public class TV extends Product implements Shippable
{
    private double weight;
    @Override
    public double getWeight() {return weight;}

    TV(String name, double price, int quantity, double weight){
        super(name, price, quantity);
        this.weight = weight;
    }
    @Override
    public String getShippedName(){
        return this.getName();
    }
}
