import java.util.ArrayList;

public class Checkout {



    private final ArrayList cashRegister;

    public Checkout()
    {
        cashRegister = new ArrayList<>();
    }

    public void enterItem(Item item)
    {
        cashRegister.add(item);
    }

    public void clear()
    {
        cashRegister.clear();
    }

    public int numberOfItems()
    {
        return cashRegister.size();
    }

    public int totalCost()
    {
        int totalCost = 0;

        for (Object item : cashRegister)
        {
            totalCost += ((Item) item).getCost();
        }

        return totalCost;
    }

    public int totalTax()
    {
        double totalTax = totalCost() * (GroceryStore.TAX_RATE / 100);
        return (int) Math.round(totalTax);
    }

    private String generateReceipt()
    {
        String receipt = "";
        for(Object someItem : cashRegister)
        {
            if (someItem instanceof Rice)
            {
                receipt += ((Rice) someItem).getWeightInPounds() + " lbs. @ " + GroceryStore.cents2dollarsAndCents(((Rice) someItem).getPricePerPound()) + "/lb.\n"
                        + ((Rice) someItem).getName() + "\t\t\t" + restrictCostWidth(GroceryStore.cents2dollarsAndCents(((Rice) someItem).getCost()));
            } else if (someItem instanceof Egg)
            {
                receipt += ((Egg) someItem).getNumber() + " @ " + GroceryStore.cents2dollarsAndCents(((Egg) someItem).getPricePerDozen()) + "/dz.\n" +
                        ((Egg) someItem).getName() + "\t\t\t" + restrictCostWidth(GroceryStore.cents2dollarsAndCents(((Egg) someItem).getCost()));
            } else if (someItem instanceof FlavoredBaguette)
            {
                receipt += ((FlavoredBaguette) someItem).getName() + " with\n" +
                        ((FlavoredBaguette) someItem).getFlavorName() + "\t\t\t\t\t\t" + restrictCostWidth(GroceryStore.cents2dollarsAndCents(((FlavoredBaguette) someItem).getCost()));
            } else if (someItem instanceof Baguette)
            {
                receipt += ((Baguette) someItem).getName() + "\t\t\t" + restrictCostWidth(GroceryStore.cents2dollarsAndCents(((Baguette) someItem).getCost()));
            }

            receipt += "\n";
        }

        int totalCostAfterTax = totalTax() + totalCost();

        receipt += "\nTax\t\t\t\t\t\t\t" + restrictCostWidth(GroceryStore.cents2dollarsAndCents(totalTax()));
        receipt += "\nTotal Cost\t\t\t\t\t" + restrictCostWidth(GroceryStore.cents2dollarsAndCents(totalCostAfterTax));

        return receipt;
    }

    private String restrictCostWidth(String cost)
    {
        if (GroceryStore.COST_WIDTH >= cost.length()) {
            return cost;
        } else {
            return cost.substring(0, GroceryStore.COST_WIDTH);
        }
    }

    @Override
    public String toString() {
        return "\t" + GroceryStore.STORE_NAME +
                "\n\t--------------\n\n" +
                generateReceipt();
    }
}
