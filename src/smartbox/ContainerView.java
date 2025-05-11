package smartbox;
import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.util.Iterator;

public class ContainerView extends View {

    private java.awt.List components;

    public ContainerView(Model model) {
        super(model);
        components = new java.awt.List(10);
        this.add(components);
    }

    // etc.


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Container container = (Container)model;
        components.removeAll(); //reset list
        for(Component i : container.getComponents()){   //re-add components
            String componentName = i.toString();
            components.add(componentName);
        }
    }
}
