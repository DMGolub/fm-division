package com.ua.foxminded.dmgolub.division;

import java.util.List;

public final class DivisionResult {
    
    private int dividend;
    private int divisor;
    private int quotient;
    private List<DivisionStepResult> divisionStepsResults;
    
    public DivisionResult(int divisible, int divisor, List<DivisionStepResult> divisionStepsResults) {
        this.divisionStepsResults = divisionStepsResults;
        this.dividend = divisible;
        this.divisor = divisor;
        this.quotient = divisible / divisor;
    }
    
    public int size() {
        return divisionStepsResults.size();
    }
    
    public int getDividend() {
        return dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public int getQuotient() {
        return quotient;
    }
    
    public int getStepMinuend(int index) {
        return (divisionStepsResults.get(index)).getMinuend();
    }
    
    public int getStepDeductible(int index) {
        return (divisionStepsResults.get(index)).getDeductible();
    }
    
    public int getStepRemainder(int index) {
        return (divisionStepsResults.get(index)).getRemainder();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + dividend;
        result = prime * result + ((divisionStepsResults == null) ? 0 : divisionStepsResults.hashCode());
        result = prime * result + divisor;
        result = prime * result + quotient;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; 
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        DivisionResult other = (DivisionResult) obj;
        if (dividend != other.dividend) {
            return false;
        }
        if (divisionStepsResults == null) {
            if (other.divisionStepsResults != null) {
                return false;              
            }
        } else if (!divisionStepsResults.equals(other.divisionStepsResults)) {
            return false;
        }
        if (divisor != other.divisor) {
            return false;
        }
        if (quotient != other.quotient) {
            return false;
        }
        return true;
    }
}
