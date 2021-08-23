import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.*;

public class MyHttpGet {
    private String host;
    private int port;
    private String contextPath;
    private StringBuffer requestMessage;
    private Map<String, String> headers = new LinkedHashMap<>();
    private Map<String, String> params = new HashMap<>();

    public MyHttpGet(String address) throws MalformedURLException {
        URL url = new URL(address);
        this.port = url.getPort();
        this.host = url.getHost();
        this.contextPath = url.getPath();

        headers.put("Host", this.host);
    }

    public InputStream execute() throws IOException {
        StringBuffer requestMessage = new StringBuffer();
        List<String> pairs = new ArrayList<>();
        // 处理查询参数
        params.keySet().stream().forEach(key->{
            StringBuffer pair = new StringBuffer();
            pair.append(key);
            pair.append("=");
            pair.append(params.get(key));
            pairs.add(pair.toString());
        });

        if(params.size() > 0){
            //String[] strings = (String[]) pairs.toArray();
            Object[] objects = pairs.toArray();
            String[] strings = new String[objects.length];
            for(int i=0;i<strings.length;i++){
                strings[i] = (String)objects[i];
            }
            //this.contextPath = this.contextPath + "?" + String.join("&", (String[])pairs.toArray());
            this.contextPath = this.contextPath + "?" + String.join("&", strings);


        }

        // http 协议内容
        requestMessage.append("GET " + this.contextPath + " HTTP/1.1" + System.getProperty("line.separator"));
        for(String key: headers.keySet()){
            requestMessage.append(key);
            requestMessage.append(": ");
            requestMessage.append(headers.get(key));
            requestMessage.append(System.getProperty("line.separator"));
        }

        requestMessage.append("\r\n");

        Socket socket = new Socket(host,port);
        /*SocketAddress socketAddress = new InetSocketAddress(this.host, this.port);
        socket.connect(socketAddress);*/

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        System.out.println(requestMessage.toString());
        bufferedWriter.write(requestMessage.toString());
        bufferedWriter.flush();

        return socket.getInputStream();
    }

    public MyHttpGet addParam(String key, String value){
        params.put(key, value);
        return this;
    }

    public MyHttpGet addHeader(String key, String value){
        headers.put(key, value);
        return this;
    }


}
