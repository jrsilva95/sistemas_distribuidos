package execute;

public class MultiplicationThread implements Runnable {
    Integer v1, v2;

    public MultiplicationThread(Integer v1, Integer v2){
        this.v1 = v1;
        this.v2 = v2;
    }
    @Override
    public void run() {
        System.out.println("Multiplication Thread: " + (v1 * v2));
    }

}
