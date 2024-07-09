package javiergs.gui.paint.gamma;

import javax.swing.*;
import java.awt.*;

public class AboutME {
    public static void show(JFrame parent) {
        JTextArea textArea = new JTextArea(10, 40);
        textArea.setText("PaintApp\n\n" +
                "Author: Nashali Vicente Lopez\n" +
                "Author: Grant Robinson\n" +
                "Author: Veer Bhagia\n\n" +
                "This is a simple paint application created for homework.\n" +
                "You can draw shapes, change colors, and manage files.\n\n" +

                "Instructions:\n"
                + "1. Choose a color from the 'Status' menu.\n"
                + "2. Select a shape from the 'Tool' menu.\n"
                + "3. Click and drag on the drawing area to draw the selected shape.\n"
                + "4. Use 'Undo' and 'Redo' to correct mistakes.\n"
                + "5. Use 'Clear' to clear the drawing area.\n"
                + "6. Use 'Save' to save your drawing to a file.\n"
                + "7. Use 'Load' to load a previously saved drawing.");
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setBackground(new Color(0, 0, 0, 0));
        textArea.setFont(new Font("Serif", Font.PLAIN, 16));

        JOptionPane.showMessageDialog(parent, new JScrollPane(textArea), "About Me", JOptionPane.INFORMATION_MESSAGE);
    }
}
