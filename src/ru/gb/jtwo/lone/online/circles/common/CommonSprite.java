package ru.gb.jtwo.lone.online.circles.common;

import java.awt.*;

public interface CommonSprite {
    void update(GameCanvas canvas, float deltaTime);
    void render(GameCanvas canvas, Graphics g);
}
