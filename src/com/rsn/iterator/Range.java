package com.rsn.iterator;

import java.util.Iterator;

public class Range implements Iterable<Long> {
    private long fromInclusive;
    private long toExclusive;

    public Range(long from, long to) {
        this.fromInclusive = from;
        this.toExclusive = to;
    }

    @Override
    public Iterator<Long> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Long> {
        long current;

        public Itr() {
            current = fromInclusive;
        }

        @Override
        public boolean hasNext() {
            return current < toExclusive;
        }

        @Override
        public Long next() {
            return current++;
        }
    }
}
