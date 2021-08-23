package com.project46.listener;

import com.google.gson.Gson;
import com.Msg;
import com.project46.service.TestService;
import com.project46.service.TestServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//监听项目启动时，开启socket服务端监听
public class StartupLisener implements ServletContextListener {
    //模拟容器
    private static Map<String,Object> context = new HashMap<>();
    static{
        context.put("com.project45.service.TestService",new TestServiceImpl());
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //放入容器
        ServerSocket  serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true)
        {
            try
            {
                Socket server = serverSocket.accept();
                //DataInputStream in = new DataInputStream(server.getInputStream());
                ObjectInputStream in = new ObjectInputStream(server.getInputStream());
                Msg msg = (Msg)in.readObject();
                Object instance = context.get(msg.getInterfaceName());

                String[] names = msg.getParamTypes();
                Class[] argClass = new Class[names.length];
                for(int i=0;i<names.length;i++){
                    Class<?> c = Class.forName(names[i]);
                    argClass[i] = c;
                }

                Method method = instance.getClass().getDeclaredMethod(msg.getMethodName(),argClass);
                Object invoke = method.invoke(instance, msg.getArgs());

                /*String json = in.readUTF();
                System.out.println(json);
                //反射调用
                Gson gson = new Gson();
                Msg msg = gson.fromJson(json, Msg.class);

                //获取参数类型的数组
                Object instance = context.get(msg.getInterfaceName());
                String[] names = msg.getParamTypes();
                Object[] args = msg.getArgs();
                Class[] argClass = new Class[names.length];
                for(int i=0;i<names.length;i++){
                    Class<?> c = Class.forName(names[i]);
                    argClass[i] = c;
                    //给参数数组类型转换
                    //args[i] = c.cast(args[i]);
                }

                Method method = instance.getClass().getDeclaredMethod(msg.getMethodName(),argClass);
                Object invoke = method.invoke(instance, Double.parseDouble(args[0]+""));
                */
                //返回结果
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF(invoke+"");
                server.close();
            }catch(Exception e)
            {
                e.printStackTrace();
                break;
            }
        }

    }
}
