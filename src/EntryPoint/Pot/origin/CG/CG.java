package EntryPoint.Pot.origin.CG;

import EntryPoint.Pot.EntryPoint;

public class CG {
    public CG() {
        rk = new double[N];
        zk = new double[N];
        xk = new double[N];
        for (int i = 0; i < N; i++) {
            rk[i] = EntryPoint.matrixB[i];
            zk[i] = rk[i];
        }
    }

    private final int N = EntryPoint.N;
    private double[] rk;
    private double[] zk;
    private double[] xk;

    public void getSolution() {
        MatrixOperations operations=new MatrixOperations(N);
        double multiplicationRk = operations.multiply(rk, rk);
        double normMatrixB = operations.multiply(EntryPoint.matrixB, EntryPoint.matrixB);
        int iteration = 0;
        double eps = 0.0001;
        while (multiplicationRk / normMatrixB > eps){ //&& iteration <= N + 1) {
            double[] multiplicationAzk = operations.multiply(EntryPoint.matrixA, zk);
            double ak = multiplicationRk / operations.multiply(multiplicationAzk, zk);
            xk = operations.add(xk, operations.multiply(ak, zk));
            rk = operations.subtract(rk, operations.multiply(ak, multiplicationAzk));
            double oldMultiplicationRk = multiplicationRk;
            multiplicationRk = operations.multiply(rk, rk);
            double bk = multiplicationRk / oldMultiplicationRk;
            zk = operations.add(rk, operations.multiply(bk, zk));
            iteration++;
            System.out.println(multiplicationRk / normMatrixB);
            //printSolution(iteration);
        }
        printSolution(iteration);
    }

    private void printSolution(int iteration) {
        System.out.println("\nMatrix X is found on " + iteration + " iteration:");
        for (double aXk : xk) {
            System.out.println(aXk);
        }
    }



}



