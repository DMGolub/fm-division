package com.ua.foxminded.dmgolub.division;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int divisible = Integer.parseInt(input[0]);
        int divisor = Integer.parseInt(input[1]);
        
        Division division = new Division();
        
        BiFunction<Integer, Integer, DivisionResult> genericFn = division::calculate;
        DivisionResult divisionResult = genericFn.apply(divisible, divisor);

        DivisionResultFormatter formatter = new DivisionResultFormatter();
        String result = formatter.format(divisionResult);
        System.out.println(result);
    }
}
