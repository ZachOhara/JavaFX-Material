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

import javafx.animation.Interpolator;
import javafx.beans.property.DoubleProperty;

public abstract class PropertyTransition<T extends PropertyTransition<T>> extends MaterialTransition<T> {
	
	private final DoubleProperty property;
	private final double startValue;
	private final double increment;
	
	public PropertyTransition(DoubleProperty property, double increment, Interpolator interpolator) {
		this.property = property;
		this.startValue = property.get();
		this.increment = increment;
		if (interpolator != null) {
			this.setInterpolator(interpolator);
		}
	}
	
	@Override
	public final void interpolate(double fraction) {
		this.property.set(this.startValue + (fraction * this.increment));
	}

}
