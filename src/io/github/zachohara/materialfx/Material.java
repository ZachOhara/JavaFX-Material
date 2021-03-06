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

import io.github.zachohara.materialfx.depthshadow.ShadowedPane;
import io.github.zachohara.materialfx.resize.ResizeHandler;
import io.github.zachohara.materialfx.transition.DepthTransition;
import io.github.zachohara.materialfx.transition.MaterialTransition;
import io.github.zachohara.materialfx.transition.TransitionCompletionListener;
import io.github.zachohara.materialfx.util.PropertyMirror;
import javafx.scene.layout.Pane;

public class Material extends Pane implements StyledElement, TransitionCompletionListener<DepthTransition> {
	
	private final StylePropertyManager styleManager;
	private final Pane background;
	private ShadowedPane shadow;
	
	public Material() {
		super();
		
		this.styleManager = new StylePropertyManager(this.styleProperty());
		this.background = new Pane();
		ResizeHandler.mirrorSize(this, this.background);
		new PropertyMirror<String>(this.styleProperty(), this.background.styleProperty());
		this.getChildren().add(this.background);
	}
	
	public final void setDepth(int depth) {
		if (this.shadow == null) {
			this.shadow = this.makeShadow(depth);
		} else {
			ShadowedPane newShadow = this.makeShadow(depth);
			newShadow.setOpacity(0);
			DepthTransition transition = new DepthTransition(this.shadow, newShadow);
			transition.addCompletionListener(this);
			transition.play();
			this.shadow = newShadow;
		}
	}
	
	private ShadowedPane makeShadow(int depth) {
		ShadowedPane shadow = new ShadowedPane(depth);
		shadow.setPrefWidth(this.getPrefWidth());
		shadow.setPrefHeight(this.getPrefHeight());
		ResizeHandler.mirrorSize(this, shadow);
		shadow.setStyle(this.getStyle());
		this.getChildren().add(shadow);
		shadow.toBack();
		return shadow;
	}

	@Override
	public final void handleTransitionCompletion(MaterialTransition<DepthTransition> transition) {
		if (transition instanceof DepthTransition) {
			DepthTransition depthTransition = (DepthTransition) transition;
			this.getChildren().remove(depthTransition.getOldShadow());
			ResizeHandler.disconnectTarget(depthTransition.getOldShadow());
		}
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
