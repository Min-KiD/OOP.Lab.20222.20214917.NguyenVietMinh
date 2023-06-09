package test;

// Nguyen Viet Minh 20214917

import java.awt.*;
import java.awt.event.*;

public class MouseEventDemo extends Frame implements MouseMotionListener, WindowListener {
    private TextField tfMouseX;
    private TextField tfMouseY; 
    private TextField tfXPosition; 
    private TextField tfYPosition; 

    public MouseEventDemo() {
        setLayout(new FlowLayout());

        add(new Label("X-Click: "));
        tfMouseX = new TextField(10); 
        tfMouseX.setEditable(false);
        add(tfMouseX);

        add(new Label("Y-Click: "));
        tfMouseY = new TextField(10);
        tfMouseY.setEditable(false);
        add(tfMouseY);

        add(new Label("X-Position: "));
        tfXPosition = new TextField(10);
        tfXPosition.setEditable(false);
        add(tfXPosition);

        add(new Label("Y-Position: "));
        tfYPosition = new TextField(10);
        tfYPosition.setEditable(false);
        add(tfYPosition);

        MyMouseListener myMouseListener = new MyMouseListener();
        addMouseListener(myMouseListener); 

        addWindowListener(this);
        addMouseMotionListener(this); 

        setTitle("MouseEvent Demo");
        setSize(400, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MouseEventDemo(); 
    }

    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            tfMouseX.setText(e.getX() + "");
            tfMouseY.setText(e.getY() + "");
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        tfXPosition.setText(e.getX() + "");
        tfYPosition.setText(e.getY() + "");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Not used 
    }
    
    // WindowListener 
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0); 
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
}