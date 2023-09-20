public class Knight extends Piece {
    private String name;

    public Knight(boolean available, boolean isWhite, int x, int y) {
        super(available, isWhite, x, y);
        this.name="knight";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean ValidMove(Spot[][] primary , Spot start, Spot end) {
        if (super.ValidMove( primary , start, end)==false)
            return false;
        if ((Math.abs(end.getX()-start.getX())==200 && Math.abs(end.getY()-start.getY())==100)||(Math.abs(end.getX()-start.getX())==100 && Math.abs(end.getY()-start.getY())==200))
        return true;
//
        return false;
    }
}
