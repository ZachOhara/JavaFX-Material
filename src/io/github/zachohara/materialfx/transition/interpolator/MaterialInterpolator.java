package io.github.zachohara.materialfx.transition.interpolator;

import javafx.animation.Interpolator;

public enum MaterialInterpolator {
	
	STANDARD (new StandardInterpolator()),
	ACCELERATION (new AccelerationInterpolator()),
	DECELERATION (new DecelerationInterpolator()),
	SHARP (new SharpInterpolator());
	
	private final Interpolator interpolator;
	
	private MaterialInterpolator(Interpolator interpolator) {
		this.interpolator = interpolator;
	}
	
	public Interpolator getInterpolator() {
		return this.interpolator;
	}

}
