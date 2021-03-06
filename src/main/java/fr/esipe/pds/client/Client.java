package fr.esipe.pds.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
/**
* This class implements java socket client
* 
*
*/

public class Client {
	

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
       
    	//get the localhost IP address, if server is running on some other IP, you need to use that
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
       
        /*for(int i=0; i<5;i++){
            //establish socket connection to server
            socket = new Socket(host.getHostName(), 8855);
            //write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Send a request to the server");
            if(i==4)oos.writeObject("exit");
            else oos.writeObject("toto "+i);
            //read the server response message
            ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Message: " + message);
            //close resources  
            ois.close();
            oos.close();
            
            // simulation add
            
        }*/
        String requestToSend = "Create;mode1";
      //establish socket connection to server
        socket = new Socket(host.getHostName(), 8855);
        //write to socket using ObjectOutputStream
        oos = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("Send a request to the server");
        oos.writeObject(requestToSend);
        //read the server response message
        ois = new ObjectInputStream(socket.getInputStream());
        String message = (String) ois.readObject();
        System.out.println("Message: " + message);
        //close resources  
        ois.close();
        oos.close();
    }
}
