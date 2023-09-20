import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;

public class Board {
    static int s1 = 102;
    static int s2;
    static boolean WP = true;
    static JFrame f = new JFrame("Chess");
    static Font font = new Font("serif", Font.PLAIN, 60);
    static Font font2 = new Font("serif", Font.PLAIN, 20);
    public static Spot[][] a = new Spot[800][800];
    static JButton label1 = new JButton("Player White");
    static JButton label2 = new JButton("Player Black");
    static JButton restart = new JButton("RESTART");
    static JButton WW = new JButton("White Wins");
    static JButton BW = new JButton("Black Wins");
    static JButton Stalemate = new JButton("Stalemate");
    static JButton Undo = new JButton("UNDO");
    static JRadioButton r1 = new JRadioButton("Gray");
    static JRadioButton r2 = new JRadioButton("Classic");
    static JRadioButton r3 = new JRadioButton("Pink-Green");
    static JRadioButton r4 = new JRadioButton("Cyan-yellow");
    static Color color2=new Color(255,222,173);
    static Color color3=new Color(160,82,45);
    static JLabel jlabel = new JLabel("Let's Start ...");
    static boolean EnpasantAvailable = false;
    static boolean DoEnpasant = false;
    static boolean Casteling = false;
    static Color color1 = new Color(255, 114, 122, 166);
    static boolean Clicked = false;
    static boolean RookSp = false;
    static boolean Promotion=false;
    static void SwitchPlayer() {

        WP = !WP;
        if (WP) {
            label1.setBackground(Color.yellow);
            label2.setBackground(Color.white);
        } else {
            label1.setBackground(Color.white);
            label2.setBackground(Color.yellow);
        }
    }

    public static void Disable() {
        for (int i = 0; i < 800; i += 100) {
            for (int j = 0; j < 800; j += 100) {
                a[i][j].setEnabled(false);
            }
        }
    }


