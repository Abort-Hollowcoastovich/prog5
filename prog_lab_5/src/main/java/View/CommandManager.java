package View;

import Controller.Commands.AbstractCommand;

public class CommandManager {
    public static void commandManager(String input) {
        try {
            int spaceIndex = input.indexOf(' ');
            AbstractCommand command;
            String argument = "";
            if (spaceIndex == -1) command = CommandQualifier.defineClass(input);
            else {
                command = CommandQualifier.defineClass(input.substring(0, spaceIndex));
                argument = input.substring(spaceIndex, input.length());
            }
            if (command == null) {
                throw new SecurityException("Enter the command in lower case using underscore instead of space");
            }
            command.execute(argument.trim());
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
    }
}
