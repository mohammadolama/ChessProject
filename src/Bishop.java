public class Bishop extends Piece {
    private String name;

    public Bishop(boolean available, boolean isWhite, int x, int y) {
        super(available, isWhite, x, y);
        this.name = "bishop";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean ValidMove(Spot[][] primary ,Spot start, Spot end) {
        if (end.getX() - start.getX() == end.getY() - start.getY() || end.getX() - start.getX() == -(end.getY() - start.getY())) {
            Boolean flag = true;
            int Cnt1 = 0;
            int Cnt2 = 0;
            int SignX = Integer.compare(end.getX() - start.getX(), 0);
            int SignY = Integer.compare(end.getY() - start.getY(), 0);
            for (int i = 100; i < Math.abs(end.getX() - start.getX()); i += 100) {
                if (start.getY() + (i * SignX) >= 0 && start.getY() + (i * SignX) <= 700 && start.getX() + (i * SignY) >= 0 && start.getX() + (i * SignY) <= 700) {
                    if (Board.a[start.getY() + (i * SignX)][start.getX() + (i * SignY)].getPiece() == null) {
                        flag = false;
                    }
                    if (flag == true && Board.a[start.getY() + (i * SignX)][start.getX() + (i * SignY)].getPiece() != null) {
                        Cnt1++;
                    } else if (flag == false && Board.a[start.getY() + (i * SignX)][start.getX() + (i * SignY)].getPiece() != null) {
                        Cnt2++;
                    }
                    if (Cnt1 >= 4 || Cnt2 > 0) {
                        return false;
                    }
                }
            }
            if ((end.getPiece() == null && Cnt1 <= 3 && Cnt2 == 0) || (end.getPiece() != null && end.getPiece().isWhite() != start.getPiece().isWhite() && Cnt1 <= 2 && Cnt2 == 0)) {
                return true;
            }
        }
        if (super.ValidMove(primary ,start, end) == false) {
            return false;
        }
        if (Math.abs(start.getX() - end.getX()) == Math.abs(start.getY() - end.getY()))
            return true;
        return false;
    }
}
