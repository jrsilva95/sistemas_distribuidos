package main;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import static main.Logger.*;

public class Reciver implements Runnable {

    private boolean running = true;
    private DatagramSocket datagramSocket;

    public Reciver(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }

    public void close(){
        this.datagramSocket.close();
        this.running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Message message = recive(datagramSocket);
                print("Mensagem recebida: " + message);
            } catch (IOException e) {
                error(e.getMessage());
            }
        }
    }

    public static Message recive(DatagramSocket socket) throws IOException {

        byte[] bufferRecive = new byte[1024];

        DatagramPacket datagramPacket = new DatagramPacket(
                bufferRecive,
                bufferRecive.length
        );

        socket.receive(datagramPacket);

        return convertByteArrayToMessage(bufferRecive);

    }

    private static Message convertByteArrayToMessage(byte[] message){

        try(ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(message);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)){
            Message messageRecived = (Message) objectInputStream.readObject();
            return messageRecived;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
