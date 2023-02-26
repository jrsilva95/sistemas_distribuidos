package pratica30.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ImplClient {

    String host;
    Integer door;

    public ImplClient(String host, Integer door){
        this.host = host;
        this.door = door;
        rodar();
    }
    private void rodar() {
        try {
            Socket socketClient = new Socket(host, door);

            DataInputStream entrada = new DataInputStream(socketClient.getInputStream());
            DataOutputStream saida = new DataOutputStream(socketClient.getOutputStream());

            var sc = new Scanner(System.in);

            System.out.println("Digite uma mensagem");

            String msg = sc.nextLine();

            System.out.println("\nMenssagem enviada ao servidor: " + msg);

            saida.writeUTF(msg);

            msg = entrada.readUTF();

            System.out.println("\nMenssagem recebida do servidor: " + msg);

            entrada.close();
            saida.close();
            socketClient.close();

        } catch (IOException e){

            System.err.println("Exceção: " + e.getMessage());

        }
    }

}
