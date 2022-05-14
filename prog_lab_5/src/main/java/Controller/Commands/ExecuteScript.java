package Controller.Commands;

import Controller.CollectionManager;
import Controller.FileManager;
import View.CommandQualifier;
import util.LoopCheck;

import java.util.ArrayList;

public class ExecuteScript extends  AbstractCommand{
    private LoopCheck checker = new LoopCheck();
    public ExecuteScript(CollectionManager collectionManager) {
        super(collectionManager, "execute_script", "read and execute the script from the specified file." +
                " The script contains commands in the same form in which they are entered by the user in interactive mode.");
    }

    @Override
    public void execute(String... args) {
        String filepath = args[0];
        checker.loopCheck("execute_script" + filepath);
        try {
            ArrayList<String> script = FileManager.readScript(filepath);
            for (String line: script) {
                if (!checker.loopCheck(line)) throw new SecurityException("Script is looping");
                int spaceIndex = line.indexOf(' ');
                AbstractCommand command;
                String argument = "";
                if (spaceIndex == -1) command = CommandQualifier.defineClass(line);
                else {
                    command = CommandQualifier.defineClass(line.substring(0, spaceIndex));
                    argument = line.substring(spaceIndex, line.length());
                }
                if (command == null) {
                    throw new SecurityException("Invalid script");
                }
                command.execute(argument.trim());
                checker.remove();
            }
        } catch (NullPointerException e) {
            System.out.println("No such file");
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
    }
}
