public class Pizza {
    protected String pizzaName;
    /** Standard toppings used for all pizzas **/
    protected String pizzaDefaultToppings;


    public Pizza() {
        this.pizzaDefaultToppings = "Standard toppings";
    }
public String getName() {
        return pizzaName;
}
public double getPrice() {
    // Temporary placeholder for price
        return 100.0;
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
    public MenuCard(/* PizzaItem[] items*/)
    {
        this.pizzaItems = new PizzaItem[]{

                new PizzaItem(1, "Vesuvio", "tomato sauce, cheese, ham, and oregano", 57),
                new PizzaItem(2, "Amerikaner", "tomato sauce, cheese, ground beef, and oregano", 53),
                new PizzaItem(3, "Cacciatore", "tomato sauce, cheese, pepperoni, and oregano", 57),
                new PizzaItem(4, "Carbona", "tomato sauce, cheese, meat sauce, spaghetti, cocktail sausages, and oregano", 63),
                new PizzaItem(5, "Dennis", "tomato sauce, cheese, ham, pepperoni, cocktail sausages, and oregano", 65),
                new PizzaItem(6, "Bertil", "tomato sauce, cheese, bacon, and oregano", 57),
                new PizzaItem(7, "Silvia", "tomato sauce, cheese, pepperoni, red pepper, onions, olives, and oregano", 61),
                new PizzaItem(8, "Victoria", "tomato sauce, cheese, ham, pineapple, mushrooms, onions, and oregano", 61),
                new PizzaItem(9, "Toronfo", "tomato sauce, cheese, ham, bacon, kebab, chili, and oregano", 61),
                new PizzaItem(10, "Capricciosa", "tomato sauce, cheese, ham, mushrooms, and oregano", 61),
                new PizzaItem(11, "Hawaii", "tomato sauce, cheese, ham, pineapple, and oregano", 61),
                new PizzaItem(12, "Le Blissola", "tomato sauce, cheese, ham, shrimp, and oregano", 61),
                new PizzaItem(13, "Venezia", "tomato sauce, cheese, ham, bacon, and oregano", 61),
                new PizzaItem(14, "Mafia", "tomato sauce, cheese, pepperoni, bacon, onions, and oregano", 61),
        };

    }

    /** Inner class that describes individual pizzas in the menu card **/
    public static class PizzaItem {

        /** Attributes **/
        private final int pizzaNumber;
        private final String pizzaName;
        private final String pizzaToppings;
        private final double pizzaPrice;



        /**
         * Constructor that initializes the name, number, price, and toppings for each pizza
         **/
        public PizzaItem(int number, String name, String toppings, double price) {

            this.pizzaNumber = number;
            this.pizzaName = name;
            this.pizzaToppings = toppings;
            this.pizzaPrice = price;
        }

        /**
         * toString method that returns a readable description of the pizza
         **/
        @Override
        public String toString() {
            return "Nr. " + pizzaNumber + ": " + pizzaName +
                    " (" + pizzaToppings + ") - " + pizzaPrice + " kr.";
        }
    }

        /** Method to print all the pizzas from the MenuCard **/
        public void printMenu() {
            System.out.println("Menu:");
            for (PizzaItem pizza : pizzaItems) {
                System.out.println(pizza);
            }
            System.out.println("\n");
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