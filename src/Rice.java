public class Rice extends Item{

    private double weightInPounds;

    private int pricePerPound;

    public Rice(String name, double weightInPounds, int pricePerPound)
    {
        super(name);

        this.weightInPounds = weightInPounds;
        this.pricePerPound = pricePerPound;
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }

    public int getPricePerPound() {
        return pricePerPound;
    }

    public int getCost()
    {
        double cost = (double) weightInPounds * pricePerPound;
        return (int) Math.round(cost);
    }
}
