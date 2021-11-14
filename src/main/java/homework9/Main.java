package homework9;

public class Main {
    public static void main(String[] args) {
        String[][] array1 = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        String[][] array2 = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15"}};
        String[][] array3 = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "ten", "11", "12"}, {"13", "14", "15", "16"}};

        try {
            Main.transformSum(array2);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static void transformSum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        if (array.length != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println(sum);
    }
}
