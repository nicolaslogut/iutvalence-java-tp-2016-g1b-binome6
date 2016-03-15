package fr.iutvalence.logutamilhaud.battleship;

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
public class Board {
    /** TODO. */
    public char[][] grid;

    // TODO WARNING! You use a lot of "magic" constants

    /** TODO. */
    public Board() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = 'v';
            }
        }
    }

    // TODO This algorithm is buggy
    // TODO It's too early for this kind of implementation

    /**
     * TODO.
     *
     * @param ship        TODO
     * @param x           TODO
     * @param y           TODO
     * @param orientation TODO
     *
     * @return TODO
     */
    public boolean putABoat(Boat ship, int x, int y, char orientation) {

        if (grid[x][y] != 'v') {
            return false;
        }

        int i;
        // TODO Why don't you use switch?
        // TODO Why don't use an "enum" for orientation rather than a char?
        // TODO You can factorize these cases (I think)
        if (orientation == 'r') {
            for (i = x; i < (ship.size + x); i++) {
                if (grid[i][y] == 'v') {
                    for (i = x; i < (ship.size + x); i++) {
                        grid[i][y] = ship.id;
                    }
                }
                else {
                    return false;
                }
            }
        }
        if (orientation == 'b') {
            for (i = y; i < (ship.size - y); i--) {
                if (grid[x][i] == 'v') {
                    for (i = y; i < (ship.size - y); i--) {
                        grid[x][i] = ship.id;
                    }
                }
                else {
                    return false;
                }
            }
        }
        if (orientation == 'l') {
            for (i = x; i < (ship.size - x); i--) {
                if (grid[i][y] == 'v') {
                    for (i = x; i < (ship.size - x); i--) {
                        grid[i][y] = ship.id;
                    }
                }
                else {
                    return false;
                }
            }
        }
        if (orientation == 't') {
            for (i = x; i < (ship.size + x); i++) {
                if (grid[x][i] == 'v') {
                    for (i = x; i < (ship.size + x); i++) {
                        grid[x][i] = ship.id;
                    }
                }
                else {
                    return false;
                }
            }
        }

        return false;
    }
}
