package main;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

public class Sender {

    public static void send(Message message, InetAddress address, int port, DatagramSocket socket) throws IOException {

        byte[] byteObject = convertMessageToByteArray(message);

        DatagramPacket datagramPacket = new DatagramPacket(
                byteObject,
                byteObject.length,
                address,
                port
        );

        socket.send(datagramPacket);

    }

    private static byte[] convertMessageToByteArray(Message message){
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(message);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
