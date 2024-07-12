package javiergs.gui.paint.gamma;

import java.awt.*;

public class ShapeDecoratorEyes extends ShapeDecorator {

    private static final int CORNEA_WIDTH_POS_1_DIVISOR = 2;
    private static final int CORNEA_WIDTH_POS_2_DIVISOR = 11;
    private static final int CORNEA_WIDTH_POS_1_DIVIDEND = 10;
    private static final int CORNEA_WIDTH_POS_2_DIVIDEND = 20;
    private static final int CORNEA_WIDTH_SIZE_DIVIDEND = 4;
    private static final int CORNEA_HEIGHT_POS_DIVISOR = 2;
    private static final int CORNEA_HEIGHT_POS_DIVIDEND = 10;
    private static final int CORNEA_HEIGHT_SIZE_DIVIDEND = 4;

    private static final int IRIS_WIDTH_POS_1_DIVISOR = 3;
    private static final int IRIS_WIDTH_POS_2_DIVISOR = 6;
    private static final int IRIS_WIDTH_POS_DIVIDEND = 10;
    private static final int IRIS_WIDTH_SIZE_DIVIDEND = 8;
    private static final int IRIS_HEIGHT_POS_DIVISOR = 3;
    private static final int IRIS_HEIGHT_POS_DIVIDEND = 10;
    private static final int IRIS_HEIGHT_SIZE_DIVIDEND = 8;

    public void draw(Graphics g, int x, int y, int width, int height) {
        super.draw(g, x, y, width, height);
        g.setColor(Color.WHITE);
        g.fillOval(
                x + (width * CORNEA_WIDTH_POS_1_DIVISOR / CORNEA_WIDTH_POS_1_DIVIDEND),
                y + (height * CORNEA_HEIGHT_POS_DIVISOR / CORNEA_HEIGHT_POS_DIVIDEND),
                width / CORNEA_WIDTH_SIZE_DIVIDEND,
                height / CORNEA_HEIGHT_SIZE_DIVIDEND);
        g.fillOval(
                x + (width * CORNEA_WIDTH_POS_2_DIVISOR / CORNEA_WIDTH_POS_2_DIVIDEND),
                y + (height * CORNEA_HEIGHT_POS_DIVISOR / CORNEA_HEIGHT_POS_DIVIDEND),
                width / CORNEA_WIDTH_SIZE_DIVIDEND,
                height / CORNEA_HEIGHT_SIZE_DIVIDEND);
        g.setColor(Color.BLUE);
        g.fillOval(
                x + (width * IRIS_WIDTH_POS_1_DIVISOR / IRIS_WIDTH_POS_DIVIDEND),
                y + (height * IRIS_HEIGHT_POS_DIVISOR / IRIS_HEIGHT_POS_DIVIDEND),
                width / IRIS_WIDTH_SIZE_DIVIDEND,
                height / IRIS_HEIGHT_SIZE_DIVIDEND);
        g.fillOval(
                x + (width * IRIS_WIDTH_POS_2_DIVISOR / IRIS_WIDTH_POS_DIVIDEND),
                y + (height * IRIS_HEIGHT_POS_DIVISOR / IRIS_HEIGHT_POS_DIVIDEND),
                width / IRIS_WIDTH_SIZE_DIVIDEND,
                height / IRIS_HEIGHT_SIZE_DIVIDEND);
    }
}
