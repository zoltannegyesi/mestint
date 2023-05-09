/**
 * 
 */
package hu.nye.mestint.puzzles;

import hu.nye.mestint.search.AbstractSolver;
import hu.nye.mestint.search.BreadthFirstSolver;
import hu.nye.mestint.search.State;

import java.util.List;

public class Tester {
	
	private static void trySolver(State initialState, AbstractSolver solver) {
		System.out.println("Solving with "+solver);
		List<State> solution = solver.solve(initialState);
		System.out.println("  States visited: "+solver.getVisitedStateCount());
		System.out.println("  Solution:");
		if (solution == null) {
			System.out.println("    None found.");
		} else {
			for (State s : solution)
				System.out.println("    "+s);
			System.out.println("   "+solution.size()+" states(s)");
		}
	}
	private static void trySolvers(State initialState) {
		trySolver(initialState, new BreadthFirstSolver());
	}
	public static void main(String[] args) {
		System.out.println("PuzzleN");
		trySolvers(new PuzzleN());
		System.out.println("---------------------------------------------------------------");
	}

}
