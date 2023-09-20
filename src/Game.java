import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.GlyphMetrics;
import java.util.ArrayList;

public class Game {
    static ArrayList<Spot[][]> status=new ArrayList<>();
    public static boolean WGame() {

        int[][] BMC = King.BMateChecker();
        Spot[][] test = Board.a.clone();

        int XW = 0;
        int YW = 0;
        for (int i = 0; i < 800; i += 100) {
            for (int j = 0; j < 800; j += 100) {
                if (test[i][j].getPiece() != null && test[i][j].getPiece().getName() == "king" && test[i][j].getPiece().isWhite()) {
                    XW = j;
                    YW = i;
                }
            }
        }

        if (BMC[YW][XW] != 0) {
            Board.jlabel.setText("White King is under attack .");
            return false;
        }

        return true;
    }

    public static boolean BGame() {
        int[][] WMC = King.WMateChecker();
        Spot[][] test = Board.a.clone();

        int XB = 0;
        int YB = 0;

        for (int i = 0; i < 800; i += 100) {
            for (int j = 0; j < 800; j += 100) {
                if (test[i][j].getPiece() != null && test[i][j].getPiece().getName() == "king" && test[i][j].getPiece().isWhite() == false) {
                    XB = j;
                    YB = i;
                }
            }
        }

        if (WMC[YB][XB] != 0) {

            Board.jlabel.setText("Black King is under attack .");

            return false;
        }

        return true;
    }

