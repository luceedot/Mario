import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       MenuCard menuCard = new MenuCard();

         OrderLine orderLine = new OrderLine("customer", LocalDateTime.now(), OrderStatus.AWAITING_ORDER);

        boolean running = true;

        while (running) {
            menuCard.printMenu();

            System.out.println("Choose an option:");
            System.out.println("1. Add pizza");
            System.out.println("2. Remove pizza");
            System.out.println("3. Check order");
            System.out.println("4. View statistics");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    //Add pizza
                    System.out.println("Enter pizza name");
                    String pizzaName = scanner.nextLine();
                    orderLine.addPizza(pizzaName);
                    System.out.println("Current order: ");
                    for(Pizza pizza : orderLine.currentOrder) {
                        System.out.println(pizza.getName());
                    }


                    break;
                case 2:
                    //Remove pizza
                    orderLine.removePizza();
                    break;
                case 3:
                    //Check order
                    orderLine.checkOrderStatus();
                    break;
                case 4:
                    //View statistics, revenue + bestsellers
                    orderLine.statisticsMenu();
                    break;
                case 5:
                    //Exit program
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;

            }
        }
        scanner.close();
    }
}