    public static void Boarde() {


        JLabel label = new JLabel();
        f.setSize(1200, 1000);
        f.setLayout(null);
        f.setVisible(true);
        f.add(label);
        f.add(jlabel);
        f.setResizable(false);
        jlabel.setFont(font2);
        jlabel.setBounds(850, 250, 300, 50);
        label1.setBounds(950, 50, 200, 50);
        label2.setBounds(950, 110, 200, 50);
        Stalemate.setEnabled(false);
        label1.setEnabled(false);
        label2.setEnabled(false);
        label.setForeground(Color.yellow);
        f.add(restart);
        restart.setBounds(900, 600, 200, 100);
        f.add(WW);
        WW.setEnabled(false);
        f.add(BW);
        BW.setEnabled(false);

        f.add(Stalemate);

        WW.setBounds(810, 400, 100, 100);
        BW.setBounds(910, 400, 100, 100);
        Stalemate.setBounds(1010, 400, 100, 100);
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int i = 0; i < 800; i += 100) {
                    for (int j = 0; j < 800; j += 100) {
                        label.setText("LET'S PLAY...");
                        a[i][j].setText("");
                        a[i][j].setEnabled(true);
                        a[i][j].setPiece(null);
                        WW.setBackground(null);
                        BW.setBackground(null);
                        Stalemate.setBackground(null);
                    }
                }
                for (int i = 0; i < 800; i += 100) {
                    a[100][i].setText("\u265F");
                    a[100][i].setPiece(new Pawn(true, false, 100, i));
                    a[600][i].setText("\u2659");
                    a[600][i].setPiece(new Pawn(true, true, 600, i));
                }
                Casteling=false;
                Clicked=false;
                RookSp=false;
                EnpasantAvailable=false;
                DoEnpasant=false;
                Game.DisColorize();
                s1 = 102;
                s2 = 102;
                a[0][0].setText("\u265C");
                a[0][0].setPiece(new Rook(true, false, 0, 0));
                a[0][700].setText("\u265C");
                a[0][700].setPiece(new Rook(true, false, 0, 700));
                a[700][0].setText("\u2656");
                a[700][0].setPiece(new Rook(true, true, 700, 0));
                a[700][700].setText("\u2656");
                a[700][700].setPiece(new Rook(true, true, 700, 700));
                a[700][100].setText("\u2658");
                a[700][100].setPiece(new Knight(true, true, 700, 100));
                a[700][600].setText("\u2658");
                a[700][600].setPiece(new Knight(true, true, 700, 600));
                a[0][100].setText("\u265E");
                a[0][100].setPiece(new Knight(true, false, 0, 100));
                a[0][600].setText("\u265E");
                a[0][600].setPiece(new Knight(true, false, 0, 600));
                a[0][200].setText("\u265D");
                a[0][200].setPiece(new Bishop(true, false, 0, 200));
                a[0][500].setText("\u265D");
                a[0][500].setPiece(new Bishop(true, false, 0, 500));
                a[700][200].setText("\u2657");
                a[700][200].setPiece(new Bishop(true, true, 700, 200));
                a[700][500].setText("\u2657");
                a[700][500].setPiece(new Bishop(true, true, 700, 500));
                a[700][300].setText("\u2655");
                a[700][300].setPiece(new Queen(true, true, 700, 300));
                a[700][400].setText("\u2654");
                a[700][400].setPiece(new King(true, true, 700, 400));
                a[0][300].setText("\u265B");
                a[0][300].setPiece(new Queen(true, false, 0, 300));
                a[0][400].setText("\u265A");
                a[0][400].setPiece(new King(true, false, 0, 400));
                WP = true;
                label1.setBackground(Color.yellow);
                label2.setBackground(Color.white);

            }
        });
        label1.setLayout(null);
        label2.setLayout(null);
        label1.setBackground(Color.yellow);
        label1.setVisible(true);
        label2.setVisible(true);
        label2.setBackground(Color.WHITE);
        f.add(label1);
        f.add(label2);


        r1.setSelected(true);
        f.add(r1);
        f.add(r2);
        f.add(r3);
        f.add(r4);
        r1.setBounds(810, 50, 70, 30);
        r2.setBounds(810, 100, 70, 30);
        r3.setBounds(810, 150, 120, 30);
        r4.setBounds(810, 200, 120, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);

