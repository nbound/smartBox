package mvc;

/*
Edits:
    Fadrigon 3/13/25: created file
    Fadrigon 3/16/25: changed to abstract class, added private model pointer, added Command() constructor, added abstract method execute()
    Fadrigon 3/17/25: model pointer changed from private to protected
 */

public abstract class Command {
    protected Model model;
    public Command(Model model){
        this.model = model;
    }

    abstract public void execute();
}
