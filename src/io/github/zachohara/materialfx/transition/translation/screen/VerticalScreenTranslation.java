package io.github.zachohara.materialfx.transition.translation.screen;

import io.github.zachohara.materialfx.transition.interpolator.StandardInterpolator;
import io.github.zachohara.materialfx.transition.translation.VerticalTranslation;
import javafx.animation.Interpolator;
import javafx.scene.Node;

public class VerticalScreenTranslation extends VerticalTranslation {

	private static final Interpolator INTERPOLATOR = new StandardInterpolator();

	public VerticalScreenTranslation(Node slidingNode, double distance) {
		super(slidingNode, distance, INTERPOLATOR);
	}
	

}
