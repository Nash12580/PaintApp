package javiergs.gui.paint.gamma;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

/** @author Nashali Vicente Lopez **/
/** @author Grant Robinson **/
/** @author Veer Bhagia **/

public class Officer {
	private static Color color;
	private static String shape;
	private static JPanel drawPanel;
	private static Stack<Component> components = new Stack<>();
	private static Stack<Component> undoneComponents = new Stack<>();
	private static int[] shapeParameters = new int[4];
	private static Component selectedShape = null;
	private static Component shapeCopy = null;
	private static final int COPY_OFFSET = 10;
	private static int clickCount = 0;

	public static Color getColor() {
		return color == null ? Color.BLACK : color;
	}

	public static void setColor(Color color) {
		Officer.color = color;
	}

	public static String getShape() {
		return shape == null ? "Rectangle" : shape;
	}

	public static void setShape(String shape) {
		Officer.shape = shape;
	}

	public static void tellYourBoss() {
		drawPanel.repaint();
//		System.out.println("Tell your boss to repaint.");
	}

	public static void setDrawPanel(JPanel d) {
		drawPanel = d;
	}

	public static Stack<Component> getComponentsStack() {
		return components;
	}

	public static int[] getShapeParameters() {
		return shapeParameters;
	}

	public static void setShapeParameters(int[] p) {
		if (p.length != 4) {
			System.out.println("Invalid parameter input");
		} else {
			shapeParameters = p;
		}
	}

	public static void clearShapeParameters() {
		int[] p = {0, 0, 0, 0};
		shapeParameters = p;
	}

	public static void clear() {
		if(!components.isEmpty()) {
			components.push(new ClearAction());
			components.clear();
			undoneComponents.clear();
			tellYourBoss();
		}
	}

	public static void undo() {
		if (!components.isEmpty()) {
			Component lastAction = components.pop();
			if (lastAction instanceof ClearAction) {
				components.push(lastAction);
				while (!undoneComponents.isEmpty() && !(undoneComponents.peek() instanceof ClearAction)) {
					undoneComponents.push(components.pop());
				}
				components.clear();

			}else{
				undoneComponents.push(lastAction);
			}
			tellYourBoss();
		}
	}

	public static void redo() {
		if (!undoneComponents.isEmpty()) {
			Component redoAction = undoneComponents.pop();
			components.push(redoAction);
			if (redoAction instanceof ClearAction) {
				components.clear();
			}else{
				tellYourBoss();
			}
		}
	}

	public static void setSelectedShape(Component c) {
		selectedShape = c;

	}

	public static Component getSelectedShape() {
		System.out.println("getSelectedShape" + selectedShape);
		return selectedShape;
	}

	public static void copyShape(Component c) {
		if (c instanceof Shape) {
			shapeCopy = ((Shape) c).copy();
		}
	}

	public static void pasteShape() {
		if (shapeCopy instanceof Shape) {
			Shape newShape = ((Shape)shapeCopy).copy();
			newShape.setX(((Shape)shapeCopy).getX() + COPY_OFFSET);
			newShape.setY(((Shape)shapeCopy).getY() + COPY_OFFSET);
			components.push(newShape);
			tellYourBoss();
		}
	}

	public static void addEyesDecorator(){
		if(selectedShape instanceof Shape){
			selectedShape = new ShapeDecoratorEyes(selectedShape);
			updateStackWithSelectedShape();
			tellYourBoss();
		}
	}

	public static void addMouthDecorator(){
		if(selectedShape instanceof Shape){
			selectedShape = new ShapeDecoratorMouth(selectedShape);
			updateStackWithSelectedShape();
			tellYourBoss();
		}
	}

	public static void addHatDecorator(){
		if(selectedShape instanceof Shape){
			selectedShape = new ShapeDecoratorHat(selectedShape);
			updateStackWithSelectedShape();
			tellYourBoss();
		}
	}

	public static void resetDecorators(){
		if(selectedShape != null){
			while (selectedShape instanceof ShapeDecorator){
				selectedShape = ((ShapeDecorator) selectedShape).getComponent();
			}

			components.removeIf(component -> component instanceof ShapeDecorator);
			components.push(selectedShape);
			tellYourBoss();
		}
	}

	public static void handleShapeClick() {
		clickCount++;
		System.out.println("Click count: " + clickCount);
		System.out.println("Selected shape before click: " + selectedShape);

			if (clickCount == 1) {
				Color newColor = JColorChooser.showDialog(null, "Choose a color", getColor());
				if (newColor != null && selectedShape instanceof Shape) {
					((Shape)selectedShape).setColor(newColor);
					updateStackWithSelectedShape();
					tellYourBoss();
				}
			} else if (clickCount == 2) {
				addEyesDecorator();
			} else if (clickCount == 3) {
				addMouthDecorator();
			} else if (clickCount == 4) {
				addHatDecorator();
			} else {
				resetDecorators();
				clickCount = 0;
				tellYourBoss();
			}
		System.out.println("Selected shape after click: " + selectedShape);
		System.out.println("Stack after click: " + Officer.getComponentsStack());
	}
	private static void updateStackWithSelectedShape() {
		if (!components.isEmpty() && components.peek() == selectedShape) {
			components.pop();
		}
		components.push(selectedShape);
	}
	// Add method to toggle decorators
	public static void toggleDecorator(Component component, Class<? extends ShapeDecorator> decoratorClass) {
		if (component == null) return;
		Component current = component;
		while (current instanceof ShapeDecorator) {
			ShapeDecorator decorator = (ShapeDecorator) current;
			if (decoratorClass.isInstance(decorator)) {
				// Remove the decorator by returning the wrapped component
				Component wrapped = decorator.getComponent();
				components.remove(decorator);
				components.add(wrapped);
				return;
			}
			current = decorator.getComponent();
		}
		// If decorator not found, add new decorator
		try {
			ShapeDecorator newDecorator = decoratorClass.getDeclaredConstructor(Component.class).newInstance(component);
			components.add(newDecorator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
