package pratica31.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class ImplServerUDP {

    private int porta;
    private String host;
    private DatagramSocket socketServidor = null;

    public ImplServerUDP(int porta) {
        this.porta = porta;
        run(this.porta);
    }

    public void run(int porta) {
        try {
            /*
             * DatagramSocket servidor na porta 5050.
             */
            socketServidor = new DatagramSocket(porta);
            host = String.valueOf(InetAddress.getLocalHost());
            System.out.println("Servidor executando no endereço " +
                    host +
                    ":" +
                    porta);
            /*
             * Cria o datagrama para receber uma mensagem.
             */
            byte[] bufferRecebimento = new byte[1024];
            DatagramPacket datagramaRecebimento =
                    new DatagramPacket(
                            bufferRecebimento,
                            bufferRecebimento.length);
            /*
             * Aguarda até o recebimento de uma mensagem.
             */
            socketServidor.receive(datagramaRecebimento);
            bufferRecebimento = datagramaRecebimento.getData();
            String mensagem = new String(bufferRecebimento);
            System.out.println("Servidor recebeu a mensagem < " + mensagem);
            System.out.println("Preparando uma resposta");
            /*
             * Enviando uma resposta
             */
            String msgResposta = "resposta:" + inverteString(mensagem);
            System.out.println(msgResposta);
            byte[] bufferEnvio = msgResposta.getBytes(StandardCharsets.UTF_8);
            DatagramPacket pacoteEnvio =
                    new DatagramPacket(
                            bufferEnvio,
                            bufferEnvio.length,
                            datagramaRecebimento.getAddress(),
                            datagramaRecebimento.getPort());
            socketServidor.send(pacoteEnvio);
            System.out.println("Servidor enviou resposta > " + msgResposta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
// Fechando o servidor.
            if (socketServidor != null)
                socketServidor.close();
        }

    }

    public static String inverteString(String s) {
        String retorna = "";
        s = s.trim();
        int len = s.length();
        for (int i = len; i > 0; i--) {
            if (i - 1 >= 0)
                retorna = retorna + s.charAt(i - 1);
        }
        return retorna;
    }

}
