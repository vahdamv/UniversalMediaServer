package net.pms.platform;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.Map;

import dorkbox.systemTray.Menu;
import dorkbox.systemTray.MenuItem;
import dorkbox.systemTray.SystemTray;

public class SystemTrayService {

    private Map<java.awt.MenuItem, ActionListener> menuItems;
    private Image trayIcon;

    public SystemTrayService(Map<java.awt.MenuItem, ActionListener> menuItems, Image trayIcon) {
        this.menuItems = menuItems;
        this.trayIcon = trayIcon;
    }

    public void loadTrayIcon() {
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

}
