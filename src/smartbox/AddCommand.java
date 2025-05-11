package smartbox;

import mvc.*;

import javax.swing.*;

public class AddCommand extends Command {
    String componentName;
    public AddCommand(Model model){
        super(model);
        componentName = "";
    }

    public void execute() throws Exception {
        Container container = (Container)model;
        componentName = JOptionPane.showInputDialog(null, "Component name?");
        container.addComponent(componentName);
    }
}
