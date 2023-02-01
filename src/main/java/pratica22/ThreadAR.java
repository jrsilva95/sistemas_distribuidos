package pratica22;

public class ThreadAR implements Runnable {

    /*
    Ao criar o bloco syncronized precisa informar qual o objeto esta sendo sincronizado
     */
    @Override
    public void run() {

        int v = (int) (Math.random() * 50);

        // codigo fora da região critica

        synchronized (this) {
            App.contador++;
            System.out.println(Thread.currentThread().getName() + " : " + App.contador);
        }

        synchronized (this) {
            App.contador--;
            System.out.println(Thread.currentThread().getName() + " : " + App.contador);
        }

        // codigo fora da região critica

    }
}
