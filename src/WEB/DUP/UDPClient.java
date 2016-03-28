/**
 * Reference:Computer Networking A Top-Down Approach 计算机网络：自顶向下方法
 */
/**
 * Reference:Computer Networking A Top-Down Approach 计算机网络：自顶向下方法
 */
package WEB.DUP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Created by lsy on 2016/3/26.
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        byte[] recveData = new byte[1024];
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9875);
        clientSocket.send(sendPacket);
        DatagramPacket receivePacket = new DatagramPacket(recveData, recveData.length);
        clientSocket.receive(receivePacket);
        String modifiedSentence = new String(receivePacket.getData());
        System.out.println(modifiedSentence);
        clientSocket.close();
    }
}
