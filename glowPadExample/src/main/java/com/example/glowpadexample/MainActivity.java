package com.example.glowpadexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.fima.glowpadview.GlowPadView;
import com.fima.glowpadview.GlowPadView.OnTriggerListener;

public class MainActivity extends Activity implements OnTriggerListener {

	private GlowPadView glowPadView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		glowPadView = findViewById(R.id.glow_pad_view);

		glowPadView.setOnTriggerListener(this);

		// uncomment this to make sure the glowpad doesn't vibrate on touch
		// mGlowPadView.setVibrateEnabled(false);
		
		// uncomment this to hide targets
		glowPadView.setShowTargetsOnIdle(true);
	}

	@Override
	public void onGrabbed(View v, int handle) {

	}

	@Override
	public void onReleased(View v, int handle) {
		glowPadView.ping();

	}

	@Override
	public void onTrigger(View v, int target) {
		final int resId = glowPadView.getResourceIdForTarget(target);
		if (resId == R.drawable.ic_item_camera) {
			Toast.makeText(this, "Camera selected", Toast.LENGTH_SHORT).show();
		} else if (resId == R.drawable.ic_item_google) {
			Toast.makeText(this, "Google selected", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onGrabbedStateChange(View v, int handle) {}

	@Override
	public void onFinishFinalAnimation() {}

}
