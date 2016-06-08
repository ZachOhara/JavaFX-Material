package io.github.zachohara.materialfx.transition.translation.exit.temporary;

import io.github.zachohara.materialfx.transition.interpolator.MaterialInterpolator;
import io.github.zachohara.materialfx.transition.translation.exit.BottomExit;
import javafx.animation.Interpolator;
import javafx.scene.layout.Region;

public class BottomTemporaryExit extends BottomExit {
	
	private static final Interpolator INTERPOLATOR = MaterialInterpolator.SHARP.getInterpolator();

	public BottomTemporaryExit(Region slidingNode) {
		super(slidingNode, INTERPOLATOR);
	}

}
