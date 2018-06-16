package particle.go.game;

import android.app.Activity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

import javax.crypto.spec.RC2ParameterSpec;

import particle.go.game.ParticleGo;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		LayoutInflater inflater  = getLayoutInflater();
//		View v = inflater.inflate(R.layout.layout_android_launcher, );
		//setContentView(R.layout.layout_android_launcher);
		//FrameLayout frameLayout = findViewById(R.id.launcher_frame);

		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new ParticleGo(), config);
//		View v = initializeForView(new ParticleGo(), config);
//		frameLayout.addView(v);

	}
}
