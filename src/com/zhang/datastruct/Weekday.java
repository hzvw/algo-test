package com.zhang.datastruct;

/**
 * 自己实现枚举类型
 */
public abstract class Weekday {
    private Weekday(){};

    public static Weekday SUN = new Weekday(){
        @Override
        public Weekday nextDay() {
            return MON;
        }
    };

    public static Weekday MON = new Weekday(){
        @Override
        public Weekday nextDay() {
            return WED;
        }
    };

    public static Weekday WED = new Weekday(){
        @Override
        public Weekday nextDay() {
            return MON;
        }
    };

    public abstract Weekday nextDay();



}
