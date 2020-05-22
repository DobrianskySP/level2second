package ru.gb.jtwo.lone.online.circles.brick;

import ru.gb.jtwo.lone.online.circles.common.CommonSprite;
import ru.gb.jtwo.lone.online.circles.common.GameCanvas;

import java.awt.*;

public class Background implements CommonSprite {
    private Color colorBackGround;
    float red = (int)(Math.random() * 255);
    float green = (int)(Math.random() * 255);
    float blue = (int)(Math.random() * 255);
    float vred = (float) (Math.random() *1);
    float vgreen = (float) (Math.random() *2);
    float vblue = (float) (Math.random() *3);

    @Override
    public void update(GameCanvas canvas, float deltaTime) {
        red += vred;
        green += vgreen;
        blue += vblue;
        if (red >=254 || red <= 1) vred = -vred;
        if (green >=253 || green <= 2) vgreen = -vgreen;
        if (blue >=252|| blue <= 3) vblue = -vblue;
        colorBackGround = new Color((int)red, (int)green, (int)blue);
    }

    @Override
    public void render(GameCanvas canvas, Graphics g) {
        canvas.setBackground(colorBackGround);
    }
}
