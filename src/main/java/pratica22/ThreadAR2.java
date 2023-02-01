package pratica22;

public class ThreadAR2 implements Runnable {

    Object porta1 = new Object();
    Object porta2 = new Object();

    /*
    Ao definir portas diferentes aumenta-se a concorrencia dos processos, pois a thread não fica restrita a trava da
    classe atual
     */
    @Override
    public void run() {

        int v = (int) (Math.random() * 50);

        synchronized (porta1) {
            App.contador++;
            System.out.println(Thread.currentThread().getName() + " : " + App.contador);
        }

        synchronized (porta2) {
            App.contador--;
            System.out.println(Thread.currentThread().getName() + " : " + App.contador);
        }

    }
}
