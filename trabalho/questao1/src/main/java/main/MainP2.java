package main;

import main.client.P;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MainP2 {

    public static void main(String[] args) {
        try {

            InetAddress targetAddress = InetAddress.getByName("localhost");

            P client = new P(2, 5053, targetAddress, 5054, true);
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
