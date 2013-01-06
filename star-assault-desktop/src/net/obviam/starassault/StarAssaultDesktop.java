package net.obviam.starassault;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class StarAssaultDesktop {

	public static void main(String[] args) {
		new LwjglApplication(new StarAssault(), "Nomme", 800, 450, true);
	}

}
