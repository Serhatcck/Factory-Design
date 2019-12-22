import java.io.IOException;
import java.net.ServerSocket;

public class FtpClass implements ProtocolInterface{
    @Override
    public void CreateConnection() {
        try {
            ServerSocket serverSocket = new ServerSocket(21);
            System.out.println("Link opened to FTP Protocol\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
