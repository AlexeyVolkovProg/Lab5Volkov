package org.itmocorp.controller.commands;

public abstract class AbstractCommand {
    public String name;
    protected String help;

    public abstract void execute(String arguments);

    public String getHelp(){
        return help;
    }

    public String getName() {
        return name;
    }

}
