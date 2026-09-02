package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 * Test various aspects of board.
 */
class BoardTest {

    private final Square[][] grid = {{ new BasicSquare() }};
    private final Board board = new Board(grid);

    /**
     * Verifies the board dimensions and square.
     */
    @Test
    void verifyBoard() {
        assertThat(board.getWidth()).isEqualTo(1);
        assertThat(board.getHeight()).isEqualTo(1);
        assertThat(board.squareAt(0, 0)).isSameAs(grid[0][0]);
    }

    /**
     * Verifies that a board with a null square cannot be constructed.
     */
    @Test
    void squareAtWithNullSquare() {
        Square[][] invalidGrid = {{ null }};

        AssertionError exception = assertThrows(AssertionError.class, () -> {
            Board invalidBoard = new Board(invalidGrid);
            invalidBoard.squareAt(0, 0);
        });
        assertThat(exception).isInstanceOf(AssertionError.class);
    }
}