package io.github.zachohara.materialfx.transition.translation.exit.temporary;

import io.github.zachohara.materialfx.transition.interpolator.MaterialInterpolator;
import io.github.zachohara.materialfx.transition.translation.exit.LeftExit;
import javafx.animation.Interpolator;
import javafx.scene.layout.Region;

public class LeftTemporaryExit extends LeftExit {
	
	private static final Interpolator INTERPOLATOR = MaterialInterpolator.SHARP.getInterpolator();

	public LeftTemporaryExit(Region slidingNode) {
		super(slidingNode, INTERPOLATOR);
	}

}
