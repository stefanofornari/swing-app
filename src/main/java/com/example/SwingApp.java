package com.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SwingApp {

    public static void main(String[] args) {
        final JFrame frame = new JFrame("Swing App");

        SwingUtilities.invokeLater(() -> {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            JEditorPane editorPane = new JEditorPane();

            // Add a key binding for Ctrl+ENTER
            InputMap inputMap = editorPane.getInputMap(JComponent.WHEN_FOCUSED);
            ActionMap actionMap = editorPane.getActionMap();

            KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK);
            String actionKey = "showPopup";

            inputMap.put(keyStroke, actionKey);
            actionMap.put(actionKey, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "Ctrl+ENTER was pressed!");
                }
            });

            frame.getContentPane().add(editorPane);
            frame.setVisible(true);
        });

        try {
            Thread.sleep(1000);
        } catch (Exception x) {}

        frame.dispose();


    }
}
