package execute;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Thread t0 = new Thread(new SumThread(10,20));
        Thread t1 = new Thread(new MultiplicationThread(10,20));
        Thread t2 = new Thread(new SubtractThread(10,20));

        t0.start();
        t1.start();
        t2.start();

        Thread t3 = new Thread(new InfoThread());
        t3.start();
        System.out.println(t3.isAlive());

    }

}
