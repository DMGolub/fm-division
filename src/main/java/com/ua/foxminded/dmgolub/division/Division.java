package com.ua.foxminded.dmgolub.division;

public final class Division implements BinaryOperation<Integer, DivisionResult> {
    
    public Division() {}
    
    @Override
    public DivisionResult calculate(Integer dividend, Integer divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor must not be 0");
        }
        
        DivisionResultBuilder resultBuilder = new DivisionResultBuilder(dividend, divisor);
        
        if (dividend == 0) {
            resultBuilder.addStep(0, 0);
            return resultBuilder.build();
        }
        
        DividendIterator dividendIterator = new DividendIterator(dividend, divisor);
        while(dividendIterator.hasNext()) {
            int minuend = dividendIterator.next();
            int deductible = divisor * (minuend / divisor);
            resultBuilder.addStep(minuend, deductible);
        }
        
        return resultBuilder.build();
    }
}
