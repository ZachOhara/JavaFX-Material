package io.github.zachohara.materialfx.transition.translation.exit;

import io.github.zachohara.materialfx.transition.interpolator.MaterialInterpolator;
import io.github.zachohara.materialfx.transition.translation.VerticalTranslation;
import javafx.animation.Interpolator;
import javafx.scene.layout.Region;

public class BottomExit extends VerticalTranslation {
	
	private static final Interpolator INTERPOLATOR = MaterialInterpolator.ACCELERATION.getInterpolator();

	public BottomExit(Region slidingNode) {
		this(slidingNode, INTERPOLATOR);
	}
	
	protected BottomExit(Region slidingNode, Interpolator interpolator) {
		super(slidingNode, BottomExit.getDistance(slidingNode), interpolator);
	}
	
	private static double getDistance(Region slidingNode) {
		return slidingNode.getScene().getHeight() - slidingNode.localToScene(0, slidingNode.getLayoutY()).getY();
	}

}
