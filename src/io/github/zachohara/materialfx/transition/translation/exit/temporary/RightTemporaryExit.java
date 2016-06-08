package io.github.zachohara.materialfx.transition.translation.exit.temporary;

import io.github.zachohara.materialfx.transition.interpolator.MaterialInterpolator;
import io.github.zachohara.materialfx.transition.translation.exit.RightExit;
import javafx.animation.Interpolator;
import javafx.scene.layout.Region;

public class RightTemporaryExit extends RightExit {
	
	private static final Interpolator INTERPOLATOR = MaterialInterpolator.SHARP.getInterpolator();

	public RightTemporaryExit(Region slidingNode) {
		super(slidingNode, INTERPOLATOR);
	}
	
}
