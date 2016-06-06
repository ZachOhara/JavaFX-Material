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

package io.github.zachohara.materialfx.transition.translation;

import io.github.zachohara.materialfx.transition.PropertyTransition;
import javafx.animation.Interpolator;
import javafx.scene.Node;

public class HorizontalTranslation extends PropertyTransition<HorizontalTranslation> {

	public HorizontalTranslation(Node slidingNode, double distance, Interpolator interpolator) {
		super(slidingNode.layoutXProperty(), distance, interpolator);
	}

}
