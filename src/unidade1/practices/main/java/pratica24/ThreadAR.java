package pratica24;

public class ThreadAR implements Runnable {

    /*
    Ao criar o bloco syncronized precisa informar qual o objeto esta sendo sincronizado
     */
    @Override
    public void run() {

        int threadCont;

        synchronized (this) {
            App.contador++;
            threadCont = App.contador * 2;
        }

        double pot = threadCont * 50;
        double raiz = Math.sqrt(pot);
        System.out.println(Thread.currentThread().getName() + " ecreve: " + raiz);

        for(int i = 0; i < 50; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            threadCont = (int) (threadCont + Math.random() * 20);
            System.out.println(Thread.currentThread().getName() + " : " + threadCont);

        }

    }

}
