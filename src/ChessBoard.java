public class ChessBoard {
    public ChessPiece[][] board = new ChessPiece[8][8];
    String nowPlayer;

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    public boolean checkPos(int pos) { // добавил 15.10
        return pos >= 0 && pos <= 7; // добавил 15.10
    }


    public boolean moveToPosition(int startLine, int startColumn, int andLine, int andColumn) {
        if (!checkPos(startLine) || !checkPos(startColumn)) return false;
        if (!nowPlayer.equals(board[startLine][startColumn].getColor())) {
            return false;
        }

        if (board[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, andLine, andColumn)) {
            if (board[startLine][startColumn].getSymbol().equals("K") ||
                    board[startLine][startColumn].getSymbol().equals("R") ||
                    board[startLine][startColumn].getSymbol().equals("P") ||
                    board[startLine][startColumn].getSymbol().equals("Q") ||
                    board[startLine][startColumn].getSymbol().equals("B")
            ) {

                board[startLine][startColumn].check = false;
            }
            board[andLine][andColumn] = board[startLine][startColumn];
            board[startLine][startColumn] = null;
            this.nowPlayer = this.nowPlayerColor().equals("Белый") ? "Черный" : "Белый";
            return true;
        }
        return false;
    }


    public void printBoard() {
    }

    ;


    public boolean castling0() {
        if (nowPlayer.equals("White")) {
            if (board[0][0] == null || board[0][4] == null) return false;
            if (board[0][0].getSymbol().equals("R") && board[0][4].getSymbol().equals("K") &&
                    board[0][1] == null && board[0][2] == null && board[0][3] == null) {
                if (board[0][0].getColor().equals("White") && board[0][4].getColor().equals("White") &&
                        board[0][0].check && board[0][4].check &&
                        !new King("White").isUnderAttack(this, 0, 4, 0, 2)) {
                    board[0][4] = null;
                    board[0][1] = new King("White");
                    board[0][1].check = false;
                    board[0][0] = null;
                    board[0][2] = new Rook("White");
                    board[0][2].check = false;
                    nowPlayer = "Black";
                    return true;
                } else return false;
            } else return false;
        } else {
            if (board[7][0] == null || board[7][4] == null) return false;
            if (board[7][0].getSymbol().equals("R") && board[7][4].getSymbol().equals("K") &&
                    board[7][1] == null && board[7][2] == null && board[7][3] == null) {
                if (board[7][0].getColor().equals("Black") && board[7][4].getColor().equals("Black") &&
                        board[7][0].check && board[7][4].check &&
                        !new King("Black").isUnderAttack(this, 7, 4, 7, 2)) {
                    board[7][4] = null;
                    board[7][1] = new King("Black");
                    board[7][1].check = false;
                    board[7][0] = null;
                    board[7][2] = new Rook("Black");
                    board[7][2].check = false;
                    nowPlayer = "White";
                    return true;
                } else return false;
            } else return false;
        }
    }

    public boolean castling7() {
        if (nowPlayer.equals("White")) {
            if (board[0][7] == null || board[0][4] == null) return false;
            if (board[0][7].getSymbol().equals("R") && board[0][4].getSymbol().equals("K") &&
                    board[0][6] == null && board[0][5] == null) {
                if (board[0][7].getColor().equals("White") && board[0][4].getColor().equals("White") &&
                        board[0][7].check && board[0][4].check &&
                        !new King("White").isUnderAttack(this, 0, 4, 0, 6)) {
                    board[0][4] = null;
                    board[0][6] = new King("White");
                    board[0][6].check = false;
                    board[0][7] = null;
                    board[0][5] = new Rook("White");
                    board[0][5].check = false;
                    nowPlayer = "Black";
                    return true;
                } else return false;
            } else return false;
        } else {
            if (board[7][7] == null || board[7][4] == null) return false;
            if (board[7][7].getSymbol().equals("R") && board[7][4].getSymbol().equals("K") &&
                    board[7][6] == null && board[7][5] == null) {
                if (board[7][7].getColor().equals("Black") && board[7][4].getColor().equals("Black") &&
                        board[7][7].check && board[7][4].check &&
                        !new King("Black").isUnderAttack(this, 7, 4, 7, 6)) {
                    board[7][4] = null;
                    board[7][6] = new King("Black");
                    board[7][6].check = false;
                    board[7][7] = null;
                    board[7][5] = new Rook("Black");
                    board[7][5].check = false;
                    nowPlayer = "White";
                    return true;
                } else return false;
            } else return false;
        }
    }
}

