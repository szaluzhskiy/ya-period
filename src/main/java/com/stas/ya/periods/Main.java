package com.stas.ya.periods;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Stanislav_Zaluzhskii on 7/23/2018.
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 4, 5, 5, 7, 7, 8, 9, 11,11};

        List<Integer> arrs = Arrays.stream(arr).boxed().collect(Collectors.toList());

        PeriodsBuilder pb = new PeriodsBuilder();

        pb.print(pb.build(arrs));
    }
}
