package com.reus.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/design-tic-tac-toe
 */
public class TicTacToe {
    Map<Integer, Map<Integer, Integer>> rowToPlayerMarked = new HashMap<>();
    Map<Integer, Map<Integer, Integer>> colToPlayerMarked = new HashMap<>();
    Map<Integer, Integer> playerToMainDiagonal = new HashMap<>();
    Map<Integer, Integer> playerToAntiDiagonal = new HashMap<>();
    private final int N;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        playerToMainDiagonal.put(1, 0);
        playerToMainDiagonal.put(2, 0);
        playerToAntiDiagonal.put(1, 0);
        playerToAntiDiagonal.put(2, 0);
        this.N = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        rowToPlayerMarked.putIfAbsent(row, new HashMap<>());
        Map<Integer, Integer> playerToRowMarkedTimes = rowToPlayerMarked.get(row);
        playerToRowMarkedTimes.putIfAbsent(player, 0);
        int newRowMarked = playerToRowMarkedTimes.get(player) + 1;
        if (newRowMarked == N) {
            return player;
        }
        playerToRowMarkedTimes.put(player, newRowMarked);

        colToPlayerMarked.putIfAbsent(col, new HashMap<>());
        Map<Integer, Integer> playerToColMarkedTimes = colToPlayerMarked.get(col);
        playerToColMarkedTimes.putIfAbsent(player, 0);
        int newColMarked = playerToColMarkedTimes.get(player) + 1;
        if (newColMarked == N) {
            return player;
        }
        playerToColMarkedTimes.put(player, newColMarked);

        int diagonals = checkDiagonal(player, row, col);
        if (diagonals == player) {
            return player;
        }
        return 0;
    }

    private int checkDiagonal(int player, int row, int col) {
        int result = 0;

        boolean isMainDiagonal = row == col;
        boolean isAntiDiagonal = !isMainDiagonal && (row + col == N - 1);

        if (isMainDiagonal) {
            playerToMainDiagonal.put(player, playerToMainDiagonal.get(player) + 1);
            if (playerToMainDiagonal.get(player) == N) {
                return player;
            }
            if (N % 2 == 1 && row == N / 2) {
                playerToAntiDiagonal.put(player, playerToAntiDiagonal.get(player) + 1);
                if (playerToAntiDiagonal.get(player) == N) {
                    return player;
                }
                isAntiDiagonal = false;
            }
        }

        if (isAntiDiagonal) {
            playerToAntiDiagonal.put(player, playerToAntiDiagonal.get(player) + 1);
            if (playerToAntiDiagonal.get(player) == N) {
                return player;
            }
        }
        return 0;
    }
}
