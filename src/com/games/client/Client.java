package com.games.client;

import com.games.commands.AddUserCommand;
import com.games.commands.CommandRegistry;
import com.games.commands.StartGameCommand;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Client {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static CommandRegistry registry = new CommandRegistry();

    public static void main(String[] args) {

        registry.addCommand(new StartGameCommand());
        registry.addCommand(new AddUserCommand());
        try {
            execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void execute() throws IOException {
        boolean toContinue = true;
        while(toContinue) {
            System.out.println("Enter a command..");
            String command = reader.readLine();
            registry.executeCommand(command);
            toContinue = false;
        }
    }

}
