import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("Vælg en handling:");
            System.out.println("1. Tilføj pizza");
            System.out.println("2. Fjern pizza");
            System.out.println("3. Se ordrer");
            System.out.println("4. Se omsætning");
            System.out.println("5. Se bestsellers");
            System.out.println("6. Afslut");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1:
                    //tilføj pizza
                    System.out.println("Indtast pizza navn eller nr");
                    String pizzaName = scanner.nextLine();
                    int pizzaNumber = scanner.nextInt();
                    currentOrder.addPizza(pizzaName /** or pizza number?**/);
                    orderHistory.addPizza(currentOrder.getCurrentPizza());
                    break;
                case 2:
                    //fjern pizza
                    currentOrder.removePizza();
                case 3:
                    //se ordrestatus
                    currentOrder.checkOrderStatus();
                    break;
                case 4:
                    //se omsætning
                    int revenue = orderHistory.calculateRevenue();
                    System.out.println("Omsætning: " + revenue);
                    break;
                case 5:
                    //se bestsellers
                    orderHistory.showBestsellers();
                    break;
                case 6:
                    //afslut program
                    running = false;
                    break;

                default:
                    System.out.println("Ugyldigt valg, prøv igen");
                    break;

            }
        }
    }
}