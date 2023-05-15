package org.itmocorp.controller.commands;


import org.itmocorp.controller.handlers.ScriptHandler;
import org.itmocorp.controller.managers.CommandManager;
import org.itmocorp.controller.handlers.InputHandler;
import org.itmocorp.model.data.Product;

public class Add extends AbstractCommand{

    public Add(){
        name = "add";
        help = "Команда позволяет добавить новый элемент в коллекцию";
    }

    @Override
    public void execute(String arguments) {
        System.out.println("Была вызвана команда ADD");
        if (arguments.equals("")) {
            if (!CommandManager.isScriptStatus()) {
                Product product = InputHandler.ArgumentsReader();
                if (product != null) {
                    CommandManager.collection.add(product);
                    System.out.println("Новый объект был успешно добавлен в вашу коллекцию");
                }else{
                    System.out.println("Новый объект не был добавлен в коллекцию, так не удалось его сформировать");
                }
            } else {
                Product product = ScriptHandler.getProductFromFile();
                if (product != null) {
                    CommandManager.collection.add(product);
                }else{
                    System.out.println("Новый объект не был добавлен в коллекцию, так не удалось его сформировать");
                }
            }
        }else{
            System.out.println("Данная команда не принимает аргументы.");
        }
    }
}
