package homework9;

public class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("Неравильный размер массива. Должен быть задан массив 4x4");
    }
}