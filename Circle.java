package javiergs.gui.paint.gamma;

import java.awt.*;

/** @author Grant Robinson **/
/** @author Nashali Vicente **/

public class Circle implements Shape {
    private int x,y, width, height;
    private String shapeName;
    private Color color;
    private boolean selected;
    public Circle(int x, int y, int width, int height, Color color, String shapeName){
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

    public Color getColor() {
        return color;
    }


    public void setColor(Color colorIn) {
        color = colorIn;
    }


    public String getShape() {
        return shapeName;
    }

    public void setShape(String shape) {shapeName = shape;
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", shapeName='" + shapeName + '\'' +
                ", color=" + color +
                ", selected=" + selected +
                '}';
    }

    public void setX(int xIn) {
        x = xIn;
    }

    public int getY() {
        return y;
    }

    public void setY(int yIn) {
        y = yIn;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int widthIn) {
        width = widthIn;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int heightIn) {
        height = heightIn;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    @Override
    public Shape copy() {
        return new Circle(x, y, width, height, color, shapeName);
    }

}
