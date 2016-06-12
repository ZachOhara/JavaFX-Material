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

import io.github.zachohara.materialfx.util.PropertyLock;
import javafx.beans.property.StringProperty;

public class StylePropertyManager {
	
	private final StringProperty styleProperty;
	private final PropertyLock propertyLock;
	
	public StylePropertyManager(StringProperty styleProperty) {
		super();
		
		this.styleProperty = styleProperty;
		this.propertyLock = new PropertyLock();
		this.styleProperty.addListener(this.propertyLock);
	}
	
	public final void addStyleProperty(String parameter, Object value) {
		parameter = StylePropertyManager.getParameterString(parameter);
		if (this.findProperty(parameter) != null) {
			this.removeProperty(parameter);
		}
		if (value != null) {
			this.modifyStyle(this.getStyle() + parameter + ":" + value + ";");
		}
	}
	
	public final String getStylePropertyValue(String parameter) {
		parameter = StylePropertyManager.getParameterString(parameter);
		String property = this.findProperty(parameter);
		if (property == null) {
			return null;
		}
		int colonIndex = property.indexOf(":");
		String value = property.substring(colonIndex + 1, property.length() - 1);
		return value.trim();
	}

	private void removeProperty(String parameter) {
		String property = this.findProperty(parameter);
		int propertyIndex = this.getStyle().indexOf(property);
		this.modifyStyle(this.getStyle().substring(0, propertyIndex) + this.getStyle().substring(propertyIndex + property.length()));
	}
	
	private String findProperty(String parameter) {
		int index = this.getStyle().indexOf(parameter);
		if (index == -1) {
			return null;
		}
		int endIndex = this.getStyle().indexOf(";", index);
		return this.getStyle().substring(index, endIndex + 1);
	}
	
	private void modifyStyle(String newStyle) {
		this.styleProperty.removeListener(this.propertyLock);
		this.setStyle(newStyle);
		this.styleProperty.addListener(this.propertyLock);
	}
	
	private static String getParameterString(String name) {
		name = name.trim();
		if (!name.startsWith("-fx-")) {
			name = "-fx-" + name;
		}
		if (name.endsWith(":")) {
			name = name.substring(0, name.indexOf(":"));
		}
		return name;
	}
	
	private String getStyle() {
		return this.styleProperty.get();
	}
	
	private void setStyle(String style) {
		this.styleProperty.set(style);
	}
	
}
