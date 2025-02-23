package com.zhang.datastruct;

/**
 * 枚举类型
 */
public class EnumTest {
    public static void main(String[] args){
        Weekday mon = Weekday.MON;
        System.out.println(mon);
        System.out.println(mon.name());
        System.out.println(Weekday.valueOf("MON"));
        System.out.println(Weekday.values());
        System.out.println(mon.i);

    }

    enum Weekday{
        MON(1), TUE(), WED(3);

        int i;

        Weekday(){};

        Weekday(int i){
            this.i = i;
        }
    }

    public enum TrafficLamp{
        RED(30){
            @Override
            public TrafficLamp nextLamp() {
                return GREEN;
            }
        },
        GREEN(45){
            @Override
            public TrafficLamp nextLamp() {
                return YELLOW;
            }
        },
        YELLOW(15){
            @Override
            public TrafficLamp nextLamp() {
                return RED;
            }
        };

        private int time;

        TrafficLamp(int time) {
            this.time = time;
        }

        public abstract TrafficLamp nextLamp();
    }

}
