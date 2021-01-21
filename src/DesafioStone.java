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

        Map<String, Integer> results = calculate(itemList,emailList, true);
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
        //
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


