package javiergs.gui.paint.gamma;

import java.awt.*;

public class ClearAction implements Shape {
    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        // This action doesn't draw anything, it's just a marker for the clear action.
    }

    @Override
    public void drawOutline(Graphics g) {

    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public void setColor(Color colorIn) {

    }

    @Override
    public String getShape() {
        return null;
    }

    @Override
    public void setShape(String shape) {

    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public void setX(int xIn) {

    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void setY(int yIn) {

    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public void setWidth(int widthIn) {

    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void setHeight(int heightIn) {

    }

    @Override
    public void setSelected(boolean selected) {

    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public Shape copy() {
        return null;
    }

}
