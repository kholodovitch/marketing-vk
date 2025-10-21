package com.nonamedev.marketing.vk.adminpanel.samples;

import java.util.HashMap;

import com.vaadin.shared.JavaScriptExtensionState;

/**
 * Shared state class for {@link AttributeExtension} communication from server
 * to client.
 */
public class AttributeExtensionState extends JavaScriptExtensionState {
	public HashMap<String, String> attributes = new HashMap<String, String>();
}
