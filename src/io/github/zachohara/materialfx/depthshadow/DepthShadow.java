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

package io.github.zachohara.materialfx.depthshadow;

import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.paint.Color;

public enum DepthShadow {

	DEPTH_0 (0, 0, 0, 0),
	DEPTH_1 (10, 0.12, -1, 2),
	DEPTH_2 (15, 0.16, 0, 4),
	DEPTH_3 (20, 0.19, 0, 6),
	DEPTH_4 (25, 0.25, 0, 8),
	DEPTH_5 (30, 0.30, 0, 10);
	
	private final BlurType BLUR_TYPE = BlurType.GAUSSIAN;
	private final Color COLOR = Color.rgb(0, 0, 0, 0.26);
	
	private final DropShadow dropShadow;
	
	private DepthShadow(double radius, double spread, double offsetX, double offsetY) {
		this.dropShadow = new DropShadow(BLUR_TYPE, COLOR, radius, spread, offsetX, offsetY);
	}
	
	public Effect getEffect() {
		return this.dropShadow;
	}
	
	public static DepthShadow fromDepth(int depth) {
		depth = Math.max(0, depth);
		depth = Math.min(5, depth);
		switch (depth) {
			default:
			case 0:
				return DEPTH_0;
			case 1:
				return DEPTH_1;
			case 2:
				return DEPTH_2;
			case 3:
				return DEPTH_3;
			case 4:
				return DEPTH_4;
			case 5:
				return DEPTH_5;
		}
	}
	
}
