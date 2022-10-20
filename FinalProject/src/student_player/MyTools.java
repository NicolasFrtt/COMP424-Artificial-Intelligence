package student_player;

import java.util.*;

import boardgame.Move;
import pentago_twist.PentagoMove;
import pentago_twist.PentagoBoardState;


public class MyTools {
	
    public static double getSomething() {
        return Math.random();
    }
    
    public static int specialFactorial(int n) {
    	if (n == 0 || n == 1) {
    		return 1;
    	}
    	return n*specialFactorial(n-1);
    }
    
    // return 0/1 if a player has a position that almost always guarantees a mate in 2
    // return -10 otherwise
    public static int additionalChecks(PentagoBoardState boardState) {
    	
    	PentagoBoardState.Piece white = PentagoBoardState.Piece.WHITE;
    	PentagoBoardState.Piece empty = PentagoBoardState.Piece.EMPTY;
    	PentagoBoardState.Piece black = PentagoBoardState.Piece.BLACK;
    	
    	
    	for(int i = 0; i < PentagoBoardState.BOARD_SIZE; i++) {
    				
    		// first check for this type:
        	//	0	w	w	w	w	0
        	// which is almost always winning
    		if(boardState.getPieceAt(i, 0).equals(empty) && boardState.getPieceAt(i, 1).equals(white) && boardState.getPieceAt(i, 2).equals(white) && boardState.getPieceAt(i, 3).equals(white) && boardState.getPieceAt(i, 4).equals(white) && boardState.getPieceAt(i, 5).equals(empty))
    				return 0;
    		if(boardState.getPieceAt(i, 0).equals(empty) && boardState.getPieceAt(i, 1).equals(black) && boardState.getPieceAt(i, 2).equals(black) && boardState.getPieceAt(i, 3).equals(black) && boardState.getPieceAt(i, 4).equals(black) && boardState.getPieceAt(i, 5).equals(empty))
    				return 1;

    		// now check for this type:
        	//	w	w	0	w	w	0/w
        	// which is almost always winning
    		
    		if(boardState.getPieceAt(i, 0).equals(white) && boardState.getPieceAt(i, 1).equals(white) && boardState.getPieceAt(i, 2).equals(empty) && boardState.getPieceAt(i, 3).equals(white) && boardState.getPieceAt(i, 4).equals(white) && !boardState.getPieceAt(i, 5).equals(black))
					return 0;
    		if(boardState.getPieceAt(i, 0).equals(black) && boardState.getPieceAt(i, 1).equals(black) && boardState.getPieceAt(i, 2).equals(empty) && boardState.getPieceAt(i, 3).equals(black) && boardState.getPieceAt(i, 4).equals(black) && !boardState.getPieceAt(i, 5).equals(white))
					return 1;

    		// now check for this type:
        	// 0/w	 w	 w	 0	 w	 w
        	// which is almost always winning
    		
    		if(!boardState.getPieceAt(i, 0).equals(black) && boardState.getPieceAt(i, 1).equals(white) && boardState.getPieceAt(i, 2).equals(white) && boardState.getPieceAt(i, 3).equals(empty) && boardState.getPieceAt(i, 4).equals(white) && boardState.getPieceAt(i, 5).equals(white))
					return 0;
    		if(!boardState.getPieceAt(i, 0).equals(white) && boardState.getPieceAt(i, 1).equals(black) && boardState.getPieceAt(i, 2).equals(black) && boardState.getPieceAt(i, 3).equals(empty) && boardState.getPieceAt(i, 4).equals(black) && boardState.getPieceAt(i, 5).equals(black))
					return 1;
    				
    		
    		// now same vertically
    		if(boardState.getPieceAt(0, i).equals(empty) && boardState.getPieceAt(1, i).equals(white) && boardState.getPieceAt(2, i).equals(white) && boardState.getPieceAt(3, i).equals(white) && boardState.getPieceAt(4, i).equals(white) && boardState.getPieceAt(5, i).equals(empty))
    				return 0;
    		if(boardState.getPieceAt(0, i).equals(empty) && boardState.getPieceAt(1, i).equals(black) && boardState.getPieceAt(2, i).equals(black) && boardState.getPieceAt(3, i).equals(black) && boardState.getPieceAt(4, i).equals(black) && boardState.getPieceAt(5, i).equals(empty))
    				return 1;

    		if(boardState.getPieceAt(0, i).equals(white) && boardState.getPieceAt(1, i).equals(white) && boardState.getPieceAt(2, i).equals(empty) && boardState.getPieceAt(3, i).equals(white) && boardState.getPieceAt(4, i).equals(white) && !boardState.getPieceAt(5, i).equals(black))
					return 0;
    		if(boardState.getPieceAt(0, i).equals(black) && boardState.getPieceAt(1, i).equals(black) && boardState.getPieceAt(2, i).equals(empty) && boardState.getPieceAt(3, i).equals(black) && boardState.getPieceAt(4, i).equals(black) && !boardState.getPieceAt(5, i).equals(white))
					return 1;

    		if(!boardState.getPieceAt(0, i).equals(black) && boardState.getPieceAt(1, i).equals(white) && boardState.getPieceAt(2, i).equals(white) && boardState.getPieceAt(3, i).equals(empty) && boardState.getPieceAt(4, i).equals(white) && boardState.getPieceAt(5, i).equals(white))
					return 0;
    		if(!boardState.getPieceAt(0, i).equals(white) && boardState.getPieceAt(1, i).equals(black) && boardState.getPieceAt(2, i).equals(black) && boardState.getPieceAt(3, i).equals(empty) && boardState.getPieceAt(4, i).equals(black) && boardState.getPieceAt(5, i).equals(black))
					return 1;

    	}

		return -10;
    }
    
