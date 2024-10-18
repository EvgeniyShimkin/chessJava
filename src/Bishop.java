public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color, "B");
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if ((line != toLine && column != toColumn) &&
                (Math.abs(toLine - line) == Math.abs(toColumn - column))){
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
        }else {return false;}

        return chessBoard.board[toLine][toColumn] == null ||
                !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor());

    }
}
