import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class OrderLine {

    private String name;
    private LocalDateTime pickUpTime;   /** Example: 2024-10-30 14:30 **/
    private OrderStatus orderStatus;

    ArrayList<Pizza> pizzasToMake = new ArrayList<>(); /** List for Mario of pizzas to make **/
    ArrayList<Pizza> currentOrder = new ArrayList<>(); /** List of orders that Alfonso has received **/
    ArrayList<Pizza> orderHistory = new ArrayList<>(); /** Liste med ordrehistorik **/

    public OrderLine(String name, LocalDateTime pickUpTime, OrderStatus orderStatus) {
        this.name = name;
        this.pickUpTime = pickUpTime;
        this.orderStatus = orderStatus;
    }

    /**
    public OrderLine(String name, LocalDateTime pickUpTime, OrderStatus orderStatus) {
        this.name = name;
        this.pickUpTime = pickUpTime;
        this.orderStatus = orderStatus;
    }
**/

    public void addPizza(String pizzaName, String pizzaToppings) {
        Pizza newPizza = new Pizza(pizzaName, pizzaToppings); //create pizza with toppings
        pizzasToMake.add(newPizza);
        currentOrder.add(newPizza);
        orderHistory.add(newPizza); /** tilføj Pizza til orderHistory **/
        setOrderStatus(OrderStatus.IN_PROGRESS);
    }

    public void removePizza() {
        Scanner input = new Scanner(System.in);
        System.out.println("Which pizza would you like to remove from the list? ");
        String inputRemove = input.nextLine();

        boolean pizzaFound = false;
        for (int i = 0; i < pizzasToMake.size(); i++) {
            Pizza randomPizza = pizzasToMake.get(i);
            if (randomPizza.getName().equalsIgnoreCase(inputRemove)) {
                pizzasToMake.remove(i);
                currentOrder.remove(i);
                System.out.println("Pizza removed: " + randomPizza.getName());
                pizzaFound = true;
                break;
            }
        }
        if (!pizzaFound) {
            System.out.println("Pizza not found: " + inputRemove);
        }
    }

    public void checkOrderStatus() {
        switch (orderStatus) {
            case IN_PROGRESS:
                if (!pizzasToMake.isEmpty() && !currentOrder.isEmpty()) {
                    setOrderStatus(OrderStatus.IN_PROGRESS);
                    System.out.println("Order is in progress.");
                } else {
                    setOrderStatus(OrderStatus.AWAITING_ORDER);
                }
                break;

            case READY:
                if (pizzasToMake.isEmpty()) {
                    setOrderStatus(OrderStatus.READY);
                    System.out.println("Order is ready for pickup.");
                } else {
                    System.out.println("Pizzas are still being made.");
                }
                break;

            case COLLECTED:
                if (currentOrder.isEmpty()) {
                    setOrderStatus(OrderStatus.COLLECTED);
                    System.out.println("Order has been collected.");
                } else {
                    System.out.println("Pizzas are waiting to be collected.");
                    }
                break;
            default:
                System.out.println("Awaiting an order.");
                break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(LocalDateTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }


public double calculateRevenue() {
        double revenue = 0;
        for (Pizza pizza : orderHistory) {
            revenue += pizza.getPrice();
            // vi mangler en method der hedder getPrice
        }
    return revenue;
}

public void showBestsellers() {
        Map<String, Integer> pizzaCount = new HashMap<>(); /** tæller antallet af bestilte pizzaer**/

        for (Pizza pizza : orderHistory) {
            pizzaCount.put(pizza.getName(), pizzaCount.getOrDefault(pizza.getName(), 0) + 1);
        }

        pizzaCount.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())) /** sorterer pizzaer efter antal bestilte**/
                .limit(3) /** få kun top 3**/
                .forEach(entry -> {
                    System.out.println("De top 3 solgte pizzaer er følgende:");
                    System.out.println("Pizza: " + entry.getKey() + " solgt " + entry.getValue() + " gange");
                });
}


    public void statisticsMenu() {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Hvilken statistik vil du gerne se?");
        System.out.println("1. Se omsætning");
        System.out.println("2. Se top 3 mest populære pizzaer");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                double revenue = calculateRevenue();
                System.out.println("Omsætning: " + revenue + "kr.");
                break;
            case 2:
                showBestsellers();
                break;
            default:
                System.out.println("Ugyldigt valg, prøv igen");
                break;

        }


    }

}
