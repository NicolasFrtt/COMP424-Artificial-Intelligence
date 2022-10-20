package student_player;

import java.util.ArrayList;

import boardgame.Move;

import pentago_twist.PentagoPlayer;
import pentago_twist.PentagoBoardState;

/** A player file submitted by a student. */
public class StudentPlayer extends PentagoPlayer {

    /**
     * You must modify this constructor to return your student number. This is
     * important, because this is what the code that runs the competition uses to
     * associate you with your agent. The constructor should do nothing else.
     */
    public StudentPlayer() {
        super("260826282");
    }

    /**
     * This is the primary method that you need to implement. The ``boardState``
     * object contains the current state of the game, which your agent must use to
     * make decisions.
     */
    public Move chooseMove(PentagoBoardState boardState) {
        // You probably will make separate functions in MyTools.
        // For example, maybe you'll need to load some pre-processed best opening
        // strategies...
    	
    	// get current time
    	long startTime = System.currentTimeMillis();
    	
    	// get my color
    	int myColor = boardState.getTurnPlayer();
    		
    		
    	// TBR
    	Move myMove = null;
    	
        // check if a move can win instantly
        ArrayList<AlphaBetaPBS> childrenList = MyTools.getChildrenBoardStates(boardState);
        for(AlphaBetaPBS child : childrenList) {

    		if (MyTools.winningBoard(child.pbs) == myColor) { 
    			//System.out.println(MyTools.winningBoard(child.pbs));
    			//System.out.println("HA! I WON, U LOSER.");
    			myMove = child.move;
    			return myMove;
    		}
    	}
        
        int depthLimit = 1;
        
        // first 3 moves really quick (since can't lose)
        if(boardState.getTurnNumber() <= 2) {
        	depthLimit = 2;
        }
        // figured out that depth 3 was the max I could do exhaustively 
        else if(boardState.getTurnNumber() <= 16) {
        	depthLimit = 3;
        }
        // if there are only 1 (if we are black) or 2 (if we are white) remaining EMPTY
        else if(boardState.getTurnNumber() <= 18) {
        	depthLimit = 2; // can only search with depth 2
        }
        else { // should never be used 
        	depthLimit = 3;
        }
        
        myMove = MyTools.getMoveWithabPruning(boardState, depthLimit, myColor, startTime);

        // error case (probably case where opponent has unstoppable mate in 1 or 2),
        // chose move with best evaluation function
        if (myMove == null) {
        	int max = -1000000;
        	for(AlphaBetaPBS child : childrenList) {
            	 int temp = MyTools.evaluationFunction(child.pbs, myColor);
            	 //System.out.println("EVAL du child" + temp);
            	 //child.pbs.printBoard();
            	 if (temp > max) { 
            		 max = temp;
            		 myMove =  child.move;
            	 }
        	}
 			return myMove;
        }
        
        // print amount of time spent on this move
        //System.out.println(System.currentTimeMillis() - startTime);
        
        return myMove;
    }
}




