package mvc;

/*
Edits:
    Fadrigon 3/13/25: created file
    Fadrigon 3/16/25: added model pointer, created View constructor that subscribes View to model, created View update() method, added comment line 17
    Fadrigon 3/17/25: added setModel() method to unassign old model and reassign new one, model pointer changed from private to protected
 */

import javax.swing.*;

public class View extends JPanel implements Subscriber{
    protected Model model;
    public View(Model model){
        this.model = model;
        this.model.subscribe(this);
    }
    public void update() {
        repaint();
    }

    public void setModel(Model newModel){
        this.model.unsubscribe(this);
        this.model = newModel;
        this.model.subscribe(this);
    }
}
