package org.itmocorp.controller.commands;

import org.itmocorp.controller.handlers.ScriptHandler;
import org.itmocorp.controller.managers.CommandManager;
import org.itmocorp.controller.handlers.InputHandler;
import org.itmocorp.model.data.Product;

//todo сделать проход по коллекции
public class UpdateId extends AbstractCommand{


    public UpdateId(){
        name = "updateId";
        help = "Обновить значение элемента коллекции, id которого равен заданному";
    }

    @Override
    public void execute(String arguments) {
        if (arguments.equals("")) {
            System.out.println("Для выполнения данной команды требуется аргумент");
        } else {
            System.out.println("Была вызвана команда UpdateId");
            int id = Integer.parseInt(arguments);
            if (id < CommandManager.collection.size() && id >= 0) {
                if (!CommandManager.isScriptStatus()) {
                    for (int i = 0; i < CommandManager.collection.size(); i++) {
                        if (CommandManager.collection.get(i).getId() == id) {
                            CommandManager.collection.set(i, InputHandler.ArgumentsReader());
                            System.out.println("Элемент c id " + id + " успешно изменен");
                        }
                    }
                } else {
                    Product product = ScriptHandler.getProductFromFile();
                    if (product != null) {
                        for (int i = 0; i < CommandManager.collection.size(); i++) {
                            if (CommandManager.collection.get(i).getId() == id) {
                                CommandManager.collection.set(i, product);
                                System.out.println("Элемент c id " + id + " успешно изменен");
                            }
                        }
                    }
                }
            }else{
                System.out.println("Элемента по данному id в коллекции нет, поэтому обновить его не получится.");
            }
        }
    }
}
