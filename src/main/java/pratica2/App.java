package pratica2;

public class App {

    static int contador = 0;

    public static void main(String[] args) {

        ThreadAC tac = new ThreadAC();

        Thread t0 = new Thread(tac);
        Thread t1 = new Thread(tac);
        Thread t2 = new Thread(tac);
        Thread t3 = new Thread(tac);
        Thread t4 = new Thread(tac);

        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

}
