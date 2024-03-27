package com.sad.adamryan;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Terrain {
	public GameObject gameObject;
	public float x, y;
	Texture t;
	public void create(float xPos, float yPos) {
		t = new Texture(Gdx.files.internal("Grass.jpeg"));
		gameObject = new GameObject();
		gameObject.setSize(100, 100);
		gameObject.setPos(xPos, yPos);
	}
	public void DrawTerrain(SpriteBatch batch)
	{
		batch.draw(t, x, y, 100, 100);
	}
}
