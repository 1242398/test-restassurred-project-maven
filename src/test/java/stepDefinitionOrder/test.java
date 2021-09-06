package stepDefinitionOrder;

public class test {
    public static void main(String args[]) {

        String orderId = "12";
        String order_payload = " {  " + "\n"+"\"orders\": "+ "[ " + "{" + "\n"+
                "\"orderId\"" +":" + "\"abcd\"" + "," +"\n"+
                "\"orderNo\"" + ":" + "\"asd\"" +  "," +"\n"+
                "\"itemName\"" + ":"+ "\"biscuit\"" + " ," + "\n"+
                "\"quantity\"" + ":" +  "\"100\"" + "," + "\n" +
                "\"amount\"" + ":" + "\"50\""  + ","  + "\n" +
                "\"deliverAdress\"" + ":" +  "{" + "\n" +
                "\"name\"" + ":" + "\"putu\"" +  "," + "\n" +
                "\"street\"" + ":" + "\"ghgg\"" +  "," + "\n" +
                "\"houseNo\"" + ":" + "\"301\""  + ","  + "\n" +
                "\"pinNo\"" + ":" + "\"276543\"" + "\n" +
               "\n" + "}" + "}" +
                " ]" + "\n" +
                "}";

        System.out.println(order_payload.replace("abcd", "123"));

    }
}
