package javiergs.gui.paint.gamma;

import java.awt.*;
/** @author Grant Robinson **/

public class ShapeDecoratorMouth implements ShapeDecorator {

    private static final int WIDTH_POS_DIVIDEND = 3;
    private static final int HEIGHT_POS_DIVISOR = 4;
    private static final int HEIGHT_POS_DIVIDEND = 7;
    private static final int WIDTH_SIZE_DIVIDEND = 3;
    private static final int HEIGHT_SIZE_DIVIDEND = 5;
    private final Component component;

    public ShapeDecoratorMouth(Component component){
        this.component = component;
    }

    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        component.draw(g, x, y, width, height);
        g.setColor(Color.BLACK);
        g.fillArc(
                x + width / WIDTH_POS_DIVIDEND,
                y + (height * HEIGHT_POS_DIVISOR / HEIGHT_POS_DIVIDEND),
                width / WIDTH_SIZE_DIVIDEND,
                height / HEIGHT_SIZE_DIVIDEND,
                0, 180);
    }

    @Override
    public void drawOutline(Graphics g) {
        component.drawOutline(g);
    }

    @Override
    public Component copy() {
        return new ShapeDecoratorMouth(component.copy());
    }
    @Override
    public Component getComponent() {
        return component;
    }

    @Override
    public String toString() {
        return "ShapeDecoratorMouth{" +
                "component=" + component +
                '}';
    }
}
