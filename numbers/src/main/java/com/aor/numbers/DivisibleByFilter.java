package com.aor.numbers;

public class DivisibleByFilter implements IListFilter{
    Integer filter;

    public DivisibleByFilter(Integer i){filter = i;}
    public boolean accept(Integer number){if(number%filter==0)return true; return false;}
}
