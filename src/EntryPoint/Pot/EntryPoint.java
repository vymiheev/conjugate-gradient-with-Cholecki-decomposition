package EntryPoint.Pot;

import EntryPoint.Pot.expanded.ExpandedActionControl;
import EntryPoint.Pot.origin.OriginActionControl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EntryPoint {
    public static int N;
    public static double[][] matrixA;
    public static double[] matrixB;


    public static void main(String[] args) throws FileNotFoundException {
        printWelcomeMessage();
        enterInitialData();
        printInitialData();
        new ExpandedActionControl(N, matrixA).potBoil();
        //new OriginActionControl().startBoiling();
    }

    private static void printInitialData() {
        System.out.println("\nInitial Data:\n");
        for (double[] aMatrixA : matrixA) {
            for (int j = 0; j < matrixA.length; j++) {
                System.out.print(aMatrixA[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (double aMatrixB : matrixB) {
            System.out.println(aMatrixB);
        }
    }

    private static void enterInitialData() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input"));
        N = scanner.nextInt();
        matrixA = new double[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrixA[i][j] = scanner.nextDouble();
            }
        }

        matrixB = new double[N];
        for (int i = 0; i < N; i++) {
            matrixB[i] = scanner.nextDouble();
        }
    }

    private static void printWelcomeMessage() {
        System.out.println("Hi! it's IC decomposition program solving equation Ax=b.");
    }

    public static void printSolution(double[][] matrix) {
        for (double[] aMatrix : matrix) {
            System.out.println();
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(aMatrix[j] + "  ");
            }
        }
    }
}
