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

package io.github.zachohara.materialfx.util;

import javafx.beans.property.Property;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class PropertyMirror<T> implements ChangeListener<T> {
	
	private final Property<T> source;
	private final Property<T> target;
	
	public PropertyMirror(Property<T> source, Property<T> target) {
		this.source = source;
		this.target = target;
		
		source.addListener(this);
	}

	@Override
	public final void changed(ObservableValue<? extends T> observable, T oldValue, T newValue) {
		target.setValue(source.getValue());
	}
	
}
