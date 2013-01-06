package net.obviam.starassault.model;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bob {

 public enum State {
  IDLE, WALKING, JUMPING, DYING, FALLING
 }

 private static final float SPEED = 4f; // unit per second
 static final float JUMP_VELOCITY = 4f;
 private static final float FALLING_ACCEL = 9.8f;
 public static final float SIZE = 0.5f; // half a unit
 private World world;

 Vector2  position = new Vector2();
 Vector2  acceleration = new Vector2();
 Vector2  velocity = new Vector2();
 Rectangle  bounds = new Rectangle();
 State  state = State.IDLE;
 boolean  facingLeft = true;

 public Bob(Vector2 position) {
  this.position = position;
  this.bounds.height = getSize();
  this.bounds.width = getSize();
  updateBounds();
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
 
 public void setState(State newState) {
  this.state = newState;
 }
 
 private void updateBounds() {
  bounds.x = position.x;
  bounds.y = position.y;
 }
 
 public void update(float delta) {
  position.add(velocity.tmp().mul(delta));
  updateBounds();
  float newX = position.x;
 
  boolean ranIntoBlocks = false;
  
  for (Block b : world.getBlocks()) {
   if (Intersector.overlapRectangles(bounds,b.getBounds())) {
    ranIntoBlocks = true;
    System.out.println(b.getBounds().x);
    System.out.println(bounds.getX());
    break;
   }
   
  }
  
  if ( newX < 0 || newX > 10 - bounds.getWidth() || ranIntoBlocks) {
   position.add(velocity.tmp().mul(-delta)); //undo the changes
   velocity.y = 0;
   updateBounds();}
  }

 public Vector2 getAcceleration() {
  return acceleration;
 }

 public void setAcceleration(Vector2 acceleration) {
  this.acceleration = acceleration;
 }

 public Vector2 getVelocity() {
  return velocity;
 }

 public void setVelocity(Vector2 velocity) {
  this.velocity = velocity;
 }

 public boolean isFacingLeft() {
  return facingLeft;
 }

 public void setFacingLeft(boolean facingLeft) {
  this.facingLeft = facingLeft;
 }

 public State getState() {
  return state;
 }

 public void setPosition(Vector2 position) {
  this.position = position;
 }

 public void setBounds(Rectangle bounds) {
  this.bounds = bounds;
 }

 public static float getSpeed() {
  return SPEED;
 }

 public World getWorld() {
  return world;
 }

 public void setWorld(World world) {
  this.world = world;
 }


 
 }

