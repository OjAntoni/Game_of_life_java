package com.company;
public enum Status {
    NONE,
    BORN,
    LIVE,
    DIED;
    public Status step1(int around)
    {
        return switch (this) {
            case NONE -> (around == 3) ? BORN : NONE;
            case LIVE -> (around <= 1 || around >= 4) ? DIED : LIVE;
            default -> this;
        };
    }
    public Status step2()
    {
        return switch (this) {
            case BORN -> LIVE;
            case DIED -> NONE;
            default -> this;
        };
    }
    public boolean isCell()
    {
        return this == LIVE || this == DIED;
    }
}
