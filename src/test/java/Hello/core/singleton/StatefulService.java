package Hello.core.singleton;

public class StatefulService {
    private int price;

    public void order(String name, int price){
        System.out.println(name);
        this.price = price;
    }

    public int getPrice(){
        return price;
    }
}
