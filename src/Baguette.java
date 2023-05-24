public class Baguette extends Item{

    private int cost;

    public Baguette(String name, int cost)
    {
        super(name);
        this.cost = cost;
    }

    public int getCost()
    {
        return cost;
    }

}
