public class Pizza
{
    /** Standardtoppings used for all pizzas **/
    protected String pizzaDefaultToppings;


    /** Constructor that initializes pizzaDefaultToppings **/
    public Pizza(String defaultToppings)
    {
        this.pizzaDefaultToppings = defaultToppings;
    }
}

/** Subclass representing a menu card of pizzas**/
public class MenuCard extends Pizza {

    /** Array containing all pizzas in the menu card **/
    private PizzaItem[] pizzaItems;


    /** Constructor for MenuCard that receives default toppings and an array of pizzas **/
    public MenuCard(String defaultToppings, PizzaItem[] items)
    {
        super(defaultToppings);
        this.pizzaItems = items;
    }

    /** Inner class that describes individual pizzas in the menu card **/
    public static class PizzaItem
    {

        /** Attributes **/
        private String pizzaName;
        private int pizzaNumber;
        private double pizzaPrice;
        private String pizzaToppings;
    }

    /** Constructor that initializes the name, number, price, and toppings for each pizza **/
        public Pizza(String name, int number, double price, String toppings)
    {
        this.pizzaName = name;
        this.pizzaNumber = number;
        this.pizzaPrice = price;
        this.pizzaToppings = toppings;
    }

    /** toString method that returns a readable description of the pizza **/
    public String toString()
    {
        return "Pizza " + pizzaNumber + ": " + pizzaName +
                " (" + pizzaToppings + ", " + pizzaDefaultToppings + ") - " + pizzaPrice  + " DKK";
    }


    /** Method to print all the pizzas from the MenuCard **/
    public void printMenu()
    {
        for(PizzaItem pizza : pizzaItems)
        {
            System.out.println(pizza);
        }

    }


}


