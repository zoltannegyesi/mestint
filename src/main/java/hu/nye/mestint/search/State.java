package hu.nye.mestint.search;

public interface State {

	Iterable<State> getPossibleMoves();
	
	boolean isSolution();
	
	double getDistance();
	
	State getParent();
}
