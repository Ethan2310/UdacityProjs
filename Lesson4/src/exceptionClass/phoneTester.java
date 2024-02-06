package exceptionClass;

public class phoneTester {

    public static void main(String[] args) {
        String[] numbers = new String[] { "123-4567", null, "234-4567", "345-5678" };

        for (int i = 0; i < numbers.length; i++) {
            try {
                System.out.println(new Phone("iPhone", numbers[i]));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getLocalizedMessage());
            }

        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(new Phone("iPhone", numbers[i]));

        }
    }
}
