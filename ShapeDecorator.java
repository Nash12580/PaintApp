package javiergs.gui.paint.gamma;

import java.awt.*;

public class ShapeDecorator extends Shape {

    protected Shape shape;

    public void add(Shape s) {
        shape = s;
    }

    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        if (shape != null) {
            shape.draw(g, x, y, width, height);
        }
    }
}