package pratica1.execute;

public class SumThread implements Runnable {
    Integer v1, v2;

    public SumThread(Integer v1, Integer v2){
        this.v1 = v1;
        this.v2 = v2;
    }
    @Override
    public void run() {
        System.out.println("Subtract Thread: " + (v1 + v2));
    }

}
