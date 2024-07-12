package javiergs.gui.paint.gamma;

import java.awt.*;

/** @author Grant Robinson **/

public class Arc extends Shape {

    public Arc(int x, int y, int width, int height, Color color, String shapeName) {
        super(x, y, width, height, color, shapeName);
    }

    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        if ((getWidth() != 0) && (getHeight() != 0)) {
            g.setColor(getColor());
            g.fillArc(getX(), getY(), getWidth(), getHeight(), 0, 180);
        }
    }

    @Override
    public void drawOutline(Graphics g) {
        g.setColor(getColor());
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));

        g2.drawArc(getX(), getY(), getWidth(), getHeight(), 0, 180);

        if (isSelected()) {
            g.setColor(Color.GREEN);
            g.drawArc(getX() - 5, getY() - 5, getWidth() + 10, getHeight() + 10, 0, 180);
        }
    }
}