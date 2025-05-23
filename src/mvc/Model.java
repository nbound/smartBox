package mvc;

import java.io.Serializable;

public abstract class Model extends Publisher implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fileName = null;
    private Boolean unsavedChanges = false;
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public Boolean getUnsavedChanges() {
        return unsavedChanges;
    }
    public void setUnsavedChanges(Boolean unsavedChanges) {
        this.unsavedChanges = unsavedChanges;
    }

    public void changed() {
        unsavedChanges = true;
        notifySubscribers();
    }

}