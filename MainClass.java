import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {
    public static void main(String[] args) {

       TestExp testExp = new TestExp();
        String conditionStr =  "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        int number = 0;
        try {
           number = testExp.exceptionTest(conditionStr);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }

        System.out.println("Первый вариант решения: " + number);



        int number2 = 0;
        try {
            number2 = testExp.exceptionTest();
        } catch (IOException | MyArraySizeException e) {
            e.printStackTrace();
        }

        System.out.println("Второй вариант решения:" + number2);
    }
}
