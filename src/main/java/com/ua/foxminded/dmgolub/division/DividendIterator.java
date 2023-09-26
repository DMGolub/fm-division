package com.ua.foxminded.dmgolub.division;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class DividendIterator implements Iterator<Integer> {
    
    private LinkedList<Integer> digits;
    private int divisor;
    private int remainder = 0;
    private boolean first = true;
    
    public DividendIterator(int dividend, int divisor) {
        this.divisor = divisor;
        digits = new LinkedList<>();

        while (dividend > 0) {
            digits.push(dividend % 10);
            dividend /= 10;
        }
    }
    
    @Override
    public boolean hasNext() {
        return !digits.isEmpty();
    }
    
    @Override
    public Integer next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        int nextDigit = 0;          
        while (!digits.isEmpty() && remainder + nextDigit < divisor) {
            remainder *= 10;                   
            nextDigit = nextDigit * 10 + digits.poll();
            if (remainder == 0 && !first) {
                break;
            }
        }
        first = false;
        int minuend = remainder + nextDigit;
        remainder = minuend - divisor * (minuend / divisor);
        return minuend;
    }
}
