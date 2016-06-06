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

package io.github.zachohara.materialfx.transition.translation.screen;

import io.github.zachohara.materialfx.transition.translation.HorizontalTranslation;
import io.github.zachohara.materialfx.transition.translation.VerticalTranslation;
import io.github.zachohara.materialfx.transition.MaterialTransition;
import javafx.animation.Interpolator;
import javafx.scene.Node;

public class DiagonalScreenTranslation extends MaterialTransition<DiagonalScreenTranslation> {
	
	private final HorizontalTranslation horizontal;
	private final VerticalTranslation vertical;
	
	private final boolean isMovingUp;
	
	public DiagonalScreenTranslation(Node translatingNode, double distanceX,
			double distanceY, Interpolator interpolator) {
		this.horizontal = new HorizontalTranslation(translatingNode, distanceX, null);
		this.vertical = new VerticalTranslation(translatingNode, distanceY, null);
		this.isMovingUp = (distanceY >= 0);
		this.setInterpolator(interpolator);
	}
	
	@Override
	public final void interpolate(double fraction) {
		double radians = fraction * (Math.PI / 2);
		double fastFraction = Math.sin(radians);
		double slowFraction = 1 - Math.cos(radians);
		if (this.isMovingUp) {
			this.horizontal.interpolate(fastFraction);
			this.vertical.interpolate(slowFraction);
		} else {
			this.horizontal.interpolate(slowFraction);
			this.vertical.interpolate(slowFraction);
		}
	}

}
