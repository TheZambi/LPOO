package com.aor.numbers;

import javafx.geometry.Pos;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListFiltererTest
{
    private List<Integer> list;

    @Test
    public void positive()
    {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(-5);
        list.add(-2);

        ListFilterer listFilterer = new ListFilterer(list);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> sol = listFilterer.filter(new PositiveFilter());

        assertEquals(expected,sol);

        expected.clear();
        expected.add(2);
        expected.add(-2);

        List<Integer> solDiv = listFilterer.filter(new DivisibleByFilter(2));

        assertEquals(expected,solDiv);

    }
}
