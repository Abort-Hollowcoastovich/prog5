package View;

import Controller.CollectionManager;
import Controller.Commands.AbstractCommand;
import Controller.Commands.*;

import java.util.HashMap;
import java.util.Map;

public class CommandQualifier {
    public static Map<String, AbstractCommand> map = new HashMap<>();
    public static void setMap(CollectionManager collectionManager) {
        map.put("add", new Add(collectionManager));
        map.put("add_if_max", new AddIfMax(collectionManager));
        map.put("clear", new Clear(collectionManager));
        map.put("count_less_than_manufacturer", new CountLessThanManufacturer(collectionManager));
        map.put("exit", new Exit(collectionManager));
        map.put("group_counting_by_price", new GroupCountingByPrice(collectionManager));
        map.put("info", new Info(collectionManager));
        map.put("remove_by_id", new RemoveById(collectionManager));
        map.put("remove_greater", new RemoveGreater(collectionManager));
        map.put("show", new Show(collectionManager));
        map.put("shuffle", new Shuffle(collectionManager));
        map.put("update_id", new UpdateId(collectionManager));
        map.put("help", new Help(collectionManager));
        map.put("save", new Save(collectionManager));
        map.put("print_field_descending_unit_of_measure", new PrintFieldDescendingUnitOfMeasure(collectionManager));
        map.put("execute_script", new ExecuteScript(collectionManager));
    }
    public static AbstractCommand defineClass (String name) {
        return map.get(name);
    }
}
