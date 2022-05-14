package com.example.glowpadexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.fima.glowpadview.GlowPadView;
import com.fima.glowpadview.GlowPadView.OnTriggerListener;

public class MainActivity extends Activity implements OnTriggerListener {

	private GlowPadView glowPadView;
	private TextView swipeHereTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		glowPadView = findViewById(R.id.glow_pad_view);
		swipeHereTextView = findViewById(R.id.swipe_here_text_view);

		glowPadView.setOnTriggerListener(this);

		// uncomment this to make sure the glowpad doesn't vibrate on touch
		// mGlowPadView.setVibrateEnabled(false);
		
		// uncomment this to hide targets
		glowPadView.setShowTargetsOnIdle(true);
	}

	@Override
	public void onGrabbed(View v, int handle) {
		swipeHereTextView.setVisibility(View.GONE);
	}

	@Override
	public void onReleased(View v, int handle) {
		glowPadView.ping();
	}

	@Override
	public void onTrigger(View v, int target) {
		final int resId = glowPadView.getResourceIdForTarget(target);
		if (resId == R.drawable.ic_deny_call) {
			Toast.makeText(this, "Deny", Toast.LENGTH_SHORT).show();
		} else if (resId == R.drawable.ic_accept_call) {
			Toast.makeText(this, "Accept", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onGrabbedStateChange(View v, int handle) {}

	@Override
	public void onFinishFinalAnimation() {}

}
