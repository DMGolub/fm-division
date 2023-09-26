package com.ua.foxminded.dmgolub.division;

public final class DivisionStepResult {
    private int minuend;
    private int deductible;
    private int remainder;
    
    public DivisionStepResult(int minuend, int deductible) {
        this.minuend = minuend;
        this.deductible = deductible;
        this.remainder = minuend - deductible;
    }
    
    public int getMinuend() {
        return minuend;
    }
    
    public int getDeductible() {
        return deductible;
    }
    
    public int getRemainder() {
        return remainder;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + deductible;
        result = prime * result + minuend;
        result = prime * result + remainder;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DivisionStepResult other = (DivisionStepResult) obj;
        if (deductible != other.deductible)
            return false;
        if (minuend != other.minuend)
            return false;
        if (remainder != other.remainder)
            return false;
        return true;
    }
}
