package com.sad.adamryan;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class SAD extends ApplicationAdapter {
	private static final float SCALE = 2.0f;
	public static final float PIXEL_PER_METER = 10f;
	private static final float TIME_STEP = 1 / 60f;
	private static final int VELOCITY_ITERATIONS = 6;
	private static final int POSITION_ITERATIONS = 2;
	
	private OrthographicCamera orthographicCamera;
	private Box2DDebugRenderer box2DDebugRenderer;
	private World world;
	private Player player;
	private Terrain ter;
	private SpriteBatch batch;
	private static final float VELOCITY_Y = -9.85f;
	private static final float VELOCITY_X = 0f;
	@Override
	public void create() {
		orthographicCamera = new OrthographicCamera();
		orthographicCamera.setToOrtho(false, Gdx.graphics.getWidth() / SCALE, Gdx.graphics.getHeight() / SCALE);
		world = new World(new Vector2(VELOCITY_X, VELOCITY_Y), false);
		box2DDebugRenderer = new Box2DDebugRenderer();
		player = new Player(world);
		ter = new Terrain(world);
		batch = new SpriteBatch();
	}
	@Override
	public void render() {
		update();
		Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		player.DrawPlayer(batch);
		batch.end();
	}
	private void update() {
		world.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
		cameraUpdate();
	}
	private void cameraUpdate() {
		Vector3 position = orthographicCamera.position;
		position.x = player.body.getPosition().x;
		position.y = player.body.getPosition().y;
		orthographicCamera.position.set(position);
		orthographicCamera.update();
		System.out.println(position);
	}
	@Override
	public void resize(int width, int height) {
		orthographicCamera.setToOrtho(false, 100, 100);
	}
	@Override
	public void dispose() {
		box2DDebugRenderer.dispose();
		world.dispose();
	}
}