class Horse extends ChessPiece {
    public Horse(String color){
        super(color, "H");
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!(chessBoard.board[toLine][toColumn] == null) && chessBoard.board [toLine] [toColumn].getColor().equals(this.getColor())){
            return false;
        }
        int deltaX = Math.abs(toLine - line);
        int deltaY = Math.abs(toColumn - column);
        return (deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2);
    }
}
