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
	
	private final Map<Region, List<Region>> widthMirrors;
	private final Map<Region, List<Region>> heightMirrors;
	
	private ResizeHandler() {
		this.widthMirrors = new HashMap<Region, List<Region>>();
		this.heightMirrors = new HashMap<Region, List<Region>>();
	}

	@Override
	public void handle(ResizeEvent event) {
		Region source = (Region) event.getSource();
		List<Region> widthTargets = this.widthMirrors.get(source);
		List<Region> heightTargets = this.heightMirrors.get(source);
		if (widthTargets != null) {
			for (Region r : widthTargets) {
				r.setPrefWidth(source.getWidth());
			}
		}
		if (heightTargets != null) {
			for (Region r : heightTargets) {
				r.setPrefHeight(source.getHeight());
			}
		}
	}
	
	public static void mirrorSize(Region source, Region target) {
		ResizeHandler.mirrorWidth(source, target);
		ResizeHandler.mirrorHeight(source, target);
	}
	
	public static void mirrorWidth(Region source, Region target) {
		ResizeHandler.mirrorProperty(source, target, singleton.widthMirrors);
	}
	
	public static void mirrorHeight(Region source, Region target) {
		ResizeHandler.mirrorProperty(source, target, singleton.heightMirrors);		
	}
	
	private static void mirrorProperty(Region source, Region target, Map<Region, List<Region>> property) {
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
		ResizeHandler.disconnectTarget(singleton.widthMirrors, target);
		ResizeHandler.disconnectTarget(singleton.heightMirrors, target);
	}
	
	private static void disconnectTarget(Map<Region, List<Region>> property, Region target) {
		for (List<Region> targetList : property.values()) {
			if (targetList.contains(target)) {
				targetList.remove(target);
			}
		}
	}
	
}