    public static boolean WCheckMate() {
        int[][] BMC = King.BMateChecker();
        Spot[][] test = Board.a.clone();

        for (int i = 0; i < 800; i += 100) {
            for (int j = 0; j < 800; j += 100) {
                if (test[i][j].getPiece() != null && test[i][j].getPiece().isWhite()) {
                    for (int k = 0; k < 800; k += 100) {
                        for (int l = 0; l < 800; l += 100) {
                            if (test[i][j].getPiece().ValidMove(test, test[i][j], test[k][l])) {
//
                                String st1 = test[i][j].getText();
                                String st2 = test[k][l].getText();
                                Piece piece1 = test[i][j].getPiece();
                                Piece piece2 = test[k][l].getPiece();
                                test[i][j].setText("");
                                test[i][j].setPiece(null);
                                test[k][l].setText(st1);
                                test[k][l].setPiece(piece1);
                                if (Game.WGame() == false) {
                                    test[i][j].setText(st1);
                                    test[i][j].setPiece(piece1);
                                    test[k][l].setText(st2);
                                    test[k][l].setPiece(piece2);
                                    continue;
                                }
                                test[i][j].setText(st1);
                                test[i][j].setPiece(piece1);
                                test[k][l].setText(st2);
                                test[k][l].setPiece(piece2);
                                return true;

                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean BCheckMate() {
        int[][] WMC = King.WMateChecker();
        Spot[][] test = Board.a.clone();

        for (int i = 0; i < 800; i += 100) {
            for (int j = 0; j < 800; j += 100) {
                if (test[i][j].getPiece() != null && test[i][j].getPiece().isWhite() == false) {
                    for (int k = 0; k < 800; k += 100) {
                        for (int l = 0; l < 800; l += 100) {
                            if (test[i][j].getPiece().isWhite() == false && test[i][j].getPiece().ValidMove(test, test[i][j], test[k][l])) {
                                String st1 = test[i][j].getText();
                                String st2 = test[k][l].getText();
                                Piece piece1 = test[i][j].getPiece();
                                Piece piece2 = test[k][l].getPiece();
                                test[i][j].setText("");
                                test[i][j].setPiece(null);
                                test[k][l].setText(st1);
                                test[k][l].setPiece(piece1);
                                if (Game.BGame() == false) {
                                    test[i][j].setText(st1);
                                    test[i][j].setPiece(piece1);
                                    test[k][l].setText(st2);
                                    test[k][l].setPiece(piece2);
                                    continue;
                                }
                                test[i][j].setText(st1);
                                test[i][j].setPiece(piece1);
                                test[k][l].setText(st2);
                                test[k][l].setPiece(piece2);
                                return true;

                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean Stalemate() {
        Spot[][] test = Board.a.clone();

        if (Board.WP == true && Game.WGame() == true) {
            for (int i = 0; i < 800; i += 100) {
                for (int j = 0; j < 800; j += 100) {
                    if (test[i][j].getPiece() != null && test[i][j].getPiece().isWhite()) {
                        for (int k = 0; k < 800; k += 100) {
                            for (int l = 0; l < 800; l += 100) {
                                if (test[i][j].getPiece().ValidMove(test, test[i][j], test[k][l])) {
//
                                    String st1 = test[i][j].getText();
                                    String st2 = test[k][l].getText();
                                    Piece piece1 = test[i][j].getPiece();
                                    Piece piece2 = test[k][l].getPiece();
                                    test[i][j].setText("");
                                    test[i][j].setPiece(null);
                                    test[k][l].setText(st1);
                                    test[k][l].setPiece(piece1);
                                    if (Game.WGame() == false) {
                                        test[i][j].setText(st1);
                                        test[i][j].setPiece(piece1);
                                        test[k][l].setText(st2);
                                        test[k][l].setPiece(piece2);
                                        continue;
                                    }
                                    test[i][j].setText(st1);
                                    test[i][j].setPiece(piece1);
                                    test[k][l].setText(st2);
                                    test[k][l].setPiece(piece2);
                                    return true;

                                }
                            }
                        }
                    }
                }
            }

        } else if (Board.WP == false && Game.BGame() == true) {
            for (int i = 0; i < 800; i += 100) {
                for (int j = 0; j < 800; j += 100) {
                    if (test[i][j].getPiece() != null && test[i][j].getPiece().isWhite() == false) {
                        for (int k = 0; k < 800; k += 100) {
                            for (int l = 0; l < 800; l += 100) {
                                if (test[i][j].getPiece().isWhite() == false && test[i][j].getPiece().ValidMove(test, test[i][j], test[k][l])) {
                                    String st1 = test[i][j].getText();
                                    String st2 = test[k][l].getText();
                                    Piece piece1 = test[i][j].getPiece();
                                    Piece piece2 = test[k][l].getPiece();
                                    test[i][j].setText("");
                                    test[i][j].setPiece(null);
                                    test[k][l].setText(st1);
                                    test[k][l].setPiece(piece1);
                                    if (Game.BGame() == false) {
                                        test[i][j].setText(st1);
                                        test[i][j].setPiece(piece1);
                                        test[k][l].setText(st2);
                                        test[k][l].setPiece(piece2);
                                        continue;
                                    }
                                    test[i][j].setText(st1);
                                    test[i][j].setPiece(piece1);
                                    test[k][l].setText(st2);
                                    test[k][l].setPiece(piece2);
                                    return true;

                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void Colorize(Spot start) {
        Spot[][] test = Board.a.clone();

        for (int i = 0; i < 800; i += 100) {
            for (int j = 0; j < 800; j += 100) {
                if (start.getPiece().ValidMove(test, test[start.getY()][start.getX()], test[i][j])) {

                    if (Board.r1.isSelected()) {
                        if (Board.a[i][j].getPiece() == null)
                            Board.a[i][j].setBackground(Color.green);
                        else
                            Board.a[i][j].setBackground(Color.red);

                    } else if (Board.r2.isSelected()){
                        if (Board.a[i][j].getPiece() == null)
                            Board.a[i][j].setBackground(Color.green);
                        else {
                            Board.a[i][j].setBackground(new Color(255,215,0));
                        }
                    }else if (Board.r3.isSelected()){
                        if (Board.a[i][j].getPiece() == null)
                            Board.a[i][j].setBackground(new Color(65,105,225));
                        else {
                            Board.a[i][j].setBackground(Color.red);
                        }
                    }
                    else if (Board.r4.isSelected()){
                        if (Board.a[i][j].getPiece() == null)
                            Board.a[i][j].setBackground(new Color(255,140,0));
                        else {
                            Board.a[i][j].setBackground(Color.GREEN);
                        }
                    }

                }
            }

        }
    }

    public static void DisColorize() {


        for (int i = 0; i < 800; i = i + 100) {
            for (int j = 0; j < 800; j = j + 100) {
                if (Board.r1.isSelected()) {
                    Board.a[i][j].setBackground((i + j) % 200 == 0 ? Color.WHITE : Color.LIGHT_GRAY);
                } else if (Board.r2.isSelected()) {
                    Board.a[i][j].setBackground((i + j) % 200 == 0 ? Board.color2 : Board.color3);
                }else if (Board.r3.isSelected()) {
                    Board.a[i][j].setBackground((i + j) % 200 == 0 ? new Color(230, 215, 250) : new Color(124,252,0));
                }else if (Board.r4.isSelected()) {
                    Board.a[i][j].setBackground((i + j) % 200 == 0 ? new Color(127,255,212) : new Color(255,255,51));
                }
            }
        }


    }

    public static void Promotion( Spot end){
        if (end.getPiece().isWhite() &&  end.getY() == 0  ) {
            Font font = new Font("Serif", Font.PLAIN, 45);
            JFrame s = new JFrame("Choose");
            JButton j1 = new JButton("\u2657");
            j1.setText("\u2657");
            j1.setFont(font);
            JButton j2 = new JButton("\u2655");
            j2.setText("\u2655");
            j2.setFont(font);

            JButton j3 = new JButton("\u2656");
            j3.setText("\u2656");
            j3.setFont(font);

            JButton j4 = new JButton("\u2658");
            j4.setText("\u2658");

            j4.setFont(font);
            s.add(j1);
            s.add(j2);
            s.add(j3);
            s.add(j4);
            s.setLayout(null);
            s.setSize(420, 150);
            s.setVisible(true);
            j1.setLayout(null);
            j1.setVisible(true);
            j2.setLayout(null);
            j2.setVisible(true);
            j3.setLayout(null);
            j3.setVisible(true);
            j4.setVisible(true);
            j4.setLayout(null);
            j1.setBounds(10, 10, 80, 80);
            j2.setBounds(110, 10, 80, 80);
            j3.setBounds(210, 10, 80, 80);
            j4.setBounds(310, 10, 80, 80);

            j1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    Board.a[end.getY()][end.getX()].setText("\u2657");
                    Board.a[end.getY()][end.getX()].setPiece(new Bishop(true, true, end.getX(), end.getY()));
                    s.dispose();
                }
            });
            j2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    Board.a[end.getY()][end.getX()].setText("\u2655");
                    Board.a[end.getY()][end.getX()].setPiece(new Queen(true, true, end.getX(), end.getY()));
                    s.dispose();
                }
            });
            j3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    Board.a[end.getY()][end.getX()].setText("\u2656");
                    Board.a[end.getY()][end.getX()].setPiece(new Rook(true, true, end.getX(), end.getY()));
                    s.dispose();
                }
            });
            j4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    Board.a[end.getY()][end.getX()].setText("\u2658");
                    Board.a[end.getY()][end.getX()].setPiece(new Knight(true, true, end.getX(), end.getY()));
                    s.dispose();
                }
            });

        }
        //promotion
        if (end.getPiece().isWhite() == false  && end.getY() == 700 ) {
            Font font = new Font("Serif", Font.PLAIN, 45);
            JFrame s = new JFrame("Choose");
            JButton j1 = new JButton("\u265D");
            j1.setFont(font);
            JButton j2 = new JButton("\u265B");
            j2.setFont(font);
            JButton j3 = new JButton("\u265C");
            j3.setFont(font);
            JButton j4 = new JButton("\u265E");
            j4.setFont(font);
            s.add(j1);
            s.add(j2);
            s.add(j3);
            s.add(j4);
            s.setLayout(null);
            s.setSize(420, 150);
            s.setVisible(true);
            j1.setLayout(null);
            j1.setVisible(true);
            j2.setLayout(null);
            j2.setVisible(true);
            j3.setLayout(null);

            j3.setVisible(true);
            j4.setVisible(true);
            j4.setLayout(null);
            j1.setBounds(10, 10, 80, 80);
            j2.setBounds(110, 10, 80, 80);
            j3.setBounds(210, 10, 80, 80);
            j4.setBounds(310, 10, 80, 80);

            j1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    Board.a[end.getY()][end.getX()].setText("\u265D");
                    Board.a[end.getY()][end.getX()].setPiece(new Bishop(true, false, end.getX(), end.getY()));
                    s.dispose();
                }
            });
            j2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    Board.a[end.getY()][end.getX()].setText("\u265B");
                    Board.a[end.getY()][end.getX()].setPiece(new Queen(true, false, end.getX(), end.getY()));
                    s.dispose();
                }
            });
            j3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    Board.a[end.getY()][end.getX()].setText("\u265C");
                    Board.a[end.getY()][end.getX()].setPiece(new Rook(true, false, end.getX(), end.getY()));
                    s.dispose();
                }
            });
            j4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    Board.a[end.getY()][end.getX()].setText("\u265E");
                    Board.a[end.getY()][end.getX()].setPiece(new Knight(true, false, end.getX(), end.getY()));
                    s.dispose();
                }
            });

        }
        DisColorize();
    }

    public static void Update(Spot[][] a){
        status.add(a);
    }
    public static void Undo(){
        if (status.size()>=1) {

            Board.a = status.get(status.size() - 1).clone();
            for (int i = 0; i < 800; i += 100) {
                for (int j = 0; j < 800; j += 100) {
                    if (Board.a[i][j].getPiece() != null && Board.a[i][j].getPiece() instanceof King && Board.a[i][j].getPiece().isWhite()) {
                        Board.a[i][j].setText("\u2654");
                    } else if (Board.a[i][j].getPiece() != null && Board.a[i][j].getPiece() instanceof King && Board.a[i][j].getPiece().isWhite() == false) {
                        Board.a[i][j].setText("\u265A");
                    } else if (Board.a[i][j].getPiece() != null && Board.a[i][j].getPiece() instanceof Queen && Board.a[i][j].getPiece().isWhite()) {
                        Board.a[i][j].setText("\u2655");

                    } else if (Board.a[i][j].getPiece() != null && Board.a[i][j].getPiece() instanceof Queen && Board.a[i][j].getPiece().isWhite() == false) {
                        Board.a[i][j].setText("\u265B");

                    } else if (Board.a[i][j].getPiece() != null && Board.a[i][j].getPiece() instanceof Rook && Board.a[i][j].getPiece().isWhite()) {
                        Board.a[i][j].setText("\u2656");

                    } else if (Board.a[i][j].getPiece() != null && Board.a[i][j].getPiece() instanceof Rook && Board.a[i][j].getPiece().isWhite() == false) {
                        Board.a[i][j].setText("\u265C");

                    } else if (Board.a[i][j].getPiece() != null && Board.a[i][j].getPiece() instanceof Bishop && Board.a[i][j].getPiece().isWhite()) {
                        Board.a[i][j].setText("\u2657");

                    } else if (Board.a[i][j].getPiece() != null && Board.a[i][j].getPiece() instanceof Bishop && Board.a[i][j].getPiece().isWhite() == false) {
                        Board.a[i][j].setText("\u265D");

                    } else if (Board.a[i][j].getPiece() != null && Board.a[i][j].getPiece() instanceof Knight && Board.a[i][j].getPiece().isWhite()) {
                        Board.a[i][j].setText("\u2658");

                    } else if (Board.a[i][j].getPiece() != null && Board.a[i][j].getPiece() instanceof Knight && Board.a[i][j].getPiece().isWhite() == false) {
                        Board.a[i][j].setText("\u265E");

                    } else if (Board.a[i][j].getPiece() != null && Board.a[i][j].getPiece() instanceof Pawn && Board.a[i][j].getPiece().isWhite()) {
                        Board.a[i][j].setText("\u2659");

                    } else if (Board.a[i][j].getPiece() != null && Board.a[i][j].getPiece() instanceof Pawn && Board.a[i][j].getPiece().isWhite() == false) {
                        Board.a[i][j].setText("\u265F");
                    }
                    else {
                        Board.a[i][j].setText("");
                    }

                }
            }
            status.remove(status.size() - 1);
        }
    }
}