    // return 0 if white win, 1 if black win, -10 otherwise
    public static int winningBoard(PentagoBoardState boardState) {
    	
    	PentagoBoardState.Piece white = PentagoBoardState.Piece.WHITE;
    	PentagoBoardState.Piece black = PentagoBoardState.Piece.BLACK;
    	
    	// first 	check for horizontally and vertically
    	for(int i = 0; i < PentagoBoardState.BOARD_SIZE; i++) {
    				if(boardState.getPieceAt(i, 0).equals(white) && boardState.getPieceAt(i, 1).equals(white) && boardState.getPieceAt(i, 2).equals(white) && boardState.getPieceAt(i, 3).equals(white) && boardState.getPieceAt(i, 4).equals(white))
    					return 0;
    				if(boardState.getPieceAt(i, 0).equals(black) && boardState.getPieceAt(i, 1).equals(black) && boardState.getPieceAt(i, 2).equals(black) && boardState.getPieceAt(i, 3).equals(black) && boardState.getPieceAt(i, 4).equals(black))
    					return 1;

    				if(boardState.getPieceAt(i, 1).equals(white) && boardState.getPieceAt(i, 2).equals(white) && boardState.getPieceAt(i, 3).equals(white) && boardState.getPieceAt(i, 4).equals(white) && boardState.getPieceAt(i, 5).equals(white))
    					return 0;
    				if(boardState.getPieceAt(i, 1).equals(black) && boardState.getPieceAt(i, 2).equals(black) && boardState.getPieceAt(i, 3).equals(black) && boardState.getPieceAt(i, 4).equals(black) && boardState.getPieceAt(i, 5).equals(black))
    					return 1;

    				if(boardState.getPieceAt(0, i).equals(white) && boardState.getPieceAt(1, i).equals(white) && boardState.getPieceAt(2, i).equals(white) && boardState.getPieceAt(3, i).equals(white) && boardState.getPieceAt(4, i).equals(white))
    					return 0;
    				if(boardState.getPieceAt(0, i).equals(black) && boardState.getPieceAt(1, i).equals(black) && boardState.getPieceAt(2, i).equals(black) && boardState.getPieceAt(3, i).equals(black) && boardState.getPieceAt(4, i).equals(black))
    					return 1;
 
    				if(boardState.getPieceAt(1, i).equals(white) && boardState.getPieceAt(2, i).equals(white) && boardState.getPieceAt(3, i).equals(white) && boardState.getPieceAt(4, i).equals(white) && boardState.getPieceAt(5, i).equals(white))
    					return 0;
    				if(boardState.getPieceAt(1, i).equals(black) && boardState.getPieceAt(2, i).equals(black) && boardState.getPieceAt(3, i).equals(black) && boardState.getPieceAt(4, i).equals(black) && boardState.getPieceAt(5, i).equals(black))
    					return 1;
    	}
    	
    	// check diagonally for big diagonals
    	
    	// top left to bottom right
    	if(boardState.getPieceAt(0, 0).equals(white) && boardState.getPieceAt(1, 1).equals(white) && boardState.getPieceAt(2, 2).equals(white) && boardState.getPieceAt(3, 3).equals(white) && boardState.getPieceAt(4, 4).equals(white))
			return 0;
		if(boardState.getPieceAt(0, 0).equals(black) && boardState.getPieceAt(1, 1).equals(black) && boardState.getPieceAt(2, 2).equals(black) && boardState.getPieceAt(3, 3).equals(black) && boardState.getPieceAt(4, 4).equals(black))
			return 1;
		
		if(boardState.getPieceAt(1, 1).equals(white) && boardState.getPieceAt(2, 2).equals(white) && boardState.getPieceAt(3, 3).equals(white) && boardState.getPieceAt(4, 4).equals(white) && boardState.getPieceAt(5, 5).equals(white))
			return 0;
		if(boardState.getPieceAt(1, 1).equals(black) && boardState.getPieceAt(2, 2).equals(black) && boardState.getPieceAt(3, 3).equals(black) && boardState.getPieceAt(4, 4).equals(black) && boardState.getPieceAt(5, 5).equals(black))
			return 1;
		
		// bottom left to top right
		if(boardState.getPieceAt(5, 0).equals(white) && boardState.getPieceAt(4, 1).equals(white) && boardState.getPieceAt(3, 2).equals(white) && boardState.getPieceAt(2, 3).equals(white) && boardState.getPieceAt(1, 4).equals(white))
			return 0;
		if(boardState.getPieceAt(5, 0).equals(black) && boardState.getPieceAt(4, 1).equals(black) && boardState.getPieceAt(3, 2).equals(black) && boardState.getPieceAt(2, 3).equals(black) && boardState.getPieceAt(1, 4).equals(black))
			return 1;
		
		if(boardState.getPieceAt(4, 1).equals(white) && boardState.getPieceAt(3, 2).equals(white) && boardState.getPieceAt(2, 3).equals(white) && boardState.getPieceAt(1, 4).equals(white) && boardState.getPieceAt(0, 5).equals(white))
			return 0;
		if(boardState.getPieceAt(4, 1).equals(black) && boardState.getPieceAt(3, 2).equals(black) && boardState.getPieceAt(2, 3).equals(black) && boardState.getPieceAt(1, 4).equals(black) && boardState.getPieceAt(0, 5).equals(black))
			return 1;
		
		
		// check small diagonals
		
		// top left to bottom right
		if(boardState.getPieceAt(0, 1).equals(white) && boardState.getPieceAt(1, 2).equals(white) && boardState.getPieceAt(2, 3).equals(white) && boardState.getPieceAt(3, 4).equals(white) && boardState.getPieceAt(4, 5).equals(white))
			return 0;
		if(boardState.getPieceAt(0, 1).equals(black) && boardState.getPieceAt(1, 2).equals(black) && boardState.getPieceAt(2, 3).equals(black) && boardState.getPieceAt(3, 4).equals(black) && boardState.getPieceAt(4, 5).equals(black))
			return 1;
		
		if(boardState.getPieceAt(1, 0).equals(white) && boardState.getPieceAt(2, 1).equals(white) && boardState.getPieceAt(3, 2).equals(white) && boardState.getPieceAt(4, 3).equals(white) && boardState.getPieceAt(5, 4).equals(white))
			return 0;
		if(boardState.getPieceAt(1, 0).equals(black) && boardState.getPieceAt(2, 1).equals(black) && boardState.getPieceAt(3, 2).equals(black) && boardState.getPieceAt(4, 3).equals(black) && boardState.getPieceAt(5, 4).equals(black))
			return 1;

		//bottom left to top right
		if(boardState.getPieceAt(4, 0).equals(white) && boardState.getPieceAt(3, 1).equals(white) && boardState.getPieceAt(2, 2).equals(white) && boardState.getPieceAt(1, 3).equals(white) && boardState.getPieceAt(0, 4).equals(white))
			return 0;
		if(boardState.getPieceAt(4, 0).equals(black) && boardState.getPieceAt(3, 1).equals(black) && boardState.getPieceAt(2, 2).equals(black) && boardState.getPieceAt(1, 3).equals(black) && boardState.getPieceAt(0, 4).equals(black))
			return 1;
		
		if(boardState.getPieceAt(5, 1).equals(white) && boardState.getPieceAt(4, 2).equals(white) && boardState.getPieceAt(3, 3).equals(white) && boardState.getPieceAt(2, 4).equals(white) && boardState.getPieceAt(1, 5).equals(white))
			return 0;
		if(boardState.getPieceAt(5, 1).equals(black) && boardState.getPieceAt(4, 2).equals(black) && boardState.getPieceAt(3, 3).equals(black) && boardState.getPieceAt(2, 4).equals(black) && boardState.getPieceAt(1, 5).equals(black))
			return 1;
		
		// else return -10
    	return -10;
    }
    
    
    // evaluation function
    public static int evaluationFunction(PentagoBoardState boardState, int myColor) {
    	
    	//System.out.println(evaluateMeWinOnly(boardState, myColor) - evaluateOpponentWinOnly(boardState, myColor));
    	return (2*evaluateMe1(boardState, myColor) - 2*evaluateMe1(boardState, 1 - myColor));
    
    }
    
