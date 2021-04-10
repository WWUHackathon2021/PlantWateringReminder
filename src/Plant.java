import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Plant implements Reminder{
   private String name;
   private String verb;
   private int daysBetweenWater;
   //Days since last time reminder triggered
   private int offset;

   //Basic constructor
   Plant(String name, int daysBetweenWater, int offset){
      this.name = name;
      this.daysBetweenWater = daysBetweenWater;
      this.offset = offset;
   }
    
   //Return the name of the plant
   public String getNameString(){
     return name;
   }
    
   //Return "Water " + getNameString()
   public String getVerbString(){
     return "Water " + name;
   }
   
   public int getDaysBetween(){
     return daysBetweenWater;
   }
    
   public int getOffset(){
     return offset;
   }
    
    /*    
    //Returns the number of times the plant must be watered between start and end
    //Highly recommended to pass start with a time set to midnight (or just after), and
    //end with a time set to just before midnight
    //Also, the value of start should align with the value of offset
    //If the plant was watered the day before offset, then offset should be 1, for example
    public int getDates(GregorianCalendar start, GregorianCalendar end){
      int out = 0;
      start.add(GregorianCalendar.DATE, offset);
      //Terminates when start is after end
      while(!start.getTime().after(end.getTime())){
         //Increment out
         out++;
         //Offset time to next watering day
         start.add(GregorianCalendar.DATE, daysBetweenWater);
      }
      return out;
    }
    */
    
}