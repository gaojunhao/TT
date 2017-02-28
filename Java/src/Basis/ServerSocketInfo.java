package Basis;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;


public class ServerSocketInfo extends Thread{
    private ServerSocket serversocket;
    public ServerSocketInfo(int port) throws IOException{
    	serversocket=new ServerSocket(port);//指定服务器端口
    	serversocket.setSoTimeout(10000);//服务器等待时间
    }
    public void run(){
    	while(true){
    	try {
			Socket server=serversocket.accept();//获取客户端引用
			DataInputStream input=new DataInputStream(server.getInputStream());
			System.out.print(input.readUTF());//服务器端读取
			DataOutputStream output=new DataOutputStream(server.getOutputStream());
			output.writeUTF("server send");//服务器端发送
			server.close();
		} catch(SocketTimeoutException s){
			System.out.println("Socket timed out!");
            break;
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			break;
		}
    	}
    }
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Thread t=new ServerSocketInfo(6606);
		t.start();
        
	}

}
