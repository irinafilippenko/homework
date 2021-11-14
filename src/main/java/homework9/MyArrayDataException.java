package homework9;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int row, int col) {
        super("Неверные данные лежат в ячейке массива [" + row + "][" + col + "]");
    }
}
