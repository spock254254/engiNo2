package com.spock254.engine.helper;

public class Math {
    // TODO : spread value have to be valid
    public static double normalize(int minOrigin,int maxOrigin,int minNew,int maxNew,int number){
        int oldRange = maxOrigin - minOrigin;
        double spread = (maxNew - minNew) / oldRange;
        double normalizedNumber = (number - minOrigin) * spread;
        System.out.println(spread);
        return normalizedNumber;
    }
}
