package smartbox;

import mvc.*;

import javax.swing.*;

public class RemCommand extends Command{
    String componentName;
    public RemCommand(Model model){
        super(model);
        componentName = "";
    }
    public void execute() throws Exception {
        Container container = (Container)model;
        componentName = JOptionPane.showInputDialog(null, "Component name?");
        container.remComponent(componentName);
    }
}
