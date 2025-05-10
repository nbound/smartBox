package smartbox;

import java.util.*;
import java.io.Serializable;
import java.lang.reflect.*;

public class Component implements Serializable {

    private Set<Class<?>> requiredInterfaces;
    private Set<Class<?>> providedInterfaces;
    private transient Map<Class<?>, Field> fields; // transient because Field not serializable
    protected Container container;
    protected String name;

    public Component() {
        fields = new HashMap<Class<?>, Field>();
        providedInterfaces = new HashSet<Class<?>>();
        requiredInterfaces = new HashSet<Class<?>>();
        computeRequiredInterfaces();
        computeProvidedInterfaces();
        container = null;
        name = this.getClass().getSimpleName();
    }

    // add needed getters & setters

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Container getContainer() { return container; }
    public void setContainer(Container container) { this.container = container; }
    public Map<Class<?>, Field> getFields() { return fields; }
    public void setFields(Map<Class<?>, Field> fields) { this.fields = fields; }
    public Set<Class<?>> getProvidedInterfaces() { return providedInterfaces; }
    public void setProvidedInterfaces(Set<Class<?>> providedInterfaces) { this.providedInterfaces = providedInterfaces; }
    public Set<Class<?>> getRequiredInterfaces() { return requiredInterfaces; }
    public void setRequiredInterfaces(Set<Class<?>> requiredInterfaces) { this.requiredInterfaces = requiredInterfaces; }
    public String toString() { return name; }

    // initializes fields and requiredInterfaces
    public void computeRequiredInterfaces() {
        Field[] fieldArray = this.getClass().getDeclaredFields();
        for(int i = 0; i < fieldArray.length; i++) {
            //if the type of field[i] is an interface, then add it to fields and requiredInterfaces ???
            Class<?> c = fieldArray[i].getType();
            if(c.isInterface()){
                fields.put(c, fieldArray[i]);
                requiredInterfaces.add(c);
            }
        }
    }

    // initializes provided interfaces
    public void computeProvidedInterfaces() {
        // get interfaces implemented by the class of this component and add them to providedInterfaces
        providedInterfaces.addAll(Arrays.asList(this.getClass().getInterfaces()));
    }

    // set the field of this object to the provider
    public void setProvider(Class<?> intf, Component provider) throws Exception {
        Field field = fields.get(intf);
        field.set(this, provider); // field probably needs to be public for this.
    }

    // needed by file/open
    public void initComponent() {
        fields = new HashMap<Class<?>, Field>();
        computeProvidedInterfaces();
        computeRequiredInterfaces();
    }
}
