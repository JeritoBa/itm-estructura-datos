import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class app {
    private static Queue<Client> clientsQueue = new LinkedList<>();
    private static Queue<Client> ticketsRegistered = new LinkedList<>();

    private static Methods bank = new Methods();

    public static void main(String[] args) {
        boolean execution = true;

        // Showing menu
        while (execution) {
            int option = bank.getAction();

            switch (option) {
                case 0:
                    System.out.println("Please type an int");
                    break;
                case 1:
                    bank.addClient(clientsQueue, ticketsRegistered);
                    break;
                case 2:
                    bank.attendClient(clientsQueue, ticketsRegistered);
                    break;
                case 3:
                    bank.nextClient(clientsQueue);
                    break;
                case 4:
                    bank.watchQueue(clientsQueue);
                    break;
                case 5:
                    bank.watchShifts(ticketsRegistered);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    execution = false;

                    break;
                default:
                    System.out.println("This option doesn't exists");
                    break;
            }
        }
    }
}
