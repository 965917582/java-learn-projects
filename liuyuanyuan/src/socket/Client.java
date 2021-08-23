package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",9999);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        String s = "http协议";
        os.write(s.getBytes("utf-8"));
        byte[] bytes = new byte[1024];
        is.read(bytes);
        System.out.println(bytes.toString());
    }
}
