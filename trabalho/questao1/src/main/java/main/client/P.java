package main.client;

import main.model.Message;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

import static main.log.Logger.*;

public class P {

    private InetAddress targetAddress;
    private Integer targetPort;
    private Integer clientId;
    private Integer port;
    private DatagramSocket datagramSocket;
    private InetAddress address;
    private Boolean detailed;
    private Scanner scanner = new Scanner(System.in);

    public P(Integer clientId, Integer port, InetAddress targetAddress, Integer targetPort, Boolean detailed) throws IOException, InterruptedException {
        this.clientId = clientId;
        this.port = port;
        this.targetAddress = targetAddress;
        this.targetPort = targetPort;
        this.datagramSocket = new DatagramSocket(port);
        this.address = InetAddress.getLocalHost();
        this.detailed = detailed;
        run();
    }

    private void run() throws InterruptedException, IOException {

        Reciver reciver = new Reciver(this);

        Thread reciverThread = new Thread(reciver);
        reciverThread.start();

        online("Cliente " + clientId + " online no endereço " + address + ":" + port);

        print("Digite um valor inteiro maior que 0 que deseja enviar para " + targetAddress);
        print("ou digite 0 para sair");
        try {
            Integer value = scanner.nextInt();

            while (value != 0){
                Message message = new Message(this, value);
                Sender.send(message, this);
                value = scanner.nextInt();
            }

        } catch (Exception e){
            error(e);
        }

        info("Finalizando o processo");

        reciver.close();

    }

    public InetAddress getTargetAddress() {
        return targetAddress;
    }

    public void setTargetAddress(InetAddress targetAddress) {
        this.targetAddress = targetAddress;
    }

    public Integer getTargetPort() {
        return targetPort;
    }

    public void setTargetPort(Integer targetPort) {
        this.targetPort = targetPort;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public DatagramSocket getDatagramSocket() {
        return datagramSocket;
    }

    public void setDatagramSocket(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }

    public InetAddress getAddress() {
        return address;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Boolean getDetailed() {
        return detailed;
    }

    public void setDetailed(Boolean detailed) {
        this.detailed = detailed;
    }

}
