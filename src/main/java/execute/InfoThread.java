package execute;

public class InfoThread implements Runnable {
    @Override
    public void run() {

        Thread t = Thread.currentThread();

        System.out.println("Name: " + t.getName());
        System.out.println("ID: " + t.getId());
        System.out.println("Priority: " + t.getPriority());
        System.out.println("State: " + t.getState());
        System.out.println("Alive: " + t.isAlive());

    }

}
