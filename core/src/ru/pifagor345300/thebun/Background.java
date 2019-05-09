package ru.pifagor345300.thebun;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

//This class describes Background

public class Background {

    //Internal class for the correct drawing of the background.
    // The background must be removed for the correct picture.
    class BackgroundPicture {
        //Texture picture
        private Texture textureBack;
        //Texture coordinates
        private Vector2 positionBack;

        public BackgroundPicture(Vector2 positionBack) {
            textureBack = new Texture("background.png");
            this.positionBack = positionBack;
        }
    }
    //Background speed
    private int speedBack;
    //Array of backgrounds
    private BackgroundPicture[] backgroundPictures;

    //Texture initialization
    public Background() {
        speedBack = Constants.SPEED_BACK;
        backgroundPictures = new BackgroundPicture[2];
        backgroundPictures[0] = new BackgroundPicture(new Vector2(0, 0));
        backgroundPictures[1] = new BackgroundPicture(new Vector2(Constants.WIDH_CONFIG, 0));
    }

    //Texture drawing
    public void renderBack(SpriteBatch spriteBatch) {
        for (int i = 0; i < backgroundPictures.length; i++) {
            spriteBatch.draw(backgroundPictures[i].textureBack, backgroundPictures[i].positionBack.x, backgroundPictures[i].positionBack.y);
        }
    }

    //Update Math Background
    public void updateBack() {
        for (int i = 0; i < backgroundPictures.length; i++) {
            backgroundPictures[i].positionBack.x -= speedBack;
        }
        if (backgroundPictures[0].positionBack.x < -Constants.WIDH_CONFIG) {
            backgroundPictures[0].positionBack.x = 0;
            backgroundPictures[1].positionBack.x = Constants.WIDH_CONFIG;
        }
    }
}
