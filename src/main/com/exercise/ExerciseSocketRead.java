package com.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ExerciseSocketRead {

	public static void main(String[] args) {
		ExerciseSocketRead main = new ExerciseSocketRead();
		
		try {
			// 1、创建客户端Socket，指定服务器地址和端口
			Socket socket = new Socket("10.46.22.248", 17991);
			// 连接建立后，通过输出流向服务器发送请求信息。
			OutputStream os = socket.getOutputStream();
			// 由系统标准输入设备构造BufferedReader对象
			PrintWriter pw = new PrintWriter(os);

			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "gb2312"));
			// os.write("R|00b0d07abcb0|1234|61| |0| |03745466|147258|WSWT|
			// |".getBytes());
			// os.flush();
			main.sendData(os, "R|00b0d07abcb0|1234|61| |0| |03745466|147258|WSWT| |");
			// pw.write("R|00b0d07abcb0|1234|61| |0| |03745466|147258|WSWT|
			// |\r\n".getBytes());
			// R| 站点地址|1234|0|营业部|委托方式
			// pw.flush();
			// socket.shutdownOutput();
			String info = null;
			byte[] buffer = new byte[1024 * (is.read() / 1024 + 1)];
			String[] arrays = null;
			System.out.println(is.read(buffer));
			if (!socket.isClosed() && !socket.isInputShutdown()) {
				/* while ((info = br.readLine()) != null) { */
				info = new String(buffer).trim();
				System.out.println(info);
				arrays = info.split("\\|");
				System.out.println(arrays[3]);
			}

			if (arrays != null && arrays.length > 0 && "Y".equals(arrays[3])) {
				for (int i = 0; i < Integer.parseInt(arrays[9]); i++) {
					// pw.write("R|00b0d07abcb0|1234|0|037|WSWT\n");
					// pw.flush();
					// os.write("R|00b0d07abcb0|1234|0|037|WSWT".getBytes());
					// os.flush();
					main.sendData(os, "R|00b0d07abcb0|1234|0|037|WSWT");
					byte[] buffers = new byte[1024 * (is.read() / 1024 + 1)];
					is.read(buffers);
					if (!socket.isClosed() && !socket.isInputShutdown()) {
						System.out.println(new String(buffers).trim());
					}
				}
			}

			br.close();
			is.close();
			pw.close();
			os.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void sendData(OutputStream os, String data) throws IOException {
		os.write(data.getBytes());
        os.flush();
		
	}

}
