package com.ua.foxminded.dmgolub.division;

import java.util.ArrayList;
import java.util.List;

public class DivisionResultBuilder {
    
    private int dividend;
    private int divisor;
    private List<DivisionStepResult> divisionStepsResults;
    
    public DivisionResultBuilder(int dividend, int divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
        divisionStepsResults = new ArrayList<>();
    }
    
    public DivisionResultBuilder addStep(int minuend, int deductible) {
        divisionStepsResults.add(new DivisionStepResult(minuend, deductible));
        return this;
    }
    
    public DivisionResult build() {
        return new DivisionResult(dividend, divisor, divisionStepsResults);
    }
}