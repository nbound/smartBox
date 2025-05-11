package smartbox;
import java.awt.*;
import java.beans.PropertyChangeEvent;

import javax.swing.*;
import mvc.*;

public class ContainerPanel extends AppPanel {
    java.awt.List components;
    public ContainerPanel(AppFactory factory) {
        // set up controls
        super(factory);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);

        JButton add = new JButton("Add");
        JButton rem = new JButton("Rem");
        JButton run = new JButton("Run");

        GridLayout layout = new GridLayout(3,1);
        layout.setVgap(10);
        p.setLayout(layout);

        add.addActionListener(this);
        rem.addActionListener(this);
        run.addActionListener(this);

        p.add(add);
        p.add(rem);
        p.add(run);

        controlPanel.add(p);
    }

    // this override needed to re-initialize component fields table:
    public void setModel(Model m) {
        super.setModel(m);
        ((Container) m).initContainer(); // restore fields of components
    }

    public static void main(String[] args) {
        AppPanel panel = new ContainerPanel(new ContainerFactory());
        panel.display();
    }
}