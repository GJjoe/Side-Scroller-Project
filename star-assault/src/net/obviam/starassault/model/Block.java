package net.obviam.starassault.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Block {

	public static final float SIZE = 1f;
	
	Vector2 	position = new Vector2();
	Rectangle 	bounds = new Rectangle();
	
	public Block(Vector2 pos) {
		  this.position = pos;
		  this.bounds.width = getSize();
		  this.bounds.height = getSize();
		  this.bounds.x = position.x;
		  this.bounds.y = position.y;
		 }
	public Vector2 getPosition() {
		return position;
	}

	public Rectangle getBounds() {
		return bounds;
	}
	
	 public static float getSize() {
		  return SIZE;
		 }
}
