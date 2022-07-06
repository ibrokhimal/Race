import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MainClass {
    public static int val = 0;
    public static int val2 = 0;
    public static Semaphore semaphore = new Semaphore(1);
    public static CountDownLatch cd = new CountDownLatch(4);
    public static CyclicBarrier cb = new CyclicBarrier(4);
    public static CyclicBarrier cb1 = new CyclicBarrier(4);
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

    }

    public static void secondMethod() {
        val++;
        if (val == CARS_COUNT) {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        }
    }

    public static void endRace() {
        val2++;
        if (val2 == CARS_COUNT*3) {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }
    }
}
