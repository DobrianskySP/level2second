package ru.gb.jtwo.lone.online.circles.balls;

import ru.gb.jtwo.lone.online.circles.common.CommonControler;
import ru.gb.jtwo.lone.online.circles.common.CommonSprite;
import ru.gb.jtwo.lone.online.circles.common.GameCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame implements CommonControler {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static int spritecount;
    private static int errors;

    private CommonSprite[] commonSprites = new CommonSprite[1];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        initApplication();
        GameCanvas canvas = new GameCanvas(this);
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 ){
                    addSprites(new Ball(e.getX(), e.getY()));
                } else if (e.getButton() == MouseEvent.BUTTON3){
                    removeSprites();
                }
            }
        });
        add(canvas, BorderLayout.CENTER);
        setTitle("Circles");
        setVisible(true);
    }

    private void initApplication() {
        addSprites(new Background());
    }

    private void addSprites(CommonSprite sprite){
        if (spritecount == commonSprites.length){
            CommonSprite[] newCommonSprite = new CommonSprite[commonSprites.length * 2];
            System.arraycopy(commonSprites, 0, newCommonSprite, 0, commonSprites.length);
            commonSprites = newCommonSprite;
        }
        commonSprites[spritecount++] = sprite;
    }

    private void removeSprites(){
        if (!(commonSprites[spritecount - 1] instanceof Background))
            spritecount --;
    }
    @Override
    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime); // obnovlenie // S = v * t
        render(canvas, g); // otrisovka
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < spritecount; i++) {
            commonSprites[i].update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < spritecount; i++) {
            commonSprites[i].render(canvas, g);
        }
    }

}
