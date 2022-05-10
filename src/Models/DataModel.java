package Models;

import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DataModel {

    String direction;
    ArrayList<ChangeListener> listeners;

       /**
      Constructs a DataModel object
      @param d the data to model
   */
   public DataModel(String direction)
   {
      this.direction = direction;
      listeners = new ArrayList<ChangeListener>();
   }

   /**
      Constructs a DataModel object
      @return the data in an ArrayList
   */
   public String getData()
   {
      return direction;
   }

   /**
      Attach a listener to the Model
      @param c the listener
   */
   public void attach(ChangeListener c)
   {
      listeners.add(c);
   }

   /**
      Change the data in the model at a particular location
      @param location the index of the field to change
      @param value the new value
   */
   public void update(String value)
   {
        ChangeEvent e = new ChangeEvent(this);
        direction = value;
        for (ChangeListener l : listeners){
            l.stateChanged(new ChangeEvent(this));
        }
   }


    
}
