package com.ua.foxminded.dmgolub.division;

import java.util.Arrays;

public final class DivisionResultFormatter {
    
    private static final String LINE_SEPARATOR = System.lineSeparator();
    
    public String format(DivisionResult divisionResult) {
        if (divisionResult == null) {
            throw new IllegalArgumentException("Input must not be null!");
        }
        StringBuilder result = new StringBuilder();
        int spacesCount = appendHeader(result, divisionResult);
        // strings after 3
        for (int i = 1; i < divisionResult.size(); ++i) {
            int minuend = divisionResult.getStepMinuend(i);
            int deductible = divisionResult.getStepDeductible(i);
            int deductibleLength = countDigits(deductible);
            int remainder = divisionResult.getStepRemainder(i);

            result.append(repeatChar(' ', spacesCount))
                .append("_")
                .append(minuend)
                .append(LINE_SEPARATOR);
            spacesCount += countDigits(minuend) - countDigits(deductible);
            result.append(repeatChar(' ', spacesCount + 1))
                .append(deductible)
                .append(LINE_SEPARATOR)
                .append(repeatChar(' ', spacesCount + 1))
                .append(repeatChar('-', deductibleLength))
                .append(LINE_SEPARATOR);
                
            spacesCount += countDigits(deductible) - countDigits(remainder);
            if (remainder == 0 && i + 1 != divisionResult.size()) {
                ++spacesCount;
            }
        }
        // last string
        result.append(repeatChar(' ', spacesCount + 1))
            .append(divisionResult.getStepRemainder(divisionResult.size() - 1));
        
        return result.toString();
    }
    
    private int appendHeader(StringBuilder builder, DivisionResult divisionResult) {
        // zero line
        builder.append("_")
            .append(divisionResult.getDividend())
            .append("|")
            .append(divisionResult.getDivisor())
            .append(LINE_SEPARATOR);
        
        int spacesCount = 0;
        final int deductible = divisionResult.getStepDeductible(0);
        final int remainder = divisionResult.getStepRemainder(0);
        
        final int dividendLength = countDigits(divisionResult.getDividend());
        final int divisorLength = countDigits(divisionResult.getDivisor());
        final int deductibleLength = countDigits(deductible);
        // first line 
        builder.append(" ")
            .append(divisionResult.getStepDeductible(0))
            .append(repeatChar(' ', dividendLength - deductibleLength))       
            .append("|")        
            .append(repeatChar('-', Math.max(countDigits(divisionResult.getQuotient()), divisorLength)))
            .append(LINE_SEPARATOR);
        //second line 
        builder.append(" ")
            .append(repeatChar('-', deductibleLength))
            .append(repeatChar(' ', dividendLength - deductibleLength))
            .append("|")
            .append(divisionResult.getQuotient())
            .append(LINE_SEPARATOR);
        // count spaces for next lines
        spacesCount += deductibleLength - countDigits(remainder);
        if (remainder == 0 && divisionResult.size() > 1) {
            ++spacesCount;
        }
        return spacesCount;
    }
    
    private int countDigits(int number) {
        return String.valueOf(number).length();
    }
    
    private String repeatChar(char character, int count) {
        char[] chars = new char[count];
        Arrays.fill(chars, character);
        return new String(chars);
    }
}
