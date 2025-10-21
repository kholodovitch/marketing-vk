package com.nonamedev.marketing.vk.adminpanel;

import com.nonamedev.marketing.vk.adminpanel.samples.MainScreen;
import com.nonamedev.marketing.vk.adminpanel.samples.authentication.AccessControl;
import com.nonamedev.marketing.vk.adminpanel.samples.authentication.BasicAccessControl;
import com.nonamedev.marketing.vk.adminpanel.samples.authentication.LoginScreen;
import com.nonamedev.marketing.vk.adminpanel.samples.authentication.LoginScreen.LoginListener;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Viewport;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Main UI class of the application that shows either the login screen or the
 * main view of the application depending on whether a user is signed in.
 *
 * The @Viewport annotation configures the viewport meta tags appropriately on
 * mobile devices. Instead of device based scaling (default), using responsive
 * layouts.
 */
@Viewport("user-scalable=no,initial-scale=1.0")
@Theme("dashboard_theme")
@Widgetset("com.nonamedev.marketing.vk.adminpanel.DashboardAppWidgetset")
public class DashboardUI extends UI {

	private AccessControl accessControl = new BasicAccessControl();

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		Responsive.makeResponsive(this);
		setLocale(vaadinRequest.getLocale());
		getPage().setTitle("Dashboard");
		if (!accessControl.isUserSignedIn()) {
			setContent(new LoginScreen(accessControl, new LoginListener() {
				@Override
				public void loginSuccessful() {
					showMainView();
				}
			}));
		} else {
			showMainView();
		}
	}

	protected void showMainView() {
		addStyleName(ValoTheme.UI_WITH_MENU);
		setContent(new MainScreen(DashboardUI.this));
		getNavigator().navigateTo(getNavigator().getState());
	}

	public static DashboardUI get() {
		return (DashboardUI) UI.getCurrent();
	}

	public AccessControl getAccessControl() {
		return accessControl;
	}
}
