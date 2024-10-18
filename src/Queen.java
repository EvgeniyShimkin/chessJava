public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color, "Q"); // поменять
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if ((line != toLine && column != toColumn) &&
                (Math.abs(toLine - line) == Math.abs(toColumn - column))||
                ((line == toLine && column != toColumn) || (line != toLine && column == toColumn )))
        {
            if (line < toLine && column > toColumn) {
                int j = column;
                for (int i = line + 1; i < toLine; i++){
                    j--;
                    if (chessBoard.board[i][j] != null) {return false;}
                }
            }
            if (line > toLine && column > toColumn) {
                int j = column;
                for (int i = line - 1; i > toLine; i--){
                    j --;
                    if (chessBoard.board[i][j] != null) {return false;}
                }
            }
            if (line < toLine && column < toColumn) {
                int j = column;
                for (int i = line + 1; i < toLine; i++){
                    j++;
                    if (chessBoard.board[i][j] != null) {return false;}
                }
            }
            if (line > toLine && column < toColumn) {
                int j = column;
                for (int i = line - 1; i > toLine; i--){
                    j++;
                    if (chessBoard.board[i][j] != null) {return false;}
                }
            }
            if ((column == toColumn) && (line > toLine)) {
                for (int i = line - 1; i > toLine; i--) {
                    if (chessBoard.board[i][column] != null) {return false;
                    }
                }
            }
            if ((column == toColumn) && (line < toLine)) {
                for (int i = line + 1; i < toLine; i++) {
                    if (chessBoard.board[i][column] != null) {
                        return false;
                    }
                }
            }
            if ((line == toLine) && (column > toColumn)) {
                for (int i = column - 1; i > toColumn; i--) {
                    if (chessBoard.board[line][i] != null) {
                        return false;
                    }
                }
            }
            if ((line == toLine) && (column < toColumn)) {
                for (int i = column + 1; i < toColumn; i++) {
                    if (chessBoard.board[line][i] != null) {
                        return false;
                    }
                }
            }

        }else { return false;}

        return chessBoard.board[toLine][toColumn] == null ||
                !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor());

    }
}


