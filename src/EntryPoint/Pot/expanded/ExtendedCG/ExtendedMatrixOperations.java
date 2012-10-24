package EntryPoint.Pot.expanded.ExtendedCG;

import EntryPoint.Pot.EntryPoint;
import EntryPoint.Pot.expanded.ConvertedData;

import java.util.List;

public class ExtendedMatrixOperations {
    private List<Integer> IA = ConvertedData.IA;
    private List<Integer> JA = ConvertedData.JA;
    private int N = EntryPoint.N;

    public double[][] makeMatrixL(List<Double> matrixL) {
        double[][] result = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int it = IA.get(i); i < N - 1 && it < IA.get(i + 1); it++) {
                result[i][JA.get(it)] = matrixL.get(it);
            }
        }
        result[N-1][JA.get(IA.get(N-1))]=matrixL.get(IA.get(N-1));
        return result;
    }
}
