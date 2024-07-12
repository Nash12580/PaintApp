package javiergs.gui.paint.gamma;

import java.awt.*;

/** @author Grant Robinson **/

public class Rectangle extends Shape {

    public Rectangle(int x, int y, int width, int height, Color color, String shapeName){
        super(x, y, width, height, color, shapeName);
    }

    @Override
    public void draw(Graphics g) {
        if ((getWidth() != 0) && (getHeight() != 0)) {
            g.setColor(getColor());
            g.fillRect(getX(), getY(), getWidth(), getHeight());
        }
    }

    @Override
    public void drawOutline(Graphics g) {
        g.setColor(getColor());
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));

        g2.drawRect(getX(), getY(), getWidth(), getHeight());

        if (isSelected()) {
            g.setColor(Color.GREEN);
            g.drawRect(getX() - 1, getY() - 1, getWidth() + 5, getHeight() + 5);
        }
    }
}
