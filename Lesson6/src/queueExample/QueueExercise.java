package queueExample;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExercise {

    public static void main(String args [])
    {
        Queue<String> customers = new LinkedList<>();

        customers.add("1234");
        customers.add("12345");
        customers.add("123456");

        while ( !customers.isEmpty())
        {
            System.out.println(customers.peek());
            customers.remove();
        }


    }
}
