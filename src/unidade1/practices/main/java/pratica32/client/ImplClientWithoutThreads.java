package pratica32.client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ImplClientWithoutThreads {

    Socket cliente;
    InetAddress inet;
    Scanner teclado;
    PrintStream saida;
    String ip;
    int porta;
    public ImplClientWithoutThreads(String ip, int porta) {
        this.ip = ip;
        this.porta = porta;
        this.rodar();
    }
    private void rodar() {
        try {
            cliente = new Socket(ip, porta);
            System.out.println("O cliente se conectou ao servidor!");
            inet = cliente.getInetAddress();
            System.out.println("HostAddress = " + inet.getHostAddress());
            System.out.println("HostName = " + inet.getHostName());
            teclado = new Scanner(System.in);
            saida = new PrintStream(cliente.getOutputStream());
            while (teclado.hasNextLine()) {
                saida.println(teclado.nextLine());
            }
            saida.close();
            teclado.close();
            cliente.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
