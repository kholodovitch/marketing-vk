package com.nonamedevelopment.marketing.vk.data;

import java.util.Collection;
import java.util.Date;

import com.nonamedevelopment.marketing.vk.domain.DashboardNotification;
import com.nonamedevelopment.marketing.vk.domain.User;

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
