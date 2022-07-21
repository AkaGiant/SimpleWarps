package me.akagiant.simplewarps;

public class Util {

    public static Double convertTo2DecimalPlaces(Double value) {
        return (double) (Math.round(value * 100) / 100);
    }

}