//
        r1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int i = 0; i < 800; i = i + 100) {
                    for (int j = 0; j < 800; j = j + 100) {
                        a[i][j].setBackground((i + j) % 200 == 0 ? Color.white : Color.LIGHT_GRAY);
                    }
                }
            }
        });
        r2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int i = 0; i < 800; i += 100) {
                    for (int j = 0; j < 800; j += 100) {
                        a[i][j].setBackground((i + j) % 200 == 0 ? color2 : color3);
                    }
                }
            }
        });

        r3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int i = 0; i < 800; i = i + 100) {
                    for (int j = 0; j < 800; j = j + 100) {
                        a[i][j].setBackground((i + j) % 200 == 0 ? new Color(230, 215, 250) : new Color(124,252,0));
                    }
                }
            }
        });
        r4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int i = 0; i < 800; i = i + 100) {
                    for (int j = 0; j < 800; j = j + 100) {
                        a[i][j].setBackground((i + j) % 200 == 0 ? new Color(127,255,212) : Color.yellow);
//
                    }
                }
            }
        });

        for (int i = 0; i < 800; i = i + 100) {
            for (int j = 0; j < 800; j = j + 100) {
                a[i][j] = new Spot(i, j);
                f.add(a[i][j]);
                a[i][j].setBounds(j, i, 100, 100);
                a[i][j].setBackground((i + j) % 200 == 0 ? Color.WHITE : Color.LIGHT_GRAY);
                a[i][j].setFont(font);
                a[i][j].setFocusPainted(false);
            }
        }

        for (int i = 0; i < 800; i += 100) {
            for (int j = 0; j < 800; j += 100) {

                int nowX = i;
                int nowY = j;
                if (s1 == 102 && a[nowX][nowY] == null)
                    continue;
                a[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
//
                        if (s1 == 102 && a[nowX][nowY].getPiece() != null && WP && a[nowX][nowY].getPiece().isWhite() == false)
                            return;
                        if (s1 == 102 && a[nowX][nowY].getPiece() != null && !WP && a[nowX][nowY].getPiece().isWhite())
                            return;
                        if (Clicked == false && a[nowX][nowY].getPiece() == null) {
                            return;
                        }

                        if (s1 == 102 && a[nowX][nowY].getPiece() != null) {
                            color1 = a[nowX][nowY].getBackground();
                            a[nowX][nowY].setBackground((r1.isSelected()||r2.isSelected())?Color.cyan:new Color(255,0,255));
                            Game.Colorize(a[nowX][nowY]);
                            s1 = nowX;
                            s2 = nowY;
                            Clicked = true;
                        } else {
                            a[s1][s2].setBackground(color1);
                            if (a[s1][s2].getPiece() != null && a[s1][s2].getPiece().ValidMove(a, a[s1][s2], a[nowX][nowY])) {
                                jlabel.setText("");
                                a[s1][s2].getPiece().CntMoveUpdater();
                                String st1 = a[s1][s2].getText();
                                String st2 = a[nowX][nowY].getText();
                                Piece piece1 = a[s1][s2].getPiece();
                                Piece piece2 = a[nowX][nowY].getPiece();
                                a[s1][s2].setText("");
                                a[s1][s2].setPiece(null);
                                a[nowX][nowY].setText(st1);
                                a[nowX][nowY].setPiece(piece1);
                                if (WP == true && Game.WGame() == false) {
                                    a[s1][s2].setText(st1);
                                    a[s1][s2].setPiece(piece1);
                                    a[nowX][nowY].setText(st2);
                                    a[nowX][nowY].setPiece(piece2);
                                    if (Game.WCheckMate() == false) {
                                        Disable();
                                        BW.setBackground(Color.yellow);
                                    }
                                    SwitchPlayer();
                                }
                                else if (WP == false && Game.BGame() == false) {
                                    a[s1][s2].setText(st1);
                                    a[s1][s2].setPiece(piece1);
                                    a[nowX][nowY].setText(st2);
                                    a[nowX][nowY].setPiece(piece2);
                                    if (Game.BCheckMate() == false) {
                                        Disable();
                                        WW.setBackground(Color.yellow);
//
                                    }
                                    SwitchPlayer();
                                }
                                if (RookSp == true) {
                                    if (s1 == nowX) {

                                        if (nowY > s2) {
                                            a[nowX][nowY - 100].setPiece(null);
                                            a[nowX][nowY - 100].setText("");
                                        } else if (nowY < s2) {
                                            a[nowX][nowY + 100].setPiece(null);
                                            a[nowX][nowY + 100].setText("");
                                        }
                                    }
                                    else if (s2 == nowY) {
                                        if (nowX > s1) {
                                            a[nowX - 100][nowY].setPiece(null);
                                            a[nowX - 100][nowY].setText("");
                                        } else if (nowX < s1) {
                                            a[nowX + 100][nowY].setPiece(null);
                                            a[nowX + 100][nowY].setText("");
                                        }
                                    }
                                }
                                if (DoEnpasant == true && EnpasantAvailable == true) {
                                    a[s1][nowY].setText("");
                                    a[s1][nowY].setPiece(null);
                                    DoEnpasant = false;
                                    EnpasantAvailable=false;
                                }
                                if (Casteling == true) {
                                    int SignX = Integer.compare(nowY - s2, 0);
                                    int SignY = Integer.compare(nowX - s1, 0);
                                    if (WP == true) {
                                        a[700][nowY - (100 * SignX)].setPiece(SignX > 0 ? a[700][700].getPiece() : a[700][0].getPiece());
                                        a[700][nowY - (100 * SignX)].setText("\u2656");
                                        if (SignX > 0) {
                                            a[700][700].setText("");
                                            a[700][700].setPiece(null);
                                            Casteling=false;

                                        } else if (SignX < 0) {
                                            a[700][0].setText("");
                                            a[700][0].setPiece(null);
                                            Casteling=false;

                                        }

                                    } else if (WP == false) {
                                        a[0][nowY - (100 * SignX)].setPiece(SignX > 0 ? a[0][700].getPiece() : a[0][0].getPiece());
                                        a[0][nowY - (100 * SignX)].setText("\u265C");
                                        if (SignX > 0) {
                                            a[0][700].setText("");
                                            a[0][700].setPiece(null);
                                            Casteling=false;

                                        } else if (SignX < 0) {
                                            a[0][0].setText("");
                                            a[0][0].setPiece(null);
                                            Casteling=false;

                                        }

                                    }
                                    a[nowX][nowY].getPiece().CntMoveUpdater();
                                    a[nowX][nowY - (100 * SignX)].getPiece().CntMoveUpdater();
                                }
                                if (Promotion==true){
                                    Game.Promotion( a[nowX][nowY]);
                                    Promotion=false;
                                }
                                Game.Update(a);
                                SwitchPlayer();
                            }
                            if (WP == true && Game.WGame() == false) {
                                System.out.println("white king is under attack");
                                if (Game.WCheckMate() == false) {
                                    Disable();
                                    BW.setBackground(Color.yellow);
                                }
                            } else if (WP == false && Game.BGame() == false) {
                                System.out.println("black king is under attack");
                                if (Game.BCheckMate() == false) {
                                    Disable();
                                    WW.setBackground(Color.yellow);
                                }
                            }
                            Game.DisColorize();
                            Clicked = false;
                            s1 = s2 = 102;
                        }
                    }
                });

            }
        }
