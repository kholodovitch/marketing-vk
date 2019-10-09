package com.nonamedev.marketing.vk.adminpanel;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

@WebServlet(urlPatterns = "/*", name = "DashboardServlet", asyncSupported = true)
@VaadinServletConfiguration(ui = DashboardUI.class, productionMode = false)
public class DashboardServlet extends VaadinServlet {

	private static final long serialVersionUID = -8455463524841677477L;

}