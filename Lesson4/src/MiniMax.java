class MiniMax {

    static final char player = XO.DOT_X;
    static final char ai = XO.DOT_O;

    static class Move {
        int row, col;
    }

    static Move findBestMove(char[][] map) {
        int bestVal = -1000;
        Move bestMove = new Move();
        bestMove.row = 0;
        bestMove.col = 0;

        for (int i = 0; i < XO.SIZE; i++) {
            for (int j = 0; j < XO.SIZE; j++) {
                if (map[i][j] == XO.DOT_EMPTY) {
                    map[i][j] = ai;
                    int moveVal = minimax(map, 0, false);
                    map[i][j] = XO.DOT_EMPTY;

                    if (XO.isCellValid(i, j)) {
                        if (moveVal > bestVal) {
                            bestMove.row = i;
                            bestMove.col = j;
                            bestVal = moveVal;
                        }
                    }
                }
            }
        }

        return bestMove;
    }

    static int minimax(char[][] map, int depth, Boolean isMax) {
        int score = evaluate(map);
        int best;

        if (score == 10) return score;
        if (score == -10) return score;
        if (!isMovesLeft(map)) return 0;
        if (depth == XO.SIZE) return score;


        if (isMax) {
            best = -1000;

            for (int i = 0; i < XO.SIZE; i++) {
                for (int j = 0; j < XO.SIZE; j++) {
                    if (map[i][j] == XO.DOT_EMPTY) {
                        map[i][j] = player;
                        best = Math.max(best, minimax(map, depth + 1, false));
                        map[i][j] = XO.DOT_EMPTY;
                    }
                }
            }
        } else {
            best = 1000;

            for (int i = 0; i < XO.SIZE; i++) {
                for (int j = 0; j < XO.SIZE; j++) {
                    if (map[i][j] == XO.DOT_EMPTY) {
                        map[i][j] = player;
                        best = Math.min(best, minimax(map, depth + 1, true));
                        map[i][j] = XO.DOT_EMPTY;
                    }
                }
            }
        }
        return best;
    }

    static int evaluate(char[][] map) {
        for (int row = 0; row < XO.SIZE; row++) {
            for (int col = 0; col < XO.SIZE; col++) {
                if (map[row][col] == player)
                    return +10;
                else if (map[row][col] == ai)
                    return -10;
            }
        }

        for (int col = 0; col < XO.SIZE; col++) {
            for (int row = 0; row < XO.SIZE; row++) {
                if (map[row][col] == player)
                    return +10;
                else if (map[row][col] == ai)
                    return -10;
            }
        }

        for (int row = 0; row < XO.SIZE; row++) {
            for (int col = 0; col < XO.SIZE; col++) {
                if (map[row][col] == player)
                    return +10;
                else if (map[row][col] == ai)
                    return -10;
            }

            for (int col = XO.SIZE; col > 0; col--) {
                if (map[row][col] == player)
                    return +10;
                else if (map[row][col] == ai)
                    return -10;
            }
        }
        return 0;
    }

    static Boolean isMovesLeft(char[][] map) {
        for (int i = 0; i < XO.SIZE; i++)
            for (int j = 0; j < XO.SIZE; j++)
                if (map[i][j] == XO.DOT_EMPTY)
                    return true;
        return false;
    }
}
