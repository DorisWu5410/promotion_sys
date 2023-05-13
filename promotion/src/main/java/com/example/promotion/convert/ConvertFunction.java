package com.example.promotion.convert;

public interface ConvertFunction<T, R, U> {
    U apply(T t, R r);
}
