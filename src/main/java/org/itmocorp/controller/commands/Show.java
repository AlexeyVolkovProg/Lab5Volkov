package org.itmocorp.controller.commands;

import org.itmocorp.controller.managers.CommandManager;
import org.itmocorp.model.data.Product;

public class Show extends AbstractCommand{
    public Show(){
        name = "show";
        help = "Выводит в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    @Override
    public void execute(String arguments){
        if (arguments.equals("")){
            System.out.println("Была вызвана команда Show");
            if (CommandManager.collection.size() == 0) {
                System.out.println("На данный момент коллекция пуста");
            }else{
                for (Product x : CommandManager.collection) {
                    System.out.println(x);
                }
            }
        }else{
            System.out.println("Данная команда не принимает аргументы.");
        }
    }
}
