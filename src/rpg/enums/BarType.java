package rpg.enums;

import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.image.BufferedImage;

public enum BarType {
    LIFE, MAGIC, EXPERIENCE;

    BufferedImage container;
    BufferedImage icon;
    BufferedImage bar;

    BarType() {
        switch (this) {
            case LIFE -> {
                container = ImageCache.addImage("life_container", "life_container.png");
                icon = ImageCache.addImage("life_icon", "life_icon.png");
                bar = ImageCache.addImage("life_bar", "life_bar.png");
            }
            case MAGIC -> {
                container = ImageCache.addImage("magic_container", "magic_container.png");
                icon = ImageCache.addImage("magic_icon", "magic_icon.png");
                bar = ImageCache.addImage("magic_bar", "magic_bar.png");
            }
            case EXPERIENCE -> {
                container = ImageCache.addImage("experience_container", "exp_container.png");
                icon = ImageCache.addImage("experience_icon", "exp_icon.png");
                bar = ImageCache.addImage("experience_bar", "exp_bar.png");
            }
        }
    }

    public BufferedImage getContainer() {
        return container;
    }

    public BufferedImage getIcon() {
        return icon;
    }

    public BufferedImage getBar() {
        return bar;
    }
}