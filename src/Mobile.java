public class Mobile extends Product implements Shippable
{
    private double weight;
    @Override
    public double getWeight() {return weight;}
    @Override
    public String getShippedName(){
        return this.getShippedName();
    }

    Mobile(String name, double price, int quantity, double weight){
        super(name, price, quantity);
        this.weight = weight;
    }
}
