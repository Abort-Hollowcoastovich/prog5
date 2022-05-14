package util;

import java.util.ArrayList;

public abstract class UniquenessChecker {
    private static ArrayList<String> valuesList = new ArrayList<>();
    public static boolean partNumberChecker(String partNumber) {
        if (valuesList.contains(partNumber)) {
            return false;
        }
        else {
            valuesList.add(partNumber);
            return true;
        }
    }

}
