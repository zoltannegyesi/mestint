package hu.nye.mestint.puzzles;

import hu.nye.mestint.search.AbstractState;
import hu.nye.mestint.search.State;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PuzzleN extends AbstractState {
    enum Direction {N, E, S, W}
    static final Integer N = 3;
    int[][] table = new int[][] {
            {1, 3, 2},
            {0, 7, 8},
            {4, 6, 5}
    };

    public PuzzleN() {

    }

    public PuzzleN(PuzzleN puzzleN, Direction direction) {
        super(puzzleN);
        this.table = new int[N][N];

        for(int i = 0; i < N; i++) {
            System.arraycopy(puzzleN.table[i], 0, table[i], 0, N);
        }

        int zeroRow = 0;
        int zeroCol = 0;

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (table[i][j] == 0) {
                    zeroRow = i;
                    zeroCol = j;
                }
            }
        }

        switch (direction) {
            case N -> {
                table[zeroRow][zeroCol] = table[zeroRow - 1][zeroCol];
                table[zeroRow - 1][zeroCol] = 0;
            }
            case E -> {
                table[zeroRow][zeroCol] = table[zeroRow][zeroCol + 1];
                table[zeroRow][zeroCol + 1] = 0;
            }
            case S -> {
                table[zeroRow][zeroCol] = table[zeroRow + 1][zeroCol];
                table[zeroRow + 1][zeroCol] = 0;
            }
            case W -> {
                table[zeroRow][zeroCol] = table[zeroRow][zeroCol - 1];
                table[zeroRow][zeroCol - 1] = 0;
            }
            default -> System.out.println("Illegal State");
        }

    }


    @Override
    public Iterable<State> getPossibleMoves() {
        int zeroRow = 0, zeroCol = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (table[row][col] == 0) {
                    zeroRow = row;
                    zeroCol = col;
                }
            }
        }
        List<State> moves = new ArrayList<>();
        if (zeroRow > 0) {
            moves.add(new PuzzleN(this, Direction.N));
        }
        if (zeroCol > 0) {
            moves.add(new PuzzleN(this, Direction.W));
        }
        if (zeroRow < N-1) {
            moves.add(new PuzzleN(this, Direction.S));
        }
        if (zeroCol < N-1) {
            moves.add(new PuzzleN(this, Direction.E));
        }
        return moves;
    }

    @Override
    public boolean isSolution() {
        int[][] solution = new int[][] {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (solution[i][j] != table[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PuzzleN puzzleN = (PuzzleN) o;
        return Arrays.deepEquals(table, puzzleN.table);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(table);
    }

    @Override
    public String toString() {
        return "PuzzleN{" +
                "table=" + Arrays.deepToString(table) +
                '}';
    }
}