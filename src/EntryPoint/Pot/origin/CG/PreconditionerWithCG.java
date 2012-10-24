package EntryPoint.Pot.origin.CG;

import EntryPoint.Pot.EntryPoint;

public class PreconditionerWithCG {
    public PreconditionerWithCG(double[][] matrixL) {
        this.N = EntryPoint.N;
        operations = new MatrixOperations(N);
        inversedMatrixL = operations.inverseLowerTriangularMatrix(matrixL);
        transposedMatrixL = operations.transposeMatrix(inversedMatrixL);
        rk = new double[N];
        zk = new double[N];
        xk = new double[N];
        System.arraycopy(EntryPoint.matrixB, 0, rk, 0, N);
        /*for (int i = 0; i < N; i++) {
            rk[i] = EntryPoint.matrixB[i];
        }*/
        zk = operations.multiplyUpperTriangularMatrix(transposedMatrixL, operations.multiplyLowerTriangularMatrix(inversedMatrixL, rk));
    }

    private MatrixOperations operations;
    private final int N;
    private double[] rk;
    private double[] zk;
    private double[] xk;
    private double[][] inversedMatrixL;
    private double[][] transposedMatrixL;

    public void getSolution() {

        double normMatrixB = operations.multiply(EntryPoint.matrixB, EntryPoint.matrixB);
        int iteration = 0;
        double eps = 0.001;
        double[] Mrk=new double[N];
        System.arraycopy(zk, 0, Mrk, 0, N);
        double normRk;
        do {
            double[] multiplicationAzk = operations.multiply(EntryPoint.matrixA, zk);
            double Mrkrk = operations.multiply(Mrk, rk);
            double ak = Mrkrk / operations.multiply(multiplicationAzk, zk);
            xk = operations.add(xk, operations.multiply(ak, zk));
            rk = operations.subtract(rk, operations.multiply(ak, multiplicationAzk));
            Mrk = operations.multiplyUpperTriangularMatrix(transposedMatrixL, operations.multiplyLowerTriangularMatrix(inversedMatrixL, rk));
            double bk = operations.multiply(Mrk, rk) / Mrkrk;
            zk = operations.add(Mrk, operations.multiply(bk, zk));
            normRk = operations.multiply(rk, rk);
            //printSolution(iteration);
            iteration++;
        }
        while (normRk / normMatrixB > eps);
        printSolution(iteration);
    }

    private void printSolution(int iteration) {
        System.out.println("Matrix X is found on " + iteration + " iteration:");
        for (double aXk : xk) {
            System.out.println(aXk);
        }
    }


}
