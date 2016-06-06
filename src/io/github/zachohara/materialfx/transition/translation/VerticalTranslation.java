package io.github.zachohara.materialfx.transition.translation;

import io.github.zachohara.materialfx.transition.PropertyTransition;
import javafx.animation.Interpolator;
import javafx.scene.Node;

public class VerticalTranslation extends PropertyTransition<HorizontalTranslation> {

	public VerticalTranslation(Node slidingNode, double distance, Interpolator interpolator) {
		super(slidingNode.layoutYProperty(), distance, interpolator);
	}
}
