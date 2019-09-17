package br.com.sevinhu.projetomaker.led.letter;

import java.util.ArrayList;
import java.util.List;

import br.com.sevinhu.projetomaker.util.RelativePoint;

public class LedLetter {
    private Letter letter;

    public LedLetter(Letter letter) {
        this.letter = letter;
    }

    public RelativePoint get(int x, int y) {
        return new RelativePoint(x, y);
    }

    private List<RelativePoint> getAsPixelRelativeCord() {
        List<RelativePoint> r = new ArrayList<>();

        switch (letter) {
            // LINHA | COLUNA
            case POINT: {
                r.add(get(7, 1));
                break;
            }
            case HYPHEN: {
                r.add(get(2, 1));
                r.add(get(2, 2));
                break;
            }
            case ORDINAL: {
                r.add(get(2, 2));

                r.add(get(3, 1));
                r.add(get(3, 3));

                r.add(get(4, 2));
                break;
            }
            case DOTS: {
                r.add(get(5, 1));

                r.add(get(7, 1));
                break;
            }
            case EQUAL: {
                r.add(get(5, 1));
                r.add(get(5, 2));

                r.add(get(7, 1));
                r.add(get(7, 2));
                break;
            }
            case NUM_0: {
                r.add(get(2, 2));
                r.add(get(2, 3));

                r.add(get(3, 1));
                r.add(get(3, 4));

                r.add(get(4, 1));
                r.add(get(4, 3));
                r.add(get(4, 4));

                r.add(get(5, 1));
                r.add(get(5, 2));
                r.add(get(5, 4));

                r.add(get(6, 1));
                r.add(get(6, 4));

                r.add(get(7, 2));
                r.add(get(7, 3));
                break;
            }
            case NUM_1: {
                r.add(get(2, 3));

                r.add(get(3, 2));
                r.add(get(3, 3));

                r.add(get(4, 1));
                r.add(get(4, 3));

                r.add(get(5, 3));

                r.add(get(6, 3));

                r.add(get(7, 3));
                break;
            }
            case NUM_2: {
                r.add(get(2, 2));
                r.add(get(2, 3));

                r.add(get(3, 1));
                r.add(get(3, 4));

                r.add(get(4, 4));

                r.add(get(5, 2));
                r.add(get(5, 3));

                r.add(get(6, 1));

                r.add(get(7, 1));
                r.add(get(7, 2));
                r.add(get(7, 3));
                r.add(get(7, 4));
                break;
            }
            case NUM_3: {

                r.add(get(2, 2));
                r.add(get(2, 3));

                r.add(get(3, 1));
                r.add(get(3, 4));

                r.add(get(4, 4));

                r.add(get(5, 4));

                r.add(get(6, 1));
                r.add(get(6, 4));

                r.add(get(7, 2));
                r.add(get(7, 3));
                break;
            }
            case NUM_4: {
                r.add(get(2, 3));
                r.add(get(2, 4));

                r.add(get(3, 2));
                r.add(get(3, 4));

                r.add(get(4, 1));
                r.add(get(4, 4));

                r.add(get(5, 1));
                r.add(get(5, 2));
                r.add(get(5, 3));
                r.add(get(5, 4));

                r.add(get(6, 4));

                r.add(get(7, 4));

                break;
            }
            case NUM_5: {
                r.add(get(2, 2));
                r.add(get(2, 3));
                r.add(get(2, 4));

                r.add(get(3, 1));

                r.add(get(4, 1));
                r.add(get(4, 2));
                r.add(get(4, 3));

                r.add(get(5, 4));

                r.add(get(6, 1));
                r.add(get(6, 4));

                r.add(get(7, 2));
                r.add(get(7, 3));
                break;
            }
            case NUM_6: {
                r.add(get(2, 2));
                r.add(get(2, 3));

                r.add(get(3, 1));
                r.add(get(3, 4));

                r.add(get(4, 1));

                r.add(get(5, 1));
                r.add(get(5, 2));
                r.add(get(5, 3));

                r.add(get(6, 1));
                r.add(get(6, 4));

                r.add(get(7, 2));
                r.add(get(7, 3));
                break;
            }
            case NUM_7: {
                r.add(get(2, 1));
                r.add(get(2, 2));
                r.add(get(2, 3));

                r.add(get(3, 4));

                r.add(get(4, 3));

                r.add(get(5, 2));

                r.add(get(6, 1));

                r.add(get(7, 1));
                break;
            }
            case NUM_8: {
                r.add(get(2, 2));
                r.add(get(2, 3));

                r.add(get(3, 1));
                r.add(get(3, 4));

                r.add(get(4, 2));
                r.add(get(4, 3));

                r.add(get(5, 1));
                r.add(get(5, 4));

                r.add(get(6, 1));
                r.add(get(6, 4));

                r.add(get(7, 2));
                r.add(get(7, 3));
                break;
            }
            case NUM_9: {
                r.add(get(2, 2));
                r.add(get(2, 3));

                r.add(get(3, 1));
                r.add(get(3, 4));

                r.add(get(4, 2));
                r.add(get(4, 3));
                r.add(get(4, 4));

                r.add(get(5, 4));

                r.add(get(6, 1));
                r.add(get(6, 4));

                r.add(get(7, 2));
                r.add(get(7, 3));
                break;
            }

            case A: {
                r.add(get(2, 2));
                r.add(get(2, 3));

                r.add(get(3, 1));
                r.add(get(3, 4));

                r.add(get(4, 1));
                r.add(get(4, 4));

                r.add(get(5, 1));
                r.add(get(5, 2));
                r.add(get(5, 3));
                r.add(get(5, 4));

                r.add(get(6, 1));
                r.add(get(6, 4));

                r.add(get(7, 1));
                r.add(get(7, 4));
                break;
            }
            case B: {
                r.add(get(2, 1));
                r.add(get(2, 2));
                r.add(get(2, 3));

                r.add(get(3, 1));
                r.add(get(3, 4));

                r.add(get(4, 1));
                r.add(get(4, 2));
                r.add(get(4, 3));

                r.add(get(5, 1));
                r.add(get(5, 4));

                r.add(get(6, 1));
                r.add(get(6, 4));

                r.add(get(7, 1));
                r.add(get(7, 2));
                r.add(get(7, 3));
                break;
            }
            case C: {
                r.add(get(2, 2));
                r.add(get(2, 3));

                r.add(get(3, 1));
                r.add(get(3, 4));

                r.add(get(4, 1));

                r.add(get(5, 1));

                r.add(get(6, 1));
                r.add(get(6, 4));

                r.add(get(7, 2));
                r.add(get(7, 3));
                break;
            }
            case D: {
                r.add(get(2, 1));
                r.add(get(2, 2));
                r.add(get(2, 3));

                r.add(get(3, 1));
                r.add(get(3, 4));

                r.add(get(4, 4));
                r.add(get(4, 4));

                r.add(get(5, 1));
                r.add(get(5, 4));

                r.add(get(6, 1));
                r.add(get(6, 4));

                r.add(get(7, 1));
                r.add(get(7, 2));
                r.add(get(7, 3));
                break;
            }
            case E: {
                r.add(get(2, 1));
                r.add(get(2, 2));
                r.add(get(2, 3));
                r.add(get(2, 4));

                r.add(get(3, 1));

                r.add(get(4, 1));
                r.add(get(4, 2));
                r.add(get(4, 3));

                r.add(get(5, 1));

                r.add(get(6, 1));

                r.add(get(7, 1));
                r.add(get(7, 2));
                r.add(get(7, 3));
                r.add(get(7, 4));
                break;
            }
            case F: {
                r.add(get(2, 1));
                r.add(get(2, 2));
                r.add(get(2, 3));
                r.add(get(2, 4));

                r.add(get(3, 1));

                r.add(get(4, 1));
                r.add(get(4, 2));
                r.add(get(4, 3));

                r.add(get(5, 1));

                r.add(get(6, 1));

                r.add(get(7, 1));
                break;
            }
            case G: {

                r.add(get(2, 2));
                r.add(get(2, 3));

                r.add(get(3, 1));
                r.add(get(3, 4));

                r.add(get(4, 1));

                r.add(get(5, 1));
                r.add(get(5, 3));
                r.add(get(5, 4));

                r.add(get(6, 1));
                r.add(get(6, 4));

                r.add(get(7, 2));
                r.add(get(7, 3));
                break;
            }
            case H: {

                r.add(get(2, 1));
                r.add(get(2, 4));

                r.add(get(3, 1));
                r.add(get(3, 4));

                r.add(get(4, 1));
                r.add(get(4, 2));
                r.add(get(4, 3));
                r.add(get(4, 4));

                r.add(get(5, 1));
                r.add(get(5, 4));

                r.add(get(6, 1));
                r.add(get(6, 4));

                r.add(get(7, 1));
                r.add(get(7, 4));
                break;
            }
            case I: {

                r.add(get(2, 1));
                r.add(get(2, 2));
                r.add(get(2, 3));

                r.add(get(2, 2));

                r.add(get(4, 2));

                r.add(get(5, 2));

                r.add(get(6, 2));

                r.add(get(7, 1));
                r.add(get(7, 2));
                r.add(get(7, 3));
                break;
            }
            case J: {
                r.add(get(2, 4));

                r.add(get(3, 4));

                r.add(get(4, 4));

                r.add(get(5, 1));
                r.add(get(5, 4));

                r.add(get(6, 1));
                r.add(get(6, 4));

                r.add(get(7, 2));
                r.add(get(7, 3));
                break;
            }
            case K: {
                r.add(get(2, 1));
                r.add(get(2, 4));

                r.add(get(3, 1));
                r.add(get(3, 3));

                r.add(get(4, 1));
                r.add(get(4, 2));

                r.add(get(5, 1));
                r.add(get(5, 3));

                r.add(get(6, 1));
                r.add(get(6, 4));

                r.add(get(7, 1));
                r.add(get(7, 4));
                break;
            }
            case L: {
                r.add(get(2, 1));

                r.add(get(3, 1));

                r.add(get(4, 1));

                r.add(get(5, 1));

                r.add(get(6, 1));

                r.add(get(7, 1));
                r.add(get(7, 2));
                r.add(get(7, 3));
                r.add(get(7, 4));
                break;
            }
            case M: {
                r.add(get(2, 1));
                r.add(get(2, 5));

                r.add(get(3, 1));
                r.add(get(3, 2));
                r.add(get(3, 4));
                r.add(get(3, 5));

                r.add(get(4, 1));
                r.add(get(4, 3));
                r.add(get(4, 5));

                r.add(get(5, 1));
                r.add(get(2, 5));

                r.add(get(6, 1));
                r.add(get(6, 5));

                r.add(get(7, 1));
                r.add(get(7, 5));
                break;
            }
            case N: {
                r.add(get(2, 1));
                r.add(get(2, 4));

                r.add(get(3, 1));
                r.add(get(3, 4));

                r.add(get(4, 1));
                r.add(get(4, 2));
                r.add(get(4, 4));

                r.add(get(5, 1));
                r.add(get(5, 3));
                r.add(get(5, 4));

                r.add(get(6, 1));
                r.add(get(5, 4));

                r.add(get(7, 1));
                r.add(get(7, 4));
                break;
            }
            case O: {
                r.add(get(2, 2));
                r.add(get(2, 3));

                r.add(get(3, 1));
                r.add(get(3, 4));

                r.add(get(4, 1));
                r.add(get(4, 4));

                r.add(get(5, 1));
                r.add(get(5, 4));

                r.add(get(6, 1));
                r.add(get(6, 4));

                r.add(get(7, 2));
                r.add(get(7, 3));
                break;
            }
            case P: {
                r.add(get(2, 1));
                r.add(get(2, 2));
                r.add(get(2, 3));

                r.add(get(3, 1));
                r.add(get(3, 4));

                r.add(get(4, 1));
                r.add(get(4, 4));

                r.add(get(5, 1));
                r.add(get(5, 2));
                r.add(get(5, 3));

                r.add(get(6, 1));

                r.add(get(7, 1));
                break;
            }
            case Q: {
                r.add(get(2, 2));
                r.add(get(2, 3));

                r.add(get(3, 1));
                r.add(get(3, 4));

                r.add(get(4, 1));
                r.add(get(4, 4));

                r.add(get(5, 1));
                r.add(get(5, 4));

                r.add(get(6, 1));
                r.add(get(6, 4));

                r.add(get(7, 2));
                r.add(get(7, 3));
                r.add(get(7, 4));
                r.add(get(7, 5));
                break;
            }
            case R: {
                r.add(get(2, 1));
                r.add(get(2, 2));
                r.add(get(2, 3));

                r.add(get(3, 1));
                r.add(get(3, 4));

                r.add(get(4, 1));
                r.add(get(4, 4));

                r.add(get(5, 1));
                r.add(get(5, 2));
                r.add(get(5, 3));

                r.add(get(6, 1));
                r.add(get(6, 4));

                r.add(get(7, 1));
                r.add(get(7, 4));
                break;
            }
            case S: {

                r.add(get(2, 2));
                r.add(get(2, 3));

                r.add(get(3, 1));
                r.add(get(3, 4));

                r.add(get(4, 2));

                r.add(get(5, 3));

                r.add(get(6, 1));
                r.add(get(6, 4));

                r.add(get(7, 2));
                r.add(get(7, 3));
                break;
            }
            case T: {
                r.add(get(2, 1));
                r.add(get(2, 2));
                r.add(get(2, 3));
                r.add(get(2, 4));
                r.add(get(2, 5));

                r.add(get(3, 3));

                r.add(get(4, 3));

                r.add(get(5, 3));

                r.add(get(6, 3));

                r.add(get(7, 3));
                break;
            }
            case U: {
                r.add(get(2, 1));
                r.add(get(2, 4));

                r.add(get(3, 1));
                r.add(get(3, 4));

                r.add(get(4, 1));
                r.add(get(4, 4));

                r.add(get(5, 1));
                r.add(get(5, 4));

                r.add(get(6, 1));
                r.add(get(6, 4));

                r.add(get(7, 1));
                r.add(get(7, 2));
                r.add(get(7, 3));
                r.add(get(7, 4));
                break;
            }
            case V: {
                r.add(get(2, 1));
                r.add(get(2, 4));

                r.add(get(3, 1));
                r.add(get(3, 4));

                r.add(get(4, 1));
                r.add(get(4, 4));

                r.add(get(5, 1));
                r.add(get(5, 4));

                r.add(get(6, 1));
                r.add(get(6, 4));

                r.add(get(7, 2));
                r.add(get(7, 3));
                break;
            }
            case W: {
                r.add(get(2, 1));
                r.add(get(2, 5));

                r.add(get(3, 1));
                r.add(get(3, 5));

                r.add(get(4, 1));
                r.add(get(4, 5));

                r.add(get(5, 1));
                r.add(get(5, 3));
                r.add(get(5, 5));

                r.add(get(6, 1));
                r.add(get(6, 3));
                r.add(get(6, 5));

                r.add(get(7, 2));
                r.add(get(7, 4));
                break;
            }
            case X: {
                r.add(get(2, 1));
                r.add(get(2, 4));

                r.add(get(3, 1));
                r.add(get(3, 4));

                r.add(get(4, 2));
                r.add(get(4, 3));

                r.add(get(5, 1));
                r.add(get(5, 4));

                r.add(get(6, 1));
                r.add(get(6, 4));

                r.add(get(7, 1));
                r.add(get(7, 4));
                break;
            }
            case Y: {
                r.add(get(2, 1));
                r.add(get(2, 5));

                r.add(get(3, 1));
                r.add(get(3, 5));

                r.add(get(4, 2));
                r.add(get(4, 4));

                r.add(get(5, 3));

                r.add(get(6, 3));

                r.add(get(7, 3));
                break;
            }
            case Z: {
                r.add(get(2, 1));
                r.add(get(2, 2));
                r.add(get(2, 3));
                r.add(get(2, 4));

                r.add(get(3, 4));

                r.add(get(4, 3));

                r.add(get(5, 2));

                r.add(get(6, 1));

                r.add(get(7, 1));
                r.add(get(7, 2));
                r.add(get(7, 3));
                r.add(get(7, 4));
                break;
            }
        }


        return r;
    }
}
