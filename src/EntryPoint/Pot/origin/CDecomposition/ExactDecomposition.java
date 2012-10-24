package EntryPoint.Pot.origin.CDecomposition;

import EntryPoint.Pot.EntryPoint;

public class ExactDecomposition {
    public ExactDecomposition(int N) {
        this.N = N;
    }

    private final int N;

    public double[][] getExactDecomposition() {
        double[][] decomposition = new double[N][N];
        for (int i = 0; i < EntryPoint.matrixA.length; i++) {
            double sum = 0;
            for (int k = 0; k < i; k++) {
                sum += Math.pow(decomposition[i][k], 2);
            }
            decomposition[i][i] = Math.sqrt(EntryPoint.matrixA[i][i] - sum);

            for (int j = i + 1; j < N; j++) {
                sum = 0;
                for (int k = 0; k < i; k++) {
                    sum += decomposition[j][k] * decomposition[i][k];
                }
                decomposition[j][i] = (EntryPoint.matrixA[j][i] - sum) / decomposition[i][i];
            }
        }
        return decomposition;
    }


    public double[][] verifyDecomposition(double[][] L) {
        double[][] result = new double[N][N];

        for (int i = 0; i < L.length; i++) {
            for (int j = 0; j < L.length; j++) {
                for (int k = 0; k < L.length; k++) {
                    result[i][j] += L[i][k] * L[j][k];
                }
            }
        }
        return result;
    }

}
