package EntryPoint.Pot.expanded;

import java.util.ArrayList;
import java.util.List;

public class ConvertedData {
    public static List<Double> AN;
    public static List<Integer> JA;
    public static List<Integer> IA;


    public ConvertedData(int n, double[][] matrixA) {
        AN = new ArrayList<Double>();
        JA = new ArrayList<Integer>();
        IA = new ArrayList<Integer>(n);
        for (int row = 0; row < n; row++) {
            IA.add(AN.size());
            for (int col = row; col < n; col++) {
                if (matrixA[row][col] != 0) {
                    AN.add(matrixA[row][col]);
                    JA.add(col);
                }
            }

        }
    }

}
