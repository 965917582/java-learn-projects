package com.project45.handler;

import com.google.gson.Gson;
import com.Msg;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("A调用test方法");
        String result = null;
        //与B通信
        try
        {
            Socket client = new Socket("127.0.0.1",8888);
            OutputStream outToServer = client.getOutputStream();
            //DataOutputStream out = new DataOutputStream(outToServer);
            ObjectOutputStream out = new ObjectOutputStream(outToServer);


            //向服务器端发送接口名，方法名，参数
            Msg msg = new Msg();
            msg.setInterfaceName(proxy.getClass().getInterfaces()[0].getName());
            msg.setMethodName(method.getName());

            /*String[] argsStr = new String[args.length];
            for(int i=0;i<args.length;i++){
                argsStr[i] = args[i]+"";
            }*/
            msg.setArgs(args);
            Class<?>[] parameterTypes = method.getParameterTypes();
            String [] pramTypes = new String [parameterTypes.length];
            for(int i=0;i<parameterTypes.length;i++){
                pramTypes[i] = parameterTypes[i].getName();
            }
            msg.setParamTypes(pramTypes);

            Gson gson = new Gson();
            String json = gson.toJson(msg);
            //out.writeUTF(json);
            out.writeObject(msg);

            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            result = in.readUTF();
            System.out.println("服务器响应： " + result);
            client.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }

        return result;
    }
}
