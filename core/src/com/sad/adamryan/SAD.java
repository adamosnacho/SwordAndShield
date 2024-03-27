package com.sad.adamryan;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
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
import com.sad.adamryan.*;

public class SAD extends ApplicationAdapter {
	SpriteBatch batch;
	Texture rect;
	private OrthographicCamera camera;
	private Player player;
	public List<GameObject> Objects = new ArrayList<GameObject>();
	GameObject rectObject = new GameObject();
	public float PlayerSpeed = 5f;
	public float MaxPlayerSpeed = 15f;
	public float PlayerFriction = 0.2f;
	@Override
	public void create () {
	      rect = new Texture(Gdx.files.internal("Grass.jpeg"));
	      rectObject.setPos(0, 0 - rect.getHeight());
	      rectObject.setSize(rect.getWidth() * 100, rect.getHeight());
	      Objects.add(rectObject);
	      camera = new OrthographicCamera();
	      camera.setToOrtho(false, 800, 480);
	      camera.zoom = 1.5f;
	      batch = new SpriteBatch();
	      player = new Player();
	      player.CreatePlayer(100, 0);
	      Objects.add(player.gameObject);
	      
	}

	@Override
	public void render () {
		player.yVel -= 0.6f;
		player.ApplyVelocity(Objects);
		float xMove = 0f;
		if (Gdx.input.isKeyPressed(Keys.A)) {
			xMove -= 1;
		}
		if (Gdx.input.isKeyPressed(Keys.D)) {
			xMove += 1;
		}
		if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			player.MovePlayer(0, -1);
			int dir = player.gameObject.CheckCollisions(Objects);
			if ((dir == 1 || dir == 2)) {
				player.yVel = 10f;
			}
			player.MovePlayer(0, 1);
		}
		
		
		if (xMove != 0) {
			if (Math.abs(player.xVel) < MaxPlayerSpeed) {
				player.xVel += xMove * PlayerSpeed;
			}
		}
		else {
			player.xVel *= PlayerFriction;
		}
		
		
		player.ApplyVelocity(Objects);
		
		camera.position.set(new Vector3(player.x + player.playerTexture.getWidth() * player.Scale / 2, player.y + player.playerTexture.getHeight() * player.Scale / 2, 0));
		ScreenUtils.clear(135 / 255.0f, 206 / 255.0f, 235 / 255.0f, 0);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		player.DrawPlayer(batch);
		batch.draw(rect, 0, 0 - rect.getHeight(),rect.getWidth() * 100,rect.getHeight());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		rect.dispose();
		player.playerTexture.dispose();
	}
}
