package io.github.zachohara.materialfx.transition.translation;

import io.github.zachohara.materialfx.transition.InterpolatedProperty;
import io.github.zachohara.materialfx.transition.MaterialTransition;
import javafx.animation.Interpolator;
import javafx.scene.Node;

public abstract class DiagonalTranslationTransition extends MaterialTransition {
	
	private final InterpolatedProperty interpolatedX;
	private final InterpolatedProperty interpolatedY;
	
	private final boolean isMovingUp;
	
	public DiagonalTranslationTransition(Node translatingNode, double translationX,
			double translationY, Interpolator interpolator) {
		this.interpolatedX = new InterpolatedProperty(translatingNode.layoutXProperty(), translationX);
		this.interpolatedY = new InterpolatedProperty(translatingNode.layoutYProperty(), translationY);
		this.isMovingUp = (translationY >= 0);
		this.setInterpolator(interpolator);
	}
	
	@Override
	public void interpolate(double fraction) {
		double radians = fraction * (Math.PI / 2);
		double fastFraction = Math.sin(radians);
		double slowFraction = 1 - Math.cos(radians);
		if (this.isMovingUp) {
			this.interpolatedX.interpolate(fastFraction);
			this.interpolatedY.interpolate(slowFraction);
		} else {
			this.interpolatedX.interpolate(slowFraction);
			this.interpolatedY.interpolate(slowFraction);
		}
	}

}
