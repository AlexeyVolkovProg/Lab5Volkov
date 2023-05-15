package org.itmocorp.controller.commands;

import org.itmocorp.controller.managers.CommandManager;
import org.itmocorp.model.data.Product;
import org.itmocorp.model.data.UnitOfMeasure;

public class CountGreaterThanUnitOfMeasure extends AbstractCommand {
     public CountGreaterThanUnitOfMeasure(){
         name = "countGreaterThanUnitOfMeasure";
         help = "Выводит количество элементов, значение поля unitOfMeasure которых больше заданного";
     }

    @Override
    public void execute(String arguments) {
        int counter = 0;
        if (!arguments.equals("")) {
            System.out.println("Команда CountGreaterThanUnitOfMeasure начала свое выполнение");
            UnitOfMeasure unitOfMeasure = UnitOfMeasure.valueOf(arguments);
            for (Product product : CommandManager.collection) {
                if (product.getUnitOfMeasure().compareTo(unitOfMeasure) > 0) {
                    counter++;
                }
            }
            System.out.println(counter);
            System.out.println("Команда CountGreaterThanUnitOfMeasure начала свое выполнение");
        }else{
            System.out.println("Не был указан аргумент для данной команды");
        }

    }
}
