package ru.pifagor345300.thebun;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Bushes {
    //Array of bushes
    static BushPair[] bushPairs;
    //Bush picture
    private Texture[] textureBush;
    //Distance between bushes
    private int distanceBetweenBushes;

    public Bushes() {
        bushPairs = new BushPair[4];
        textureBush = new Texture[4];
        distanceBetweenBushes = 150;
        int startPositionX = 400;
        for (int i = 0; i < bushPairs.length; i++) {
            textureBush[i] = new Texture("bush" + (i + 1) + ".png");
            bushPairs[i] = new BushPair(new Vector2(startPositionX, 0));
            startPositionX += 240;
        }
    }

    //Bushes drawing
    public void renderBushes(SpriteBatch spriteBatch) {
        for (int i = 0; i < bushPairs.length; i++) {
            spriteBatch.draw(textureBush[i], bushPairs[i].positionBush.x, bushPairs[i].positionBush.y - bushPairs[i].offsetBush);
            spriteBatch.draw(textureBush[i], bushPairs[i].positionBush.x, bushPairs[i].positionBush.y + distanceBetweenBushes + textureBush[i].getHeight() - bushPairs[i].offsetBush);
        }

    }

    //Update Math Bushes
    public void updateBushes() {
        for (int i = 0; i < bushPairs.length; i++) {
            bushPairs[i].updateBushPair();
        }
    }

    //Recreate Bushes
    public void recreateBushes() {
        int startPositionX = 400;
        for (int i = 0; i < bushPairs.length; i++) {
            textureBush[i] = new Texture("bush" + (i + 1) + ".png");
            bushPairs[i] = new BushPair(new Vector2(startPositionX, 0));
            startPositionX += 240;
        }
    }

    class BushPair {
        //Bush coordinates
        Vector2 positionBush;
        //Bush speed
        private float speedBush;
        //Bush offset
        private int offsetBush;
        //Random range
        private int low = 250;
        private int high = 500;
        //Empty space between two objects
        Rectangle emptySpace;

        public BushPair(Vector2 positionBush) {
            this.positionBush = positionBush;
            speedBush = Constants.SPEED_BUSH;
            offsetBush = new Random().nextInt(high - low) + low;
            emptySpace = new Rectangle(positionBush.x, positionBush.y - offsetBush + 600, 150, distanceBetweenBushes);

        }

        //Update Math BushPair
        public void updateBushPair() {
            positionBush.x -= speedBush;
            if (positionBush.x < -150) {
                positionBush.x = Constants.WIDH_CONFIG;
                offsetBush = new Random().nextInt(high - low) + low;
            }
            emptySpace.x = positionBush.x;
        }
    }
}
