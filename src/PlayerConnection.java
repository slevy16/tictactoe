import java.io.*;
import java.net.Socket;

public class PlayerConnection implements Runnable{
	private Socket playerSocket;
	private Board b;
	InputStream in;
	PrintStream out;
	private String marker;
	private boolean printGameOver;
	
	
	public PlayerConnection(Socket s, Board b){
		marker = "";
		playerSocket = s;
		this.b = b;
		printGameOver = true;
		 try {
	        in = playerSocket.getInputStream();
	        out = new PrintStream(playerSocket.getOutputStream());
	     } catch (IOException e) {
	         e.printStackTrace();
	        }
	}

	@Override
	public void run() {
		out.println("game started");
		while(true);
		
	}
	public void takeTurn(){
		
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		if(marker.length()<1){
			out.println("choose a marker");
			try {
				marker = br.readLine();	
					
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(b.isFull() || b.isWon()){
			if(printGameOver){
				out.println(b);
				out.println("game over");
				printGameOver = false;
			}
		}
		else{
			out.println("it's your turn");
			out.println(b);
		
			try {
				boolean turn = true;
				while(turn){
					out.println("enter a column to place your marker");
					int row = Integer.parseInt(br.readLine());
					out.println("enter a row to place your marker");
					int column = Integer.parseInt(br.readLine());
					if(b.getSquare(column-1, row-1).equals("-")){
						b.setBoard(column-1, row-1, marker);
						out.println(b);
						turn = false;
			}
					else out.println("space already taken");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		
	}


	public void stop() {
		System.exit(0);
	}

}
