public class King extends Piece {
    private String name;

    public King(boolean available, boolean isWhithe, int x, int y) {
        super(available, isWhithe, x, y);
        this.name = "king";
    }

    public static int[][] WMateChecker() {
        int[][] Bchecker = new int[800][800];

        for (int i = 0; i < 800; i += 100) {
            for (int j = 0; j < 800; j += 100) {
                if (Board.a[j][i].getPiece() != null && Board.a[j][i].getPiece().isWhite()) {
                    if (Board.a[j][i].getPiece().getName() == "pawn") {
                        if (i >= 100 && i <= 600 && j>=100 && j<=600) {
                            Bchecker[j - 100][i + 100]++;
                            Bchecker[j - 100][i - 100]++;

                        } else if (i == 0) {
                            Bchecker[j - 100][i + 100]++;
                        } else if (i == 700) {
                            Bchecker[j - 100][i - 100]++;
                            Bchecker[j][i]++;
                        }
                    } else if (Board.a[j][i].getPiece().getName() == "rock") {
                        for (int k = i; k < 800; k += 100) {
                            if (k != i && Board.a[j][k].getPiece() == null)
                                Bchecker[j][k]++;
                            else if (k != i && Board.a[j][k].getPiece() != null) {
                                Bchecker[j][k]++;
                                break;
                            }
                        }
                        for (int k = i; k >= 0; k -= 100) {
                            if (k != i && Board.a[j][k].getPiece() == null)
                                Bchecker[j][k]++;
                            else if (k != i && Board.a[j][k].getPiece() != null) {
                                Bchecker[j][k]++;
                                break;
                            }
                        }
                        for (int k = j; k < 800; k += 100) {
                            if (k != j && Board.a[k][i].getPiece() == null)
                                Bchecker[k][i]++;
                            else if (k != j && Board.a[k][i].getPiece() != null) {
                                Bchecker[k][i]++;
                                break;
                            }
                        }
                        for (int k = j; k >= 0; k -= 100) {
                            if (k != j && Board.a[k][i].getPiece() == null)
                                Bchecker[k][i]++;
                            else if (k != j && Board.a[k][i].getPiece() != null) {
                                Bchecker[k][i]++;
                                break;
                            }
                        }
                        Bchecker[j][i]++;

                    } else if (Board.a[j][i].getPiece().getName() == "bishop") {
                        outer:
                        for (int k = j; k >= 0; k -= 100) {
                            for (int l = i; l < 800; l += 100) {
                                if (k == j && l == i)
                                    continue;
                                if (k + l == i + j && Board.a[k][l].getPiece() == null)
                                    Bchecker[k][l]++;
                                else if (k + l == i + j && Board.a[k][l] != null) {
                                    Bchecker[k][l]++;
                                    break outer;
                                }
                            }
                        }
                        outer:
                        for (int k = j; k >= 0; k -= 100) {
                            for (int l = i; l >= 0; l -= 100) {
                                if (k == j && l == i)
                                    continue;
                                if (k - l == j - i && Board.a[k][l].getPiece() == null)
                                    Bchecker[k][l]++;
                                else if (k - l == j - i && Board.a[k][l] != null) {
                                    Bchecker[k][l]++;
                                    break outer;
                                }
                            }
                        }
                        outer:
                        for (int k = j; k <= 700; k += 100) {
                            for (int l = i; l >= 0; l -= 100) {
                                if (k == j && l == i)
                                    continue;
                                if (k + l == i + j && Board.a[k][l].getPiece() == null)
                                    Bchecker[k][l]++;
                                else if (k + l == i + j && Board.a[k][l] != null) {
                                    Bchecker[k][l]++;
                                    break outer;
                                }
                            }
                        }
                        outer:
                        for (int k = j; k < 800; k += 100) {
                            for (int l = i; l < 800; l += 100) {
                                if (k == j && l == i)
                                    continue;
                                if (k - l == j - i && Board.a[k][l].getPiece() == null)
                                    Bchecker[k][l]++;
                                else if (k - l == j - i && Board.a[k][l] != null) {
                                    Bchecker[k][l]++;
                                    break outer;
                                }
                            }
                        }
                        Bchecker[j][i]++;
                    } else if (Board.a[j][i].getPiece().getName() == "queen") {
                        outer:
                        for (int k = j; k >= 0; k -= 100) {
                            for (int l = i; l < 800; l += 100) {
                                if (k == j && l == i)
                                    continue;
                                if (k + l == i + j && Board.a[k][l].getPiece() == null)
                                    Bchecker[k][l]++;
                                else if (k + l == i + j && Board.a[k][l] != null) {
                                    Bchecker[k][l]++;
                                    break outer;
                                }
                            }
                        }
                        outer:
                        for (int k = j; k >= 0; k -= 100) {
                            for (int l = i; l >= 0; l -= 100) {
                                if (k == j && l == i)
                                    continue;
                                if (k - l == j - i && Board.a[k][l].getPiece() == null)
                                    Bchecker[k][l]++;
                                else if (k - l == j - i && Board.a[k][l] != null) {
                                    Bchecker[k][l]++;
                                    break outer;
                                }
                            }
                        }
                        outer:
                        for (int k = j; k <= 700; k += 100) {
                            for (int l = i; l >= 0; l -= 100) {
                                if (k == j && l == i)
                                    continue;
                                if (k + l == i + j && Board.a[k][l].getPiece() == null)
                                    Bchecker[k][l]++;
                                else if (k + l == i + j && Board.a[k][l] != null) {
                                    Bchecker[k][l]++;
                                    break outer;
                                }
                            }
                        }
                        outer:
                        for (int k = j; k < 800; k += 100) {
                            for (int l = i; l < 800; l += 100) {
                                if (k == j && l == i)
                                    continue;
                                if (k - l == j - i && Board.a[k][l].getPiece() == null)
                                    Bchecker[k][l]++;
                                else if (k - l == j - i && Board.a[k][l] != null) {
                                    Bchecker[k][l]++;
                                    break outer;
                                }
                            }
                        }

                        for (int k = i; k < 800; k += 100) {
                            if (k != i && Board.a[j][k].getPiece() == null)
                                Bchecker[j][k]++;
                            else if (k != i && Board.a[j][k].getPiece() != null) {
                                Bchecker[j][k]++;
                                break;
                            }
                        }
                        for (int k = i; k >= 0; k -= 100) {
                            if (k != i && Board.a[j][k].getPiece() == null)
                                Bchecker[j][k]++;
                            else if (k != i && Board.a[j][k].getPiece() != null) {
                                Bchecker[j][k]++;
                                break;
                            }
                        }
                        for (int k = j; k < 800; k += 100) {
                            if (k != j && Board.a[k][i].getPiece() == null)
                                Bchecker[k][i]++;
                            else if (k != j && Board.a[k][i].getPiece() != null) {
                                Bchecker[k][i]++;
                                break;
                            }
                        }
                        for (int k = j; k >= 0; k -= 100) {
                            if (k != j && Board.a[k][i].getPiece() == null)
                                Bchecker[k][i]++;
                            else if (k != j && Board.a[k][i].getPiece() != null) {
                                Bchecker[k][i]++;
                                break;
                            }
                        }
                        Bchecker[j][i]++;

                    } else if (Board.a[j][i].getPiece().getName() == "king") {
                        for (int k = 0; k < 800; k += 100) {
                            for (int l = 0; l < 800; l += 100) {
                                if ((k == j && l == i))
                                    continue;
                                if (Math.abs(k - j) <= 100 && Math.abs(l - i) <= 100) {
                                    Bchecker[k][l]++;
                                }
                            }

                        }
                        Bchecker[j][i]++;


                    } else if (Board.a[j][i].getPiece().getName() == "knight") {
                        for (int k = 0; k < 800; k += 100) {
                            for (int l = 0; l < 800; l += 100) {
                                if (Math.abs(k - j) == 200 && Math.abs(l - i) == 100) {
                                    Bchecker[k][l]++;
                                }
                                if (Math.abs(k - j) == 100 && Math.abs(l - i) == 200) {
                                    Bchecker[k][l]++;
                                }
                            }
                        }
                    }
                }
            }
        }



        return Bchecker;
    }


