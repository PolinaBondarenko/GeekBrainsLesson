import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestExp {

    public int exceptionTest(String string) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        String[][] arrayStrings = new String[4][4];
        String[] tempArr = string.split("\\W");
        if (tempArr.length != 16) throw new MyArraySizeException("Неправильное количество элментов!");
        int count = 0;
        for (int i = 0; i<4; i++){
            for (int j = 0; j<4;j++){
                arrayStrings[i][j] = tempArr[count++];
            }
        }

        for (int i = 0; i<arrayStrings.length; i++){
            for (int j = 0; j<arrayStrings[i].length; j++){
                int x = 0;
                try {
                    x = Integer.parseInt(arrayStrings[i][j]);
                } catch ( NumberFormatException e){
                    throw new MyArrayDataException("Некорректное значение строки: " + arrayStrings[i][j] + "Элемент: "+ i + ", " + j);
                }
                sum+=x;
            }
        }

        return sum/2;
    }

    public int exceptionTest() throws IOException, MyArraySizeException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        String [][] strMatrix = new String[4][4];

        System.out.println("Необходимо ввести 4 строки по 4 цифры, которые будут разделены пробелом, когда закончите наберите exit");

        String str = reader.readLine();
        int count = 0;

        while (!str.equalsIgnoreCase("exit")){
            String[] tempArr = str.split(" ");
            if (tempArr.length != 4 || count >= 4) throw new MyArraySizeException("Недопустимое количество элементов!");
            for (int i = 0; i< strMatrix[count].length; i++){
                strMatrix[count][i] = tempArr[i];
            }
            str = reader.readLine();
            count++;
        }

        System.out.println("Спасибо!");

        for (int i = 0; i<strMatrix.length; i++){
            for (int j = 0; j<strMatrix[i].length; j++){
                int x = 0;
                try {
                    x = Integer.parseInt(strMatrix[i][j]);
                } catch ( NumberFormatException e){
                    throw new MyArrayDataException("Некорректное значение строки: " + strMatrix[i][j] + "Элемент: "+ i + ", " + j);
                }
                sum+=x;
            }
        }

        return sum/2;
    }
}
