package com.example.promotion.convert;

import java.util.function.Function;

public interface Converter<T, R> {
    R convert(Function<T, R> f);    
}
