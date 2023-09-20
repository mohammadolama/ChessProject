import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pawn extends Piece {
    private String name;
    private int cntMove = 0;
    private boolean EnPasant = false;
    private boolean Enpasantable = false;
//    private boolean EnpasantAvailable = false;
    private boolean BEnpasantAvailable=false;

    @Override
    public boolean isEnpasantable() {
        return super.isEnpasantable();
    }

    @Override
    public void setEnpasantable(boolean enpasantable) {
        super.setEnpasantable(enpasantable);
    }

    @Override
    public int getCntMove() {
        return super.getCntMove();
    }

    public Pawn(boolean available, boolean isWhite, int x, int y) {
        super(available, isWhite, x, y);
        this.name = "pawn";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void ValidColorize(Board board, Spot start) {
        super.ValidColorize(board, start);
        if (start.getPiece().isWhite() != false) {
            if (start.getY() == 100) {

            }
        }
    }

    @Override
    public boolean ValidMove(Spot[][] primary ,Spot start, Spot end) {
        if (super.ValidMove(primary ,start, end) == false)
            return false;

        //promotion
        if (start.getPiece().isWhite() && start.getY() == 100 && end.getY() == 0 && ((end.getPiece() == null && end.getX() == start.getX()) || (end.getPiece() != null && (end.getX() == start.getX() + 100 || end.getX() == start.getX() - 100)))) {
            Board.Promotion=true;
            this.cntMove++;

            return true;
        }
        //promotion
        if (start.getPiece().isWhite() == false && start.getY() == 600 && end.getY() == 700 && ((end.getPiece() == null && end.getX() == start.getX()) || (end.getPiece() != null && (end.getX() == start.getX() + 100 || end.getX() == start.getX() - 100)))) {
            Board.Promotion=true;
            this.cntMove++;
            return true;
        }

        if (Board.EnpasantAvailable && super.isWhite() == false) {
            if (start.getX() >= 100 && start.getX() <= 600) {
                if (Board.a[start.getY()][start.getX() + 100].getPiece() != null && Board.a[start.getY()][start.getX() + 100].getPiece().isEnpasantable()) {
                    if (end.getY() == start.getY() + 100 && end.getX() == start.getX() + 100) {
                        Board.DoEnpasant=true;

                        return true;
                    }
                }
                if (Board.a[start.getY()][start.getX() - 100].getPiece() != null && Board.a[start.getY()][start.getX() - 100].getPiece().isEnpasantable()) {
                    if (end.getY() == start.getY() + 100 && end.getX() == start.getX() - 100) {
                        Board.DoEnpasant=true;

                        return true;
                    }
                }
            } else if (start.getX() == 700) {
                if (Board.a[start.getY()][start.getX() - 100].getPiece() != null && Board.a[start.getY()][start.getX() - 100].getPiece().isEnpasantable()) {
                    if (end.getY() == start.getY() + 100 && end.getX() == start.getX() - 100) {
                        Board.DoEnpasant=true;

                        return true;
                    }
                }
            } else if (start.getX() == 0) {
                if (Board.a[start.getY()][start.getX() + 100].getPiece() != null && Board.a[start.getY()][start.getX() + 100].getPiece().isEnpasantable()) {
                    if (end.getY() == start.getY() + 100 && end.getX() == start.getX() + 100) {
                        Board.DoEnpasant=true;

                        return true;
                    }
                }
            }
        }

        if (Board.EnpasantAvailable && super.isWhite()) {
            if (start.getX() >= 100 && start.getX() <= 600) {
                if (Board.a[start.getY()][start.getX() + 100].getPiece() != null && Board.a[start.getY()][start.getX() + 100].getPiece().isEnpasantable()) {
                    if (end.getY() == start.getY() - 100 && end.getX() == start.getX() + 100) {
//
                        Board.DoEnpasant=true;
                        return true;
                    }
                }
                if (Board.a[start.getY()][start.getX() - 100].getPiece() != null && Board.a[start.getY()][start.getX() - 100].getPiece().isEnpasantable()) {
                    if (end.getY() == start.getY() - 100 && end.getX() == start.getX() - 100) {
//
                        Board.DoEnpasant=true;

                        return true;
                    }
                }
            } else if (start.getX() == 700) {
                if (Board.a[start.getY()][start.getX() - 100].getPiece() != null && Board.a[start.getY()][start.getX() - 100].getPiece().isEnpasantable()) {
                    if (end.getY() == start.getY() - 100 && end.getX() == start.getX() - 100) {
                        Board.DoEnpasant=true;

                        return true;
                    }
                }
            } else if (start.getX() == 0) {
                if (Board.a[start.getY()][start.getX() + 100].getPiece() != null && Board.a[start.getY()][start.getX() + 100].getPiece().isEnpasantable()) {
                    if (end.getY() == start.getY() - 100 && end.getX() == start.getX() + 100) {
                        Board.DoEnpasant=true;

                        return true;
                    }
                }
            }
        }

        if (super.isWhite() && end.getY() - start.getY() == -100 && end.getX() == start.getX() && end.getPiece() == null) {
            this.cntMove++;
            return true;
        }

        if (super.isWhite() == false && end.getY() - start.getY() == 100 && end.getX() == start.getX() && end.getPiece() == null) {
            this.cntMove++;
            return true;
        }

        if (super.isWhite() && end.getY() - start.getY() == -100 && (end.getX() == start.getX() - 100 || end.getX() == start.getX() + 100) && end.getPiece() != null && end.getPiece().isWhite() == false) {
            this.cntMove++;
            return true;
        }

        if (super.isWhite() == false && end.getY() - start.getY() == 100 && (end.getX() == start.getX() - 100 || end.getX() == start.getX() + 100) && end.getPiece() != null && end.getPiece().isWhite()) {
            this.cntMove++;
            return true;
        }

        if (super.isWhite() && start.getY() == 600 && (end.getY() - start.getY() == -100 || end.getY() - start.getY() == -200) && (end.getX() == start.getX()) && end.getPiece() == null) {
            if (start.getX() >= 100 && start.getX() <= 600) {
                if (this.getCntMove() == 0 && end.getY() == 400 && ((Board.a[end.getY()][end.getX() - 100].getPiece() != null && Board.a[end.getY()][end.getX() - 100].getPiece().isWhite())==false || (Board.a[end.getY()][end.getX() + 100].getPiece() != null && Board.a[end.getY()][end.getX() + 100].getPiece().isWhite()==false))) {
                    if (Board.a[end.getY()][end.getX() - 100].getPiece() != null) {
                        Board.a[end.getY()][end.getX() - 100].getPiece().setEnPasant(true);
                        Board.EnpasantAvailable =true;
                        this.setEnpasantable(true);
                    }
                    if (Board.a[end.getY()][end.getX() + 100].getPiece() != null) {
                        Board.a[end.getY()][end.getX() + 100].getPiece().setEnPasant(true);
                        Board.EnpasantAvailable =true;
                        this.setEnpasantable(true);
                    }
                    this.cntMove++;
                    return true;
                }
            } else if (start.getX() == 600) {
                if ( this.getCntMove() == 0 && end.getY() == 400 && Board.a[end.getY()][end.getX() - 100].getPiece() != null && Board.a[end.getY()][end.getX() - 100].getPiece().isWhite()==false) {
                    Board.a[end.getY()][end.getX() - 100].getPiece().setEnPasant(true);
                    Board.EnpasantAvailable =true;
                    this.cntMove++;
                    return true;
                }
            } else if (start.getX() == 0) {
                if ( this.getCntMove() == 0 && end.getY() == 300 && Board.a[end.getY()][end.getX() + 100].getPiece() != null && Board.a[end.getY()][end.getX() + 100].getPiece().isWhite()==false) {
                    Board.a[end.getY()][end.getX() + 100].getPiece().setEnPasant(true);
                    Board.EnpasantAvailable =true;
                    this.cntMove++;
                    return true;
                }
            }
            this.cntMove++;
            return true;
        }

        if (super.isWhite() == false && start.getY() == 100 && (end.getY() - start.getY() == 100 || end.getY() - start.getY() == 200) && (end.getX() == start.getX()) && end.getPiece() == null) {
            if (start.getX() >= 100 && start.getX() <= 600) {
                if (this.getCntMove() == 0 && end.getY() == 300 && ((Board.a[end.getY()][end.getX() - 100].getPiece() != null && Board.a[end.getY()][end.getX() - 100].getPiece().isWhite()) || (Board.a[end.getY()][end.getX() + 100].getPiece() != null && Board.a[end.getY()][end.getX() + 100].getPiece().isWhite()))) {
                    if (Board.a[end.getY()][end.getX() - 100].getPiece() != null) {
                        Board.a[end.getY()][end.getX() - 100].getPiece().setEnPasant(true);
                        Board.EnpasantAvailable =true;
                        
                        this.setEnpasantable(true);
                    }
                    if (Board.a[end.getY()][end.getX() + 100].getPiece() != null) {

                        Board.a[end.getY()][end.getX() + 100].getPiece().setEnPasant(true);
                        Board.EnpasantAvailable =true;
                        this.setEnpasantable(true);
                    }
                    this.cntMove++;
                    return true;
                }
            } else if (start.getX() == 600) {
                if ( this.getCntMove() == 0 && end.getY() == 300 && Board.a[end.getY()][end.getX() - 100].getPiece() != null && Board.a[end.getY()][end.getX() - 100].getPiece().isWhite()) {
                    Board.a[end.getY()][end.getX() - 100].getPiece().setEnPasant(true);
                    Board.EnpasantAvailable =true;
                    this.setEnpasantable(true);
                    this.cntMove++;
                    return true;
                }
            } else if (start.getX() == 0) {

                if ( this.getCntMove() == 0 && end.getY() == 300 && Board.a[end.getY()][end.getX() + 100].getPiece() != null && Board.a[end.getY()][end.getX() + 100].getPiece().isWhite()) {

                    Board.a[end.getY()][end.getX() + 100].getPiece().setEnPasant(true);
                    Board.EnpasantAvailable =true;
                    this.setEnpasantable(true);
                    this.cntMove++;
                    return true;
                }
            }

            this.cntMove++;
            return true;
        }
        return false;
    }

}
