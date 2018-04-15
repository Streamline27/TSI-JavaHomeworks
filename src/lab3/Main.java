package lab3;

import java.util.Random;

public class Main {

    public static final int MAX_TO_BAKE = 6;
    public static final int MAX_TO_BUY = 10;

    public static final int MILLIS_TO_BAKE_MUFFIN = 100;
    public static final int MAX_CLIENT_WAITING_TIME = 1000;

    public static final int NUM_BAKERS_ITERATIONS = 100;
    public static final int NUM_CLIENT_ITERATIONS = 100;

    public static final Random random = new Random();

    public static void main(String[] args) {

        Thread bakerThread = new Thread(() -> {

            try {

                for (int i = 0; i < NUM_BAKERS_ITERATIONS; i++) {

                    int muffinsToBake = getMuffinsToBake();
                    Thread.sleep(muffinsToBake * MILLIS_TO_BAKE_MUFFIN);
                    Bakery.getInstance().addMuffins(muffinsToBake);
                }
                System.out.println("Bakers work is over!");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread clientThread = new Thread(() -> {

            try {

                for (int i = 0; i < NUM_CLIENT_ITERATIONS; i++) {

                    int millisBeforeVisit = random.nextInt(MAX_CLIENT_WAITING_TIME);
                    int muffinsToBuy = getClientRequest();
                    Thread.sleep(millisBeforeVisit);
                    Bakery.getInstance().buyMuffins(muffinsToBuy);
                }
                System.out.println("Bakery is closed!");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        bakerThread.start();
        clientThread.start();
    }

    private static int getClientRequest() {
        return random.nextInt(MAX_TO_BUY - 1) + 1;
    }

    private static int getMuffinsToBake() {
        return random.nextInt(MAX_TO_BAKE -1 ) + 1;
    }

}
