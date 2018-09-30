package september2018;

import java.util.Scanner;

public class JavaBasics {
    public static void quadraticEquation() {
        Scanner in = new Scanner(System.in);

        double firstCoefficient,
                secondCoefficient,
                thirdCoefficient,
                discriminant;

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

            if (0 > discriminant) {
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

        double firstNumber,
                secondNumber,
                thirdNumber,
                temp;

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
                (int) ((firstNumber + secondNumber + thirdNumber) / 3));
    }

    public static void sinTabulation() {
        Scanner in = new Scanner(System.in);

        double a, b,
                openInterval;

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

    public static void calculateSystemOfLinearEquation(double[][] system) {
        double temp;

        if (system[0][0] * system[0][1] - system[1][0] * system[1][1] == 0) {
            System.out.println("The system has many solutions");
        } else {

            if (system[0][0] != 0) {
                temp = system[0][0];

                system[0][0] /= temp;
            } else {
                temp = system[0][1];
            }

            system[0][1] /= temp;
            system[0][2] /= temp;

            temp = -(system[0][0] == 0 ? system[1][1] : system[1][0]);

            system[1][0] += system[0][0] * temp;
            system[1][1] += system[0][1] * temp;
            system[1][2] += system[0][2] * temp;

            if (system[1][1] != 0) {
                temp = system[1][1];

                system[1][1] /= temp;
                system[1][2] /= temp;

                temp = -system[0][1];

                system[0][1] += system[1][1] * temp;
                system[0][2] += system[1][2] * temp;
            }

            if (system[0][0] < 0) {
                system[0][0] = -system[0][0];
                system[0][2] = -system[0][2];
            }

            if (system[0][1] < 0) {
                system[0][1] = -system[0][1];
                system[0][2] = -system[0][2];
            }

            if (system[0][0] != 0 && system[0][0] % system[0][2] == 0) {
                temp = system[0][0];
                system[0][0] /= temp;
                system[0][2] /= temp;
            }

            if (system[0][1] != 0 && system[0][1] % system[0][2] == 0) {
                temp = system[1][1];
                system[0][1] /= temp;
                system[0][2] /= temp;
            }

            if (system[1][0] < 0) {
                system[1][0] = -system[1][0];
                system[1][2] = -system[1][2];
            }

            if (system[1][1] < 0) {
                system[1][1] = -system[1][1];
                system[1][2] = -system[1][2];
            }

            if (system[1][0] != 0 && system[1][0] % system[1][2] == 0) {
                temp = system[1][0];
                system[1][0] /= temp;
                system[1][2] /= temp;
            }

            if (system[1][1] != 0 && system[1][1] % system[1][2] == 0) {
                temp = system[1][1];
                system[1][1] /= temp;
                system[1][2] /= temp;
            }

            System.out.printf("Roots: x = %.2f, y = %.2f", system[0][2], system[1][2]);
        }
    }

    public static double calcExp(double x, double eps) {
        double sum = 1;
        double aN = 1;

        for (int i = 1; aN > eps; i++) {
            aN *= (x / i);
            sum += aN;
        }

        return sum;
    }

    public static void main(String[] args) {
        calculateSystemOfLinearEquation(new double[][]{{0, 1, 2}, {3, 4, 5}});
    }
}