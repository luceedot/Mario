import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class OrderLine {

    private String name;
    private LocalDateTime pickUpTime;   /** Example: 2024-10-30 14:30 **/
    private OrderStatus orderStatus;

    ArrayList<Pizza> pizzasToMake = new ArrayList<>(); /** List for Mario of pizzas to make **/
    ArrayList<Pizza> currentOrder = new ArrayList<>(); /** List of orders that Alfonso has received **/
    ArrayList<Pizza> orderHistory = new ArrayList<>(); /** List with order history **/

    public OrderLine(String name, LocalDateTime pickUpTime, OrderStatus orderStatus) {
        this.name = name;
        this.pickUpTime = pickUpTime;
        this.orderStatus = orderStatus;
    }

    public void addPizza(String pizzaName) {
        Pizza newPizza = new Pizza(pizzaName); //create pizza with toppings
        pizzasToMake.add(newPizza);
        currentOrder.add(newPizza);
        orderHistory.add(newPizza); /** Add Pizza to orderHistory **/
        setOrderStatus(OrderStatus.IN_PROGRESS);
        System.out.println("Added pizza: " + newPizza.getName());
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
        if(pizzasToMake.isEmpty() && currentOrder.isEmpty())
        {
            setOrderStatus(OrderStatus.AWAITING_ORDER);
            System.out.println("No orders received. Awaiting order. ");
        }

        switch (orderStatus) {
            case IN_PROGRESS:
                if (!pizzasToMake.isEmpty()) {
                    System.out.println("Order is in progress.");
                } else {
                    setOrderStatus(OrderStatus.READY);
                    System.out.println("Order is ready for pickup");
                }
                break;

            case READY:
                if (pizzasToMake.isEmpty()) {
                    System.out.println("Order is ready for pickup.");
                } else {
                    setOrderStatus(OrderStatus.IN_PROGRESS);
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
                System.out.println("Order status is unclear.");
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
    if (orderHistory.isEmpty()) {
        System.out.println("No orders in history to calculate revenue.");
        return 0; // Return 0 revenue if there are no orders
    }
    double revenue = 0;
        for (Pizza pizza : orderHistory) {
            revenue += pizza.getPrice();

        }
    return revenue;
}

public void showBestsellers() {

        if (orderHistory.isEmpty()) {
        System.out.println("No orders in history to show bestsellers.");
        return; // Exit if there are no orders
        }
        Map<String, Integer> pizzaCount = new HashMap<>(); /** Count number of ordered pizzas**/

        for (Pizza pizza : orderHistory) {
            pizzaCount.put(pizza.getName(), pizzaCount.getOrDefault(pizza.getName(), 0) + 1);
        }

        System.out.println("The top 3 best-selling pizzas are the following: ");
        pizzaCount.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())) /** sorting pizzas by number sold**/
                .limit(3) /** Get top 3 **/
                .forEach(entry -> {
                    System.out.println("Pizza: " + entry.getKey() + " sold " + entry.getValue() + " times");
                });
}


    public void statisticsMenu() {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Which statistics would you like to check?");
        System.out.println("1. Check Revenue");
        System.out.println("2. View top 3 popular pizzas");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                double revenue = calculateRevenue();
                System.out.println("Revenue: " + revenue + "kr.");
                break;
            case 2:
                showBestsellers();
                break;
            default:
                System.out.println("Invalid choice, please try again");
                break;

        }
    }

}
