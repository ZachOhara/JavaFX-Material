package io.github.zachohara.materialfx.transition.translation.screen;

import io.github.zachohara.materialfx.transition.interpolator.StandardInterpolator;
import io.github.zachohara.materialfx.transition.translation.HorizontalTranslation;
import javafx.animation.Interpolator;
import javafx.scene.Node;

public class HorizontalScreenTranslation extends HorizontalTranslation {
	
	private static final Interpolator INTERPOLATOR = new StandardInterpolator();

	public HorizontalScreenTranslation(Node slidingNode, double distance) {
		super(slidingNode, distance, INTERPOLATOR);
	}

}
