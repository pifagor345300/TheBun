package ru.pifagor345300.thebun;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bun {
    //Bun picture
    private Texture textureBun;
    //Bun coordinates
    Vector2 positionBun;
    //Bun vector
    private float vy;

    public Bun() {
        textureBun = new Texture("bun.png");
        positionBun = new Vector2(100, 380);
        vy = 0;
    }

    //Bun drawing
    public void renderBun(SpriteBatch spriteBatch) {
        spriteBatch.draw(textureBun, positionBun.x, positionBun.y);
    }

    //Update Math Bun
    public void updateBun() {
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)) {
            vy = 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)) {
            vy = -1;
        }
        positionBun.y += vy;
    }

    //Recreate Bun
    public void recreateBun() {
        positionBun = new Vector2(100, 380);
        vy = 0;
    }
}
