public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color, "P");
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.board[toLine][toColumn] == null && column == toColumn) {
            if (check) {
                if (this.getColor().equals("Белый")) {
                    if (chessBoard.board[line + 1][column] != null) {
                        return false;
                    }
                    return line - toLine == -1 || line - toLine == -2;
                } else {
                    if (chessBoard.board[line - 1][column] != null) {
                        return false;

                    }
                    return line - toLine == 1 || line - toLine == 2;
                }

            } else {
                if (this.getColor().equals("Белый")) {
                    return line - toLine == -1;
                } else {
                    return line - toLine == 1;
                }
            }
        }

        if (chessBoard.board[toLine][toColumn] != null && !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            if (this.getColor().equals("Белый")) {
                return line - toLine == -1 && Math.abs(column - toColumn) == 1;

            } else {
                return line - toLine == 1 && Math.abs(column - toColumn) == 1;
            }
        }
        return false;
    }
}
//
//                return line - toLine == 1;
//
//
//            if
//
//            return false;
//        }
//        int deltaX = Math.abs(toLine - line);
//        int deltaY = Math.abs(toColumn - column);
//        return (deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2);
//    }
//}


