package javiergs.gui.paint.gamma;
import java.awt.*;
/**@author Nashali Vicente Lopez**/
public class Line extends Shape{
    public Line(int x, int y, int width, int height, Color color, String shapeName){
        super(x, y, width, height, color, shapeName);
    }

    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        if ((getWidth() != 0) && (getHeight() != 0)) {
            g.setColor(getColor());
            g.drawLine(getX(), getY(), getX() + getWidth(), getY() + getHeight());
        }
    }

    @Override
    public void drawOutline(Graphics g) {
        g.setColor(getColor());
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));

        g2.drawLine(getX(), getY(), getX() + getWidth(),  getY() + getHeight());

        if (isSelected()) {
            g.setColor(Color.GREEN);
            g.drawLine(getX() - 10, getY() - 5, getX() + getWidth() , getY() + getHeight());
        }
    }
}
