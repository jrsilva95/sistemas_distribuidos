package pratica29;

public class App {

    public static void main(String[] args) {

        int[] array = {2,4,6,8,10};

        ThreadAR threadAR1 = new ThreadAR(array);
        ThreadAR threadAR2 = new ThreadAR(array);
        ThreadAR threadAR3 = new ThreadAR(array);

    }

}
