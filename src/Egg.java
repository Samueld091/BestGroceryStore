public class Egg extends Item {

    private int number;
    private int pricePerDozen;

    public Egg(String name, int number, int pricePerDozen)
    {
        super(name);

        this.number = number;
        this.pricePerDozen = pricePerDozen;

    }

    public int getNumber() {
        return number;
    }

    public int getPricePerDozen() {
        return pricePerDozen;
    }

    public int getCost()
    {
        double cost = ((double) number / 12) * pricePerDozen;
        return (int) Math.round(cost);
    }
}
