package EntryPoint.Pot.origin;

import EntryPoint.Pot.EntryPoint;
import EntryPoint.Pot.origin.CDecomposition.ExactDecomposition;
import EntryPoint.Pot.origin.CG.PreconditionerWithCG;

public class OriginActionControl {
    private static ExactDecomposition exactDecomposition = new ExactDecomposition(EntryPoint.N);

    public void startBoiling() {
        double[][] matrixL = exactDecomposition.getExactDecomposition();
        printResult(matrixL);
        printResult(exactDecomposition.verifyDecomposition(matrixL));
        //new CG().getSolution();
        new PreconditionerWithCG(matrixL).getSolution();
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
