package ru.pifagor345300.thebun.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.pifagor345300.thebun.Constants;
import ru.pifagor345300.thebun.TheBunGDX;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = Constants.WIDH_CONFIG;
        config.height = Constants.HEIGHT_CONFIG;
        new LwjglApplication(new TheBunGDX(), config);
    }
}
