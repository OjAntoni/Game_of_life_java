package com.pw_team.model;

import com.pw_team.gui.GameWindow;
import com.pw_team.logics.OptionConstants;

public enum Status {
    NONE,
    BORN,
    LIVE,
    DIED;

    public Status step1(int around)
    {
        if(GameWindow.getOption()== OptionConstants.OPTION_ONE) {
            return switch (this) {
                case NONE -> (around == 3) ? BORN : NONE;
                case LIVE -> (around <= 1 || around >= 4) ? DIED : LIVE;
                default -> this;
            };
        }
        else{
            return switch (this) {
                case NONE -> (around == 2) ? BORN : NONE;
                case LIVE -> (around <= 1 || around >= 4) ? DIED : LIVE;
                default -> this;
            };
        }
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
