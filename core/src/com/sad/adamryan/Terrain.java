package com.sad.adamryan;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Terrain {
	public Terrain (World world) {
		createFloor(world);
	}
	public Body body;
	private void createFloor (World world) {
		BodyDef bdef = new BodyDef();
		bdef.fixedRotation = true;
		bdef.type = BodyDef.BodyType.StaticBody;
		bdef.position.set(0, -100);
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(10000, 100);
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = 1f;
		body = world.createBody(bdef);
		body.createFixture(fixtureDef).setUserData(this);
	}
}

