package ru.pifagor345300.thebun;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TheBunGDX extends ApplicationAdapter {
    SpriteBatch batch;
    Background background;
    Bun bun;
    Bushes bushes;
    boolean gameOver;
    Texture restartTexture;

    @Override
    public void create() {
        batch = new SpriteBatch();
//        img = new Texture("badlogic.jpg");
        background = new Background();
        bun = new Bun();
        bushes = new Bushes();
        gameOver = false;
        restartTexture = new Texture("fairyTale.png");
    }

    @Override
    public void render() {
        update();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
//        batch.draw(img, 0, 0);
        background.renderBack(batch);
        if (!gameOver) {
            bushes.renderBushes(batch);
            bun.renderBun(batch);
        } else {
            batch.draw(restartTexture, 50, 50);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
//        img.dispose();
    }

    //Update math graphics
    public void update() {
        background.updateBack();
        bun.updateBun();
        bushes.updateBushes();
        for (int i = 0; i < Bushes.bushPairs.length; i++) {
            if (bun.positionBun.x > Bushes.bushPairs[i].positionBush.x && bun.positionBun.x < Bushes.bushPairs[i].positionBush.x + 150) {
                if (!Bushes.bushPairs[i].emptySpace.contains(bun.positionBun)) {
                    gameOver = true;
                }
            }
        }
        if (bun.positionBun.y < 0 || bun.positionBun.y > Constants.HEIGHT_CONFIG) {
            gameOver = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && gameOver) {
            bun.recreateBun();
            bushes.recreateBushes();
            gameOver = false;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.T) && gameOver) {
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File("../assets/The Bun.pdf");
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    // no application registered for PDFs
                }
            }
        }
    }
}
