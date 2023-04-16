package vitaliy.grab.supertelport;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * @author Oywayten 09.04.2023
 */
class PortTest {

    @Test
    public void whenArraysIs135234ThenStringArrToIntArrThenSuccessfully() {
        String[] indexes = {"1,3-5", "2", "3-4"};
        Port port = new Port(indexes);
        int[][] actual = port.stringArrToIntArr();
        int[][] expected = {{1, 3, 4, 5}, {2}, {3, 4}};
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenNumberMultipleDigits() {
        String[] indexes = {"1,3-5", "2", "3-4", "233"};
        Port port = new Port(indexes);
        int[][] actual = port.stringArrToIntArr();
        int[][] expected = {{1, 3, 4, 5}, {2}, {3, 4}, {233}};
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenArraysIs135234ThenMultiplyArraysThenSuccessfully() {
        String[] indexes = {"1,3-5", "2", "3-4"};
        Port port = new Port(indexes);
        int[][] actual = port.multiplyArrays();
        int[][] expected = {{1, 2, 3}, {1, 2, 4}, {3, 2, 3}, {3, 2, 4}, {4, 2, 3}, {4, 2, 4}, {5, 2, 3}, {5, 2, 4}};
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenIndexesWithEmptyStringThenException() {
        String[] indexes = {"1,3-5", "", "3-4"};
        Port port = new Port(indexes);
        assertThatIllegalArgumentException().isThrownBy(port::multiplyArrays).withMessage("An empty array specified!");
    }

    @Test
    public void whenIndexesIsNullThenException() {
        Port port = new Port(null);
        assertThatIllegalArgumentException().isThrownBy(port::multiplyArrays).withMessage("null is an invalid value!");
    }

    @Test
    public void whenArrCellIsNullThenException() {
        String[] indexes = {"1,3-5", "2", null};
        Port port = new Port(indexes);
        assertThatIllegalArgumentException().isThrownBy(port::multiplyArrays).withMessage("null is an invalid value!");
    }

    @Test
    public void whenArrayIsEmptyThenSuccessfully() {
        String[] indexes = {};
        Port port = new Port(indexes);
        int[][] actual = port.multiplyArrays();
        int[][] expected = {{}};
        assertThat(actual).isEqualTo(expected);
    }
}