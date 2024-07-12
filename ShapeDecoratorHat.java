package javiergs.gui.paint.gamma;

import java.awt.*;

public class ShapeDecoratorHat extends ShapeDecorator {

    private static final int BRIM_WIDTH_POS_DIVIDEND = 24;
    private static final int BRIM_HEIGHT_POS_DIVIDEND = 12;
    private static final int BRIM_WIDTH_SIZE_DIVIDEND = 12;
    private static final int BRIM_HEIGHT_SIZE_DIVIDEND = 12;

    private static final int CROWN_WIDTH_POS_DIVIDEND = 12;
    private static final int CROWN_HEIGHT_POS_DIVIDEND = 5;
    private static final int CROWN_WIDTH_SIZE_DIVIDEND = 6;
    private static final int CROWN_HEIGHT_SIZE_DIVIDEND = 5;

    public void draw(Graphics g, int x, int y, int width, int height) {
        super.draw(g, x, y, width, height);
        g.setColor(Color.BLACK);
        g.fillRect(
                x - (width / BRIM_WIDTH_POS_DIVIDEND), y - (height / BRIM_HEIGHT_POS_DIVIDEND),
                width + (width / BRIM_WIDTH_SIZE_DIVIDEND), height / BRIM_HEIGHT_SIZE_DIVIDEND);
        g.fillRect(
                x + (width / CROWN_WIDTH_POS_DIVIDEND), y - (height / CROWN_HEIGHT_POS_DIVIDEND),
                width - (width / CROWN_WIDTH_SIZE_DIVIDEND), height / CROWN_HEIGHT_SIZE_DIVIDEND);
    }
}
