package com.ua.foxminded.dmgolub.division;

public interface BinaryOperation<T, R> {
    
    public abstract R calculate(T lhs, T rhs);
}
