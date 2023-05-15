package org.itmocorp.controller.managers;

import org.itmocorp.controller.commands.*;
import org.itmocorp.model.data.Product;
import org.itmocorp.model.managers.CollectionManager;

import java.util.*;

public class CommandManager {

    public static Map<String, AbstractCommand> commands = new HashMap<>();

    public static Vector<Product> collection = CollectionManager.getVectorProducts();
    public static Date collectionTime;
    private final Scanner scanner = new Scanner(System.in);

    private static boolean isRunning = true;

    private static boolean ScriptStatus = false;

    public static Map<String, AbstractCommand> getCommands() {
        return commands;
    }

    public CommandManager() {
        collectionTime = new Date();
        commands.put("add", new Add());
        commands.put("executeScript", new ExecuteScript());
        commands.put("show", new Show());
        commands.put("updateId", new UpdateId());
        commands.put("addIfMax", new AddIfMax());
        commands.put("groupCountingById", new GroupCountingById());
        commands.put("countGreaterThanUnitOfMeasure", new CountGreaterThanUnitOfMeasure());
        commands.put("exit", new Exit());
        commands.put("removeFirst", new RemoveFirst());
        commands.put("removeById", new RemoveById());
        commands.put("info", new Info());
        commands.put("save", new Save());
        commands.put("clear", new Clear());
        commands.put("printDescending", new PrintDescending());
        commands.put("help", new Help());
        commands.put("shuffle", new Shuffle());
    }

    //метод, который поможет узнать вашу команду и приступить к ее выполнению
    public void executeCommands() {
        try {
            while (isRunning) {
                System.out.print("Введите команду: ");
                String[] input = scanner.nextLine().trim().split("\\s+", 2);
                String commandName = input[0];
                String argument = input.length > 1 ? input[1] : "";
                AbstractCommand command = commands.get(commandName);
                if (command == null) {
                    System.out.println("Команда \"" + commandName + "\" не найдена. Введите \"help\" для списка команд.");
                } else {
                    try {
                        command.execute(argument);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка выполнения команды \"" + commandName + "\": " + e.getMessage());
                    }
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Ошибка выполнения команды из-за введенного необрабатываемого символа");
        }
    }

    public static void setRunning(boolean running) {
        isRunning = running;
    }

    public static void setScriptStatus(boolean scriptStatus) {
        ScriptStatus = scriptStatus;
    }

    public static boolean isScriptStatus() {
        return ScriptStatus;
    }
}
