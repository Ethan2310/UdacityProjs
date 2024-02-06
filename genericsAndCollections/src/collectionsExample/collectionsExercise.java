package collectionsExample;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class collectionsExercise {

    public static void main(String args[]){

        List<String> names = new LinkedList<String>();

        names.add("Ethan");
        names.add("Presh");
        names.add("Charles");

        for(String name : names)
        {

            System.out.println(name);
        }

        Collections.sort(names);

        System.out.println("After Sort");

        for(String name : names)
        {

            System.out.println(name);
        }

    }
}
