package net.obviam.starassault.controller;

import java.util.HashMap;
import java.util.Map;

import net.obviam.starassault.model.Bob;
import net.obviam.starassault.model.Bob.State;
import net.obviam.starassault.model.World;

public class WorldController {

	enum Keys {
		LEFT, RIGHT, JUMP, FIRE, DOWN
	}
	
	private World 	world;
	private Bob 	bob;
	
	static Map<Keys, Boolean> keys = new HashMap<WorldController.Keys, Boolean>();
	static {
		keys.put(Keys.LEFT, false);
		keys.put(Keys.RIGHT,false);
		keys.put(Keys.JUMP, false);
		keys.put(Keys.FIRE, false);
		keys.put(Keys.DOWN, false);
	};

	public WorldController(World world) {
		this.world = world;
		this.bob = world.getBob();
	}

	// ** Key presses and touches **************** //
	
	public void leftPressed() {
		keys.get(keys.put(Keys.LEFT, true));
	}
	
	public void rightPressed() {
		keys.get(keys.put(Keys.RIGHT, true));
	}
	
	public void jumpPressed() {
		keys.get(keys.put(Keys.JUMP, true));
	}
	
	public void firePressed() {
		keys.get(keys.put(Keys.FIRE, false));
	}
	public void DOWNPressed() {
		keys.get(keys.put(Keys.DOWN, true));
	}
	public void DOWNReleased() {
		keys.get(keys.put(Keys.DOWN, false));
	}
	
	public void leftReleased() {
		keys.get(keys.put(Keys.LEFT, false));
	}
	
	public void rightReleased() {
		keys.get(keys.put(Keys.RIGHT, false));
	}
	
	public void jumpReleased() {
		keys.get(keys.put(Keys.JUMP, false));
	}
	
	public void fireReleased() {
		keys.get(keys.put(Keys.FIRE, false));
	}
	
	/** The main update method **/
	public void update(float delta) {
		processInput();
		bob.update(delta);
	}

	/** Change Bob's state and parameters based on input controls **/
	private void processInput() {
		if (keys.get(Keys.LEFT)) {
			// left is pressed
			bob.setFacingLeft(true);
			bob.setState(State.WALKING);
			bob.getVelocity().x = -Bob.getSpeed();
		}
		if (keys.get(Keys.RIGHT)) {
			// left is pressed
			bob.setFacingLeft(false);
			bob.setState(State.WALKING);
			bob.getVelocity().x = Bob.getSpeed();
		}
		if (keys.get(Keys.JUMP)) {
			//jump
			bob.setFacingLeft(true);
			bob.setState(State.JUMPING);
			bob.getVelocity().y = Bob.getSpeed();
		}
			if (keys.get(Keys.DOWN)) {
				// left is pressed
				//bob.setFacingLeft(true);
				bob.setState(State.FALLING);
				bob.getVelocity().y = -Bob.getSpeed();


	
		}
		// need to check if both or none direction are pressed, then Bob is idle
		if ((keys.get(Keys.LEFT) && keys.get(Keys.RIGHT)) || ((!keys.get(Keys.LEFT) && !(keys.get(Keys.RIGHT) )))){
			bob.setState(State.IDLE);
			// acceleration is 0 on the x
			bob.getAcceleration().x = 0;
			// horizontal speed is 0
			bob.getVelocity().x = 0;
		}
		
			if(keys.get(Keys.JUMP) && keys.get(Keys.DOWN)){
				bob.setState(State.IDLE);
				// acceleration is 0 on the x
				bob.getAcceleration().y = 0;
				// horizontal speed is 0
				bob.getVelocity().y = 0;
		
		}
		if((!keys.get(Keys.DOWN) && !(keys.get(Keys.JUMP) ))){
			bob.getAcceleration().y = 0;
			// horizontal speed is 0
			bob.getVelocity().y = 0;
		}

	}
}
