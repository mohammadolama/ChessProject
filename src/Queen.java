public class Queen extends Piece {
    private String name;
    public Queen(boolean available, boolean isWhite, int x, int y) {
        super(available, isWhite, x, y);
        this.name="queen";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean ValidMove(Spot[][] primary ,  Spot start, Spot end) {
        if (super.ValidMove( primary , start, end)==false)
            return false;
        if(start.getY()==end.getY())
            return true;
        if(start.getX()==end.getX())
            return true;
        if(Math.abs(start.getX()-end.getX())==Math.abs(start.getY()-end.getY()))
            return true;
        return false;
    }
}
