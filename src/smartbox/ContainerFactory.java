package smartbox;

import mvc.*;

public class ContainerFactory implements AppFactory {
    @Override
    public Model makeModel() {
        return new Container();
    }

    @Override
    public View makeView(Model m) {
        return new ContainerView((Container)m);
    }

    @Override
    public String getTitle() {
        return "Container";
    }

    @Override
    public String[] getHelp() {
        return new String[] {"help"};
    }

    @Override
    public String about() {
        return "SmartBox Container";
    }

    @Override
    public String[] getEditCommands() {
        return new String[0];
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        return switch (type){
            case "Add" -> new AddCommand(model);
            case "Rem" -> new RemCommand(model);
            case "Run" -> new RunCommand(model);
            default -> null;
        };
    }
}
