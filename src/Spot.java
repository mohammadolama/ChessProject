import javax.swing.*;

public class Spot extends JButton {
    private int x;
    private int y;
    Piece piece;

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Spot(int x, int y) {
        this.x = x;
        this.y = y;
        piece = null;
    }


}
