package javiergs.gui.paint.gamma;
import java.awt.*;
/**@author Nashali Vicente Lopez**/
/** @author Nashali Vicente **/

public class Line implements Shape{
    private int x,y, width, height;
    private String shapeName;
    private Color color;
    private boolean selected;

    @Override
    public String toString() {
        return "Line{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", shapeName='" + shapeName + '\'' +
                ", color=" + color +
                ", selected=" + selected +
                '}';
    }

    public Line(int x, int y, int width, int height, Color color, String shapeName){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.shapeName = shapeName;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color colorIn) {
        this.color = colorIn;
    }


    public String getShape() {
        return shapeName;
    }

    public void setShape(String shape) {
        this.shapeName = shape;
    }

    public int getX() {
        return x;
    }

    public void setX(int xIn) {
        this.x = xIn;
    }

    public int getY() {
        return y;
    }

    public void setY(int yIn) {
        this.y = yIn;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int widthIn) {
        this.width = widthIn;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int heightIn) {
        this.height = heightIn;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    @Override
    public Shape copy() {
        return new Line(x, y, width, height, color, shapeName);
    }

}
