package student_player;

import pentago_twist.PentagoBoardState;
import pentago_twist.PentagoMove;

public class AlphaBetaPBS {
	
	private int depth;
	private int alpha;
	private int beta;
	public PentagoBoardState pbs;
	public PentagoMove move;
	
	public AlphaBetaPBS(PentagoBoardState pbs, PentagoMove move) {
		this.alpha = -1000;
		this.beta = 1000;
		this.pbs = (PentagoBoardState) pbs.clone();
		// default depth
		this.depth = 0;
		this.move = move;
	}
	
	public AlphaBetaPBS(PentagoBoardState pbs) {
		this.alpha = -1000;
		this.beta = 1000;
		this.pbs = (PentagoBoardState) pbs.clone();
		// default depth
		this.depth = 0;
		this.move = null;
	}
	
	public AlphaBetaPBS(int depth, int alpha, int beta, PentagoBoardState pbs) {
		this.depth = depth;
		this.alpha = alpha;
		this.beta = beta;
		this.pbs = (PentagoBoardState) pbs.clone();
	}
	
	public int getAlpha() {
		return this.alpha;
	}
	
	public int setAlpha(int newAlpha) {
		this.alpha = newAlpha;
		return this.alpha;
	}
	
	public int getBeta() {
		return this.beta;
	}
	
	public int setBeta(int newBeta) {
		this.beta = newBeta;
		return this.beta;
	}
	
	public int getDepth() {
		return this.depth;
	}
	
	public int setDepth(int newDepth) {
		this.beta = newDepth;
		return this.depth;
	}
}
