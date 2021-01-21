import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DesafioStone {
    public static void main(String[] args)  {
        Utils.log("Aplicacao Iniciada",true);

        //Inicializando as Variáveis
        List<Item> itemList = new ArrayList<>();
        List<Email> emailList = new ArrayList<>();

        //This flag turn on (true) or off(false) a detail log of
        Boolean showDetailsLog = false;


        //Carregar a Lista de Itens - ADICIONAR A LISTA itemList UM NOVO Item
        //  itemList.add(new Item(description, quantity, unitaryValue));
        //#########################################################################################################################
        itemList.add(new Item("Produto 1",20,1600));
        itemList.add(new Item("Produto 2",7,300));
        itemList.add(new Item("Produto 3",1,100));
        //#########################################################################################################################
        //FIM DE CARREGAR A LISTA DE ITENS


        //Carregar a Lista de Emails - ADICIONAR A LISTA emailList
        // emailList.add(new (Email(mailAddress));
        //#########################################################################################################################
        emailList.add(new Email("z_user1@provider"));
        emailList.add(new Email("a_user2@provider"));
        emailList.add(new Email("user3@provider"));
        //#########################################################################################################################
        //FIM DE CARREGAR A LISTA DE EMAILS

        Map<String, Integer> results = calculate(itemList,emailList, showDetailsLog);
        System.out.println(results);





        Utils.log("Aplicacao Finalizada",true);
    }



    public static Map<String, Integer> calculate(List<Item> itemList, List<Email> emailList, Boolean showDetails){
        Map<String, Integer> hashMap= new HashMap<String, Integer>();

        Integer totalValueList = 0;
        //Totalizando os valores da lista de itens
        Utils.log("---------------------------------------------- Itens da Lista --------------------------------------------------------",showDetails);
        for (Item item : itemList){
            Utils.log(item.toString(),showDetails);
            totalValueList += item.getTotalItem();
        }
        Utils.log("        Valor Total da Lista => R$ "+Utils.formatFloat(Utils.convertDouble(totalValueList)/100),showDetails);

        Utils.log("---------------------------- Rateio dos valores --------------------------------------",showDetails);
        Integer i = 0;
        for(Email email : emailList){
            Integer valueParcel = (totalValueList / (emailList.size() - i));
            totalValueList -= valueParcel;
            Double valueParcelDouble = Utils.convertDouble(valueParcel)/ 100;
            Utils.log(email.getMailAddress() + "  |  Valor do Rateio: R$ "+Utils.formatFloat(valueParcelDouble),showDetails);
            hashMap.put(email.getMailAddress() ,valueParcel);

            i++;
        }

        if(totalValueList > 0){
            Utils.log("          ---------     A T E N Ç Ã O !!!     ---------          ",showDetails);
            Utils.log("Não foram informadas pessoas para compor a lista de rateio",showDetails);
        }

        return hashMap;

    }



}



class Email {
    private String mailAddress;


    public Email(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
}


class Item {

    private String description;
    private Integer quantity;
    private Integer unitaryValue;

    public Item() {
    }

    public Item(String description, Integer quantity, Integer unitaryValue) {
        this.description = description;
        this.quantity = quantity;
        this.unitaryValue = unitaryValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getUnitaryValue() {
        return unitaryValue;
    }

    public void setUnitaryValue(Integer unitaryValue) {
        this.unitaryValue = unitaryValue;
    }

    public Integer getTotalItem(){
        return (quantity * unitaryValue);
    }

    @Override
    public String toString() {
        return
                "Produto: "+getDescription()+
                        "  | Quantidade: "+getQuantity()+
                        "  | Unitario: R$ "+Utils.formatFloat( Utils.convertDouble(getUnitaryValue())/100)+
                        "  | Subtotal: R$ "+Utils.formatFloat( Utils.convertDouble(getTotalItem())/100);
    }
}

class Utils {

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
