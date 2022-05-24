package Models;

import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DataModel {

   private String direction;
   private ArrayList<ChangeListener> listeners;

   // Constructs a DataModel object
   public DataModel(String direction){
      this.direction = direction;
      listeners = new ArrayList<ChangeListener>();
   }

   // Returns the data (direction)
   public String getData(){
      return direction;
   }

   // Attach a listener to the Model
   public void attach(ChangeListener c){
      listeners.add(c);
   }

   // Notify all listeners of a change
   public void update(String value){
      direction = value;
      for (ChangeListener l : listeners){
         l.stateChanged(new ChangeEvent(this));
      }
   }

}
