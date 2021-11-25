package homework12;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        changeFirstArray();
        try {
            changeSecondArray();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static float[] calculateArray(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr;
    }

    private static void changeFirstArray() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        long startTime = System.currentTimeMillis();
        calculateArray(arr);
        System.out.println("Время выполнения первого метода: " + (System.currentTimeMillis() - startTime));
    }

    private static void changeSecondArray() throws InterruptedException {
        float[] arr = new float[SIZE];
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];

        Arrays.fill(arr, 1);
        long startTime = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);

        Thread t1 = new Thread(() -> {
            calculateArray(arr1);
//            System.arraycopy(arr1, 0, arr, 0, HALF);
        });

        Thread t2 = new Thread(() -> {
            calculateArray(arr2);
//            System.arraycopy(arr2, 0, arr, HALF, HALF);
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);

        System.out.println("Время выполнения второго метода: " + (System.currentTimeMillis() - startTime));
    }
}
