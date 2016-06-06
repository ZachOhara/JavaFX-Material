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

package io.github.zachohara.materialfx.transition.interpolator;

import javafx.geometry.Point2D;

public class BezierCurve {
	
	private final double[][] xValues;
	private final double[][] yValues;
	
	public BezierCurve(double[][] points) {
		this.xValues = new double[points.length][];
		this.yValues = new double[points.length][];
		for (int i = 0; i < points.length; i++) {
			this.xValues[i] = new double[points.length - i];
			this.yValues[i] = new double[points.length - i];
			this.xValues[0][i] = points[i][0];
			this.yValues[0][i] = points[i][1];
		}
	}
	
	public final Point2D getPoint(double t) {
		for (int i = 1; i < this.xValues.length; i++) {
			for (int j = 0; j < this.xValues.length - i; j++) {
				BezierCurve.populateArrayPosition(this.xValues, i, j, t);
				BezierCurve.populateArrayPosition(this.yValues, i, j, t);
			}
		}
		double x = this.xValues[this.xValues.length - 1][0];
		double y = this.yValues[this.yValues.length - 1][0];
		return new Point2D(x, y);
	}
	
	private static void populateArrayPosition(double[][] array, int i, int j, double t) {
		double x0 = array[i - 1][j];
		double x1 = array[i - 1][j + 1];
		double xf = x0 + (t * (x1 - x0));
		array[i][j] = xf;
	}
	
	public static void main(String[] args) {
		double[][] points = {
			{0, 0},
			{0, 10},
			{10, 10},
			{10, 0},
		};
		BezierCurve curve = new BezierCurve(points);
		for (double t = 0.0; t <= 1.0; t += 0.1) {
			System.out.println(curve.getPoint(t));
		}
	}
	
}
