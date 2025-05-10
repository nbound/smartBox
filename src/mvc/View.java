package mvc;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class View extends JPanel implements Subscriber {

    protected Model model;
    // static public Dimension dim;

    public View(Model model) {
        super();
        this.model = model;
        model.subscribe(this);
        // optional border around the view component
        setBorder(LineBorder.createGrayLineBorder());//.createBlackLineBorder());
    }

    public Model getModel() { return model; }

    // called by File/Open and File/New
    public void setModel(Model newModel) {
        if (model != null) model.unsubscribe(this);
        this.model = newModel;
        if (newModel != null) {
            model.subscribe(this);
            update();
        }
    }
    @Override
    public void update() {
        this.repaint();
    }


}