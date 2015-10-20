import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;


public class GameServer {

    private static int port = 8003;
    private static int maxConnections = 2;

    public static void main(String[] args) {
    	System.out.println("do you want to play with a robot? (y/n)");
    	Scanner s = new Scanner(System.in);
    	String response = s.nextLine();
    	if(response.equals("n")){
    		ServerSocket myServer = null;
    		Socket playerSocket = null;
    		int i = 0;
    		PlayerConnection[] players = new PlayerConnection[2];


    		try {
    			myServer = new ServerSocket(port);
    			System.out.println("Server started");
    		} catch (IOException e) {
    			System.out.println(e);
    		}

    		try {
    			Board b = new Board();
    			while(i++ < maxConnections || maxConnections == 0) {
    				PlayerConnection connection = null;
    				playerSocket = myServer.accept();
    				players[i-1] = connection;
    				players[i-1] = new PlayerConnection(playerSocket, b);
    				Thread t = new Thread(players[i-1]);
    				t.start();
    				System.out.println("got a player");
               
    			}
            
    			System.out.println("got 2 players");
    			while(!b.isFull()&& !b.isWon()){
    				if(!b.isFull()&& !b.isWon()){
    					players[0].takeTurn();
    				}
    				if(!b.isFull() && !b.isWon()){
    					players[1].takeTurn();
    				}
    			}
    			players[0].takeTurn();
    			players[1].takeTurn();
    			System.out.println("game over");
            
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	else{
    		Board b = new Board();
    		AIPlayer ai = new AIPlayer(b);
    		System.out.println("robot made");
    		ServerSocket myServer = null;
    		Socket playerSocket = null;
    		try {
    			myServer = new ServerSocket(port);
    			System.out.println("Server started");
    			PlayerConnection player = null;
				playerSocket = myServer.accept();
				player = new PlayerConnection(playerSocket, b);
				Thread t = new Thread(player);
				t.start();
				System.out.println("got a player");
				Thread t1 = new Thread(ai);
				t1.start();
				System.out.println("robot ready");
				while(!b.isFull()&& !b.isWon()){
    				if(!b.isFull()&& !b.isWon()){
    					player.takeTurn();
    				}
    				if(!b.isFull() && !b.isWon()){
    					ai.takeTurn();
    				}
    			}
    			player.takeTurn();
    			System.out.println("game over");
            
			} catch (IOException e) {
				e.printStackTrace();
			}
			
    	}
    }


}
