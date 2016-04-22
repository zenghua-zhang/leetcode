package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FlattenNestedListIterator {
    public class NestedIterator implements Iterator<Integer> {

        LinkedList<Integer> list = null;

        public NestedIterator(List<NestedInteger> nestedList) {
            list = new LinkedList<Integer>();
            addIntegerToList(nestedList);
        }

        private void addIntegerToList(List<NestedInteger> nestedList) {
            if (null == nestedList || nestedList.size() == 0) {
                return;
            }
            for (NestedInteger i : nestedList) {
                if (i.isInteger()) {
                    list.add(i.getInteger());
                } else {
                    addIntegerToList(i.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return list.poll();

        }

        @Override
        public boolean hasNext() {
            return !list.isEmpty();

        }

        @Override
        public void remove() {
        }
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather
        // than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds
        // a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a
        // nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
