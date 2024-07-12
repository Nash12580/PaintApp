package javiergs.gui.paint.gamma;

import java.awt.*;

/** @author Grant Robinson **/

public class Shape {
    private String shapeName;
    private Color color;
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean selected;

    public Shape() {
    }

    public Shape(int xin, int yin, int widthin, int heightin, Color colorin, String namein) {
        shapeName = namein;
        color = colorin;
        x = xin;
        y = yin;
        width = widthin;
        height = heightin;
        selected = false;
    }

    public void draw(Graphics g) {
        System.out.println("Shape draw");
        g.setColor(color);
        switch (shapeName) {
            case "Rectangle":
                g.fillRect(x, y, width, height);
                break;
            case "Circle":
                g.fillOval(x, y, width, height);
                break;
            case "Arc":
                g.fillArc(x, y, width, height, 0, 180);
                break;
            case "Line":
                g.drawLine(x, y, x + width, y + height);
                break;
        }
    }

    public void drawOutline(Graphics g) {
        System.out.println("Shape drawOutline");
        g.setColor(getColor());
        switch (shapeName) {
            case "Rectangle":
                g.drawRect(x, y, width, height);
                break;
            case "Circle":
                g.drawOval(x, y, width, height);
                break;
            case "Arc":
                g.drawArc(x, y, width, height, 0, 180);
                break;
            case "Line":
                g.drawLine(x, y, x + width, y + height);
                break;
        }

        // Draw highlighted border if selected
        if (isSelected()) {
            g.setColor(Color.GREEN);
            switch (shapeName) {
                case "Rectangle":
                    g.drawRect(x - 3, y - 3, width + 15, height + 10);
                    break;
                case "Circle":
                    g.drawOval(x - 3, y - 3, width + 15, height + 10);
                    break;
                case "Arc":
                    g.drawArc(x - 3, y - 3, width + 15, height + 10, 0, 180);
                    break;
                case "Line":
                    g.drawLine(x - 3, y - 3, x + width + 15, y + height + 10);
                    break;
            }
        }
    }

    public Color getColor() {
        return color == null ? Color.BLACK : color;
    }

    public void setColor(Color colorIn) {
        color = colorIn;
    }

    public String getShape() {
        return shapeName == null ? "Rectangle" : shapeName;
    }

    public void setShape(String shape) {
        shapeName = shape;
    }

    public int getX() {
        return x;
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

    public boolean isSelected(){
        return selected;
    }
}
