package com.aor.numbers;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {

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
    public void deduplicate() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);

        class ListSorterStub implements IListSorter
        {
            public List<Integer> sort() {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(2);
                list.add(2);
                list.add(4);
                return list;
            }
        }

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate(new ListSorter(list));

        assertEquals(expected, distinct);
    }


}