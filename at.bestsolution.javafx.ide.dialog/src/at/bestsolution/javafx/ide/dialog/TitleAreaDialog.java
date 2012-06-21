/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package at.bestsolution.javafx.ide.dialog;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Window;

public abstract class TitleAreaDialog extends Dialog {
	private String title;
	private String message;
	private URL imageURI;
	
	public TitleAreaDialog(Window parent, String windowTitle, String title, String message, URL imageURI) {
		super(parent, windowTitle);
		this.title = title;
		this.message = message;
		this.imageURI = imageURI;
	}
	
	@Override
	protected final Node createDialogArea() {
		VBox pane = new VBox();
		BorderPane titleArea = new BorderPane();
		titleArea.setPadding(new Insets(0,0,0,10));
		
		VBox messageArea = new VBox();
		messageArea.setPadding(new Insets(10, 0, 0, 0));
		messageArea.getChildren().add(new Label(title));
		messageArea.getChildren().add(new Label(message));
		
		titleArea.setCenter(messageArea);
		try(InputStream in = imageURI.openStream();) {
			titleArea.setRight(new ImageView(new Image(in)));	 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		titleArea.setStyle("-fx-border-style: none none solid none; -fx-border-color: lightgray; -fx-border-width: 2px;");
		
		pane.getChildren().add(titleArea);
		BorderPane dialogContent = new BorderPane();
		dialogContent.setCenter(createDialogContent());
		dialogContent.setPadding(new Insets(10, 10, 10, 10));
		pane.getChildren().add(dialogContent);
		
		return pane;
	}
	
	@Override
	protected Insets getContentInset() {
		return new Insets(0,0,0,0);
	}

	protected abstract Node createDialogContent();
}
