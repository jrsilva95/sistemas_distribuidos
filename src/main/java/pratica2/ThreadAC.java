package pratica2;

public class ThreadAC implements Runnable {

    // synchronized faz com que somente uma thread
    // (da mesma instancia) execute o metodo por vez
    // enfileirando as threads
    @Override
    public synchronized void run() {
        App.contador++;
        System.out.println(Thread.currentThread().getName() + " : " + App.contador);
    }
}
