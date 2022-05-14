package util;

import java.util.Stack;

public class LoopCheck {
    private final Stack<String> arrayList = new Stack<>();
    public boolean loopCheck(String string){
        if (arrayList.contains(string)){
            return false;
        } else {
            arrayList.push(string);
            return true;
        }
    }
    public void remove(){
        arrayList.pop();
    }
}


