package javiergs.gui.paint.gamma;

import javax.swing.*;
import java.awt.*;

/** @author Grant Robinson **/
/** @author Veer Bhagia **/

public class DrawPanel extends JPanel {
	public DrawPanel() {
		setBackground(new Color(176, 250, 192));
	}

	@Override
	protected void paintComponent(Graphics g) {
		System.out.println("Telling boss to repaint");
		super.paintComponent(g);
		g.setColor(new Color(176, 250, 192));
		g.fillRect(0, 0, getWidth(), getHeight());

		for (Shape shape : Officer.getShapeStack()) {
			shape.draw(g);
			if (shape instanceof ClearAction) {
				g.setColor(new Color(176, 250, 192));
				g.fillRect(0, 0, getWidth(), getHeight());
			}

			if (shape.isSelected()){
				shape.drawOutline(g);
			}
		}

		if (Officer.getShape() != null) {
			switch (Officer.getShape()) {
				case "Rectangle":
					int[] p = Officer.getShapeParameters();
					Rectangle rect = new Rectangle(p[0], p[1], p[2], p[3], Officer.getColor(), "Rectangle");
					rect.drawOutline(g);
					break;
				case "Circle":
					p = Officer.getShapeParameters();
					Circle circ = new Circle(p[0], p[1], p[2], p[3], Officer.getColor(), "Circle");
					circ.drawOutline(g);
					break;
				case "Arc":
					p = Officer.getShapeParameters();
					Arc arc = new Arc(p[0], p[1], p[2], p[3], Officer.getColor(), "Arc");
					arc.drawOutline(g);
					break;
				case "Line":
					p = Officer.getShapeParameters();
					Line line = new Line(p[0], p[1], p[2], p[3], Officer.getColor(), "Line");
					line.drawOutline(g);
					break;
			}
		}
	}
}
