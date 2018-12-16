package ServerSC;

import java.io.*;
import java.net.*;
 
public class ComServer2 {
    public static void main(String [] args) throws IOException{
        int port = 8888;
        ServerSocket sk = new ServerSocket(port);
        Socket ss = sk.accept();
        
        System.out.println("====( Info Port : "+port+")====");
        
        BufferedReader sin=new BufferedReader(new InputStreamReader(ss.getInputStream()));
        PrintStream sout=new PrintStream(ss.getOutputStream());
        BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (true) {            
            s = sin.readLine();  // MEMBACA PESAN DARI Client
            System.out.print("Client : " + s +"\n");  // MENAMPILKAN PESAN DARI Client
            System.out.print("Server : ");
            s = stdin.readLine();
            sout.println(s);
            if (s.equalsIgnoreCase("quit")){
                sout.println("Server : BHAY!!!!");
                s = stdin.readLine();
            sout.println(s);
                break;
            }
        }
        sk.close();
        sin.close();
        sout.close();
        stdin.close();
    }
}