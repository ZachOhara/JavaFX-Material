/* Copyright (C) 2016 Zach Ohara
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.github.zachohara.materialfx.transition;

import io.github.zachohara.materialfx.depthshadow.ShadowedPane;
import io.github.zachohara.materialfx.transition.interpolator.StandardInterpolator;
import javafx.animation.Interpolator;
import javafx.util.Duration;

public class DepthTransition extends MaterialTransition {
	
	private static final double DURATION = 100; // milliseconds
	private static final Interpolator INTERPOLATOR = new StandardInterpolator();
	
	private final ShadowedPane oldShadow;
	private final ShadowedPane newShadow;
	
	public DepthTransition(ShadowedPane oldShadow, ShadowedPane newShadow) {
		super();
		this.oldShadow = oldShadow;
		this.newShadow = newShadow;
		this.setInterpolator(INTERPOLATOR);
		this.setCycleDuration(Duration.millis(DURATION));
	}
	
	public final ShadowedPane getOldShadow() {
		return this.oldShadow;
	}
	
	public final ShadowedPane getNewShadow() {
		return this.newShadow;
	}

	@Override
	protected void interpolate(double fraction) {
		this.oldShadow.setOpacity(1 - fraction);
		this.newShadow.setOpacity(fraction);
	}
	
}
