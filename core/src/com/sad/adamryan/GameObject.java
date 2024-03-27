package com.sad.adamryan;

import java.util.List;

import com.badlogic.gdx.math.Vector2;

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
	public int CheckCollisions (List<GameObject> CollisionObjects) {
		Vector2 C1, C2, C3, C4;
		C1 = new Vector2(this.x, this.y);
		C2 = new Vector2(this.x + this.width, this.y);
		C3 = new Vector2(this.x + this.width, this.y + this.height);
		C4 = new Vector2(this.x, this.y + this.height);
		
		for (int i = 0; i < CollisionObjects.size(); i++) {
			if (C3.x < CollisionObjects.get(i).x + CollisionObjects.get(i).width && C3.x > CollisionObjects.get(i).x) {
				if (C3.y >= CollisionObjects.get(i).y && C3.y < CollisionObjects.get(i).y + CollisionObjects.get(i).height) {
					return 3;
				}
			}
			if (C4.x < CollisionObjects.get(i).x + CollisionObjects.get(i).width && C4.x > CollisionObjects.get(i).x) {
				if (C4.y >= CollisionObjects.get(i).y && C4.y < CollisionObjects.get(i).y + CollisionObjects.get(i).height) {
					return 4;
				}
			}
			if (C1.x < CollisionObjects.get(i).x + CollisionObjects.get(i).width && C1.x > CollisionObjects.get(i).x) {
				if (C1.y >= CollisionObjects.get(i).y && C1.y <= CollisionObjects.get(i).y + CollisionObjects.get(i).height) {
					return 1;
				}
			}
			if (C2.x < CollisionObjects.get(i).x + CollisionObjects.get(i).width && C2.x > CollisionObjects.get(i).x) {
				if (C2.y >= CollisionObjects.get(i).y && C2.y < CollisionObjects.get(i).y + CollisionObjects.get(i).height) {
					return 2;
				}
			}
		}
		return 0;
	}
}
