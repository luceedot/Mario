public class Pizza {
    protected String pizzaName;
    /** Standardtoppings used for all pizzas **/
    protected String pizzaDefaultToppings;


    public Pizza() {
        this.pizzaDefaultToppings = "Standard toppings";
    }
public String getName() {
        return pizzaName;
}
public double getPrice() {
        return 100.0; // 100 er bare midlertidig placeholder for pris

}

    /** Constructor that initializes pizzaDefaultToppings **/
    public Pizza(String pizzaName, String defaultToppings) {
        this.pizzaName = pizzaName;
        this.pizzaDefaultToppings = defaultToppings;
    }
    public Pizza (String pizzaName) {
        this.pizzaName = pizzaName;
    }
}

/** Subclass representing a menu card of pizzas**/
class MenuCard extends Pizza {

    /** Array containing all pizzas in the menu card **/
    private final PizzaItem[] pizzaItems;


    /** Constructor for MenuCard that receives default toppings and an array of pizzas **/
    public MenuCard(String defaultToppings, PizzaItem[] items)
    {
        super(defaultToppings);
        this.pizzaItems = items;
    }

    /** Inner class that describes individual pizzas in the menu card **/
    public static class PizzaItem {

        /** Attributes **/
        private String pizzaName;
        private int pizzaNumber;
        private double pizzaPrice;
        private String pizzaToppings;


        /**
         * Constructor that initializes the name, number, price, and toppings for each pizza
         **/
        public PizzaItem(String name, int number, double price, String toppings) {
            this.pizzaName = name;
            this.pizzaNumber = number;
            this.pizzaPrice = price;
            this.pizzaToppings = toppings;
        }

        /**
         * toString method that returns a readable description of the pizza
         **/
        @Override
        public String toString() {
            return "Pizza " + pizzaNumber + ": " + pizzaName +
                    " (" + pizzaToppings + ") - " + pizzaPrice + " DKK";
        }
    }

        /** Method to print all the pizzas from the MenuCard **/
        public void printMenu() {
            for (PizzaItem pizza : pizzaItems) {
                System.out.println(pizza);
            }

        }

}


/**  summary of the key components and how they work together:
  1. Pizza Class: Holds pizzaDefaultToppings, which is inherited by MenuCard.

  2. MenuCard Class:
 Contains an array of PizzaItem objects representing each pizza on the menu.
 Has a printMenu method to print all pizzas in the pizzaItems array.

 3. PizzaItem Inner Class: Represents individual pizzas with specific attributes
 and provides a toString method for easy display.
 **/