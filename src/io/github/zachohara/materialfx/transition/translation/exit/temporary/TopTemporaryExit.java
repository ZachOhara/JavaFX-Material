package io.github.zachohara.materialfx.transition.translation.exit.temporary;

import io.github.zachohara.materialfx.transition.interpolator.MaterialInterpolator;
import io.github.zachohara.materialfx.transition.translation.exit.TopExit;
import javafx.animation.Interpolator;
import javafx.scene.layout.Region;

public class TopTemporaryExit extends TopExit {
	
	private static final Interpolator INTERPOLATOR = MaterialInterpolator.SHARP.getInterpolator();

	public TopTemporaryExit(Region slidingNode) {
		super(slidingNode, INTERPOLATOR);
	}

}
