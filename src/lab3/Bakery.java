package lab3;

public class Bakery  {
    private static Bakery ourInstance = new Bakery();

    public static Bakery getInstance() {
        return ourInstance;
    }

    private int bakedMuffins;

    private Bakery() {
        this.bakedMuffins = 0;
    }

    public synchronized int buyMuffins(int desiredCount) {

        if (desiredCount > bakedMuffins) {
            int actuallyBought = bakedMuffins;
            bakedMuffins = 0;
            System.out.println("Client wanted to buy " + desiredCount + " muffins but actually bought " + actuallyBought);
            return actuallyBought;
        }
        else {
            System.out.println("Client bought " + desiredCount + " muffins");
            bakedMuffins -= desiredCount;
            return desiredCount;
        }
    }

    public synchronized void addMuffins(int muffinCount) {
        System.out.println("Baker baked: " + muffinCount + " (Total supply: " + bakedMuffins + ")");
        bakedMuffins += muffinCount;
    }
}
