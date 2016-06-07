package io.github.zachohara.materialfx.transition.translation.entrance;

import io.github.zachohara.materialfx.transition.interpolator.DecelerationInterpolator;
import io.github.zachohara.materialfx.transition.translation.HorizontalTranslation;
import javafx.animation.Interpolator;
import javafx.geometry.Point2D;
import javafx.scene.layout.Region;

public class RightEntrance extends HorizontalTranslation {

	private static final Interpolator INTERPOLATOR = new DecelerationInterpolator();

	public RightEntrance(Region slidingNode, Point2D endScenePosition) {
		super(slidingNode, RightEntrance.getSlidingDistance(slidingNode, endScenePosition), INTERPOLATOR);
	}
	
	private static double getSlidingDistance(Region slidingNode, Point2D endScenePosition) {
		slidingNode.setLayoutX(slidingNode.sceneToLocal(slidingNode.getScene().getWidth(), 0).getX());
		slidingNode.setLayoutY(slidingNode.sceneToLocal(endScenePosition).getY());
		return endScenePosition.getX() - slidingNode.getLayoutX();
	}

}
