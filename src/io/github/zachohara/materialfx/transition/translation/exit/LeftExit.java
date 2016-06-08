package io.github.zachohara.materialfx.transition.translation.exit;

import io.github.zachohara.materialfx.transition.interpolator.MaterialInterpolator;
import io.github.zachohara.materialfx.transition.translation.HorizontalTranslation;
import javafx.animation.Interpolator;
import javafx.scene.layout.Region;

public class LeftExit extends HorizontalTranslation {
	
	private static final Interpolator INTERPOLATOR = MaterialInterpolator.ACCELERATION.getInterpolator();

	public LeftExit(Region slidingNode) {
		this(slidingNode, INTERPOLATOR);
	}
	
	protected LeftExit(Region slidingNode, Interpolator interpolator) {
		super(slidingNode, LeftExit.getDistance(slidingNode), interpolator);
	}
	
	private static double getDistance(Region slidingNode) {
		return -slidingNode.localToScene(slidingNode.getLayoutX(), 0).getX() - slidingNode.getPrefWidth();
	}

}
