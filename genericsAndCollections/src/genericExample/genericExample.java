package genericExample;

import java.util.ArrayList;

public class genericExample {

    public static void main(String arg[])
    {
        ArrayList<Object> variables = new ArrayList<Object>();
        Double doubleNumber = 1.5;
        String name = "Sally";
        int intNumber = 1;
        char letter = 'a';

        variables.add(doubleNumber);
        variables.add(name);
        variables.add(intNumber);
        variables.add(letter);

        for (Object variable : variables) {
            genericExample.displayClassName(variable);
        }

    }
    static <T> void displayClassName(T variable) {
        System.out.println(variable.getClass().getName());
    }


}


