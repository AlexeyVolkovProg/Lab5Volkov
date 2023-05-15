package org.itmocorp.controller.commands;

import org.itmocorp.controller.managers.CommandManager;

import java.rmi.activation.ActivationGroup_Stub;

public class Info extends AbstractCommand{
    public Info(){
        name = "info";
        help = "Выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов)";
    }

    @Override
    public void execute(String arguments) {
        if (arguments.equals("")){
            System.out.println("Команда info начала свое выполнение");
            System.out.println("Тип коллекции: " + CommandManager.collection.getClass().getName());
            System.out.println("Время создания коллекции: " + CommandManager.collectionTime);
            System.out.println("Количество элементов в коллеции: " + CommandManager.collection.size());
            System.out.println("Команда info закончила свое выполнение");
        }else{
            System.out.println("Данная команда не принимает аргументы");
        }
    }
}
