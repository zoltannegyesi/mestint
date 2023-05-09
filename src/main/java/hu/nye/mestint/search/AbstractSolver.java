package hu.nye.mestint.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class AbstractSolver implements Solver {

	
	private final Set<State> closed = new HashSet<>();

	public List<State> solve(State initialState) {
		// Reset closed set
		closed.clear();
		clearOpen();
		addState(initialState);
		while (hasElements()) {
			State s = nextState();
			if (s.isSolution())
				return findPath(s);
			closed.add(s);
			Iterable<State> moves = s.getPossibleMoves();
			for (State move : moves)
				if (!closed.contains(move))
					addState(move);
		}
		return null;
	}

	public int getVisitedStateCount() {
		return closed.size();
	}

	private List<State> findPath(State solution) {
		LinkedList<State> path = new LinkedList<>();
		while (solution != null) {
			path.addFirst(solution);
			solution = solution.getParent();
		}
		return path;
	}

	protected abstract boolean hasElements();

	protected abstract State nextState();

	protected abstract void addState(State s);
	
	protected abstract void clearOpen();

}
