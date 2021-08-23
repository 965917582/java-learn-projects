import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

public class Test {

    public static void main(String[] args) throws MalformedURLException {
        //MyHttpGet myHttpGet = new MyHttpGet("http://blog.csdn.net/lmy86263");
        MyHttpGet myHttpGet = new MyHttpGet("http://localhost:8080/project19/hello");

        myHttpGet.addHeader("Connection", "keep-alive");

        myHttpGet.addParam("name","zhangsan");
        myHttpGet.addParam("age","9");

        InputStream inputStream = null;
        try {
            inputStream = myHttpGet.execute();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while((line = bufferedReader.readLine()) != null){
                System.out.print(line + "\r\n");
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
