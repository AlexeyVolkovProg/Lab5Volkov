package org.itmocorp.controller.commands;

import org.itmocorp.model.managers.CollectionManager;

public class Save extends AbstractCommand{
    public Save(){
        name = "save";
        help = "Сохраняет коллекцию в файл";
    }

    @Override
    public void execute(String arguments) {
        if (arguments.equals("")){
            System.out.println("Команда Save начала выполнение");
            CollectionManager.saveToFile();
            System.out.println("Команда Save закончила выполнение");
        }else{
            System.out.println("Данная команда не принимает аргументы");
        }

    }
}
