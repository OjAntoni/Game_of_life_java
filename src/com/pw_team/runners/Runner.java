package com.pw_team.runners;

import com.pw_team.gui.Generator;
import com.pw_team.gui.SettingsWindow;

public class Runner {
    public static void main(String[] args) {
        SettingsWindow settingsWindow = new SettingsWindow();
        Generator.setFatherFrame(settingsWindow);
    }
}


