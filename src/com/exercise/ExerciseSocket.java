package com.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ExerciseSocket {
	public static void main(String[] args) {
		Socket socket = null;
        try {
         //1、创建客户端Socket，指定服务器地址和端口
            socket = new Socket("10.46.22.248", 17991);
            //连接建立后，通过输出流向服务器发送请求信息。
            OutputStream os = socket.getOutputStream();
            // 由系统标准输入设备构造BufferedReader对象
            PrintWriter pw = new PrintWriter(os);

            InputStream is = socket.getInputStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(is, "gb2312"));
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            pw.write("R|00b0d07abcb0|1234|61| |0| |03745466|147258|WSWT| |");
            pw.println();
            //pw.write("\n");
            //R| 站点地址|1234|0|营业部|委托方式    
            pw.flush();
            //socket.shutdownOutput();
            String info = null; 
//            char[] bytes = new char[1024];
//            while (br.read(bytes) != -1) {
//            	String temp = new String(bytes);
//            	System.out.println(temp);
//            }
            byte[] bytes = new byte[1024];
            while (is.read(bytes) != -1) {
				String temp = new String(bytes);
				System.out.println(temp);
			}
            read(bytes);
            while ((info = br.readLine()) != null && info.length() != 0) {
            	
            	
                System.out.println(info);
                String[] arrays=info.split("\\|");
                System.out.println(arrays[3]);
                if("Y".equals(arrays[3])){
                 for(int i=0;i<Integer.parseInt(arrays[9]);i++){
                  /*ExecutorServiceUtil.addTask(new Runnable(){
                   
                  });*/
                  pw.write("R|00b0d07abcb0|1234|0|037|WSWT");
                        pw.flush();
                        String message = null;
                        while ((message = br.readLine()) != null) {
                            System.out.println(info);
                         }
                 }
                }
                
                if (info.length() < 1024)
            		break;
                
            }
            br.close();
            is.close();
            pw.close();
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }
    }
}
