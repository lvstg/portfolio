package g61305.othello.model;

/**
 * Show the eight possible directions for moving around the board.
 */
enum Direction {
    UP(-1, 0),

    DOWN(1, 0),
    RIGHT(0, 1),

    LEFT(0, -1),

    UP_RIGHT(-1, 1),

    UP_LEFT(-1, -1),

    DOWN_RIGHT(1, 1),

    DOWN_LEFT(1, -1);

    private int x;
    private final int y;

    private int value;

    private int oldSize;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
        this.value = 0;
        this.oldSize = 1;

    }

    int getValue() {
        return value;
    }

    /**
     * Updates the value of X in relation to the size of the table for directions where necessary.
     * @param size is the size of the table used to update the directions.
     */
    void setX(int size) {
        if (this != RIGHT && this != LEFT) {
            x = (x/oldSize)*size;
            setOldSize(size);
        }
    }
    void setValue() {
        value = x + y;
    }

    /**
     * Resets the value of x when a new table is created.
     * @param oldSize size of the old table.
     */
    private void setOldSize(int oldSize) {
        this.oldSize = oldSize;
    }
}
