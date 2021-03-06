package io.github.zachohara.materialfx.transition.translation.entrance;

import io.github.zachohara.materialfx.transition.interpolator.DecelerationInterpolator;
import io.github.zachohara.materialfx.transition.translation.VerticalTranslation;
import javafx.animation.Interpolator;
import javafx.geometry.Point2D;
import javafx.scene.layout.Region;

public class BottomEntrance extends VerticalTranslation {

	private static final Interpolator INTERPOLATOR = new DecelerationInterpolator();

	public BottomEntrance(Region slidingNode, Point2D endScenePosition) {
		super(slidingNode, BottomEntrance.getSlidingDistance(slidingNode, endScenePosition), INTERPOLATOR);
	}
	
	private static double getSlidingDistance(Region slidingNode, Point2D endScenePosition) {
		slidingNode.setLayoutX(slidingNode.sceneToLocal(endScenePosition).getX());
		slidingNode.setLayoutY(slidingNode.sceneToLocal(0, slidingNode.getScene().getHeight()).getY());
		return endScenePosition.getX() - slidingNode.getLayoutX();
	}

}
