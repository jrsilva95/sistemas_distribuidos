package pratica29;

public class ThreadAR implements Runnable {

    static Recurso recurso = new Recurso();
    int[] numeros;

    public ThreadAR(int[] numeros){
        this.numeros = numeros;
        new Thread(this).start();
    }

    @Override
    public void run() {

        String nome = Thread.currentThread().getName();
        System.out.println(nome + " -> começou");

        int soma = 0;
        try {
            soma = recurso.somaVetor(this.numeros);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(nome + " - resultado da soma do vetor: " + soma);

        System.out.println(nome + " -> terminou");

    }
}
