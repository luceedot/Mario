import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderLine {

    private String name;
    private LocalDateTime pickUpTime;   /** Example: 2024-10-30 14:30 **/
    private OrderStatus orderStatus;

    ArrayList<Pizza> pizzasToMake = new ArrayList<>(); /** List for Mario of pizzas to make **/
    ArrayList<Pizza> currentOrder = new ArrayList<>(); /** List of orders that Alfonso has received **/

    public OrderLine(String name, LocalDateTime pickUpTime, OrderStatus orderStatus) {
        this.name = name;
        this.pickUpTime = pickUpTime;
        this.orderStatus = orderStatus;
    }

    public void addPizza(String pizzaName, String pizzaToppings) {
        Pizza newPizza = new Pizza(pizzaName, pizzaToppings);
        pizzasToMake.add(newPizza);
        currentOrder.add(newPizza);
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
                if(pizzasToMake.isEmpty()){
                    setOrderStatus(OrderStatus.READY);
                    System.out.println("Order is ready for pickup.");
                } else {
                    System.out.println("Pizzas are still being made.");
                }
                break;

            case COLLECTED:
                if(currentOrder.isEmpty()){
                    setOrderStatus(OrderStatus.COLLECTED);
                    System.out.println("Order has been collected.");
                }else
                    System.out.println("Pizzas are waiting to be collected.");
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
}
