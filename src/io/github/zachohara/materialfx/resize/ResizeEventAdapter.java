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

package io.github.zachohara.materialfx.resize;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.layout.Region;

public class ResizeEventAdapter implements ChangeListener<Number> {

	private final Region eventSource;
	private final EventHandler<ResizeEvent> eventHandler;
	
	private ResizeEventAdapter(Region eventSource, EventHandler<ResizeEvent> eventHandler) {
		this.eventSource = eventSource;
		this.eventHandler = eventHandler;
	}

	@Override
	public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
		this.eventHandler.handle(new ResizeEvent(this.eventSource));
	}
	
	public static void createAdapter(Region eventSource, EventHandler<ResizeEvent> eventHandler) {
		ResizeEventAdapter adapter = new ResizeEventAdapter(eventSource, eventHandler);
		eventSource.widthProperty().addListener(adapter);
		eventSource.heightProperty().addListener(adapter);
	}
	
}
