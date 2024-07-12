package javiergs.gui.paint.gamma;

import java.awt.*;

/** @author Grant Robinson **/

public class Circle extends Shape {

    public Circle(int x, int y, int width, int height, Color color, String shapeName){
        super(x, y, width, height, color, shapeName);
    }

    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        if ((getWidth() != 0) && (getHeight() != 0)) {
            g.setColor(getColor());
            g.fillOval(getX(), getY(), getWidth(), getHeight());
        }
    }

    @Override
    public void drawOutline(Graphics g) {
        g.setColor(getColor());
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));

        g2.drawOval(getX(), getY(), getWidth(), getHeight());

        if (isSelected()) {
            g.setColor(Color.GREEN);
            g.drawOval(getX() - 5, getY() - 5, getWidth() + 10, getHeight() + 10);
        }
    }
}
