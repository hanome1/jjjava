package jjjava.hw2;

public class hw2 {

    private static String sqlbuilder(String request) {
        String requestStart = "select * from students where ";
        // String jsonReq = "{\"name\":\"Ivanov\",\"country\":\"Russia\",\"city\":\"Moscow\",\"age\":null}";
        StringBuilder newstr = new StringBuilder().append(request).deleteCharAt(request.length() - 1).deleteCharAt(0);
        StringBuilder result = new StringBuilder().append(requestStart);
        String[] parts = newstr.toString().split(",");
        int temp = result.length();
        for (int i = 0; i < parts.length; i++) {
            String[] kv = parts[i].split(":");
            // System.out.println(kv[1]);
            if (kv[1].contains("null") == false) {
                if (i != 0)
                    result.append(" and ");
                temp = result.length();
                result.append(kv[0]).deleteCharAt(temp).deleteCharAt(result.length() - 1);
                result.append(" = " + kv[1]);
                

                // System.out.println(result);
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
       
        String jsonReq = "{\"name\":\"Ivanov\",\"country\":\"Russia\",\"city\":\"Moscow\",\"age\":null}";
        System.out.println(sqlbuilder(jsonReq));
        jsonReq = "{\"name\":\"Ivanov\",\"country\":\"null\",\"city\":\"Moscow\",\"age\":null}";
        System.out.println(sqlbuilder(jsonReq));
        
        
    }

}
