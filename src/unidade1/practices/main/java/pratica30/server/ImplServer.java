package pratica30.server;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ImplServer {

    private Integer door;

    public ImplServer(Integer door){
        this.door = door;
        run();
    }

    private void run(){

        try {

            ServerSocket serverSocket = new ServerSocket(this.door);

            System.out.println("==== Iniciando servidor TCP ====");
            System.out.println("==== Servidor pronto para receber conexões ====");

            Socket socket = serverSocket.accept();

            System.out.println("Nova conexão com o cliente "+ socket.getInetAddress().getHostAddress());

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            String msg = inputStream.readUTF();

            System.out.println("Mensagem recebida do cliente: " + msg);

            msg = "Bem vindo e tchau!";

            System.out.println("Servidor enviando meensagem: "+ msg);

            outputStream.writeUTF(msg);

            inputStream.close();
            outputStream.close();
            socket.close();

            System.out.println("==== Conexão Finalizada ====");

            serverSocket.close();

        } catch (IOException e){
            System.err.println("Erro: " + e.getMessage());
        }

    }

}
