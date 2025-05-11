package smartbox;

import mvc.*;

import javax.swing.*;

public class RunCommand extends Command {
    String componentName;
    public RunCommand(Model model){
        super(model);
        componentName = "";
    }
    public void execute() throws Exception {
        Container container = (Container)model;
        componentName = JOptionPane.showInputDialog(null, "Component name?");
        container.launch(componentName);
    }
}
