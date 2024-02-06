package iteratorExample;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorExercise {

    public static void main(String args[])
    {

        List<String> names = new LinkedList<String>();
        names.add("Mike");
        names.add("Alice");
        names.add("Bob");

        Iterator<String> it = names.iterator();


        while (it.hasNext())
        {
            System.out.println(it.next());

        }


    }
}
