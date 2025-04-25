package csc435.app;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ClientAppInterface {
    private ClientProcessingEngine engine;

    public ClientAppInterface(ClientProcessingEngine engine) {
        this.engine = engine;
    }

    public void readCommands() {
        Scanner sc = new Scanner(System.in);
        String command;

        while (true) {
            System.out.print("> ");
            command = sc.nextLine().trim();

            if (command.compareTo("quit") == 0) { 
                break;
            }

            if (command.length() >= 7 && command.substring(0, 7).compareTo("connect") == 0) {
                String[] parts = command.split(" ");
                if (parts.length == 3) {
                    engine.connect(parts[1], parts[2]);
                } else {
                    System.out.println("Connect <ip> <port>");
                }
                continue;
            }

            if (command.length() >= 8 && command.substring(0, 8).compareTo("get_info") == 0) {
                System.out.println("Client ID: " + engine.getInfo());
                continue;
            }

            if (command.length() >= 5 && command.substring(0, 5).compareTo("index") == 0) {
                String[] parts = command.split(" ", 2);
                if (parts.length == 2) {
                    engine.indexFiles(parts[1]);
                } else {
                    System.out.println("index <folder_path>");
                }
                continue;
            }

            if (command.length() >= 6 && command.substring(0, 6).compareTo("search") == 0) {
                String[] parts = command.split(" ", 2);
                if (parts.length == 2) {
                    String[] terms = parts[1].split(" AND ");
                    engine.searchFiles(new ArrayList<>(List.of(terms)));
                } else {
                    System.out.println("search <term1> AND <term2> ...");
                }
                continue;
            }

            System.out.println("unrecognized command!");
        }

        sc.close();
    }
}
