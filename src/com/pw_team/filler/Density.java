package com.pw_team.filler;

public enum Density {
    VERY_RARE,
    RARE,
    NORMAL,
    HIGH,
    VERY_HIGH;

    public static int getDensity(Density d){
        return
            switch (d){
                case VERY_RARE -> 20;
                case RARE -> 15;
                case NORMAL -> 10;
                case HIGH -> 6;
                case VERY_HIGH -> 3;
            };
    }
    public static int getDensity(int index){
        return
                switch (index){
                    case 0 -> 20;
                    case 1 -> 15;
                    case 3 -> 6;
                    case 4 -> 3;
                    default -> 10;
                };
    }

    public static String[] getAllDesnsities(){
        return new String[]{"Vare rare"," rare","Normal","High","Very high"};
    }

    public static int getCoef(int index){
        return getDensity(index);
    }
}
