package pratica1.execute;

public class SubtractThread implements Runnable {
    Integer v1, v2;

    public SubtractThread(Integer v1, Integer v2){
        this.v1 = v1;
        this.v2 = v2;
    }
    @Override
    public void run() {
        System.out.println("Sum Thread: " + (v1 - v2));
    }

}
