package SetExample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetExercise {

    public static void main(String args [])
    {
        List<String> myList = new ArrayList<>();
        myList.add("7");
        myList.add("9");
        myList.add("7");
        myList.add("10");

        Set<String> mySet = new HashSet<String>(myList);

        for (String num : mySet)
        {
            System.out.println(num);
        }

    }
}
