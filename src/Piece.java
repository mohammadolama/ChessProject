import java.awt.*;
import java.security.PrivateKey;
import java.util.PrimitiveIterator;

public class Piece {

    private boolean available;
    private int x;
    private int y;
    private boolean isWhite;
    private String name;
    private Board board;
    private int cntMove = 0;
    private boolean EnPasant = false;
    private boolean Enpasantable = false;


    public boolean isEnpasantable() {
        return Enpasantable;
    }

    public void setEnpasantable(boolean enpasantable) {
        Enpasantable = enpasantable;
    }

    public boolean isEnPasant() {
        return EnPasant;
    }

    public void setEnPasant(boolean enPasant) {
        EnPasant = enPasant;
    }

    public boolean CastellingDone(Spot start, Spot end) {
        if (end.getPiece() == null)
            return false;
        return false;
    }

    public int getCntMove() {
        return cntMove;
    }

    public void CntMoveUpdater() {
        this.cntMove++;
    }

    public void CntMoveUpdater_decrease() {
        this.cntMove--;
    }

    public Piece() {

    }

    public Piece(boolean available, boolean isWhite, int x, int y) {
        this.available = available;
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
    }

    public String getName() {
        return name;
    }

    public boolean isWhite() {

        return isWhite;
    }

    public void ValidColorize(Board board, Spot start) {
        this.board = board;
    }


    public void setWhite(boolean white) {

        isWhite = white;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean ValidMove(Spot[][] primary , Spot start, Spot end) {
        if (start == end) {
            return false;
        }
//
        if (end.getPiece() != null && end.getPiece().getName() == "king")
            return false;
        if (end.getX() < 0 || start.getX() < 0 || end.getY() > 700 || start.getY() > 700 || end.getX() > 700 || start.getX() > 700 || end.getY() < 0 || start.getY() < 0) {
            return false;
        }
        if (start.getPiece() != null && end.getPiece() != null && end.getPiece().isWhite() == start.getPiece().isWhite())
            return false;
        //vertical
        if (start.getPiece().getName() != "rock" && end.getY() > start.getY() && end.getX() == start.getX()) {
            for (int i = start.getY() + 100; i <= end.getY(); i += 100) {
                if (i < end.getY() && Board.a[i][start.getX()].getPiece() != null) {
                    return false;
                } else if (i == end.getY() && end.getPiece() != null && end.getPiece().isWhite() == start.getPiece().isWhite()) {
                    return false;
                }
            }
        }


        if (start.getPiece().getName() != "knight" && end.getY() > start.getY() && end.getX() > start.getX()) {
            for (int i = start.getX() + 100; i <= end.getX(); i += 100) {
                for (int j = start.getY() + 100; j <= end.getY(); j += 100) {
                    if (i < end.getX() && j < end.getY() && end.getY() - j == end.getX() - i && Board.a[j][i].getPiece() != null) {
                        return false;
                    } else if (i == end.getX() && j == end.getY() && end.getY() - start.getY() == end.getX() - start.getX() && end.getPiece() != null && end.getPiece().isWhite() == start.getPiece().isWhite()) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (start.getPiece().getName() != "rock" && end.getY() == start.getY() && end.getX() > start.getX()) {
            for (int i = start.getX() + 100; i <= end.getX(); i += 100) {
                if (i < end.getX() && Board.a[start.getY()][i].getPiece() != null) {
                    return false;
                } else if (i == end.getX() && end.getPiece() != null && end.getPiece().isWhite() == start.getPiece().isWhite()) {
                    return false;
                }
            }
        }
        if (start.getPiece().getName() != "knight" && end.getY() < start.getY() && end.getX() > start.getX()) {
            for (int i = start.getX() + 100; i <= end.getX(); i += 100) {
                for (int j = start.getY() - 100; j >= end.getY(); j -= 100) {
                    if (i < end.getX() && j > end.getY() && end.getY() - j == -(end.getX() - i) && Board.a[j][i].getPiece() != null) {
                        return false;
                    } else if (i == end.getX() && j == end.getY() && end.getY() - start.getY() == -(end.getX() - start.getX()) && end.getPiece() != null && end.getPiece().isWhite() == start.getPiece().isWhite()) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (start.getPiece().getName() != "rock" && end.getY() < start.getY() && end.getX() == start.getX()) {
            for (int i = start.getY() - 100; i >= end.getY(); i -= 100) {
                if (i > end.getY() && Board.a[i][start.getX()].getPiece() != null) {
                    return false;
                } else if (i == end.getY() && end.getPiece() != null && end.getPiece().isWhite() == start.getPiece().isWhite()) {
                    return false;
                }
            }
        }
        if (start.getPiece().getName() != "knight" && end.getY() < start.getY() && end.getX() < start.getX()) {
            for (int i = start.getX() - 100; i >= end.getX(); i -= 100) {
                for (int j = start.getY() - 100; j >= end.getY(); j -= 100) {
                    if (i > end.getX() && j > end.getY() && end.getY() - j == end.getX() - i && Board.a[j][i].getPiece() != null) {
                        return false;
                    } else if (i == end.getX() && j == end.getY() && end.getY() - start.getY() == end.getX() - start.getX() && end.getPiece() != null && end.getPiece().isWhite() == start.getPiece().isWhite()) {
                        return false;
                    }
                }
            }
            return true;
        }

        if (start.getPiece().getName() != "rock" && end.getY() == start.getY() && end.getX() < start.getX()) {
            for (int i = start.getX() - 100; i >= end.getX(); i -= 100) {
                if (i > end.getX() && Board.a[start.getY()][i].getPiece() != null) {
                    return false;
                } else if (i == end.getX() && end.getPiece() != null && end.getPiece().isWhite() == start.getPiece().isWhite()) {
                    return false;
                }
            }
        }
        if (start.getPiece().getName() != "knight" && end.getY() > start.getY() && end.getX() < start.getX()) {
            for (int i = start.getX() - 100; i >= end.getX(); i -= 100) {
                for (int j = start.getY() + 100; j <= end.getY(); j += 100) {
                    if (i > end.getX() && j < end.getY() && end.getY() - j == -(end.getX() - i) && Board.a[j][i].getPiece() != null) {
                        return false;
                    } else if (i == end.getX() && j == end.getY() && end.getY() - start.getY() == -(end.getX() - start.getX()) && end.getPiece() != null && end.getPiece().isWhite() == start.getPiece().isWhite()) {
                        return false;
                    }
                }
            }
            return true;
        }


        return true;
    }


}
