package EntryPoint.Pot.expanded;

import EntryPoint.Pot.expanded.ExtendedCG.ExtendedMatrixOperations;
import EntryPoint.Pot.expanded.ICDecomposition.IncompleteDecomposition;
import EntryPoint.Pot.origin.CG.PreconditionerWithCG;

import java.util.ArrayList;
import java.util.List;

public class ExpandedActionControl {
    private List<Double> matrixL;

    public ExpandedActionControl(int n, double[][] matrixA) {
        matrixL = new ArrayList<Double>();
        new ConvertedData(n, matrixA);
    }

    private void printData() {
        System.out.println("\nAN: ");
        for (Double ANel : ConvertedData.AN) {
            System.out.print(ANel + " ");
        }
        System.out.println("\nJA: ");
        for (Integer JAel : ConvertedData.JA) {
            System.out.print(JAel + " ");
        }
        System.out.println("\nIA: ");
        for (Integer IAel : ConvertedData.IA) {
            System.out.print(IAel + " ");
        }
        System.out.println();
    }

    public void potBoil() {
        printData();
        new IncompleteDecomposition().startGoldenAntelope(matrixL);
        double[][] massiveL = new ExtendedMatrixOperations().makeMatrixL(matrixL);
        printResult(massiveL);
        new PreconditionerWithCG(massiveL).getSolution();
    }

    private void printResult() {
        System.out.println("\nPrint Result matrixL:");
        for (Double el : matrixL) {
            System.out.println(el);
        }
    }

    private void printResult(double[][] matrix) {
        for (double[] aMatrix : matrix) {
            System.out.println();
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(aMatrix[j] + "\t");
            }
        }
        System.out.println();
    }

}
