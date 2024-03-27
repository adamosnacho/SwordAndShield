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
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;


public class LevelGenerator {
	Texture Level1;
	public void CreateLevel1() {
		Level1 = new Texture(Gdx.files.internal("Levels/Level1.png"));
		Pixmap pix = Level1.getTextureData().consumePixmap();
		pix.getPixels();
	}
}
