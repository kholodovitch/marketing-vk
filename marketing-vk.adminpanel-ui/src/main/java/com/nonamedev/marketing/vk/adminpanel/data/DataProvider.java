package com.nonamedev.marketing.vk.adminpanel.data;

import java.util.Collection;
import java.util.Date;

import com.nonamedev.marketing.vk.adminpanel.domain.DashboardNotification;
import com.nonamedev.marketing.vk.adminpanel.domain.User;

/**
 * QuickTickets Dashboard backend API.
 */
public interface DataProvider {
    /**
     * @param userName
     * @param password
     * @return Authenticated used.
     */
    User authenticate(String userName, String password);

    /**
     * @return The number of unread notifications for the current user.
     */
    int getUnreadNotificationsCount();

    /**
     * @return Notifications for the current user.
     */
    Collection<DashboardNotification> getNotifications();
}
