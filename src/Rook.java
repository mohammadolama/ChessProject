import javax.print.DocFlavor;
import java.nio.file.FileAlreadyExistsException;

public class Rook extends Piece {
    private String name;

    public Rook(boolean available, boolean isWhite, int x, int y) {
        super(available, isWhite, x, y);
        this.name = "rock";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean ValidMove(Spot[][] primary ,Spot start, Spot end) {
        if (super.ValidMove( primary ,start, end) == false) {
            return false;
        }
        if (end.getX() == start.getX() || end.getY() == start.getY()) {
            int SignX = Integer.compare(end.getX() - start.getX(), 0);
            int SignY = Integer.compare(end.getY() - start.getY(), 0);
            if (end.getX() == start.getX()) {
                if (end.getPiece() == null) {
                    for (int i = 100; i < Math.abs(end.getY() - start.getY()); i += 100) {
                        if (Board.a[start.getY() + (i * SignY)][start.getX()].getPiece() != null)
                            return false;

                    }
                    return true;
                } else if (end.getPiece() != null && end.getPiece().getName() != "pawn") {
                    for (int i = 100; i < Math.abs(end.getY() - start.getY()); i += 100) {
                        if (Board.a[start.getY() + (i * SignY)][start.getX()].getPiece() != null)
                            return false;
                    }
                    return true;
                } else if (end.getPiece() != null && end.getPiece().getName() == "pawn") {
                    for (int i = 100; i < Math.abs(end.getY() - start.getY()); i += 100) {
                        if (i < (Math.abs(end.getY() - start.getY()) - 100) && Board.a[start.getY() + (i * SignY)][start.getX()].getPiece() != null)
                            return false;
                        else if (i == (Math.abs(end.getY() - start.getY()) - 100)) {
                            if ((Board.a[start.getY() + (i * SignY)][start.getX()].getPiece() != null && Board.a[start.getY() + (i * SignY)][start.getX()].getPiece().getName() == "pawn" && Board.a[start.getY() + (i * SignY)][start.getX()].getPiece().isWhite() != start.getPiece().isWhite())) {
                                Board.RookSp = true;
                                return true;
                            } else if ((Board.a[start.getY() + (i * SignY)][start.getX()].getPiece() == null))
                                return true;
                            return false;
                        }
                    }
                    return true;
                }

            }
            if (end.getY() == start.getY()) {
                if (end.getPiece() == null) {
                    for (int i = 100; i < Math.abs(end.getX() - start.getX()); i += 100) {
                        if (Board.a[start.getY()][start.getX() + (i * SignX)].getPiece() != null)
                            return false;
                    }
                    return true;
                }
                else if (end.getPiece()!=null && end.getPiece().getName()!="pawn"){
                    for (int i = 100; i < Math.abs(end.getX() - start.getX()); i += 100) {
                        if (Board.a[start.getY()][start.getX() + (i * SignX)].getPiece() != null)
                            return false;
                    }
                    return true;
                }
                else if (end.getPiece() != null && end.getPiece().getName() == "pawn"){
                    for (int i = 100; i <Math.abs(end.getX()-start.getX()) ; i+=100) {
                        if (i<(Math.abs(end.getX() - start.getX()) - 100) && Board.a[start.getY()][start.getX() + (i*SignX)].getPiece()!=null)
                            return false;
                        else if (i==(Math.abs(end.getX() - start.getX()) - 100)){
                            if (Board.a[start.getY()][start.getX() + (i*SignX)].getPiece()!=null && Board.a[start.getY()][start.getX() + (i*SignX)].getPiece().getName()=="pawn" && Board.a[start.getY()][start.getX() + (i*SignX)].getPiece().isWhite()!=start.getPiece().isWhite()) {
                                Board.RookSp = true;
                                return true;
                            }
                            else if (Board.a[start.getY()][start.getX() + (i*SignX)].getPiece()==null) {
                                return true;
                            }
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}

