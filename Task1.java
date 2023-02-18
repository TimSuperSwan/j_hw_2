import java.util.Arrays;

/*В файле содержится строка с исходными данными в такой форме:
{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
Для разбора строки используйте String.split. 
Сформируйте новую строку, используя StringBuilder. Значения null не включаются в запрос. */
public class Task1 {
    public static void main(String[] args) {
        String taskString = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        taskString = taskString.substring(1, taskString.length()-1);

        String[] arrayTaskString = taskString.split(", ", 0);
        System.out.println(Arrays.toString(arrayTaskString));

        StringBuilder resultBuilder =  new StringBuilder();
        resultBuilder.append("SELECT * FROM students WHERE ");
        
        boolean count = true;
        for (String string : arrayTaskString) {
            String[] keyValue = string.split(":", 0);
            String key = keyValue[0];
            key = key.replace("\"", "");
            String value = keyValue[1];
            if (!count) {
                resultBuilder.append(" AND ");
            }
            resultBuilder.append(String.format("%s = %s", key, value));
            count = false;
            
            

        }

        System.out.println(resultBuilder.toString());
    }

}
