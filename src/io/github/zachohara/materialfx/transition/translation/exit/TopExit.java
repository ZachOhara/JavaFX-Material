package io.github.zachohara.materialfx.transition.translation.exit;

import io.github.zachohara.materialfx.transition.interpolator.MaterialInterpolator;
import io.github.zachohara.materialfx.transition.translation.VerticalTranslation;
import javafx.animation.Interpolator;
import javafx.scene.layout.Region;

public class TopExit extends VerticalTranslation {
	
	private static final Interpolator INTERPOLATOR = MaterialInterpolator.ACCELERATION.getInterpolator();

	public TopExit(Region slidingNode) {
		this(slidingNode, INTERPOLATOR);
	}
	
	protected TopExit(Region slidingNode, Interpolator interpolator) {
		super(slidingNode, TopExit.getDistance(slidingNode), interpolator);
	}
	
	private static double getDistance(Region slidingNode) {
		return -slidingNode.localToScene(0, slidingNode.getLayoutY()).getY() - slidingNode.getPrefHeight();
	}

}
