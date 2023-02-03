package pratica29;

public class Recurso {

    int soma;

    public int somaVetor(int[] n) throws InterruptedException {

        soma = 0;

        synchronized (n) {

            for (int i = 0; i < n.length; i++) {
                soma += n[i];
            }

            Thread.sleep(500);

        }

        return soma;
    }

}
