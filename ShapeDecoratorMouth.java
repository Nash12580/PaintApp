package javiergs.gui.paint.gamma;

import java.awt.*;

public class ShapeDecoratorMouth extends ShapeDecorator {

    private static final int WIDTH_POS_DIVIDEND = 3;
    private static final int HEIGHT_POS_DIVISOR = 4;
    private static final int HEIGHT_POS_DIVIDEND = 7;
    private static final int WIDTH_SIZE_DIVIDEND = 3;
    private static final int HEIGHT_SIZE_DIVIDEND = 5;

    public void draw(Graphics g, int x, int y, int width, int height) {
        super.draw(g, x, y, width, height);
        g.setColor(Color.BLACK);
        g.fillArc(
                x + width / WIDTH_POS_DIVIDEND,
                y + (height * HEIGHT_POS_DIVISOR / HEIGHT_POS_DIVIDEND),
                width / WIDTH_SIZE_DIVIDEND,
                height / HEIGHT_SIZE_DIVIDEND,
                0, 180);
    }
}
