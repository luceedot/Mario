import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderLine {

    private String name;
    private LocalDateTime pickUpTime;   /** Example: 2024-10-30 14:30 **/
    private OrderStatus orderStatus;


    ArrayList<Pizza> pizzasToMake = new ArrayList<>(); /** Liste for Mario af pizza som skal laves **/
    ArrayList<Pizza> currentOrder = new ArrayList<>(); /** Liste af ordrer som Alfonso har taget imod **/


    public OrderLine(String name, LocalDateTime pickUpTime, OrderStatus orderStatus) {  /** Constructor for Mario's array af pizza som skal laves **/
        this.name = name;
        this.pickUpTime = pickUpTime;
        this.orderStatus = orderStatus;
    }

    public currentOrder(String name, LocalDateTime pickUpTime, OrderStatus orderStstus){  /** Constructor for Alsonso's array af ordrer som han har taget imod  **/
        this.name = name;
        this.pickUpTime = pickUpTime;
        this.orderStatus = orderStatus;
    }

    public void addPizza(String pizzaName, String pizzaToppings){
        Pizza newPizza = new Pizza(pizzaName, pizzaToppings);

        pizzasToMake.add(newPizza);
        currentOrder.add(newPizza);

        orderStatus(OrderStatus.IN_PROGRESS);
    }

    public void removePizza(){
        Scanner input = new Scanner(System.in);
        System.out.println("Which pizza would you like to remove from the list? ");
        String inputRemove = input.nextLine();

        boolean pizzaFound = false;
        for(int i = 0; i < pizzasToMake.size(); i++){
            Pizza randomPizza = pizzasToMake.get(i);
            if(randomPizza.getName().equalsIgnoreCase(inputRemove)){
                pizzasToMake.remove(i);
                currentOrder.remove(i);
                System.out.println("Pizza removed: " + randomPizza.getName());
                pizzaFound = true;
                break;
            }

        }
        if(!pizzaFound) {
            System.out.println("Pizza not found: " + inputRemove);
        }

    }

    boolean pizzaFinished = false;
    boolean orderInProgress = false;

        while (!pizzaFinished) {
        switch (orderStatus) {
            case IN_PROGRESS:

                setOrderStatus(OrderStatus.IN_PROGRESS);
        }
        break;

        case READY:

            break;

        case COLLECTED:

            break;

        default:
            System.out.println("Awaiting an order");
            break;  /
    }
}

public String getName(){
    return name;
}
public void setName(String name){
    this.name = name;
}

public LocalDateTime getPickUpTime(){
    return pickUpTime;
}
public void setPickUpTime(LocalDateTime pickUpTime){
    this.pickUpTime = pickUpTime;
}

public OrderStatus getOrderStatus() {
    return orderStatus;
}
public void setOrderStatus(OrderStatus orderStatus){
    this.orderStatus = orderStatus;
}


