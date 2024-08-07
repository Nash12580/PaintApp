package javiergs.gui.paint.gamma;

import java.awt.*;
/** @author Grant Robinson **/
/** @author Nashali Vicente **/

public interface ShapeDecorator extends Component {
    void draw(Graphics g, int x, int y, int width, int height);
    void drawOutline(Graphics g);
    Component getComponent();
    Component copy();
}