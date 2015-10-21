import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;


public class GameServer {

    private static int port = 8003;
    private static int maxConnections = 2;

    public static void main(String[] args) {
    	System.out.println("how many tictactoe-bots do you want to play? (0-2)");
    	Scanner s = new Scanner(System.in);
    	int response = s.nextInt();
    	if(response == 0){
    		ServerSocket myServer = null;
    		Socket playerSocket = null;
    		int i = 0;
    		PlayerConnection[] players = new PlayerConnection[2];


    		try {
    			myServer = new ServerSocket(port);
    			System.out.println("server started");
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
    			players[0].stop();
    			players[1].stop();
    			myServer.close();
            
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	else if(response == 1){
    		Board b = new Board();
    		System.out.println("enter a difficulty for the tictactoe-bot (1-5): ");
            int d = s.nextInt();
            AIPlayer ai = new AIPlayer(b , "*" , d);
    		System.out.println("tictactoe-bot made");
    		ServerSocket myServer = null;
    		Socket playerSocket = null;
    		try {
    			myServer = new ServerSocket(port);
    			System.out.println("server started");
    			PlayerConnection player = null;
				playerSocket = myServer.accept();
				player = new PlayerConnection(playerSocket, b);
				Thread t = new Thread(player);
				t.start();
				System.out.println("got a player");
				Thread t1 = new Thread(ai);
				t1.start();
				System.out.println("tictactoe-bot ready");
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
    			ai.stop();
    			player.stop();
    			
    			myServer.close();
            
			} catch (IOException e) {
				e.printStackTrace();
			}
			
    	}
    	else if(response == 2){
    		Board b = new Board();
    		System.out.println("enter a difficulty for the first tictactoe-bot (1-5): ");
            int d = s.nextInt();
            System.out.println("enter a difficulty for the second tictactoe-bot (1-5): ");
            int d1 = s.nextInt();
    		AIPlayer robot1 = new AIPlayer(b, "x", d);
    		AIPlayer robot2 = new AIPlayer(b, "o", d1);
    		System.out.println("robot ready");
			while(!b.isFull()&& !b.isWon()){
				if(!b.isFull()&& !b.isWon()){
					robot1.takeTurn();
				}
				if(!b.isFull() && !b.isWon()){
					robot2.takeTurn();
				}
			}
			boolean win1 = false;
			boolean win2 = false;
			
			if(b.getSquare(0,0).equals(b.getSquare(0,1)) && b.getSquare(0,1).equals(b.getSquare(0,2)) && b.getSquare(0,0).equals("x")) win1 = true;
			else if(b.getSquare(1,0).equals(b.getSquare(1,1)) && b.getSquare(1,1).equals(b.getSquare(1,2)) && b.getSquare(1,0).equals("x")) win1 = true;
			else if(b.getSquare(2,0).equals(b.getSquare(2,1)) && b.getSquare(2,1).equals(b.getSquare(2,2)) && b.getSquare(2,0).equals("x")) win1 = true;
			else if(b.getSquare(0,0).equals(b.getSquare(1,0)) && b.getSquare(1,0).equals(b.getSquare(2,0)) && b.getSquare(0,0).equals("x")) win1 = true;
			else if(b.getSquare(0,1).equals(b.getSquare(1,1)) && b.getSquare(1,1).equals(b.getSquare(2,1)) && b.getSquare(0,1).equals("x")) win1 = true;
			else if(b.getSquare(0,2).equals(b.getSquare(1,2)) && b.getSquare(1,2).equals(b.getSquare(2,2)) && b.getSquare(0,2).equals("x")) win1 = true;
			else if(b.getSquare(0,0).equals(b.getSquare(1,1)) && b.getSquare(1,1).equals(b.getSquare(2,2)) && b.getSquare(0,0).equals("x")) win1 = true;
			else if(b.getSquare(0,2).equals(b.getSquare(1,1)) && b.getSquare(1,1).equals(b.getSquare(2,0)) && b.getSquare(0,2).equals("x")) win1 = true;
			if(b.getSquare(0,0).equals(b.getSquare(0,1)) && b.getSquare(0,1).equals(b.getSquare(0,2)) && b.getSquare(0,0).equals("o")) win2 = true;
			else if(b.getSquare(1,0).equals(b.getSquare(1,1)) && b.getSquare(1,1).equals(b.getSquare(1,2)) && b.getSquare(1,0).equals("o")) win2 = true;
			else if(b.getSquare(2,0).equals(b.getSquare(2,1)) && b.getSquare(2,1).equals(b.getSquare(2,2)) && b.getSquare(2,0).equals("o")) win2 = true;
			else if(b.getSquare(0,0).equals(b.getSquare(1,0)) && b.getSquare(1,0).equals(b.getSquare(2,0)) && b.getSquare(0,0).equals("o")) win2 = true;
			else if(b.getSquare(0,1).equals(b.getSquare(1,1)) && b.getSquare(1,1).equals(b.getSquare(2,1)) && b.getSquare(0,1).equals("o")) win2 = true;
			else if(b.getSquare(0,2).equals(b.getSquare(1,2)) && b.getSquare(1,2).equals(b.getSquare(2,2)) && b.getSquare(0,2).equals("o")) win2 = true;
			else if(b.getSquare(0,0).equals(b.getSquare(1,1)) && b.getSquare(1,1).equals(b.getSquare(2,2)) && b.getSquare(0,0).equals("o")) win2 = true;
			else if(b.getSquare(0,2).equals(b.getSquare(1,1)) && b.getSquare(1,1).equals(b.getSquare(2,0)) && b.getSquare(0,2).equals("o")) win2 = true;
			
			if(win1) System.out.println("game over, tictactoe-bot 1 won");
			else if (win2) System.out.println("game over, tictactoe-bot 2 won");
			else System.out.println("game over, neither tictactoe-bot won");
    		
    	}
    	else System.out.println("a maximum of two tictactoe-bots can play, sorry :(");
    }


}
