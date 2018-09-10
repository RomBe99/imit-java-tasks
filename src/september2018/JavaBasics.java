package september2018;

import java.util.Scanner;

public class JavaBasics {

    public static void quadraticEquation() {
        Scanner in = new Scanner(System.in);

        double firstCoefficient;
        double secondCoefficient;
        double thirdCoefficient;

        double discriminant;

        System.out.println("Enter the coefficients of the square equation:");
        System.out.println("Input the first coefficient:");
        firstCoefficient = in.nextInt();

        System.out.println("Input the second coefficient:");
        secondCoefficient = in.nextInt();

        System.out.println("Input the third coefficient:");
        thirdCoefficient = in.nextInt();
        in.close();

        if (firstCoefficient == 0) {
            System.out.printf("The equation has one root (the first coefficient = 0): %.2f", -thirdCoefficient / secondCoefficient);
        } else {
            discriminant = secondCoefficient * secondCoefficient - 4 * firstCoefficient * thirdCoefficient;

            if (discriminant < 0) {
                System.out.println("The equation has complex roots");
            } else {
                discriminant = Math.sqrt(discriminant);
                double firstRoot = 2 * firstCoefficient;
                double secondRoot = firstRoot;
                firstRoot = (-secondCoefficient + discriminant) / firstRoot;
                secondRoot = (-secondCoefficient - discriminant) / secondRoot;

                System.out.printf("First root: %.2f\nSecond root: %.2f\n", firstRoot, secondRoot);
            }
        }
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static int[] enterArray(int arraySize) {
        int[] array = new int[arraySize];

        Scanner in = new Scanner(System.in);

        for (int i = 0; i < arraySize; i++) {
            array[i] = in.nextInt();
        }

        return array;
    }

    public static int sumAllElements(int[] array) {
        int sumAllElements = 0;

        for (int i : array) {
            sumAllElements += i;
        }

        return sumAllElements;
    }

    public static int numberOfEvenElemnts(int[] array) {
        int numberOfEvenElements = 0;

        for (int i : array) {
            if (i % 2 == 0) {
                numberOfEvenElements++;
            }
        }

        return numberOfEvenElements;
    }

    public static int elementsOnInterval(int intervalStart, int intervalEnd, int[] array) {
        int elementsOnInterval = 0;

        for (int i : array) {
            if (i >= intervalStart && i <= intervalEnd) {
                elementsOnInterval++;
            }
        }

        return elementsOnInterval;
    }

    public static boolean allElementsPositive(int[] array) {
        for (int i : array) {
            if (i < 0) {
                return false;
            }
        }

        return true;
    }

    public static int[] reverseArray(int[] array) {
        int arrayLength = array.length - 1;
        int iterations = array.length / 2;
        int temp;

        for (int i = 0; i < iterations; i++) {
            temp = array[i];
            array[i] = array[arrayLength - i];
            array[arrayLength - i] = temp;
        }

        return array;
    }

    public static void compositionAndAverage() {
        Scanner in = new Scanner(System.in);

        double firstNumber;
        double secondNumber;
        double thirdNumber;
        double temp;

        System.out.println("Hello world!\nEnter first number");
        firstNumber = in.nextDouble();

        System.out.println("Enter second number");
        secondNumber = in.nextDouble();

        if (firstNumber > secondNumber) {
            temp = firstNumber - secondNumber;
            secondNumber += temp;
            firstNumber -= temp;
        }

        System.out.println("Enter third number");
        thirdNumber = in.nextDouble();

        if (firstNumber > thirdNumber) {
            temp = firstNumber - thirdNumber;
            firstNumber -= temp;
            thirdNumber += temp;
        }

        if (secondNumber > thirdNumber) {
            temp = secondNumber - thirdNumber;
            secondNumber -= temp;
            thirdNumber += temp;
        }

        System.out.println("The entered numbers:");
        System.out.println(firstNumber);
        System.out.println(secondNumber);
        System.out.println(thirdNumber);

        System.out.printf("\nComposition: %.2f\nAverage: %d\n", firstNumber * secondNumber * thirdNumber,
                (int)((firstNumber + secondNumber + thirdNumber) / 3));
    }

    public static void sinTabulation() {
        Scanner in = new Scanner(System.in);

        double a, b;
        double openInterval;

        System.out.println("Enter first interval point:");
        a = in.nextDouble();
        System.out.println("Enter second interval point:");
        b = in.nextDouble();
        System.out.println("Enter open interval:");
        openInterval = in.nextDouble();
        in.close();

        for (double i = a; i <= b; i += openInterval) {
            System.out.printf("sin(%.2f) = %f\n", i, Math.sin(i));
        }
    }

    public static void main(String[] args) {
    }
}

//TODO 6. Напишите программу для решения системы двух линейных уравнений с двумя неизвестными в вещественных числах.
//TODO 7. Напишите программу вычисления функции exp(x) разложением в ряд Тейлора с заданной точностью. Программа должна суммировать члены ряда до тех пор, пока модуль очередного члена ряда не станет меньше точности.

//TODO 18. Разработайте класс Vector3DArray (массив трехмерных векторов). Методы:
//TODO 7) метод, который получает на вход массив вещественных чисел (коэффициентов) и вычисляет линейную комбинацию векторов с заданными коэффициентами. При несовпадении длин массивов векторов и коэффициентов, результатом считать нулевой вектор (если кто-то знает, как работать с исключениями, то выбросить исключение).
//TODO 8) метод, который получает на вход точку P (типа Point3D) и вычисляет массив точек, каждая из которых – результат сдвига точки P, на соответствующий вектор.