package com.nonamedevelopment.marketing.vk.data.dummy;

import java.util.Collection;
import java.util.Collections;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.nonamedevelopment.marketing.vk.data.DataProvider;
import com.nonamedevelopment.marketing.vk.domain.DashboardNotification;
import com.nonamedevelopment.marketing.vk.domain.User;

/**
 * A dummy implementation for the backend API.
 */
public class DummyDataProvider implements DataProvider {

    private final Collection<DashboardNotification> notifications = DummyDataGenerator
            .randomNotifications();

    @Override
    public User authenticate(String userName, String password) {
        User user = new User();
        user.setFirstName(DummyDataGenerator.randomFirstName());
        user.setLastName(DummyDataGenerator.randomLastName());
        user.setRole("admin");
        String email = user.getFirstName().toLowerCase() + "."
                + user.getLastName().toLowerCase() + "@"
                + DummyDataGenerator.randomCompanyName().toLowerCase() + ".com";
        user.setEmail(email.replaceAll(" ", ""));
        user.setLocation(DummyDataGenerator.randomWord(5, true));
        user.setBio("Quis aute iure reprehenderit in voluptate velit esse."
                + "Cras mattis iudicium purus sit amet fermentum.");
        return user;
    }

    @Override
    public int getUnreadNotificationsCount() {
        Predicate<DashboardNotification> unreadPredicate = new Predicate<DashboardNotification>() {
            @Override
            public boolean apply(DashboardNotification input) {
                return !input.isRead();
            }
        };
        return Collections2.filter(notifications, unreadPredicate).size();
    }

    @Override
    public Collection<DashboardNotification> getNotifications() {
        for (DashboardNotification notification : notifications) {
            notification.setRead(true);
        }
        return Collections.unmodifiableCollection(notifications);
    }
}
