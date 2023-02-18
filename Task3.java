import java.io.FileReader;
import java.io.IOException;

/*В файле содержится строка с данными:
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, 
{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, 
{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]

Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика. */
public class Task3 {
    public static void main(String[] args) {
        String stringFromTxt = new String();
        try (FileReader reader = new FileReader("task3.txt")) {
            // читаем посимвольно
            int c;
            StringBuilder taskString = new StringBuilder();

            while ((c = reader.read()) != -1) {
                taskString.append((char) c);
            }
            stringFromTxt = taskString.toString();
            System.out.println(stringFromTxt);

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        MyStringBuilder(stringFromTxt);
    }

    private static void MyStringBuilder(String string) {
        String string1 = string.replace("{", "")
        .replace("}", "")
        .replace("[", "")
        .replace("]", "")
        .replace("\"", "")
        .replace("фамилия", "Студент")
        .replace(":", " ")
        .replace(",", " ")
        .replace("оценка", "получил оценку")
        .replace("предмет", "по предмету");
        System.out.println(string1);
    

    }
}
