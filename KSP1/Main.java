import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args)  {
        try(ServerSocket _server = new ServerSocket(8080)) {
            while (true) {
                Socket client = _server.accept();

                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                String message = in.readUTF();
                out.writeUTF("Server: Hi!");

                in.close();
                out.close();

                client.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
