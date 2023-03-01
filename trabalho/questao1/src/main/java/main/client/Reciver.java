package main.client;

import main.model.Message;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import static main.log.Logger.*;

public class Reciver implements Runnable {

    private boolean running = true;
    private P client;

    public Reciver(P client) {
        this.client = client;
    }

    public void close(){
        client.getDatagramSocket().close();
        this.running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Message message = recive(client.getDatagramSocket());
                message.print();


                    message.setNewClient(client);

                    if(message.isClientIdEven()){
                        message.setValue(message.getValue() * 2);
                    } else {
                        message.setValue(message.getValue());
                    }

                if(!message.getClientOrigim().equals(client.getClientId())){

                    Sender.send(message, client);
                }
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
