import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;

public class HttpClient {

    public static void main(String[] args) throws Exception {
        goGet(null,null);
    }

    public static String goGet(String url, Map<String,String> params) throws Exception {
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;

        socket = new Socket("127.0.0.1", 8080);
        os = socket.getOutputStream();
        is = socket.getInputStream();


        String req = "GET /project19/hello HTTP/1.1\\r\\n"
                +"Host: localhost";


        //System.out.println(req);
        os.write(req.getBytes());


        byte[] bytes = new byte[1024*1024];
        int len = is.read(bytes);
        /*int len;
        while((len = is.read())!=-1){
            System.out.print(len);
        }*/
        System.out.println(new String(bytes,0,len));

        socket.close();








        return null;
    }

}
