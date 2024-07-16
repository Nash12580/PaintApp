package javiergs.gui.paint.gamma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

/** @author Nashali Vicente Lopez **/
/** @author Grant Robinson **/

public class MouseNanny implements MouseListener, MouseMotionListener {
	int tmpx, tmpy;
	private Shape selectedShape = null;
	int offsetX, offsetY;

	public void mousePressed(MouseEvent e) {
		tmpx = e.getX();
		tmpy = e.getY();
		selectedShape = getShapeAt(e.getX(), e.getY());
		if (selectedShape != null){
			Officer.setSelectedShape(selectedShape);
			selectedShape.setSelected(!selectedShape.isSelected());
			offsetX = tmpx - selectedShape.getX();
			offsetY = tmpy -selectedShape.getY();
			Officer.tellYourBoss();
		}
	}

	public void mouseReleased(MouseEvent e){
		if (selectedShape != null) {
			selectedShape.setX(e.getX() - offsetX);
			selectedShape.setY(e.getY() - offsetY);
			Officer.tellYourBoss();
		}

		int[] p = Officer.getShapeParameters();
		Shape newShape = null;
		if (Officer.getShape().equals("Rectangle")) {
			newShape = new Rectangle(p[0], p[1], p[2], p[3], Officer.getColor(), Officer.getShape());
		} else if (Officer.getShape().equals("Circle")) {
			newShape = new Circle(p[0], p[1], p[2], p[3], Officer.getColor(), Officer.getShape());
		} else if (Officer.getShape().equals("Arc")) {
			newShape = new Arc(p[0], p[1], p[2], p[3], Officer.getColor(), Officer.getShape());
		} else if (Officer.getShape().equals("Line")) {
			newShape = new Line(p[0], p[1], p[2], p[3], Officer.getColor(), Officer.getShape());
		} else {
			System.out.println("Bad Shape name");
		}

		if(newShape != null){
			Officer.getComponentsStack().push(newShape);
			Officer.tellYourBoss();
		}
		Officer.clearShapeParameters();
	}

	public void mouseDragged(MouseEvent e) {
		if (selectedShape != null){
			selectedShape.setX(e.getX() - offsetX);
			selectedShape.setY(e.getY() - offsetY);
			Officer.tellYourBoss();
		}
		else {
			int x = e.getX();
			int y = e.getY();
			int[] p = calculateShapeParameters(x, y);
			Officer.setShapeParameters(p);
			Officer.tellYourBoss();
		}
	}


	public void mouseClicked(MouseEvent e) {
		Officer.handleShapeClick();
	}

	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
	private int[] calculateShapeParameters(int x, int y) {
		int[] parameters = new int[4];
		if(Officer.getShape().equals("Line")){
			parameters[0] = tmpx;
			parameters[1] = tmpy;
			parameters[2] = x - tmpx;
			parameters[3] = y - tmpy;
		}else {
			parameters[0] = Math.min(tmpx, x);
			parameters[1] = Math.min(tmpy, y);
			parameters[2] = Math.abs(x - tmpx);
			parameters[3] = Math.abs(y - tmpy);
		}
		return parameters;
	}

	private Shape getShapeAt(int x, int y){
		Stack<Component> components = Officer.getComponentsStack();
		for(Component c : components) {
			if (c instanceof Shape s) {
				if (x >= s.getX() && x <= s.getX() + s.getWidth() &&
						y >= s.getY() && y <= s.getY() + s.getHeight()) {
					return s;
				}
			}else if(c instanceof ShapeDecorator){
				Shape decoratedShape = (Shape) ((ShapeDecorator) c).getComponent();
				if (x >= decoratedShape.getX() && x <= decoratedShape.getX() + decoratedShape.getWidth() &&
						y >= decoratedShape.getY() && y <= decoratedShape.getY() + decoratedShape.getHeight()) {
					return decoratedShape;
				}
			}
		}
		return null;

	}
}