package Graph;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import Graph.Graph;
import Graph.GraphAPI;
import Graph.ReadText;


public class ReadFromTXT {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

//		BufferedReader in=new BufferedReader(new FileReader("/home/here/Downloads/test/graph.txt"));
//		int str;
//		while((str=in.read())!=-1){
//			if(str!=10&&str!=32)
//			System.out.println((char)str);	
//		}
//		ReadText r=new ReadText("/home/here/Downloads/test/graph.txt");
//		char[] chars=r.ReadFromText("/home/here/Downloads/test/graph.txt");
//		System.out.println(r.next());
//		System.out.println(r.next());
		ReadText in=new ReadText("/home/here/Downloads/test/graph.txt");
		Graph graph=new Graph(in);
		System.out.println("V:"+graph.V()+" E:"+graph.E());
		GraphAPI gapi=new GraphAPI(graph);
		System.out.println(gapi.degree(2));
		System.out.println(gapi.maxDegree());
	}
		

}
