import java.util.Date;
import java.util.ArrayList;

public class Plant implements Reminder{
   private String name;
   private String verb;
   private int daysBetweenWater;

    //Return array of dates between start and end in which the plant must be watered
    //Pass Date objects such that they are both at the same time of day; time of day does not matter, otherwise
    public Date[] getDates(Date start, Date end){
      ArrayList<Date> dates = new ArrayList<>();
      //For every day between start and end, including start and end
      while(start.getTime() <= end.getTime()){
         dates.add(start);
         //Offset time to next watering day
         start.setTime(start.getTime() + daysBetweenWater * 86400000);
      }
      return dates.toArray(new Date[dates.size()]);
    }
    
    //Return the name of the plant
    public String getNameString(){
      return name;
    }
    
    //Return "Water " + getNameString()
    public String getVerbString(){
      return "Water " + name;
    }
    
}