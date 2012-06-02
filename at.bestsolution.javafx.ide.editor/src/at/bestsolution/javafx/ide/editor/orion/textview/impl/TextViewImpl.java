package at.bestsolution.javafx.ide.editor.orion.textview.impl;

import javafx.scene.web.WebEngine;
import netscape.javascript.JSObject;
import at.bestsolution.javafx.ide.editor.orion.editor.impl.NativeObjectWrapper;
import at.bestsolution.javafx.ide.editor.orion.textview.TextView;

public class TextViewImpl extends NativeObjectWrapper implements TextView {
	
	public TextViewImpl(WebEngine e, JSObject jsObject) {
		super(e, jsObject);
	}
	
	@Override
	protected Object createWrapper(JSObject object, String type) {
		Object jObject = object.getMember("__javaObject");
		
		if( jObject == null || ((String)jObject).equals("undefined") ) {
			if( "orion.textview.ModelChangedEvent".equals(type) ) {
				return new ModelChangedEventImpl(e, object);
			}
			
			return super.createWrapper(object, type);
		} else {
			return jObject;
		}
	}
	
	@Override
	public String getText() {
		Object o = getJSObject().call("getText");
		return (String)o;
	}
	
	@Override
	public String getText(int start, int end) {
		 return  (String) getJSObject().call("getText", start, end);
	}
}
