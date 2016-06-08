package io.github.zachohara.materialfx.transition.translation.exit;

import io.github.zachohara.materialfx.transition.interpolator.MaterialInterpolator;
import io.github.zachohara.materialfx.transition.translation.VerticalTranslation;
import javafx.animation.Interpolator;
import javafx.scene.layout.Region;

public class RightExit extends VerticalTranslation {
	
	private static final Interpolator INTERPOLATOR = MaterialInterpolator.ACCELERATION.getInterpolator();

	public RightExit(Region slidingNode) {
		this(slidingNode, INTERPOLATOR);
	}
	
	protected RightExit(Region slidingNode, Interpolator interpolator) {
		super(slidingNode, RightExit.getDistance(slidingNode), interpolator);
	}
	
	private static double getDistance(Region slidingNode) {
		return slidingNode.getScene().getWidth() - slidingNode.localToScene(slidingNode.getLayoutX(), 0).getX();
	}

}
