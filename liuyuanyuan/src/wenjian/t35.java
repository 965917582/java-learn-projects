package wenjian;

import java.io.FileOutputStream;
import java.io.IOException;

public class t35 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("Hello.txt");
        fos.write("HelloJavaWorld你好世界".getBytes("utf-8"));

    }
}
