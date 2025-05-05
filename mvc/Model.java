package mvc;

/*
Edits:
    Fadrigon 3/13/25: created file
    Sharma 3/17/25: added code for Model abstract class
 */

public abstract class Model extends Publisher{
    private boolean unsavedChanges;
    private String fileName;
    public Model() {
        this.unsavedChanges = false;
        this.fileName = null;
    }
    public void changed(){
        unsavedChanges = true;
        notifySubscribers();
    }
    public void setUnsavedChanges(boolean uc){
        this.unsavedChanges = uc;
    }
    public boolean getUnsavedChanges(){
        return unsavedChanges;
    }
    public void setFileName(String name){
        fileName = name;
    }
    public String getFileName(){
        return fileName;
    }


}