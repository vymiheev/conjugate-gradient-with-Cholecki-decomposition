package EntryPoint.Pot.expanded.ICDecomposition;

import EntryPoint.Pot.EntryPoint;
import EntryPoint.Pot.expanded.ConvertedData;

import java.util.List;

public class IncompleteDecomposition {

    public void startGoldenAntelope(List<Double> matrixL) {
        int N = EntryPoint.N;

        for (int i = 0; i < N; i++) {
            double sum = 0;
            for (int rowIterator = 0; rowIterator < i; rowIterator++) {
                int indexSumEl = searchIndexEl(rowIterator, ConvertedData.IA.get(rowIterator) + 1, i);
                if (indexSumEl != -1) {
                    sum += Math.pow(matrixL.get(indexSumEl), 2);
                }
            }
            matrixL.add(Math.sqrt(ConvertedData.AN.get(ConvertedData.IA.get(i)) - sum));

            for (int colIterator = ConvertedData.IA.get(i) + 1; i < N - 1 && colIterator < ConvertedData.IA.get(i + 1); colIterator++) {
                sum = 0;
                for (int rowIterator = 0; rowIterator < i; rowIterator++) {
                    int startIndex = ConvertedData.IA.get(rowIterator) + 1;
                    int indexFirstEl = searchIndexEl(rowIterator, startIndex, i);
                    int indexSecondEl = searchIndexEl(rowIterator, startIndex + 1, ConvertedData.JA.get(colIterator));
                    if (indexFirstEl != -1 && indexSecondEl != -1) {
                        sum += matrixL.get(indexFirstEl) * matrixL.get(indexSecondEl);
                    }
                }
                matrixL.add((ConvertedData.AN.get(colIterator) - sum) / matrixL.get(ConvertedData.IA.get(i)));
            }
        }
    }

    private int searchIndexEl(int row, int startIndex, Integer colToSearch) {
        for (int it = startIndex; it < ConvertedData.IA.get(row + 1); it++) {
            if (ConvertedData.JA.get(it).equals(colToSearch)) {
                return it;
            }
        }
        return -1;
    }
}
