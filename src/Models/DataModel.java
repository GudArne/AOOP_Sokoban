package Models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class DataModel {
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    // Attach a listener to a class. (The listener will be notified when the property changes)
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public void firePropertyChange(String propertyName) {
        this.propertyChangeSupport.firePropertyChange(propertyName, null, null);
    }
}