//
        for (int i = 0; i < 800; i += 100) {
            a[100][i].setText("\u265F");
            a[100][i].setPiece(new Pawn(true, false, 100, i));
            a[600][i].setText("\u2659");
            a[600][i].setPiece(new Pawn(true, true, 600, i));
        }
        a[0][0].setText("\u265C");
        a[0][0].setPiece(new Rook(true, false, 0, 0));
        a[0][700].setText("\u265C");
        a[0][700].setPiece(new Rook(true, false, 0, 700));
        a[700][0].setText("\u2656");
        a[700][0].setPiece(new Rook(true, true, 700, 0));
        a[700][700].setText("\u2656");
        a[700][700].setPiece(new Rook(true, true, 700, 700));
        a[700][100].setText("\u2658");
        a[700][100].setPiece(new Knight(true, true, 700, 100));
        a[700][600].setText("\u2658");
        a[700][600].setPiece(new Knight(true, true, 700, 600));
        a[0][100].setText("\u265E");
        a[0][100].setPiece(new Knight(true, false, 0, 100));
        a[0][600].setText("\u265E");
        a[0][600].setPiece(new Knight(true, false, 0, 600));
        a[0][200].setText("\u265D");
        a[0][200].setPiece(new Bishop(true, false, 0, 200));
        a[0][500].setText("\u265D");
        a[0][500].setPiece(new Bishop(true, false, 0, 500));
        a[700][200].setText("\u2657");
        a[700][200].setPiece(new Bishop(true, true, 700, 200));
        a[700][500].setText("\u2657");
        a[700][500].setPiece(new Bishop(true, true, 700, 500));
        a[700][300].setText("\u2655");
        a[700][300].setPiece(new Queen(true, true, 700, 300));
        a[700][400].setText("\u2654");
        a[700][400].setPiece(new King(true, true, 700, 400));
        a[0][300].setText("\u265B");
        a[0][300].setPiece(new Queen(true, false, 0, 300));
        a[0][400].setText("\u265A");
        a[0][400].setPiece(new King(true, false, 0, 400));



    }

}


