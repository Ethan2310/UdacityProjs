package mapsExample;

import java.util.HashMap;
import java.util.Map;

public class MapsExercise {

    public static void main(String args[])
    {

        Map<String,person> mapOfPeeps = new HashMap<>();

        person Ethan = new person("Ethan","evaraden@gmail.com");
        person Ronny = new person("Ronny","ronny@gmail.com");

        mapOfPeeps.put(Ethan.getEmail(),Ethan);
        mapOfPeeps.put(Ronny.getEmail(),Ronny);

        for(String email : mapOfPeeps.keySet())
        {
            System.out.println(email);
        }

    }
}
