package main;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import static main.Logger.online;
import static main.Logger.print;
import static main.Logger.info;

public class P {

    private InetAddress targetAddress;
    private Integer targetPort;
    private Integer clientId;
    private Integer port;
    private DatagramSocket datagramSocket;
    private InetAddress address;
    private Scanner scanner = new Scanner(System.in);

    public P(Integer clientId, Integer port, InetAddress targetAddress, Integer targetPort) throws IOException, InterruptedException {
        this.clientId = clientId;
        this.port = port;
        this.targetAddress = targetAddress;
        this.targetPort = targetPort;
        this.datagramSocket = new DatagramSocket(port);
        this.address = InetAddress.getLocalHost();
        run();
    }

    private void run() throws InterruptedException, IOException {

        Reciver reciver = new Reciver(datagramSocket);

        Thread reciverThread = new Thread(reciver);
        reciverThread.start();

        online("Cliente " + clientId + " online no endereço " + address + ":" + port);

        print("Digite um valor inteiro maior que 0 que deseja enviar para " + targetAddress);
        print("ou digite 0 para sair");
        try {
            Integer value = scanner.nextInt();
        } catch (Exception e){

        }


        while (value != 0){
            Message message = new Message(clientId, value);
            Sender.send(message,targetAddress,targetPort, datagramSocket);
            value = scanner.nextInt();
        }

        info("Finalizando o processo");

        reciver.close();

    }

}
