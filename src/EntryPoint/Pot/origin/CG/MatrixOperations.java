package EntryPoint.Pot.origin.CG;

public class MatrixOperations {
    private final int N;

    public MatrixOperations(int N) {
        this.N = N;
    }

    double[] subtract(double[] matrixA, double[] matrixB) {
        double[] result = new double[N];
        for (int i = 0; i < N; i++) {
            result[i] = matrixA[i] - matrixB[i];
        }
        return result;
    }

    double[] add(double[] matrixA, double[] matrixB) {
        double[] result = new double[N];
        for (int i = 0; i < N; i++) {
            result[i] = matrixA[i] + matrixB[i];
        }
        return result;
    }

    double[] multiply(double coefficientA, double[] matrixB) {
        for (int i = 0; i < N; i++) {
            matrixB[i] *= coefficientA;
        }
        return matrixB;
    }

    double multiply(double[] matrixA, double[] matrixB) {
        double result = 0;
        for (int i = 0; i < N; i++) {
            result += matrixA[i] * matrixB[i];
        }
        return result;
    }

    double[] multiply(double[][] matrixA, double[] matrixB) {
        double result[] = new double[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[i] += matrixA[i][j] * matrixB[j];
            }
        }
        return result;
    }

    double[][] inverseLowerTriangularMatrix(double[][] matrixA) {
        double[][] result = new double[N][N];
        for (int i = 0; i < result.length; i++) {
            result[i][i] = 1;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                result[i][j] /= matrixA[i][i];
            }
            matrixA[i][i] = 1;
            for (int itRow = i + 1; itRow < N; itRow++) {
                for (int itCol = 0; itCol < i + 1; itCol++) {
                    result[itRow][itCol] -= matrixA[itRow][i] * result[i][itCol];
                }
                matrixA[itRow][i] = 0;
            }
        }
        return result;
    }

    double[] multiplyLowerTriangularMatrix(double[][] matrixK, double[] rk) {
        double[] result = new double[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                result[i] += matrixK[i][j] * rk[j];
            }
        }
        return result;
    }

    double[] multiplyUpperTriangularMatrix(double[][] matrixK, double[] rk) {
        double[] result = new double[N];
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                result[i] += matrixK[i][j] * rk[j];
            }
        }
        return result;
    }

    double[][] transposeMatrix(double[][] matrixA) {
        double[][] result = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[j][i] = matrixA[i][j];
            }
        }
        return result;
    }

}
