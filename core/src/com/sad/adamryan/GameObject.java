package com.sad.adamryan;

public class GameObject {
	public float x;
	public float y;
	public float width;
	public float height;
	public void setSize(float w, float h) {
		width = w;
		height = h;
	}
	public void setPos(float xPos, float yPos) {
		x = xPos;
		y = yPos;
	}
	
}
