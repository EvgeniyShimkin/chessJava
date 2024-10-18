public class King extends ChessPiece {
    public King(String color) {
        super(color, "Q"); // поменять
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean isTrue = false;

        ChessPiece tempChessPiece = chessBoard.board[toLine][toColumn];
        chessBoard.board[toLine][toColumn] = new King(this.getColor());
        chessBoard.board[line][column] = null;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (chessBoard.board[i][j] != null) {
                    if (chessBoard.board[i][j].getColor().equals(this.getColor()) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, toLine, toColumn)) {
                        return true;
                    }
                }
            }
        }
        chessBoard.board[toLine][toColumn] = tempChessPiece;
        chessBoard.board[line][column] = new King(this.getColor());

        return isTrue;
    }


    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (Math.abs(line - toLine) > 1 || Math.abs(column - toColumn) > 1) {
            return false;
        }
        if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return false;
        }

        return !isUnderAttack(chessBoard, line, column, toLine, toColumn);
    }

    }







