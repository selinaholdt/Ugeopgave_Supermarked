import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class CashRegister {
    FileIO io = new FileIO();
    Robot robot = new Robot();

    ArrayList<Vare> alleVarer = io.alleVarer("data/varer.csv");
    HashMap<String, Vare> tilbudsVarer = io.tilbudsVarer("data/tilbud.csv");

    public void receipt (){
        ArrayList<Vare> basket = (ArrayList<Vare>) robot.fyldIKurv(alleVarer);
        HashMap<Vare, Integer> map = new HashMap<>();
        for (Vare item : basket){
            Vare placeHolder = tilbudsVarer.get(item.getId());
            if(placeHolder != null) {
                item.setSaved(item.getPrice()- placeHolder.getPrice());
            }
            map.merge(item, 1, Integer::sum);
        }

        double receiptSum = 0;
        for (Vare v : map.keySet()){
            receiptSum += v.getPrice();
        }

        double tax = 0;
        tax = receiptSum * 0.25;

        //Receipt

        System.out.println(" ==== Receipt ==== ");
        for (Vare vare : map.keySet()){
            System.out.println( vare.getName() + "\n"+ map.get(vare) + " x " + vare.getPrice()
            + " kr. = " + map.get(vare) * vare.getPrice() + " kr.");
            if (vare.getSaved()> 0) {
                System.out.println("== Discount ==" +
                        "\n -" + vare.getSaved());
            }
            System.out.println("\n");
        }






    }








}

