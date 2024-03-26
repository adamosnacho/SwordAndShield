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
A git test
public class Player {
	public Texture playerTexture;
	public GameObject gameObject = new GameObject();
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
		if (this.CheckCollisions(CollisionObjects))
		{
			this.MovePlayer(-xVel, -yVel);
			yVel = 0;
			for (int i = 0; i < 1000; i++)
			{
				if (xVel > 0) this.MovePlayer(0.1f,0);
				if (xVel < 0) this.MovePlayer(-0.1f,0);
				if (yVel > 0) this.MovePlayer(0,0.1f);
				if (yVel < 0) this.MovePlayer(0,-0.1f);
				if(this.CheckCollisions(CollisionObjects))
				{
					if (xVel > 0) this.MovePlayer(-0.1f,0);
					if (xVel < 0) this.MovePlayer(0.1f,0);
					if (yVel > 0) this.MovePlayer(0,-0.1f);
					if (yVel < 0) this.MovePlayer(0,0.1f);
					break;
				}
			}
			return false;
		}
		
		return true;
	}
	public Boolean CheckCollisions (List<GameObject> CollisionObjects) {
		Boolean colliding = false;
		Vector2 C1, C2, C3, C4;
		C1 = new Vector2(gameObject.x, gameObject.y);
		C2 = new Vector2(gameObject.x + gameObject.width, gameObject.y);
		C3 = new Vector2(gameObject.x + gameObject.width, gameObject.y + gameObject.height);
		C4 = new Vector2(gameObject.x, gameObject.y + gameObject.height);
		
		for (int i = 0; i < CollisionObjects.size(); i++) {
			
			if (C1.x < CollisionObjects.get(i).x + CollisionObjects.get(i).width && C1.x > CollisionObjects.get(i).x) {
				if (C1.y >= CollisionObjects.get(i).y && C1.y <= CollisionObjects.get(i).y + CollisionObjects.get(i).height) {
					colliding = true;
				}
			}
			if (C2.x < CollisionObjects.get(i).x + CollisionObjects.get(i).width && C2.x > CollisionObjects.get(i).x) {
				if (C2.y >= CollisionObjects.get(i).y && C2.y < CollisionObjects.get(i).y + CollisionObjects.get(i).height) {
					colliding = true;
				}
			}
			if (C3.x < CollisionObjects.get(i).x + CollisionObjects.get(i).width && C3.x > CollisionObjects.get(i).x) {
				if (C3.y >= CollisionObjects.get(i).y && C3.y < CollisionObjects.get(i).y + CollisionObjects.get(i).height) {
					colliding = true;
				}
			}
			if (C4.x < CollisionObjects.get(i).x + CollisionObjects.get(i).width && C4.x > CollisionObjects.get(i).x) {
				if (C4.y >= CollisionObjects.get(i).y && C4.y < CollisionObjects.get(i).y + CollisionObjects.get(i).height) {
					colliding = true;
				}
			}
			
		}
		return colliding;
	}
	public void DrawPlayer (SpriteBatch batch) {
		batch.draw(playerTexture, x, y, playerTexture.getWidth() * Scale, playerTexture.getHeight() * Scale);
	}
}
