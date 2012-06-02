package at.bestsolution.javafx.ide.editor.orion.textview.impl;

import javafx.scene.web.WebEngine;
import netscape.javascript.JSObject;
import at.bestsolution.javafx.ide.editor.orion.editor.impl.NativeObjectWrapper;
import at.bestsolution.javafx.ide.editor.orion.textview.ModelChangedEvent;

public class ModelChangedEventImpl extends NativeObjectWrapper implements ModelChangedEvent {
	public final int addedCharCount;
	public final int addedLineCount;
	public final int removedCharCount;
	public final int removedLineCount;
	public final int start;
	
	public ModelChangedEventImpl(WebEngine e, JSObject jsObject) {
		super(e, jsObject);
		this.addedCharCount = ((Number)jsObject.getMember("addedCharCount")).intValue();
		this.addedLineCount = ((Number)jsObject.getMember("addedLineCount")).intValue();
		this.removedCharCount = ((Number)jsObject.getMember("removedCharCount")).intValue();
		this.removedLineCount = ((Number)jsObject.getMember("removedLineCount")).intValue();
		this.start = ((Number)jsObject.getMember("start")).intValue();
	}

	@Override
	public int getAddedCharCount() {
		return addedCharCount;
	}
	
	@Override
	public int getAddedLineCount() {
		return addedLineCount;
	}
	
	@Override
	public int getRemovedCharCount() {
		return removedCharCount;
	}
	
	@Override
	public int getRemovedLineCount() {
		return removedLineCount;
	}
	
	@Override
	public int getStart() {
		return start;
	}

}
