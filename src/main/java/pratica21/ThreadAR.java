package pratica21;

public class ThreadAR implements Runnable {

    /*
    Ao criar o bloco syncronized precisa informar qual o objeto esta sendo sincronizado
     */
    @Override
    public void run() {

        int v = (int) (Math.random() * 50);

        synchronized (this) {
            App.contador++;
            System.out.println(Thread.currentThread().getName() + " : " + App.contador);
        }

        System.out.println(Thread.currentThread().getName() + " escreve v: " + v);

    }
}
