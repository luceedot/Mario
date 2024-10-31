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
        return 100.0; /** 100 er bare midlertidig placeholder for pris **/

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
    public MenuCard(/**PizzaItem[] items**/)
    {
        this.pizzaItems = new PizzaItem[]{
          new PizzaItem(1, "Vesuvio","tomatsauce, ost, skinke og oregano", 57 ),
          new PizzaItem(2, "Amerikaner","tomatsauce, ost, oksefars og oregano", 53),
          new PizzaItem(3, "Cacciatore","tomatsauce, ost, pepperoni og oregano",57),
          new PizzaItem(4, "Carbona","tomatsauce, ost, kødsauce, spaghetti, cocktailpølser og oregano",63),
          new PizzaItem(5, "Dennis","tomatsauce, ost, skinke, pepperoni, cocktailpølser og oregano", 65),
          new PizzaItem(6, "Bertil","tomatsauce, ost, bacon og oregano", 57),
          new PizzaItem(7, "Silvia","tomatsauce, ost, pepperoni, rød peber, løg, oliven og oregano", 61),
          new PizzaItem(8, "Victoria","tomatsauce, ost, skinke, ananas, champignon, løg og oregano", 61),
          new PizzaItem(9, "Toronfo","tomatsauce, ost, skinke, bacon, kebab, chili og oregano", 61),
          new PizzaItem(10, "Capricciosa","tomatsauce, ost, skinke, champignon og oregano", 61),
          new PizzaItem(11, "Hawaii","tomatsauce, ost, skinke, ananas og oregano", 61),
          new PizzaItem(12, "Le Blissola","tomatsauce, ost, skinke, rejer og oregano", 61),
          new PizzaItem(13, "Venezia","tomatsauce, ost, skinke, bacon og oregano", 61),
          new PizzaItem(14, "Mafia","tomatsauce, ost, pepperoni, bacon, løg og oregano", 61),




        };

    }

    /** Inner class that describes individual pizzas in the menu card **/
    public static class PizzaItem {

        /** Attributes **/
        private int pizzaNumber;
        private String pizzaName;
        private String pizzaToppings;
        private double pizzaPrice;



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
            return "Pizza " + pizzaNumber + ": " + pizzaName +
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