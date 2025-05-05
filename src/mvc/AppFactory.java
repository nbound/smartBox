package mvc;

/*
Edits:
    Fadrigon 3/13/25: created file
    Sharma 3/17/25: added code for AppFactory interface
 */

public interface AppFactory {

    Model makeModel();
    View makeView(Model m);
    String getTitle();
    String[] getHelp();
    String about();
    String[] getEditCommands();
    Command makeEditCommand(Model model, String type, Object source);
}