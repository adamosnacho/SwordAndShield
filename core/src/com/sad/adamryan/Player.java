package com.sad.adamryan;
import java.io.Console;
import java.util.Iterator;
import java.util.List;

import com.sad.adamryan.GameObject;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
public class Player {
	public Texture playerTexture;
	public GameObject gameObject = new GameObject();
	public float andreigejj;
	public float x;
	public float y;
	public float xVel;
	public float yVel;
	public float Scale = 0.2f;
	public void CreatePlayer (float xPos, float yPos) {
		playerTexture = new Texture(Gdx.files.internal("person.png"));
		gameObject.setPos(xPos, yPos);
		gameObject.setSize(playerTexture.getWidth() * Scale, playerTexture.getHeight() * Scale);
		x = xPos;
		y = yPos;
	}
	public void MovePlayer (float xMove, float yMove) {
		x += xMove;
		y += yMove;
		gameObject.x = x;
		gameObject.y = y;
	}
	public void SetPlayerPosition (float xPos, float yPos) {
		x = xPos;
		y = yPos;
		gameObject.x = x;
		gameObject.y = y;
	}
	public Boolean ApplyVelocity (List<GameObject> CollisionObjects) {
		this.MovePlayer(xVel, yVel);
		if (gameObject.CheckCollisions(CollisionObjects) != 0)
		{
			int dir = gameObject.CheckCollisions(CollisionObjects);
			this.MovePlayer(-xVel, -yVel);
			Vector2 move;
			if (dir == 1 || dir == 2) {
				
				if (yVel > 0) {
					move = new Vector2(0,0.1f);
				}
				else
				{
					move = new Vector2(0,-0.1f);
				}
				yVel = 0;
				
			}
			else {
				if (xVel > 0) {
					move = new Vector2(0.1f,0);
				}
				else
				{
					move = new Vector2(-0.1f,0);
				}
			}
			for (int i = 0; i < 1000; i++)
			{
				this.MovePlayer(move.x, move.y);
				if (gameObject.CheckCollisions(CollisionObjects) != 0)
				{
					this.MovePlayer(-move.x, -move.y);
				}
			}
			return false;
		}
		
		return true;
	}
	
	public void DrawPlayer (SpriteBatch batch) {
		batch.draw(playerTexture, x, y, playerTexture.getWidth() * Scale, playerTexture.getHeight() * Scale);
	}
}
