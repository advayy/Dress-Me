package ui;

import model.Event;

import javax.swing.*;

// Special JFrame class to have a log on dispose
public class MainJFrame extends JFrame {
    DressMeApp backUI;

    public MainJFrame(DressMeApp backUI) {
        super();
        this.backUI = backUI;
    }

    @Override
    //
    public void dispose() {
        for (Event next: this.backUI.getUserWardrobe().getLog()) {
            System.out.println(next.toString());
        }
        super.dispose();
    }
}
