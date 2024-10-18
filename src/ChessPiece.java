public abstract class ChessPiece {
    private final String color;
    private final String symbol;
    public boolean check = true;

    public ChessPiece(String color, String symbol){
        this.color = color;
        this.symbol = symbol;
    }

    public String getColor(){// adstract
    return color;
    }

    abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public String getSymbol(){
        return symbol;
    }

    public boolean checkPos (int pos){
        return pos >= 0 && pos <=7;
    }


}
