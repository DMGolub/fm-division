package com.ua.foxminded.dmgolub.division;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DivisionTest {
    private Division division = new Division();

    @Test
    void calculate_shouldThrowIllegalAgrumentException_whenDivisorIsZero() {
        assertThrows(IllegalArgumentException.class, () -> division.calculate(1, 0));
    }

    @Test
    void division_shouldMakeOneStepAndReturnZero_whenDivisibleIsZero() {   
        DivisionResult divisionResult = new DivisionResultBuilder(0, 123)
                .addStep(0, 0)
                .build();
        assertEquals(divisionResult, division.calculate(0, 123));
    }
    
    @Test
    void division_shouldReturnDivisible_whenDivisorIsOne() {
        DivisionResult divisionResult = new DivisionResultBuilder(9, 1)
                .addStep(9, 9)
                .build();
        assertEquals(divisionResult, division.calculate(9, 1));
    }

    @Test
    void division_shouldMakeOneStep_whenDivisorEqualsDivisible() {
        DivisionResult divisionResult = new DivisionResultBuilder(2, 2)
                .addStep(2, 2)
                .build();
        assertEquals(divisionResult, division.calculate(2, 2));
    }
    
    @Test
    void division_shouldMakeOneStep_whenDivisibleHasOneDigit() {
        DivisionResult divisionResult = new DivisionResultBuilder(5, 2)
                .addStep(5, 4)
                .build();
        assertEquals(divisionResult, division.calculate(5, 2));     
    }
    
    @Test
    void division_shouldMakeOneStep_whenDivisorEqualsDivisibleAndHasTwoDigits() {
        DivisionResult divisionResult = new DivisionResultBuilder(12, 3)
                .addStep(12, 12)
                .build();
        assertEquals(divisionResult, division.calculate(12, 3));
    }
    
    @Test
    void division_shouldReturnResultFromTheTask_whenComplexDivisionIsPerformed() {
        DivisionResult divisionResult = new DivisionResultBuilder(78945, 4)
                .addStep(7, 4)
                .addStep(38, 36)
                .addStep(29, 28)
                .addStep(14, 12)
                .addStep(25, 24)
                .build();
        assertEquals(divisionResult, division.calculate(78945, 4));
    }
    
    @Test
    void division_shouldPreserveZeroSteps_whenDivisibleHasZerosAtTheEnd() {  
        DivisionResult divisionResult = new DivisionResultBuilder(1000, 10)
                .addStep(10, 10)
                .addStep(0, 0)
                .addStep(0, 0)
                .build();
        assertEquals(divisionResult, division.calculate(1000, 10));
    }

}
