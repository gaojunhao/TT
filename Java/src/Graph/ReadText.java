package Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadText {

	public  String[] strings=new String[100];
	public int postion;
	public  ReadText(String filePath) throws IOException{
		BufferedReader in=new BufferedReader(new FileReader(filePath));
		String str;
		int pos=0;
		while((str=in.readLine())!=null){
			String[] strs=str.split(" ");
			for(String s:strs){
				strings[pos++]=s;
			}
		}
	}
	public int next(){
		return Integer.parseInt(strings[postion++]);
	}
}
