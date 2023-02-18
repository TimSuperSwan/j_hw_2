import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл. */
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Введите числа через пробел: ");
        Scanner sc = new Scanner(System.in);
        String numbers = sc.nextLine();

        String[] numbersArray = MakeArray(numbers);
        SortArrayAndLog(numbersArray);
        sc.close();
    }

    private static String[] MakeArray(String numbersString) {
        String[] numbersArray = numbersString.split(" ", 0);

        // int[] numbersArrayInt = new int[numbersArray.length];
        // for (int i = 0; i < numbersArrayInt.length; i++) {
        // numbersArrayInt[i] = Integer.parseInt(numbersArray[i]);
        // }

        return numbersArray;
    }

    private static void SortArrayAndLog(String[] numbersArray) {
        for (int i = 0; i < numbersArray.length - 1; i++) {
            for (int j = 0; j < numbersArray.length - i - 1; j++) {
                try{
                    if (Integer.parseInt(numbersArray[j]) > Integer.parseInt(numbersArray[j + 1])) {
                        try {
                            String temp = numbersArray[j];
                            numbersArray[j] = numbersArray[j + 1];
                            numbersArray[j + 1] = temp;
                        } catch (Exception ex) {
                            System.err.println("Ошибка :" + ex);
                        }

                    }
                } catch(Exception ex) {
                    System.err.println("Ошибка :" + ex);

                }
            }
        }
        System.out.println(Arrays.toString(numbersArray));

    }
}
