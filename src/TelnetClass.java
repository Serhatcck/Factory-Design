import java.io.IOException;
import java.net.ServerSocket;

public class TelnetClass implements ProtocolInterface{
    public void CreateConnection() {
        try {
            ServerSocket serverSocket = new ServerSocket(23);
            System.out.println("Link opened to TELNET Protocol\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
