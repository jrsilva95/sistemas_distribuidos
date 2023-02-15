package pratica31.client;

import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ImplClientUDP {

    DatagramSocket socketClient;
    Scanner sc = new Scanner(System.in);

    public ImplClientUDP(){
        rodar();
    }

    private void rodar(){

        try {
            socketClient = new DatagramSocket();

            InetAddress address = InetAddress.getByName("localhost");

            System.out.println("Cliente rodando em: " + socketClient.getLocalPort());

            System.out.println("Digite uma mensagem:");

            String msg = sc.nextLine();

            byte[] buffetSend = msg.getBytes(StandardCharsets.UTF_8);

            DatagramPacket datagramPacket = new DatagramPacket(
                    buffetSend,
                    buffetSend.length,
                    address,
                    5051
            );

            System.out.println("Cliente " + address.getHostAddress() + " " +
                    socketClient.getLocalPort() + " " +
                    "enviando mensagem " + msg);

            socketClient.send(datagramPacket);

            byte[] bufferRecive = new byte[1024];

            DatagramPacket datagramPacketRecive = new DatagramPacket(
                    bufferRecive,
                    bufferRecive.length
            );

            socketClient.receive(datagramPacketRecive);

            bufferRecive = datagramPacketRecive.getData();

            System.out.println("Mensagem recebida: " + new String(bufferRecive));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
            socketClient.close();
        }

    }

}
