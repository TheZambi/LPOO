package com.aor.numbers;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {

    public List<Integer> setUpList()
    {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);

        return list;
    }

    @Test
    public void sum() {
        List<Integer> list;
        list = setUpList();

        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        assertEquals(14, sum);
    }

    @Test
    public void max() {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(-4);
        list.add(-5);

        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(-1, max);
    }

    @Test
    public void min() {
        List<Integer> list = new ArrayList<>();
        list = setUpList();

        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        assertEquals(1, min);
    }

    @Test
    public void distinct() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        class ListDeduplicatorStub implements IListDeduplicator{
            public List<Integer> deduplicate(IListSorter list) {
                List<Integer> unique = new ArrayList<>();
                unique.add(1);
                unique.add(2);
                unique.add(4);
                return unique;
            }
        }
        IListDeduplicator deduplicator = Mockito.mock(IListDeduplicator.class);

//        List<Integer> deduplicated = new ArrayList<>();
//        deduplicated.add(1);
//        deduplicated.add(2);
//        deduplicated.add(4);
//        Mockito.when(deduplicator.deduplicate(Mockito.any(IListSorter.class))).thenReturn(deduplicated);

        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(new ListDeduplicatorStub());

        assertEquals(3, distinct);
    }
}