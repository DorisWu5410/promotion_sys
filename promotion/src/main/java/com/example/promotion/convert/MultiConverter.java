package com.example.promotion.convert;

public interface MultiConverter<T, R, U> {
    U convert(ConvertFunction<T, R, U> f);
}