    // helper to evaluate
    public static int evaluateMe1(PentagoBoardState boardState, int myColor) {
    	
    	
    	// currentCount is used as a local counter, and maxCountX as max counters
    	int maxCountH = 0;
    	int maxCountV = 0;
    	int maxCountD1 = 0;
    	int maxCountD2 = 0;
    	int currentCount = 0;
    	//int ourColor = boardState.getTurnPlayer(); 
    	
    	// get color letter
    	String strColor = "w";
    	if(myColor == 1) { // 0 is white, 1 is black
    		strColor = "b";
    	}
    	    	
    	if (additionalChecks(boardState) == 1-myColor) {
    		return -70;
    	}
    	if (additionalChecks(boardState) == myColor) {
    		return 70;
    	}
    	
    	// first count horizontally
    	for(int i = 0; i < PentagoBoardState.BOARD_SIZE; i++) {
    		currentCount = 0;
			for(int j = 0; j < PentagoBoardState.BOARD_SIZE; j++) {
				if(boardState.getPieceAt(i, j).toString().equals(strColor)){
					currentCount++;
					if (currentCount > maxCountH) {
						maxCountH = currentCount;
						//System.out.println("J'IMPROVE H "+ maxCountH);
					}
				}
				else {
					currentCount = 0;
				}
			}
		}
    	
    	// check winning condition
    	if (maxCountH >= 5) {
    		//System.out.println("IM WINNING H");
    		return 1000;
    	}
    	
    	// reset currentCount:
    	currentCount = 0;
    	
    	// Here, we have maxCountH that has the max number of aligned pieces horizontally
    	// We will do the same vertically, and diagonally.
    	
    	// count vertically
    	for(int i = 0; i < PentagoBoardState.BOARD_SIZE; i++) {
    		currentCount = 0;
			for(int j = 0; j < PentagoBoardState.BOARD_SIZE; j++) {
				if(boardState.getPieceAt(j, i).toString().equals(strColor)){
					currentCount++;
					if (currentCount > maxCountV) {
						maxCountV = currentCount;
						//System.out.println("J'IMPROVE V "+ maxCountV);
					}
				}
				else {
					currentCount = 0;
				}
			}
		}
    	
    	// check winning condition
    	if (maxCountV >= 5) {
    		//System.out.println("IM WINNING V");
    		return 1000;
    	}
    	
    	// reset currentCount:
    	currentCount = 0;
    	
    	// count diagonally - only main diagonal for now, might improve later
    	// top left to bottom right
    	for(int i = 0; i < PentagoBoardState.BOARD_SIZE; i++) {
				if(boardState.getPieceAt(i, i).toString().equals(strColor)){
					currentCount++;
					if (currentCount > maxCountD1) {
						maxCountD1 = currentCount;
						//System.out.println("J'IMPROVE D1 "+ maxCountD1);
					}
				}
				else {
					currentCount = 0;
				}
		}
    	
    	// check winning condition
    	if (maxCountD1 >= 5) {
    		//System.out.println("IM WINNING D1");
    		return 1000;
    	}
    	
    	// reset currentCount:
    	currentCount = 0;
    	
    	// count diagonally - only main diagonal for now, might improve later
    	// bottom left to top right
    	for(int i = 0; i < PentagoBoardState.BOARD_SIZE; i++) {
				if(boardState.getPieceAt(i, PentagoBoardState.BOARD_SIZE - i - 1).toString().equals(strColor)){
					currentCount++;
					if (currentCount > maxCountD2) {
						maxCountD2 = currentCount;
						//System.out.println("J'IMPROVE D2 "+ maxCountD2);
					}
				}
				else {
					currentCount = 0;
				}
    	}
    	
    	// check winning condition
    	if (maxCountD2 >= 5) {
    		//System.out.println("IM WINNING D2");
    		return 1000;
    	}
    	
    	
    	// since having a length of 1 is useless, remove 1 to each counter if it is == to 1
    	if (maxCountH == 1) maxCountH--;
    	if (maxCountV == 1) maxCountV--;
    	if (maxCountD1 == 1) maxCountD1--;
    	if (maxCountD2 == 1) maxCountD2--;
    	
    	
    	// utility defined as the sum 
    	int utility = specialFactorial(maxCountH) +  specialFactorial(maxCountV) + specialFactorial(maxCountD1)/2 + specialFactorial(maxCountD2)/2;
    	//System.out.println("THIS IS ME  " + utility);
    	return utility;
    	
    }
    

