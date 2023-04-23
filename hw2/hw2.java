// package jjjava.hw2;

import java.io.IOException;
import java.util.logging.*;

public class hw2 {

    private static String sqlbuilder(String request) {
        String requestStart = "select * from students where "; // начало строки запроса sql
        // "{\"name\":\"Ivanov\",\"country\":\"Russia\",\"city\":\"Moscow\",\"age\":null}";
        StringBuilder newstr = new StringBuilder().append(request).deleteCharAt(request.length() - 1).deleteCharAt(0); // отсекли скобки в json
        StringBuilder result = new StringBuilder().append(requestStart); // начали строить sql запрос
        String[] parts = newstr.toString().split(","); // разбили запрос на массив
        int temp = result.length(); // маркер последнего символа
        for (int i = 0; i < parts.length; i++) {
            String[] keyval = parts[i].split(":"); // разбили часть запроса на ключ и значение
            // System.out.println(kv[1]);
            if (keyval[1].contains("null") == false) {
                if (i != 0)
                    result.append(" and "); // добавляем энд после первой части запроса
                temp = result.length(); // обновляем маркер
                result.append(keyval[0]).deleteCharAt(temp).deleteCharAt(result.length() - 1); // убираем кавычки в
                                                                                               // ключе
                result.append(" = " + keyval[1]); // добавляем значение для ключа

                // System.out.println(result);
            }
        }
        return result.toString();
    }
    
    public static Logger log = Logger.getLogger(hw2.class.getName());

    private static String bubbleSort(int[] arr) {
        // Logger logger = Logger.getLogger(hw2.class.getName());
        log.info("bubbleSort starting");


        StringBuilder result = new StringBuilder();
        int temp = 0;
        String msg = "";
        for (int j = 0; j < arr.length - 1; j++) {

            msg = "SCANNING try "+(j+1)+"  of "+arr.length;
            log.info(msg);

            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {

                    msg = "replacing elements "+(i+1)+" and "+(i+2);
                    log.info(msg);

                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
                
            }

            log.info("array has been sorted");

        }
        for (int i = 0; i < arr.length; i++) {
            result.append(arr[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException{

        FileHandler fh = new FileHandler("log.txt");
        log.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        
        int[] array = { 2, 6, 8, 3, 7, 6, 8, 4, 5, 7, 9, 1, 2, 0 };
        System.out.println(bubbleSort(array));

    }

}
