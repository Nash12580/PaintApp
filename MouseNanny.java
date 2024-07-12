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
		if (Officer.getShape().equals("Rectangle")) {
			Officer.getShapeStack().push(new Rectangle(p[0], p[1], p[2], p[3], Officer.getColor(), Officer.getShape()));
		} else if (Officer.getShape().equals("Circle")) {
			Officer.getShapeStack().push(new Circle(p[0], p[1], p[2], p[3], Officer.getColor(), Officer.getShape()));
		} else if (Officer.getShape().equals("Arc")) {
			Officer.getShapeStack().push(new Arc(p[0], p[1], p[2], p[3], Officer.getColor(), Officer.getShape()));
		} else if (Officer.getShape().equals("Line")) {
			Officer.getShapeStack().push(new Line(p[0], p[1], p[2], p[3], Officer.getColor(), Officer.getShape()));
		} else {
			System.out.println("Bad Shape name");
		}
		Officer.clearShapeParameters();
		Officer.tellYourBoss();

	}

	public void mouseDragged(MouseEvent e) {
		if (selectedShape != null){
			selectedShape.setX(e.getX() - offsetX);
			selectedShape.setY(e.getY() - offsetY);
			Officer.tellYourBoss();
		} else {
			int x = e.getX();
			int y = e.getY();
			int[] p = calculateShapeParameters(x, y);
			Officer.setShapeParameters(p);
			Officer.tellYourBoss();
		}
	}


	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 1) {
			Shape clickedShape = getShapeAt(e.getX(), e.getY());
			if (clickedShape != null) {
				clickedShape.setSelected(!clickedShape.isSelected());
				for (Shape shape : Officer.getShapeStack()) {
					if (shape.isSelected() && shape != clickedShape) {
						shape.setSelected(false);
					}
				}
				clickedShape.setSelected(!clickedShape.isSelected());
				Officer.tellYourBoss();

				Color newColor = JColorChooser.showDialog(null, "Choose a color", selectedShape.getColor());
				if(newColor != null){
					selectedShape.setColor(newColor);
					Officer.tellYourBoss();
				}
			}
		}



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
		Stack<Shape> shapes = Officer.getShapeStack();
		for(int i = shapes.size() - 1; i >= 0; i--){
			Shape shape = shapes.get(i);
			if(shapeContains(shape, x, y)){
				return shape;
			}
		}
		return null;
	}

	private boolean shapeContains(Shape shape, int x, int y){
		if (shape instanceof Rectangle || shape instanceof Circle || shape instanceof Arc){
			return x >= shape.getX() && x <= shape.getX() + shape.getWidth() &&
					y >= shape.getY() && y <= shape.getY() + shape.getHeight();
		}else if (shape instanceof  Line){
			int tolerance = 5;
			return distanceFromLine(shape.getX(), shape.getY(), shape.getX() + shape.getWidth(), shape.getY() + shape.getHeight(), x, y) <= tolerance;
		}
		return false;
	}

	private double distanceFromLine(int x1, int y1, int x2, int y2, int x, int y){
		double A = x - x1;
		double B = y - y1;
		double C = x2 - x1;
		double D = y2 - y1;

		double dot = A * C + B * D;
		double len_sq = C * C + D * D;
		double param = -1;
		if(len_sq != 0)
			param = dot/len_sq;

		double xx, yy;

		if(param < 0){
			xx = x1;
			yy = y1;
		}else if(param > 1){
			xx = x2;
			yy = y2;
		}else{
			xx = x1 + param * C;
			yy = y1 + param * D;
		}

		double dx = x - xx;
		double dy  = y -yy;
		return Math.sqrt(dx * dx + dy * dy);
	}
}