package Basis;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Map;
import java.util.Set;


public class NetworkInfo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        //获取指定主机的IP地址
		InetAddress address=null;
		String host="www.magiclub.cn";
//		address=InetAddress.getByName(host);
//		System.out.println(address.getHostName()+":"+address.getHostAddress());
		//查看端口是否已使用
//		String host1="localhost";
//		Socket socket;
//		for(int i=20;i<24;i++){
//			try{
//			System.out.println("查看端口:"+i);
//			socket=new Socket(host1,i);//Connection后执行下一步
//			System.out.println("端口:"+i+"被占用");
//			}catch(UnknownHostException e){
//				System.out.println("Exception occured"+ e);
//	            break;
//			}catch (IOException e) {
//				System.out.println("**"+e);//Connection refused
//	         }
//		}
		//获取本机ip地址及主机名
//		InetAddress hostaddress=InetAddress.getLocalHost();
//		System.out.println("IP:"+hostaddress.getHostAddress()+"\nHostName:"+hostaddress.getHostName());
		//获取远程文件大小
		int size;
		URL url=new URL("http://www.runoob.com/wp-content/themes/runoob/assets/img/newlogo.png");
//		URLConnection conn=url.openConnection();
//		System.out.println(conn.getContentLength());
		//Socket 实现多线程服务器程序
//		ServerSocket serversocket=new ServerSocket(6066);
//		System.out.println("Listening");
//		while(true){
//			Socket socket=serversocket.accept();
//			System.out.println("Connected");
//			new Thread(new MultiThreadServer(socket)).start();
//		}
		//查看主机指定文件的最后修改时间
//		URL timeurl=new URL("http://127.0.0.1/java.bmp");
//		URLConnection timeconn=timeurl.openConnection();
//		timeconn.setUseCaches(false);
//		long modtimestamp=timeconn.getLastModified();
//		System.out.println("modify time:"+modtimestamp);
		//使用 Socket 连接到指定主机
//		try{
//		InetAddress addr;
//		Socket soc=new Socket("www.magiclub.cn",22);
//		addr=soc.getInetAddress();
//		System.out.println("connect "+addr);
//		soc.close();
//		}catch(IOException e){
//		    System.out.println("无法连接");
//			System.out.println(e);
//		}
		//网页抓取
		URL neturl=new URL("http://www.runoob.com/java/java-examples.html");
//		BufferedReader bufread=new BufferedReader(new InputStreamReader(neturl.openStream()));
//		BufferedWriter bufwrite=new BufferedWriter(new FileWriter("/home/here/Downloads/data.html"));
//		String line;
//		while((line=bufread.readLine())!=null){
//			System.out.println(line);
//			bufwrite.write(line);
//			bufwrite.newLine();
//		}
//		bufread.close();
//		bufwrite.close();
		//获取 URL响应头的日期信息
		HttpURLConnection httpCon=(HttpURLConnection) neturl.openConnection();
		long date=httpCon.getDate();
		System.out.println("date:"+new Date(date));
		//获取 URL 响应头信息
		URLConnection headurl=neturl.openConnection();
		Map headers=headurl.getHeaderFields();
		Set<String> set=headers.keySet();
		for(String key:set){
			String val=headurl.getHeaderField(key);
			System.out.println(key+": "+val);
		}
		System.out.println(new Date(headurl.getLastModified()));
		//解析 URL
		System.out.println("url:"+neturl.toString());
		System.out.println("协议:"+neturl.getProtocol());
		System.out.println("文件名:"+neturl.getFile());
		System.out.println("主机:"+neturl.getHost());
		System.out.println("路径:"+neturl.getPath());
		System.out.println("端口号:"+neturl.getPort());
		System.out.println("默认端口号:"+neturl.getDefaultPort());
		//ServerSocket 和 Socket 通信实例
		ServerSocket serversocket=new ServerSocket(6066);
		System.out.println("Listening");
		while(true){
			try{
			Socket socket=serversocket.accept();
			System.out.println("connecting");
			new Thread(new MultiThreadServer(socket)).start();
			}catch(IOException e){
				System.out.println(e);
			}
		}
	}

}
class MultiThreadServer implements Runnable{
    public Socket socket;
    public MultiThreadServer(Socket _socket){
    	socket=_socket;
    }
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(socket.toString()+"running");
		try {
			DataInputStream input=new DataInputStream(socket.getInputStream());
			System.out.println(input.readUTF());
			DataOutputStream output=new DataOutputStream(socket.getOutputStream());
			output.writeUTF("server send");
			input.close();
			output.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}