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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javafx.event.EventHandler;
import javafx.scene.layout.Region;

public class ResizeHandler implements EventHandler<ResizeEvent> {
	
	private static final ResizeHandler singleton = new ResizeHandler();
	
	private final Map<Region, List<Region>> widthMimes;
	private final Map<Region, List<Region>> heightMimes;
	
	private ResizeHandler() {
		this.widthMimes = new HashMap<Region, List<Region>>();
		this.heightMimes = new HashMap<Region, List<Region>>();
	}

	@Override
	public void handle(ResizeEvent event) {
		Region source = (Region) event.getSource();
		List<Region> widthMimes = this.widthMimes.get(source);
		List<Region> heightMimes = this.heightMimes.get(source);
		if (widthMimes != null) {
			for (Region r : widthMimes) {
				r.setPrefWidth(source.getWidth());
			}
		}
		if (heightMimes != null) {
			for (Region r : heightMimes) {
				r.setPrefHeight(source.getHeight());
			}
		}
	}
	
	public static void mimicSize(Region source, Region target) {
		ResizeHandler.mimicWidth(source, target);
		ResizeHandler.mimicHeight(source, target);
	}
	
	public static void mimicWidth(Region source, Region target) {
		ResizeHandler.mimicProperty(source, target, singleton.widthMimes);
	}
	
	public static void mimicHeight(Region source, Region target) {
		ResizeHandler.mimicProperty(source, target, singleton.heightMimes);		
	}
	
	private static void mimicProperty(Region source, Region target, Map<Region, List<Region>> property) {
		List<Region> mimes;
		if (property.containsKey(source)) {
			mimes = property.get(source);
		} else {
			mimes = new LinkedList<Region>();
			property.put(source, mimes);
		}
		if (!mimes.contains(target)) {
			mimes.add(target);
			ResizeEventAdapter.createAdapter(source, singleton);
		} else {
			throw new IllegalArgumentException("The given target is already attached to the source");
		}
	}
	
	public static void disconnectTarget(Region target) {
		ResizeHandler.disconnectTarget(singleton.widthMimes, target);
		ResizeHandler.disconnectTarget(singleton.heightMimes, target);
	}
	
	private static void disconnectTarget(Map<Region, List<Region>> property, Region target) {
		for (List<Region> targetList : property.values()) {
			if (targetList.contains(target)) {
				targetList.remove(target);
			}
		}
	}
	
}