    // same as evaluateMe1, except we only keep the max of the maxes (and thus no sum)
    // not used in the final submission
    public static int evaluateMe2(PentagoBoardState boardState, int myColor) {
    	
    	
    	// currentCount is used as a local counter, and maxCountX as max counters
    	int maxCount = 0;
    	int currentCount = 0;
    	//int ourColor = boardState.getTurnPlayer(); // 0 is white, 1 is black
    	
    	// get color letter
    	String strColor = "w";
    	if(myColor == 1) {
    		strColor = "b";
    	}
    	    	
    	
    	// first count horizontally
    	for(int i = 0; i < PentagoBoardState.BOARD_SIZE; i++) {
    		currentCount = 0;
			for(int j = 0; j < PentagoBoardState.BOARD_SIZE; j++) {
				if(boardState.getPieceAt(i, j).toString().equals(strColor)){
					currentCount++;
					if (currentCount > maxCount) {
						maxCount = currentCount;
						//System.out.println("J'IMPROVE H "+ maxCount);
					}
				}
				else {
					currentCount = 0;
				}
			}
		}
    	
    	// check winning condition
    	if (maxCount >= 5) {
    		//System.out.println("IM WINNING H");
    		return 1000;
    	}
    	
    	// reset currentCount:
    	currentCount = 0;
    	
    	// Here, we have maxCountH that has the max number of aligned pieces horizontally
    	// We will do the same vertically, and diagonally.
    	
    	// count vertically
    	for(int i = 0; i < PentagoBoardState.BOARD_SIZE; i++) {
    		currentCount = 0;
			for(int j = 0; j < PentagoBoardState.BOARD_SIZE; j++) {
				if(boardState.getPieceAt(j, i).toString().equals(strColor)){
					currentCount++;
					if (currentCount > maxCount) {
						maxCount = currentCount;
						//System.out.println("J'IMPROVE V "+ maxCount);
					}
				}
				else {
					currentCount = 0;
				}
			}
		}
    	
    	// check winning condition
    	if (maxCount >= 5) {
    		//System.out.println("IM WINNING V");
    		return 1000;
    	}
    	
    	// reset currentCount:
    	currentCount = 0;
    	
    	// count diagonally - only main diagonal for now, might improve later
    	// top left to bottom right
    	for(int i = 0; i < PentagoBoardState.BOARD_SIZE; i++) {
				if(boardState.getPieceAt(i, i).toString().equals(strColor)){
					currentCount++;
					if (currentCount > maxCount) {
						maxCount = currentCount;
						//System.out.println("J'IMPROVE D1 "+ maxCount);
					}
				}
				else {
					currentCount = 0;
				}
		}
    	
    	// check winning condition
    	if (maxCount >= 5) {
    		//System.out.println("IM WINNING D1");
    		return 1000;
    	}
    	
    	// reset currentCount:
    	currentCount = 0;
    	
    	// count diagonally - only main diagonal for now, might improve later
    	// bottom left to top right
    	for(int i = 0; i < PentagoBoardState.BOARD_SIZE; i++) {
				if(boardState.getPieceAt(i, PentagoBoardState.BOARD_SIZE - i - 1).toString().equals(strColor)){
					currentCount++;
					if (currentCount > maxCount) {
						maxCount = currentCount;
						//System.out.println("J'IMPROVE D2 "+ maxCount);
					}
				}
				else {
					currentCount = 0;
				}
    	}
    	
    	// check winning condition
    	if (maxCount >= 5) {
    		//System.out.println("IM WINNING D2");
    		return 1000;
    	}
    	
    	// utility defined as the sum 
    	//System.out.println("THIS IS ME  " + utility);
    	return maxCount;
    	
    }
    
    
    // evaluation only based on win, not used on the final submission
    public static int evaluateMe3(PentagoBoardState boardState, int myColor) {
    	
    	
    	// currentCount is used as a local counter, and maxCountX as max counters
    	int maxCount = 0;
    	int currentCount = 0;
    	//int ourColor = boardState.getTurnPlayer(); // 0 is white, 1 is black
    	
    	// get color letter
    	String strColor = "w";
    	if(myColor == 1) {
    		strColor = "b";
    	}
    	
    	//System.out.println("JE SUIS WHITEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE" + strColor);
    	
    	
    	// first count horizontally
    	for(int i = 0; i < PentagoBoardState.BOARD_SIZE; i++) {
    		currentCount = 0;
			for(int j = 0; j < PentagoBoardState.BOARD_SIZE; j++) {
				if(boardState.getPieceAt(i, j).toString().equals(strColor)){
					currentCount++;
					if (currentCount > maxCount) {
						maxCount = currentCount;
						//System.out.println("J'IMPROVE H "+ maxCount);
					}
				}
				else {
					currentCount = 0;
				}
			}
		}
    	
    	// check winning condition
    	if (maxCount >= 5) {
    		//System.out.println("IM WINNING H");
    		return 1;
    	}
    	
    	// reset currentCount:
    	currentCount = 0;
    	
    	// Here, we have maxCountH that has the max number of aligned pieces horizontally
    	// We will do the same vertically, and diagonally.
    	
    	// count vertically
    	for(int i = 0; i < PentagoBoardState.BOARD_SIZE; i++) {
    		currentCount = 0;
			for(int j = 0; j < PentagoBoardState.BOARD_SIZE; j++) {
				if(boardState.getPieceAt(j, i).toString().equals(strColor)){
					currentCount++;
					if (currentCount > maxCount) {
						maxCount = currentCount;
						//System.out.println("J'IMPROVE V "+ maxCount);
					}
				}
				else {
					currentCount = 0;
				}
			}
		}
    	
    	// check winning condition
    	if (maxCount >= 5) {
    		//System.out.println("IM WINNING V");
    		return 1;
    	}
    	
    	// reset currentCount:
    	currentCount = 0;
    	
    	// count diagonally - only main diagonal for now, might improve later
    	// top left to bottom right
    	for(int i = 0; i < PentagoBoardState.BOARD_SIZE; i++) {
				if(boardState.getPieceAt(i, i).toString().equals(strColor)){
					currentCount++;
					if (currentCount > maxCount) {
						maxCount = currentCount;
						//System.out.println("J'IMPROVE D1 "+ maxCount);
					}
				}
				else {
					currentCount = 0;
				}
		}
    	
    	// check winning condition
    	if (maxCount >= 5) {
    		//System.out.println("IM WINNING D1");
    		return 1;
    	}
    	
    	// reset currentCount:
    	currentCount = 0;
    	
    	// count diagonally - only main diagonal for now, might improve later
    	// bottom left to top right
    	for(int i = 0; i < PentagoBoardState.BOARD_SIZE; i++) {
				if(boardState.getPieceAt(i, PentagoBoardState.BOARD_SIZE - i - 1).toString().equals(strColor)){
					currentCount++;
					if (currentCount > maxCount) {
						maxCount = currentCount;
						//System.out.println("J'IMPROVE D2 "+ maxCount);
					}
				}
				else {
					currentCount = 0;
				}
    	}
    	
    	// check winning condition
    	if (maxCount >= 5) {
    		//System.out.println("IM WINNING D2");
    		return 1;
    	}
    	return 0;
    } 
    
    
    // get first move in a favorable position
    // not used in the final submission
    public static Move getFirstMove(PentagoBoardState boardState) {
    	
    	int turnPlayer = boardState.getTurnPlayer();
    	
    	
    	if(boardState.getPieceAt(1, 1).toString().equals(" ")) {
    		return (new PentagoMove(1, 1, 2, 0, turnPlayer));
        }
    	return (new PentagoMove(1, 4, 2, 0, turnPlayer));
    }

