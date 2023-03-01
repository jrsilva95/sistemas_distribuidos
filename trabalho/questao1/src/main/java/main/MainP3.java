package main;

import main.client.P;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MainP3 {

    public static void main(String[] args) {
        try {

            InetAddress targetAddress = InetAddress.getByName("localhost");

            P client = new P(3, 5054, targetAddress, 5055, true);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
