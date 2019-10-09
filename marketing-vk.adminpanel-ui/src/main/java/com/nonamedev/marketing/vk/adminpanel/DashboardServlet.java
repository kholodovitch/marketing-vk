package com.nonamedev.marketing.vk.adminpanel;

import javax.servlet.ServletException;

import com.vaadin.server.VaadinServlet;

@SuppressWarnings("serial")
public class DashboardServlet extends VaadinServlet {

    @Override
    protected final void servletInitialized() throws ServletException {
        super.servletInitialized();
        getService().addSessionInitListener(new DashboardSessionInitListener());
    }
}