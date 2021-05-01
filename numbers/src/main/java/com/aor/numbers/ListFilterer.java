package com.aor.numbers;

import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer{
    List<Integer> filter;

    public ListFilterer(List<Integer> l){filter = l;}

    public List<Integer> filter(IListFilter filter2)
    {
        List<Integer> list = new ArrayList<>();
        for(Integer n : filter)
        {
            if(filter2.accept(n))
                list.add(n);
        }
        return list;
    }
}
