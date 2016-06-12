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

package io.github.zachohara.materialfx;

import io.github.zachohara.materialfx.color.MaterialColor;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class MaterialScene extends Scene implements StyledElement {
	
	private final Pane rootPane;
	
	private final StylePropertyManager styleManager;
	
	public MaterialScene() {
		this(new Pane());
	}
	
	public MaterialScene(Pane rootPane) {
		super(rootPane);
		
		this.rootPane = rootPane;
		this.styleManager = new StylePropertyManager(this.rootPane.styleProperty());
		
		this.addStyleProperty("background-color", MaterialColor.GREY_050);
	}

	@Override
	public final void addStyleProperty(String parameter, Object value) {
		this.styleManager.addStyleProperty(parameter, value);
	}

	@Override
	public final String getStylePropertyValue(String parameter) {
		return this.styleManager.getStylePropertyValue(parameter);
	}
	
}
