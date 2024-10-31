import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       MenuCard menuCard = new MenuCard();

         OrderLine orderLine = new OrderLine("kunde", LocalDateTime.now(), OrderStatus.AWAITING_ORDER);

        boolean running = true;

        while (running) {
            menuCard.printMenu();

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
                    break;
                case 2:
                    //fjern pizza
                    orderLine.removePizza();
                    break;
                case 3:
                    //se ordrer
                    orderLine.checkOrderStatus();
                    break;
                case 4:
                    //se statistik, omsætning + bestsellers
                    orderLine.statisticsMenu();
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
