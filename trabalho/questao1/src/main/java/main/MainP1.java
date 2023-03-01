package main;

import main.client.P;
import main.log.Logger;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MainP1 {

    public static void main(String[] args) {

        Integer clientId = 1;
        Integer port = 5052;
        String targetAddress = "localhost";
        Integer targetPort = 5053;
        Boolean detailed = true;

        if(System.getenv("RUN_ON_DOCKER") != null && System.getenv("RUN_ON_DOCKER").equals("TRUE")){
            //clientId = Integer.parseInt(System.getenv("CLIENT_ID"));
            //port = Integer.parseInt(System.getenv("PORT"));
            targetAddress = System.getenv("TARGET_ADDRESS");
            // = Integer.parseInt(System.getenv("TARGET_PORT"));
            //detailed = Boolean.parseBoolean(System.getenv("DETAILED"));
            Logger.print(targetAddress);
        }

        try {

            InetAddress inetTargetAddress = InetAddress.getByName(targetAddress);

            P client = new P(clientId, port, inetTargetAddress, targetPort, detailed);
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
