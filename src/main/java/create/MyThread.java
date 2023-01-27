package create;

public class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("Olá Mundo Paralelo");
    }

}
