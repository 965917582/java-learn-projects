package socket;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        byte[] bytes = new byte[1024];
        is.read(bytes);
        System.out.println(bytes.toString());
        os.write("收到".getBytes("utf-8"));

    }
}
