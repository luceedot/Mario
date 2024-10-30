import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //opret instans af currentOrder og OrderHistory klasser
        CurrentOrder currentOrder = new CurrentOrder("Kunde", LocalDateTime.now());
        OrderHistory orderHistory = new OrderHistory();

        boolean running = true;

        while (running) {
            System.out.println("Vælg en handling:");
            System.out.println("1. Tilføj pizza");
            System.out.println("2. Fjern pizza");
            System.out.println("3. Se ordrer");
            System.out.println("4. Se statistik");
            System.out.println("5. Afslut");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    //tilføj pizza
                    System.out.println("Indtast pizza navn");
                    String pizzaName = scanner.nextLine();
                    currentOrder.addPizza(pizzaName);
                    orderHistory.addPizza(currentOrder.getCurrentPizza());
                    break;
                case 2:
                    //fjern pizza
                    currentOrder.removePizza();
                    break;
                case 3:
                    //se ordrer
                    currentOrder.checkOrderStatus();
                    break;
                case 4:
                    //se statistik, omsætning + bestsellers
                    double revenue = orderHistory.calculateRevenue();
                    System.out.println("Omsætning: " + revenue + "kr.");
                    orderHistory.showBestsellers();
                    break;
                case 5:
                    //afslut program
                    running = false;
                    break;

                default:
                    System.out.println("Ugyldigt valg, prøv igen");
                    break;

            }
        }
        scanner.close();
    }
}