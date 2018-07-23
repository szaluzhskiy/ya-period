package com.stas.ya.periods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Stanislav_Zaluzhskii on 7/23/2018.
 */
public class PeriodsBuilder {

    public List<Period> build(List<Integer> vals) {

        SortedSet<Integer> setOfNums = new TreeSet<>(Comparator.comparingInt(Integer::intValue));
        List<Period> periods = new ArrayList<>();
        setOfNums.addAll(vals);

        final int[] prev = {setOfNums.first()};
        Period period = new Period();
        period.setStart(setOfNums.first());
        for(Integer v : setOfNums) {
            if( (v > prev[0] + 1) || (v == setOfNums.last())) {
                period.setEnd(prev[0]);
                periods.add(period);
                period = new Period();
                period.setStart(v);
                if (v == setOfNums.last()) {
                    period.setEnd(v);
                    periods.add(period);
                }
            }
            prev[0] = v;
        }
        return periods;
    }

    public void print(List<Period> periods) {
        StringBuilder sb = new StringBuilder();
        for(Period p : periods) {
            if(p.getStart() == p.getEnd()) {
                sb.append(p.getStart());
                sb.append((periods.get(periods.size() - 1).getEnd() == p.getEnd()) ? "" : ",");
            } else {
                sb.append(p.getStart());
                sb.append("-");
                sb.append(p.getEnd());
                sb.append(",");
            }
        }
        System.out.println(sb.toString());
    }
}
