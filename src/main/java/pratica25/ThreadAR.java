package pratica25;

public class ThreadAR implements Runnable {

    @Override
    public void run() {

        String nome = Thread.currentThread().getName();
        App.lista.add(nome);
        System.out.println(nome + " inseriu na lista");

    }
}
