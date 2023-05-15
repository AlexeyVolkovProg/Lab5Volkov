package org.itmocorp.controller.commands;

import org.itmocorp.controller.handlers.ScriptHandler;

import java.io.File;

public class ExecuteScript extends AbstractCommand {

    public ExecuteScript(){
        name = "executeScript";
        help = "Считывает и исполняет скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }

    @Override
    public void execute(String arguments) {
        if (!arguments.equals("")) {
            ScriptHandler.startFile(arguments);
        }else{
            System.out.println("Данная команда требует указание пути к файлу исполняемого скрипта.");
        }
    }
}
