import java.util.Scanner;
import java.util.Queue;
import java.util.List;

import java.time.LocalDateTime;;

public class Methods {
    static Scanner keyboard = new Scanner(System.in);

    public int getAction() {
        try {
            System.out.println("---------------------------");
            System.out.println("---Welcome to Esperanza Bank---");
            System.out.println("1. Add client to queue");
            System.out.println("2. Attend client in shift");
            System.out.println("3. See next client in shift");
            System.out.println("4. Watch queue");
            System.out.println("5. Watch all registered shifts");
            System.out.println("6. Exit");

            System.out.print("Type the option you want do: ");
            int option = keyboard.nextInt();

            return option;
        } catch(Exception err) {
            keyboard.nextLine(); // Buffer reset
            return 0;
        }
    }

    public boolean addClient(Queue<Client> actualQueue, Queue<Client> ticketsRegistered) {
        keyboard.nextLine(); // Buffer reset

        System.out.println("---------------------------");
        System.out.println("---Add a new client to queue---");

        // Requesitng client data
        System.out.print("Type the name: ");
        String name = keyboard.nextLine();

        System.out.println("Type of service ");
        System.out.println("1. Withdrawal");
        System.out.println("2. Consignment");
        System.out.println("3. Advice");
        System.out.print("Type the number of the option: ");
        int optionType = keyboard.nextInt();

        String serviceType;

        switch (optionType) {
            case 1:
                serviceType = "withdrawal";
                break;
            case 2:
                serviceType = "consignment";
                break;
            case 3:
                serviceType = "advice";
                break;
            default:
                System.out.println("That option doesn't exists");
                return false; // Breaks the running
        }

        String arrivalTime = LocalDateTime.now().toString();

        // Create new client obj
        Client newClient = new Client(ticketsRegistered.size(), name, serviceType, arrivalTime, false);

        // Adding to queue
        actualQueue.add(newClient);

        // Adding to tickets registered
        ticketsRegistered.add(newClient);

        // Printing result
        System.out.println("Added client shift to system.");

        return true;
    }

    public boolean attendClient(Queue<Client> actualQueue, Queue<Client> ticketsRegistered) {
        // Checking if it's empty
        if(actualQueue.isEmpty()) {
            System.out.println("There isn't any client to attend");
            return false;
        }
        
        // Changing client attend date
        Client actualClient = actualQueue.poll();

        actualClient.setServed(true);

        // Printing result
        System.out.println("Client served.");

        return true;
    }

    public boolean nextClient(Queue<Client> actualQueue) {
        // Checking if it's empty or if there isn't next client
        if(actualQueue.isEmpty()) {
            System.out.println("There isn't any client to attend");
            return false;
        }

        // Printing it
        Client nextClient = actualQueue.peek();

        System.out.println(nextClient.toString());

        return true;
    }

    public boolean watchQueue(Queue<Client> actualQueue) {
        // Checking that it's not empty
        if(actualQueue.isEmpty()) {
            System.out.println("There isn't any client to attend");
            return false;
        }

        // Printing it
        for(Client actualClient : actualQueue) {
            System.out.println(actualClient.toString());
        }

        return true;
    }

    public boolean watchShifts(Queue<Client> ticketsRegistered) {
        // Checking that isn't empty
        if(ticketsRegistered.isEmpty()) {
            System.out.println("There isn't any client to attend");
            return false;
        }

        // Printing it
        for(Client actualClient : ticketsRegistered) {
            System.out.println(actualClient.toString());
        }

        return true;
    }
}
