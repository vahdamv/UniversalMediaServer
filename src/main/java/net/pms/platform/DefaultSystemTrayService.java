package net.pms.platform;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.Map;

import dorkbox.systemTray.Menu;
import dorkbox.systemTray.MenuItem;
import dorkbox.systemTray.SystemTray;

public class DefaultSystemTrayService implements SystemTrayService {

    private Map<java.awt.MenuItem, ActionListener> menuItems;

    public DefaultSystemTrayService(Map<java.awt.MenuItem, ActionListener> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public void loadTrayIcon(Image trayIcon) {
        SystemTray tray = SystemTray.get();
        tray.setImage(trayIcon);
        tray.setTooltip("Universal Media Server");
        Menu menu = tray.getMenu();

        menuItems.forEach((item, action) -> {
            MenuItem menuItem = new MenuItem(item.getLabel());
            menuItem.setCallback(action);
            menu.add(menuItem);
        });
    }

    public void updateTrayIcon(Image trayIcon) {
        SystemTray tray = SystemTray.get();
        tray.setImage(trayIcon);
    }

}
