package Basis;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class SocketInfo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        Socket client=new Socket("localhost",6606);//客户端创建实例
        DataOutputStream output=new DataOutputStream(client.getOutputStream());
        output.writeUTF("Client send");//客户端发送
        DataInputStream input=new DataInputStream(client.getInputStream());
        System.out.print(input.readUTF());//客户端读取
        client.close();
	}

}