    // return children state (in a new DS that has an alpha beta field)
    public static ArrayList<AlphaBetaPBS> getChildrenBoardStates(PentagoBoardState current) {
    	
    	// TBR
    	ArrayList<AlphaBetaPBS> listChildrenStates = new ArrayList<AlphaBetaPBS>();

    	// get list of all available moves at current state
    	ArrayList<PentagoMove> moves = current.getAllLegalMoves();
    	
    	// for each move, create associated new board state
    	for(PentagoMove m : moves) {
    		// create new clone board state
    		AlphaBetaPBS newState = new AlphaBetaPBS(current, m);
    		// process move
    		newState.pbs.processMove(m);
    		// add to the list
    		listChildrenStates.add(newState);
    	}
    	
    	return listChildrenStates;
    }
    
    
    // alpha beta pruning
    public static PentagoMove getMoveWithabPruning(PentagoBoardState boardState, int depthLimit, int myColor, long time) {
    	

    	// create new Data Structure for alpha and beta (see AlphaBetaPBS class)
    	AlphaBetaPBS boardStateAB = new AlphaBetaPBS(boardState);

    	// prune
    	TupleChildrenListAndInt bestMoveEval = maxValue(boardStateAB, 0, 1000, depthLimit, 0, myColor, time);
    	
    	// get alpha value
    	int currentAlpha = bestMoveEval.returnedByMaxValue;
    	
    	// get children list with modified values of alpha and beta
    	ArrayList<AlphaBetaPBS> childrenList = bestMoveEval.childrenList;

    	PentagoMove myMove = null;
    	// check for which move does my current alpha equal the resulting child's beta
    	for(AlphaBetaPBS child : childrenList) {

    		int indicator = 0; // = can be chosen
    		    		
    		ArrayList<AlphaBetaPBS> childrenListDepth2 = MyTools.getChildrenBoardStates(child.pbs);
           
    		
    		//System.out.println(child.getBeta());
    		if (child.getBeta() >= currentAlpha) {
    			 // check if this move can lead to a lost game
    			for(AlphaBetaPBS childDepth2 : childrenListDepth2) {
                	if (MyTools.winningBoard(childDepth2.pbs) == 1 - myColor) { 
            			indicator = 1; // = cannot be chosen
            			//System.out.println("ELIMINATED LAST SECOND");
            			break;
            		}
                }
    			if (indicator == 0) {
    				myMove = child.move;
        			return myMove;
    			}
    		}
    	}
    	return myMove;
    }
    
    
    // max function
    private static TupleChildrenListAndInt maxValue(AlphaBetaPBS current, int alpha, int beta, int depthLimit, int currentDepth, int myColor, long time) {
    	// check if out of time
    	if(System.currentTimeMillis() - time >= 1800){
    		alpha = evaluationFunction(current.pbs, myColor);
    		current.setAlpha(alpha);
    		TupleChildrenListAndInt tuple = new TupleChildrenListAndInt(alpha);
    		//System.out.println("MAX out of time");
    		return tuple;
    	}
    	
    	
    	// check if board is winning for someone
    	if (current.pbs.getWinner() == myColor) {
    		TupleChildrenListAndInt tuple = new TupleChildrenListAndInt(1000);
    		current.setAlpha(1000);
    		current.setBeta(1000); 
    		return tuple;
    	}
    	if (current.pbs.getWinner() == 1-myColor) {
    		TupleChildrenListAndInt tuple = new TupleChildrenListAndInt(-1000);
    		current.setAlpha(-1000);
    		current.setBeta(-1000); 
    		return tuple;
    	}
    	
    	/*if (additionalChecks(current.pbs) == 1-myColor) {
    		System.out.println("MAX LEAF" + (-100));
    		System.out.println(1-myColor);
    		current.setBeta(-100);
    		//current.setAlpha(-100);
    		TupleChildrenListAndInt tuple = new TupleChildrenListAndInt(-100);
    		return tuple;
    	}
    	if (additionalChecks(current.pbs) == myColor) {
    		System.out.println("MAX LEAF" + (100));
    		System.out.println(myColor);
    		current.setBeta(100);
    		//current.setAlpha(100);
    		TupleChildrenListAndInt tuple = new TupleChildrenListAndInt(100);
    		return tuple;
    	}*/
    	
    	
    	// 'leaf' case, when we reached depth limit
    	if (currentDepth >= depthLimit) {
    		alpha = evaluationFunction(current.pbs, myColor);
    		current.setAlpha(alpha);
    		TupleChildrenListAndInt tuple = new TupleChildrenListAndInt(alpha);
    		return tuple; // this will never actually be returned to the caller, since we 
    		// need at least depth 1 to run ab-pruning (depth 0 gives no information)
    	}
    	
    	// increase depth counter
    	currentDepth++;
    	
    	// get children
    	ArrayList<AlphaBetaPBS> childrenList = getChildrenBoardStates(current.pbs);
    	
    	// obvious pruning: if a child evaluate to a loss, don't consider it
    	Iterator<AlphaBetaPBS> itr = childrenList.iterator(); 
    	while (itr.hasNext()) { 
    		AlphaBetaPBS pbs = itr.next(); 
    		if(pbs.pbs.getWinner() == 1-myColor) {
    			itr.remove(); 
    			//System.out.println("MAX LEAF removed");
    		} 
    	}

    	
    	// TB Returned,  (used so that caller get list of children to iterate through)
    	TupleChildrenListAndInt tuple = new TupleChildrenListAndInt(alpha, childrenList);
    	
    	// iterate through the list of children, update alpha and prune
    	for(AlphaBetaPBS pbs : childrenList) {
    		
    		int temp = minValue(pbs, alpha, beta, depthLimit, currentDepth, myColor, time);

    		if (alpha < temp) {
    			alpha = temp;
    			current.setAlpha(alpha);
    			tuple.returnedByMaxValue = alpha;
    		}
    		if (alpha >= beta) {
    			tuple.returnedByMaxValue = beta;
    			return tuple; // to tell the parent that he doesn't need to update?
    		}
    	}
    	return tuple;
    }
    
