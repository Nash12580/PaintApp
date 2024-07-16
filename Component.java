package javiergs.gui.paint.gamma;

import java.awt.*;
/** @author Nashali Vicente **/

public interface Component {
    void draw(Graphics g, int x, int y, int width, int height);
    void drawOutline(Graphics g);
    Component copy();
}
