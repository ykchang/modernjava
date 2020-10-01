package insightbook.newjava.ch06;

import java.util.Arrays;
import java.util.List;

public class ParallelReduceMinMax {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(4, 2, 8, 1, 9, 6, 7, 3, 5);

        // 최대 값 구하기 - 병렬
        int max = intList.parallelStream().reduce(1, Integer::max);
        System.out.printf("최대값 : %s\n", max);

        // 최소 값 구하기 - 병렬
        int min = intList.parallelStream().reduce(1, Integer::min);
        System.out.printf("최소값 : %s\n", min);
    }
}
