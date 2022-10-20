package student_player;

import java.util.ArrayList;

public class TupleChildrenListAndInt {
	
	public int returnedByMaxValue;
	public ArrayList<AlphaBetaPBS> childrenList;
	
	public TupleChildrenListAndInt(int value, ArrayList<AlphaBetaPBS> childrenList) {
		this.returnedByMaxValue = value;
		this.childrenList = childrenList;
	}
	
	public TupleChildrenListAndInt(int value) {
		this.returnedByMaxValue = value;
		this.childrenList = null;
	}
	
}
