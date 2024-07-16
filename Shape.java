package javiergs.gui.paint.gamma;

import java.awt.*;

/** @author Grant Robinson **/
/** @author Nashali Vicente **/


public interface Shape extends Component{
    void draw(Graphics g, int x, int y, int width, int height);
    void drawOutline(Graphics g);
    Color getColor();
    void setColor(Color colorIn);
    String getShape();
    void setShape(String shape);
    int getX();
    void setX(int xIn);
    int getY();
    void setY(int yIn);
    int getWidth();
    void setWidth(int widthIn);
    int getHeight();
    void setHeight(int heightIn);
    void setSelected(boolean selected);
    boolean isSelected();
    Shape copy();

}
