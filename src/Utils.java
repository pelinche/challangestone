public class Utils {

    public static String formatFloat(Double value){
        return String.format("%.2f",value);
    }
    public static void log(String message,Boolean showDetails){
        if(showDetails) {
            System.out.println(message);
        }
    }

    public static Double convertDouble(Integer value){
        return Double.valueOf(value);
    }

    public static String lpad(String text,Integer quantity, char character ){
        if (quantity > 0) {
            StringBuffer result = new StringBuffer(quantity);

            for (int i = text.length() ; i < quantity; i++) {
                result.append(character);
            }

            return text + result.toString();
        } else {
            return text;
        }
    }
}
