package pratica25;

import java.util.ArrayList;
import java.util.List;

public class App {

    static List<String> lista = new ArrayList<>();

    public static void main(String[] args) {

        //lista

        ThreadAR tar = new ThreadAR();

        Thread t0 = new Thread(tar);
        Thread t1 = new Thread(tar);
        Thread t2 = new Thread(tar);

        t0.start();
        t1.start();
        t2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(lista);

    }

}
