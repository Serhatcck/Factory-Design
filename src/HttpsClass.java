import java.io.IOException;
import java.net.ServerSocket;

public class HttpsClass implements ProtocolInterface {
    @Override
    public void CreateConnection() {
        try {
            ServerSocket serverSocket = new ServerSocket(80);
            System.out.println("Link opened to HTTPS Protocol\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
