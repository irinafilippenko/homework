package homework4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final int SIZE = 6;
    private static final char DOT_EMPTY = '∙';
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';

    private static final String SPACE_MAP = " ";
    private static final String HEADER_FIRST_MAP = "♦";

    private static final char[][] MAP = new char[SIZE][SIZE];
    private static final Scanner in = new Scanner(System.in);
    private static final Random random = new Random();

    private static int turnsCount;
    private static int lastRowTurn;
    private static int lastColumnTurn;
    private static int count;
    private static int countWinSymbols;

    public static void main(String[] args) {
        turnGame();
    }

    public static void turnGame() {
        do {
            System.out.println("\nИгра начинается.");
            init();
            printMap();
            playGame();
        } while (isContinueGame());
        endGame();
    }

    private static void init() {
        initMap();
        turnsCount = 0;
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printHeaderMap();
        printBodyMap();
    }

    private static void printHeaderMap() {
        System.out.print(HEADER_FIRST_MAP + SPACE_MAP);
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }

    private static void printMapNumber(int i){
        System.out.print(i + 1 + SPACE_MAP);
    }

    private static void printBodyMap() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + SPACE_MAP);
            }
            System.out.println();
        }
    }

    private static void playGame() {
        while (true) {
            turnHuman();
            printMap();
            if (checkEnd(DOT_HUMAN)) {
                break;
            }

            turnAI();
            printMap();
            if (checkEnd(DOT_AI)) {
                break;
            }
        }
    }

    private static void turnHuman() {
        System.out.println("Ход человека");
        int rowNumber, columnNumber;

        while (true) {
            rowNumber = getValidNumberFromUser() - 1;
            columnNumber = getValidNumberFromUser() - 1;
            if (isCellFree(rowNumber, columnNumber)) {
                break;
            } else {
                System.out.println("\nВы выбрали занятую ячейку.");
            }
        }

        MAP[rowNumber][columnNumber] = DOT_HUMAN;
        lastRowTurn = rowNumber;
        lastColumnTurn = columnNumber;
        turnsCount++;
    }

    private static int getValidNumberFromUser() {
        while (true) {
            System.out.print("Введите координату (1-" + SIZE + "): ");
            if (in.hasNextInt()) {
                int n = in.nextInt();
                if (isNumberValid(n)) {
                    return n;
                } else {
                    System.out.println("\nПроверьте значение координаты. Должно былть от 1 до " + SIZE);
                }
            } else {
                in.next();
                System.out.println("\nВвод допускает лишь целые числа.");
            }
        }
    }

    private static boolean isNumberValid(int n) {
        return n >= 1 && n <= SIZE;
    }

    private static boolean isCellFree(int rowNumber, int columnNumber) {
        return MAP[rowNumber][columnNumber] == DOT_EMPTY;
    }

    private static boolean checkEnd(char symbol) {
        if (checkWin(symbol)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("\nВы победили!");
            } else {
                System.out.println("\nКомпьютер победил.");
            }
            return true;
        }
        if (checkDraw()) {
            System.out.println("\nНичья!");
            return true;
        }
        return false;
    }

    private static boolean checkWin(char symbol) {
        if (SIZE >= 3 && SIZE <= 5) {
            countWinSymbols = 3;
        } else if (SIZE >= 6 && SIZE <= 10) {
            countWinSymbols = 4;
        } else {
            countWinSymbols = 5;
        }
        if (checkWinLineX(symbol)) return true;
        if (checkWinLineY(symbol)) return true;
        if (!(lastRowTurn == 0 && lastColumnTurn == 0 || lastRowTurn == (SIZE - 1) && lastColumnTurn == (SIZE - 1))) {
            if (checkWinDiagonal1(symbol)) return true;
        }
        if (!(lastRowTurn == (SIZE - 1) && lastColumnTurn == 0 || lastRowTurn == 0 && lastColumnTurn == (SIZE - 1))) {
            if (checkWinDiagonal2(symbol)) return true;
        }
        return false;
    }

    private static boolean checkWinLineX(char symbol) {
        count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (MAP[lastRowTurn][i] == symbol) {
                if (++count == countWinSymbols) {
                    break;
                }
            } else {
                count = 0;
            }
        }
        return (count == countWinSymbols);
    }

    private static boolean checkWinLineY(char symbol) {
        count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (MAP[i][lastColumnTurn] == symbol) {
                if (++count == countWinSymbols) {
                    break;
                }
            } else {
                count = 0;
            }
        }
        return (count == countWinSymbols);
    }

    private static boolean checkWinDiagonal1(char symbol) {
        int amount, startX, startY, finX, finY, i, j;
        amount = lastRowTurn + lastColumnTurn;
        count = 0;
        startX = (amount < SIZE) ? 0 : (amount - (SIZE - 1));
        startY = (amount < SIZE) ? amount : (SIZE - 1);
        finX = startY;
        finY = startX;
        i = startX;
        j = startY;
        while (i < (finX + 1) && j > (finY - 1)) {
            if (MAP[i][j] == symbol) {
                if (++count == countWinSymbols) {
                    break;
                }
            } else {
                count = 0;
            }
            i++;
            j--;
        }
        return (count == countWinSymbols);
    }

    private static boolean checkWinDiagonal2(char symbol) {
        int dif, startX, startY, finX, finY, i, j;
        dif = lastRowTurn - lastColumnTurn;
        count = 0;
        startX = (dif > 0) ? dif : 0;
        startY = (dif > 0) ? 0 : -dif;
        finX = SIZE - 1 - startY;
        finY = SIZE - 1 - startX;
        i = startX;
        j = startY;
        while (i < (finX + 1) && j < (finY + 1)) {
            if (MAP[i][j] == symbol) {
                if (++count == countWinSymbols) {
                    break;
                }
            } else {
                count = 0;
            }
            i++;
            j++;
        }
        return (count == countWinSymbols);
    }

    private static boolean checkDraw() {
        return turnsCount >= SIZE * SIZE;
    }

    private static void turnAI() {
        System.out.println("Ход компьютера");
        int rowNumber, columnNumber;

        do {
            rowNumber = random.nextInt(SIZE);
            columnNumber = random.nextInt(SIZE);
        } while (!isCellFree(rowNumber, columnNumber));

        MAP[rowNumber][columnNumber] = DOT_AI;
        lastRowTurn = rowNumber;
        lastColumnTurn = columnNumber;
//        System.out.println("lastRowTurn " + (lastRowTurn+1) + " lastColumnTurn " + (lastColumnTurn+1));
        turnsCount++;
    }

    private static boolean isContinueGame() {
        System.out.println("Хотите продолжить? y/n");
        return switch (in.next()) {
            case "y", "yes", "+", "да" -> true;
            default -> false;
        };
    }

    private static void endGame() {
        System.out.println("Конец игры.");
    }
}
