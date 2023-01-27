package create;

import create.MyThread;

public class Main {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread t0 = new Thread(new MyThread());
        Thread t1 = new Thread(new MyThread());
        t0.start();
        t1.start();

        Thread t2 = new Thread(
                () -> System.out.println("Sou uma outra thread...")
        );
        t2.start();

        Thread t3 =  new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread numa classe anonima");
            }
        });

        t3.start();
    }

}
