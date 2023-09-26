package com.ua.foxminded.dmgolub.division;

import static org.junit.jupiter.api.Assertions.*;
import java.util.StringJoiner;
import org.junit.jupiter.api.Test;

class DivisionResultFormatterTest {
    DivisionResultFormatter formatter = new DivisionResultFormatter();

    @Test
    void formatter_shouldThrowIllegalArgumentException_whinDivisonResultIsNull() {
        assertThrows(IllegalArgumentException.class, () -> formatter.format(null));
    }
    
    @Test
    void formatter_shouldPrintOneStep_whenDivisibleIsZero() {
        DivisionResult divisionResult = new DivisionResultBuilder(0, 123)
                .addStep(0, 0)
                .build();
        String expected = new StringJoiner(System.lineSeparator())
                .add("_0|123")
                .add(" 0|---")
                .add(" -|0")
                .add(" 0")
                .toString();
        assertEquals(expected, formatter.format(divisionResult));
    }
    
    @Test
    void formatter_shouldPrintOneStep_whenDivisorEqualsDivisible() {   
        DivisionResult divisionResult = new DivisionResultBuilder(2, 2)
                .addStep(2, 2)
                .build();
        String expected = new StringJoiner(System.lineSeparator())
                .add("_2|2")
                .add(" 2|-")
                .add(" -|1")
                .add(" 0")
                .toString();
        assertEquals(expected, formatter.format(divisionResult));
    }
    
    @Test
    void formatter_shouldPrintOneStep_whenDivisibleHasOneDigit() {
        DivisionResult divisionResult = new DivisionResultBuilder(5, 2)
                .addStep(5, 4)
                .build();
        String expected = new StringJoiner(System.lineSeparator())
                .add("_5|2")
                .add(" 4|-")
                .add(" -|2")
                .add(" 1")
                .toString();
        assertEquals(expected, formatter.format(divisionResult));                
    }
    
    @Test
    void formatter_sshouldPrintOneStep_whenDivisorEqualsDivisibleAndHasTwoDigits() {
        DivisionResult divisionResult = new DivisionResultBuilder(12, 12)
                .addStep(12, 12)
                .build();
        String expected = new StringJoiner(System.lineSeparator())
                .add("_12|12")
                .add(" 12|--")
                .add(" --|1")
                .add("  0")
                .toString();
        assertEquals(expected, formatter.format(divisionResult));
    }
    
    @Test
    void formatter_shouldPrintResultFromTheTask_whenComplexDivisionIsPerformed() {  
        DivisionResult divisionResult = new DivisionResultBuilder(78945, 4)
                .addStep(7, 4)
                .addStep(38, 36)
                .addStep(29, 28)
                .addStep(14, 12)
                .addStep(25, 24)
                .build();
        String expected = new StringJoiner(System.lineSeparator())
                .add("_78945|4")
                .add(" 4    |-----")
                .add(" -    |19736")
                .add("_38")
                .add(" 36")
                .add(" --")
                .add(" _29")
                .add("  28")
                .add("  --")
                .add("  _14")
                .add("   12")
                .add("   --")
                .add("   _25")
                .add("    24")
                .add("    --")
                .add("     1")
                .toString();
        assertEquals(expected, formatter.format(divisionResult));
    }
    
    @Test
    void formatter_shouldPreserveZeroSteps_whenDivisibleHasZerosAtTheEnd() {
        DivisionResult divisionResult = new DivisionResultBuilder(1000, 10)
                .addStep(10, 10)
                .addStep(0, 0)
                .addStep(0, 0)
                .build();
        String expected = new StringJoiner(System.lineSeparator())
                .add("_1000|10")
                .add(" 10  |---")
                .add(" --  |100")
                .add("  _0")
                .add("   0")
                .add("   -")
                .add("   _0")
                .add("    0")
                .add("    -")
                .add("    0")
                .toString();
        assertEquals(expected, formatter.format(divisionResult));
    }
}
