public class FlavoredBaguette extends Baguette{

    private String flavorName;
    private int flavorCost;

    public FlavoredBaguette(String name, int cost, String flavorName, int flavorCost)
    {
        super(name, cost);

        this.flavorName = flavorName;
        this.flavorCost = flavorCost;
    }

    public String getFlavorName()
    {
        return flavorName;
    }

    @Override
    public int getCost()
    {
        return super.getCost() + flavorCost;
    }


}