    public static int[][] BMateChecker() {
        int[][] Wchecker = new int[800][800];
        for (int i = 0; i < 800; i += 100) {
            for (int j = 0; j < 800; j += 100) {
                if (Board.a[j][i].getPiece() != null && Board.a[j][i].getPiece().isWhite() == false) {
                    if (Board.a[j][i].getPiece().getName() == "pawn") {
                        if (i >= 100 && i <= 600) {
                            Wchecker[j + 100][i + 100]++;
                            Wchecker[j + 100][i - 100]++;

                        } else if (i == 0) {
                            Wchecker[j + 100][i + 100]++;
                        } else if (i == 700) {
                            Wchecker[j + 100][i - 100]++;
                        }
                    } else if (Board.a[j][i].getPiece().getName() == "rock") {
                        for (int k = i; k < 800; k += 100) {
                            if (k != i && Board.a[j][k].getPiece() == null)
                                Wchecker[j][k]++;
                            else if (k != i && Board.a[j][k].getPiece() != null) {
                                Wchecker[j][k]++;
                                break;
                            }
                        }
                        for (int k = i; k >= 0; k -= 100) {
                            if (k != i && Board.a[j][k].getPiece() == null)
                                Wchecker[j][k]++;
                            else if (k != i && Board.a[j][k].getPiece() != null) {
                                Wchecker[j][k]++;
                                break;
                            }
                        }
                        for (int k = j; k < 800; k += 100) {
                            if (k != j && Board.a[k][i].getPiece() == null)
                                Wchecker[k][i]++;
                            else if (k != j && Board.a[k][i].getPiece() != null) {
                                Wchecker[k][i]++;
                                break;
                            }
                        }
                        for (int k = j; k >= 0; k -= 100) {
                            if (k != j && Board.a[k][i].getPiece() == null)
                                Wchecker[k][i]++;
                            else if (k != j && Board.a[k][i].getPiece() != null) {
                                Wchecker[k][i]++;
                                break;
                            }
                        }
                        Wchecker[j][i]++;

                    } else if (Board.a[j][i].getPiece().getName() == "bishop") {
                        outer:
                        for (int k = j; k >= 0; k -= 100) {
                            for (int l = i; l < 800; l += 100) {
                                if (k == j && l == i)
                                    continue;
                                if (k + l == i + j && Board.a[k][l].getPiece() == null)
                                    Wchecker[k][l]++;
                                else if (k + l == i + j && Board.a[k][l] != null) {
                                    Wchecker[k][l]++;
                                    break outer;
                                }
                            }
                        }
                        outer:
                        for (int k = j; k >= 0; k -= 100) {
                            for (int l = i; l >= 0; l -= 100) {
                                if (k == j && l == i)
                                    continue;
                                if (k - l == j - i && Board.a[k][l].getPiece() == null)
                                    Wchecker[k][l]++;
                                else if (k - l == j - i && Board.a[k][l] != null) {
                                    Wchecker[k][l]++;
                                    break outer;
                                }
                            }
                        }
                        outer:
                        for (int k = j; k <= 700; k += 100) {
                            for (int l = i; l >= 0; l -= 100) {
                                if (k == j && l == i)
                                    continue;
                                if (k + l == i + j && Board.a[k][l].getPiece() == null)
                                    Wchecker[k][l]++;
                                else if (k + l == i + j && Board.a[k][l] != null) {
                                    Wchecker[k][l]++;
                                    break outer;
                                }
                            }
                        }
                        outer:
                        for (int k = j; k < 800; k += 100) {
                            for (int l = i; l < 800; l += 100) {
                                if (k == j && l == i)
                                    continue;
                                if (k - l == j - i && Board.a[k][l].getPiece() == null)
                                    Wchecker[k][l]++;
                                else if (k - l == j - i && Board.a[k][l] != null) {
                                    Wchecker[k][l]++;
                                    break outer;
                                }
                            }
                        }
                        Wchecker[j][i]++;
                    } else if (Board.a[j][i].getPiece().getName() == "queen") {
                        outer:
                        for (int k = j; k >= 0; k -= 100) {
                            for (int l = i; l < 800; l += 100) {
                                if (k == j && l == i)
                                    continue;
                                if (k + l == i + j && Board.a[k][l].getPiece() == null)
                                    Wchecker[k][l]++;
                                else if (k + l == i + j && Board.a[k][l] != null) {
                                    Wchecker[k][l]++;
                                    break outer;
                                }
                            }
                        }
                        outer:
                        for (int k = j; k >= 0; k -= 100) {
                            for (int l = i; l >= 0; l -= 100) {
                                if (k == j && l == i)
                                    continue;
                                if (k - l == j - i && Board.a[k][l].getPiece() == null)
                                    Wchecker[k][l]++;
                                else if (k - l == j - i && Board.a[k][l] != null) {
                                    Wchecker[k][l]++;
                                    break outer;
                                }
                            }
                        }
                        outer:
                        for (int k = j; k <= 700; k += 100) {
                            for (int l = i; l >= 0; l -= 100) {
                                if (k == j && l == i)
                                    continue;
                                if (k + l == i + j && Board.a[k][l].getPiece() == null)
                                    Wchecker[k][l]++;
                                else if (k + l == i + j && Board.a[k][l] != null) {
                                    Wchecker[k][l]++;
                                    break outer;
                                }
                            }
                        }
                        outer:
                        for (int k = j; k < 800; k += 100) {
                            for (int l = i; l < 800; l += 100) {
                                if (k == j && l == i)
                                    continue;
                                if (k - l == j - i && Board.a[k][l].getPiece() == null)
                                    Wchecker[k][l]++;
                                else if (k - l == j - i && Board.a[k][l] != null) {
                                    Wchecker[k][l]++;
                                    break outer;
                                }
                            }
                        }

                        for (int k = i; k < 800; k += 100) {
                            if (k != i && Board.a[j][k].getPiece() == null)
                                Wchecker[j][k]++;
                            else if (k != i && Board.a[j][k].getPiece() != null) {
                                Wchecker[j][k]++;
                                break;
                            }
                        }
                        for (int k = i; k >= 0; k -= 100) {
                            if (k != i && Board.a[j][k].getPiece() == null)
                                Wchecker[j][k]++;
                            else if (k != i && Board.a[j][k].getPiece() != null) {
                                Wchecker[j][k]++;
                                break;
                            }
                        }
                        for (int k = j; k < 800; k += 100) {
                            if (k != j && Board.a[k][i].getPiece() == null)
                                Wchecker[k][i]++;
                            else if (k != j && Board.a[k][i].getPiece() != null) {
                                Wchecker[k][i]++;
                                break;
                            }
                        }
                        for (int k = j; k >= 0; k -= 100) {
                            if (k != j && Board.a[k][i].getPiece() == null)
                                Wchecker[k][i]++;
                            else if (k != j && Board.a[k][i].getPiece() != null) {
                                Wchecker[k][i]++;
                                break;
                            }
                        }
                        Wchecker[j][i]++;

                    } else if (Board.a[j][i].getPiece().getName() == "king") {

                        for (int k = 0; k < 800; k += 100) {
                            for (int l = 0; l < 800; l += 100) {
                                if ((k == j && l == i))
                                    continue;
                                if (Math.abs(k - j) <= 100 && Math.abs(l - i) <= 100) {
                                    Wchecker[k][l]++;
                                }
                            }

                        }
//
                        Wchecker[j][i]++;


                    } else if (Board.a[j][i].getPiece().getName() == "knight") {
                        for (int k = 0; k < 800; k += 100) {
                            for (int l = 0; l < 800; l += 100) {
                                if ((k - j == 200 || k - j == -200) && (l - i == 100 || l - i == -100)) {
                                    Wchecker[k][l]++;
                                }
                                if ((k - j == 100 || k - j == -100) && (l - i == 200 || l - i == -200)) {
                                    Wchecker[k][l]++;
                                }
                            }
                        }
                    }
                }
            }
        }
//
        return Wchecker;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean ValidMove(Spot[][] primary, Spot start, Spot end) {

        if (start.getPiece().isWhite() && start.getY() == 700 && start.getX() == 400) {

            if (end.getX() == 600 && end.getY() == 700 && start.getPiece().getCntMove() == 0 && Board.a[700][700].getPiece() != null && Board.a[700][700].getPiece().getName() == "rock" && Board.a[700][700].getPiece().getCntMove() == 0) {
                if (Board.a[700][500].getPiece()!=null || Board.a[700][600].getPiece()!=null)
                    return false;
                Board.Casteling=true;
                return true;
            }
            if (end.getX() == 200 && end.getY() == 700 && start.getPiece().getCntMove() == 0 && Board.a[700][0].getPiece() != null && Board.a[700][0].getPiece().getName() == "rock" && Board.a[700][0].getPiece().getCntMove() == 0) {

                if (Board.a[700][300].getPiece()!=null || Board.a[700][200].getPiece()!=null || Board.a[700][100].getPiece()!=null)
                    return false;
                Board.Casteling=true;
                return true;
            }
        }
        if (start.getPiece().isWhite() == false && start.getY() == 0 && start.getX() == 400) {

            if (end.getX() == 600 && end.getY() == 0 && start.getPiece().getCntMove() == 0 && Board.a[0][700].getPiece() != null && Board.a[0][700].getPiece().getName() == "rock" && Board.a[0][700].getPiece().getCntMove() == 0) {
                if (Board.a[0][500].getPiece()!=null || Board.a[0][600].getPiece()!=null)
                    return false;
                Board.Casteling=true;
                return true;
            }
            if (end.getX() == 200 && end.getY() == 0 && start.getPiece().getCntMove() == 0 && Board.a[0][0].getPiece() != null && Board.a[0][0].getPiece().getName() == "rock" && Board.a[0][0].getPiece().getCntMove() == 0) {
                if (Board.a[0][300].getPiece()!=null || Board.a[0][200].getPiece()!=null || Board.a[0][100].getPiece()!=null)
                    return false;
                Board.Casteling=true;
                return true;
            }

        }


        if (super.ValidMove(primary, start, end) == false) {
            return false;
        }

        if (super.isWhite() && end.getY() - start.getY() == 200 && end.getX() - start.getX() == 200)
            return true;
        if (super.isWhite() && end.getY() - start.getY() == 200 && end.getX() - start.getX() == 0)
            return true;
        if (super.isWhite() && end.getY() - start.getY() == 200 && end.getX() - start.getX() == -200)
            return true;
        if (super.isWhite() == false && end.getY() - start.getY() == -200 && end.getX() - start.getX() == 200)
            return true;
        if (super.isWhite() == false && end.getY() - start.getY() == -200 && end.getX() - start.getX() == 0)
            return true;
        if (super.isWhite() == false && end.getY() - start.getY() == -200 && end.getX() - start.getX() == -200)
            return true;

        if ((Math.abs(start.getX() - end.getX()) <= 100) && (Math.abs(start.getY() - end.getY()) <= 100))
            return true;
        return false;
    }
}
