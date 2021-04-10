import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Plant implements Reminder{
   private String name;
   private String verb;
   private int daysBetweenWater;

   //Basic constructor
   Plant(String name, int daysBetweenWater){
      this.name = name;
      this.daysBetweenWater = daysBetweenWater;
   }

    //Return array of dates between start and end in which the plant must be watered
    //Since isDaily() == false, make sure that end is later in the day than start, otherwise
    //end will not be included in the dates, even if it should be
    public GregorianCalendar[] getDates(GregorianCalendar start, GregorianCalendar end){
      ArrayList<GregorianCalendar> dates = new ArrayList<>();
      //For every day between start and end, including start and end
      while(start.getTime().before(end.getTime())){
         dates.add(start);
         start = (GregorianCalendar)start.clone();
         //Offset time to next watering day
         start.add(GregorianCalendar.DATE, daysBetweenWater);
      }
      return dates.toArray(new GregorianCalendar[dates.size()]);
    }
    
    //Return the name of the plant
    public String getNameString(){
      return name;
    }
    
    //Return "Water " + getNameString()
    public String getVerbString(){
      return "Water " + name;
    }
    
    //Return false, because plant watering is not given a specific time of day
    public boolean isDaily(){
      return false;
    }
    
}