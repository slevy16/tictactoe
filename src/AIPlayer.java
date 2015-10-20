import java.util.*;
public class AIPlayer implements Runnable{
	private Board b;
	private Random r;
	private String marker;
	
	public AIPlayer(Board b, String marker){
		this.b = b;
		r = new Random();
		this.marker = marker;
	}
	

	@Override
	public void run() {
		while(true);
	}
	
	public void takeTurn(){
		boolean hasMoved = false;
		//makes robot win
		//top left corner
		if(!hasMoved && b.getSquare(0, 0).equals(marker)&& b.getSquare(0, 1).equals(b.getSquare(0, 0))) hasMoved = b.setBoard(0, 2, marker);
		if(!hasMoved && b.getSquare(0, 0).equals(marker)&& b.getSquare(1, 1).equals(b.getSquare(0, 0))) hasMoved = b.setBoard(2, 2, marker);
		if(!hasMoved && b.getSquare(0, 0).equals(marker)&& b.getSquare(1, 0).equals(b.getSquare(0, 0))) hasMoved = b.setBoard(2, 0, marker);
		//top right corner
		if(!hasMoved && b.getSquare(2, 0).equals(marker)&& b.getSquare(1, 0).equals(b.getSquare(2, 0))) hasMoved = b.setBoard(0, 0, marker);
		if(!hasMoved && b.getSquare(2, 0).equals(marker)&& b.getSquare(1, 1).equals(b.getSquare(2, 0))) hasMoved = b.setBoard(0, 2, marker);
		if(!hasMoved && b.getSquare(2, 0).equals(marker)&& b.getSquare(2, 1).equals(b.getSquare(2, 0))) hasMoved = b.setBoard(2, 2, marker);
		//bottom left corner
		if(!hasMoved && b.getSquare(0, 2).equals(marker)&& b.getSquare(0, 1).equals(b.getSquare(0, 2))) hasMoved = b.setBoard(0, 0, marker);
		if(!hasMoved && b.getSquare(0, 2).equals(marker)&& b.getSquare(1, 1).equals(b.getSquare(0, 2))) hasMoved = b.setBoard(2, 0, marker);
		if(!hasMoved && b.getSquare(0, 2).equals(marker)&& b.getSquare(1, 2).equals(b.getSquare(0, 2))) hasMoved = b.setBoard(2, 2, marker);
		//bottom right
		if(!hasMoved && b.getSquare(2, 2).equals(marker)&& b.getSquare(2, 1).equals(b.getSquare(2, 2))) hasMoved = b.setBoard(2, 0, marker);
		if(!hasMoved && b.getSquare(2, 2).equals(marker)&& b.getSquare(1, 1).equals(b.getSquare(2, 2))) hasMoved = b.setBoard(0, 0, marker);
		if(!hasMoved && b.getSquare(2, 2).equals(marker)&& b.getSquare(1, 2).equals(b.getSquare(2, 2))) hasMoved = b.setBoard(1, 2, marker);
		//checks for x's with middle empty
		if(!hasMoved && b.getSquare(0, 0).equals(marker) && b.getSquare(0, 0).equals(b.getSquare(2, 2))) hasMoved = b.setBoard(1, 1, marker);
		if(!hasMoved && b.getSquare(2, 0).equals(marker) && b.getSquare(2, 0).equals(b.getSquare(0, 2))) hasMoved = b.setBoard(1, 1, marker);
		//checks for crosses with middle empty
		if(!hasMoved && b.getSquare(1, 0).equals(marker) && b.getSquare(1, 0).equals(b.getSquare(1, 2))) hasMoved = b.setBoard(1, 1, marker);
		if(!hasMoved && b.getSquare(0, 1).equals(marker) && b.getSquare(0, 1).equals(b.getSquare(2, 1))) hasMoved = b.setBoard(1, 1, marker);
		//checks for middle and non-corner
		if(!hasMoved && b.getSquare(0, 1).equals(marker) && b.getSquare(0, 1).equals(b.getSquare(1, 1))) hasMoved = b.setBoard(2, 1, marker);
		if(!hasMoved && b.getSquare(1, 0).equals(marker) && b.getSquare(1, 0).equals(b.getSquare(1, 1))) hasMoved = b.setBoard(1, 2, marker);
		if(!hasMoved && b.getSquare(2, 1).equals(marker) && b.getSquare(2, 1).equals(b.getSquare(1, 1))) hasMoved = b.setBoard(0, 1, marker);
		if(!hasMoved && b.getSquare(1, 2).equals(marker) && b.getSquare(1, 2).equals(b.getSquare(1, 1))) hasMoved = b.setBoard(1, 0, marker);
		//checks for two corners
		if(!hasMoved && b.getSquare(0, 0).equals(marker) && b.getSquare(0, 0).equals(b.getSquare(0, 2))) hasMoved = b.setBoard(0, 1, marker);
		if(!hasMoved && b.getSquare(0, 0).equals(marker) && b.getSquare(0, 0).equals(b.getSquare(2, 0))) hasMoved = b.setBoard(1, 0, marker);
		if(!hasMoved && b.getSquare(2, 2).equals(marker) && b.getSquare(0, 2).equals(b.getSquare(2, 2))) hasMoved = b.setBoard(1, 2, marker);
		if(!hasMoved && b.getSquare(2, 2).equals(marker) && b.getSquare(2, 0).equals(b.getSquare(2, 2))) hasMoved = b.setBoard(2, 1, marker);
		
		//blocks you
		//top left corner
		if(!hasMoved && !b.getSquare(0, 0).equals("-")&& b.getSquare(0, 1).equals(b.getSquare(0, 0))) hasMoved = b.setBoard(0, 2, marker);
		if(!hasMoved && !b.getSquare(0, 0).equals("-")&& b.getSquare(1, 1).equals(b.getSquare(0, 0))) hasMoved = b.setBoard(2, 2, marker);
		if(!hasMoved && !b.getSquare(0, 0).equals("-")&& b.getSquare(1, 0).equals(b.getSquare(0, 0))) hasMoved = b.setBoard(2, 0, marker);
		//top right corner
		if(!hasMoved && !b.getSquare(2, 0).equals("-")&& b.getSquare(1, 0).equals(b.getSquare(2, 0))) hasMoved = b.setBoard(0, 0, marker);
		if(!hasMoved && !b.getSquare(2, 0).equals("-")&& b.getSquare(1, 1).equals(b.getSquare(2, 0))) hasMoved = b.setBoard(0, 2, marker);
		if(!hasMoved && !b.getSquare(2, 0).equals("-")&& b.getSquare(2, 1).equals(b.getSquare(2, 0))) hasMoved = b.setBoard(2, 2, marker);
		//bottom left corner
		if(!hasMoved && !b.getSquare(0, 2).equals("-")&& b.getSquare(0, 1).equals(b.getSquare(0, 2))) hasMoved = b.setBoard(0, 0, marker);
		if(!hasMoved && !b.getSquare(0, 2).equals("-")&& b.getSquare(1, 1).equals(b.getSquare(0, 2))) hasMoved = b.setBoard(2, 0, marker);
		if(!hasMoved && !b.getSquare(0, 2).equals("-")&& b.getSquare(1, 2).equals(b.getSquare(0, 2))) hasMoved = b.setBoard(2, 2, marker);
		//bottom right
		if(!hasMoved && !b.getSquare(2, 2).equals("-")&& b.getSquare(2, 1).equals(b.getSquare(2, 2))) hasMoved = b.setBoard(2, 0, marker);
		if(!hasMoved && !b.getSquare(2, 2).equals("-")&& b.getSquare(1, 1).equals(b.getSquare(2, 2))) hasMoved = b.setBoard(0, 0, marker);
		if(!hasMoved && !b.getSquare(2, 2).equals("-")&& b.getSquare(1, 2).equals(b.getSquare(2, 2))) hasMoved = b.setBoard(1, 2, marker);
		//checks for x's with middle empty
		if(!hasMoved && !b.getSquare(0, 0).equals("-") && b.getSquare(0, 0).equals(b.getSquare(2, 2))) hasMoved = b.setBoard(1, 1, marker);
		if(!hasMoved && !b.getSquare(2, 0).equals("-") && b.getSquare(2, 0).equals(b.getSquare(0, 2))) hasMoved = b.setBoard(1, 1, marker);
		//checks for crosses with middle empty
		if(!hasMoved && !b.getSquare(1, 0).equals("-") && b.getSquare(1, 0).equals(b.getSquare(1, 2))) hasMoved = b.setBoard(1, 1, marker);
		if(!hasMoved && !b.getSquare(0, 1).equals("-") && b.getSquare(0, 1).equals(b.getSquare(2, 1))) hasMoved = b.setBoard(1, 1, marker);
		//checks for middle and non-corner
		if(!hasMoved && !b.getSquare(0, 1).equals("-") && b.getSquare(0, 1).equals(b.getSquare(1, 1))) hasMoved = b.setBoard(2, 1, marker);
		if(!hasMoved && !b.getSquare(1, 0).equals("-") && b.getSquare(1, 0).equals(b.getSquare(1, 1))) hasMoved = b.setBoard(1, 2, marker);
		if(!hasMoved && !b.getSquare(2, 1).equals("-") && b.getSquare(2, 1).equals(b.getSquare(1, 1))) hasMoved = b.setBoard(0, 1, marker);
		if(!hasMoved && !b.getSquare(1, 2).equals("-") && b.getSquare(1, 2).equals(b.getSquare(1, 1))) hasMoved = b.setBoard(1, 0, marker);
		//check for two corners
		if(!hasMoved && !b.getSquare(0, 0).equals("-") && b.getSquare(0, 0).equals(b.getSquare(0, 2))) hasMoved = b.setBoard(0, 1, marker);
		if(!hasMoved && !b.getSquare(0, 0).equals("-") && b.getSquare(0, 0).equals(b.getSquare(2, 0))) hasMoved = b.setBoard(1, 0, marker);
		if(!hasMoved && !b.getSquare(2, 2).equals("-") && b.getSquare(0, 2).equals(b.getSquare(2, 2))) hasMoved = b.setBoard(1, 2, marker);
		if(!hasMoved && !b.getSquare(2, 2).equals("-") && b.getSquare(2, 0).equals(b.getSquare(2, 2))) hasMoved = b.setBoard(2, 1, marker);
		
		//moves to middle
		if(!hasMoved) hasMoved = b.setBoard(1, 1, marker);
		
		//else tries to move into random corner
		int availableCorners = 0;
		if(b.getSquare(0, 0).equals("-")) availableCorners ++;
		if(b.getSquare(0, 2).equals("-")) availableCorners ++;
		if(b.getSquare(2, 0).equals("-")) availableCorners ++;
		if(b.getSquare(2, 2).equals("-")) availableCorners ++;
		
		while(availableCorners!= 0 && !hasMoved){
			int corner = r.nextInt(4);
			if(corner == 0 && !hasMoved) hasMoved = b.setBoard(0, 0, marker);
			if(corner == 1 && !hasMoved) hasMoved = b.setBoard(0, 2, marker);
			if(corner == 2 && !hasMoved) hasMoved = b.setBoard(2, 0, marker);
			if(corner == 3 && !hasMoved) hasMoved = b.setBoard(2, 2, marker);
		}
		
		
		
		//else moves to random other square
		while(!hasMoved){
			int space = r.nextInt(4);
			if(space == 0 && !hasMoved) hasMoved = b.setBoard(1, 0, marker);
			if(space == 1 && !hasMoved) hasMoved = b.setBoard(0, 1, marker);
			if(space == 2 && !hasMoved) hasMoved = b.setBoard(1, 2, marker);
			if(space == 3 && !hasMoved) hasMoved = b.setBoard(2, 1, marker);
		}
		System.out.println(b);
	}

}