    // min function
    private static int minValue(AlphaBetaPBS current, int alpha, int beta, int depthLimit, int currentDepth, int myColor, long time) {
    	
    	// check if out of time
    	if(System.currentTimeMillis() - time >= 1800){
    		beta = evaluationFunction(current.pbs, myColor);
    		current.setBeta(beta);
    		//System.out.println("MIN out of time");
    		return beta;
    	}

    	// check if board is winning for someone
    	if (current.pbs.getWinner() == myColor) {
    		current.setBeta(1000);
    		current.setAlpha(1000); 
    		return 1000;
    	}
    	if (current.pbs.getWinner() == 1-myColor) {
    		current.setBeta(-1000);
    		current.setAlpha(-1000);
    		return -1000;
    	}
    	
    	/*if (additionalChecks(current.pbs) == 1-myColor) {
    		System.out.println("MIN LEAF" + (-100));
    		System.out.println(1-myColor);
    		current.setBeta(-100);
    		//current.setAlpha(-100);
    		return -100;
    	}
    	if (additionalChecks(current.pbs) == myColor) {
    		System.out.println("MIN LEAF" + (100));
    		System.out.println(myColor);
    		current.setBeta(100);
    		//current.setAlpha(100);
    		return 100;
    	}*/
    	
    	
    	// 'leaf' case, when we reached depth limit
    	if (currentDepth >= depthLimit) {
    		beta = evaluationFunction(current.pbs, myColor);
    		current.setBeta(beta);
    		return beta;
    	}
    	
     	// increase depth counter
    	currentDepth++;
    	
    	ArrayList<AlphaBetaPBS> childrenList = getChildrenBoardStates(current.pbs);
    	
    	
    	// obvious pruning: if a child is losing, don't consider it
    	Iterator<AlphaBetaPBS> itr = childrenList.iterator(); 
    	while (itr.hasNext()) { 
    		AlphaBetaPBS pbs = itr.next(); 
    		if(pbs.pbs.getWinner() == myColor) {
    			itr.remove(); 
    		} 
    	}

    	
    	// iterate through the list of children, update beta and prune
    	for(AlphaBetaPBS pbs : childrenList) {
    		int temp = maxValue(pbs, alpha, beta, depthLimit, currentDepth, myColor, time).returnedByMaxValue;
    		if (beta > temp) {
    			beta = temp;
    			current.setBeta(beta);
    		}
    		if (alpha >= beta) {
    			return alpha; // to tell the parent that he doesn't need to update?
    		}
    	}
    	return beta;
    }
    
}

