package pratica32.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ImplServerWithoutThreads {

    ServerSocket servidor;
    Socket cliente;
    Scanner entrada;
    int porta;
    public ImplServerWithoutThreads(int porta) {
        this.porta = porta;
        this.rodar();
    }
    private void rodar() {
        try {
            servidor = new ServerSocket(porta);
            System.out.println("Servidor rodando na porta " +
                    servidor.getLocalPort());
            System.out.println("HostAddress = " +
                    InetAddress.getLocalHost().getHostAddress());
            System.out.println("HostName = " +
                    InetAddress.getLocalHost().getHostName());
            cliente = servidor.accept();
            System.out.println("Nova conexão com o cliente " +
                    cliente.getInetAddress().getHostAddress());
            entrada = new Scanner(cliente.getInputStream());
            while (entrada.hasNextLine()) {
                System.out.println(entrada.nextLine());
            }
            entrada.close();
            servidor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
