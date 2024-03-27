package com.sad.adamryan;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Player {
	 public static final float JUMP_FORCE = 250f;
	 public static final float RUN_FORCE = 5f;
	 private static final float PLAYER_START_X = 8f;
	 private static final float PLAYER_START_Y = 18f;
	 private static final float SCALE = 0.1f;
	 
	 private Texture playerTexture;
	 public Body body;
 
	 public Player(World world) {
		 playerTexture = new Texture(Gdx.files.internal("person.png"));
		 createBoxBody(world, PLAYER_START_X, PLAYER_START_Y);
	 }
	 
	 private void createBoxBody(World world, float x, float y) {
		  BodyDef bdef = new BodyDef();
		  bdef.fixedRotation = true;
		  bdef.type = BodyDef.BodyType.DynamicBody;
		  bdef.position.set(x, y);
		  PolygonShape shape = new PolygonShape();
		  shape.setAsBox(playerTexture.getWidth() * SCALE, playerTexture.getHeight() * SCALE);
		  FixtureDef fixtureDef = new FixtureDef();
		  fixtureDef.shape = shape;
		  fixtureDef.density = 1;
		  body = world.createBody(bdef);
		  body.createFixture(fixtureDef).setUserData(this);
	 }
	 public void DrawPlayer(SpriteBatch batch)
	 {
		 batch.draw(playerTexture, body.getPosition().x, body.getPosition().y, playerTexture.getWidth() * SCALE, playerTexture.getHeight() * SCALE);
	 }
}