import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.io.FileWriter;
import org.json.simple.JSONObject;
import java.util.Calendar;

public class ReminderCalendar{

   //Stores all of the Reminders that this calendar handles
   ArrayList<Reminder> reminders;
   //Stores the generated list of reminders for each day
   String[] days;
   //Stores the current date
   GregorianCalendar today;
   
   //Basic constructor
   ReminderCalendar(){
      reminders = new ArrayList<>();
      today = new GregorianCalendar();
   };
   
   //Initializes days with the given number of days
   void setLength(int length){
      this.days = new String[length];
   }
   
   //Adds a reminder to the calendar
   void addReminder(Reminder reminder){
      reminders.add(reminder);
   }
   
   //Increments the offset of each reminder by increment
   void incrementOffsets(int increment){
      for(Reminder check : reminders){
         check.setOffset(check.getOffset() + increment);
      }
   }
   
   //Updates the days array, according to the current reminders and range of days
   void updateDays(){
        int dayIndex;
        for(Reminder check : reminders){
            dayIndex = check.getDaysBetween() - check.getOffset();
            while(dayIndex < days.length){
                  days[dayIndex] = (days[dayIndex] != null ? days[dayIndex] : "") + check.getVerbString() + "\n";
                  dayIndex += check.getDaysBetween();
            }
        }
   }

   //Saves data to JSON.
   void saveData(){
      JSONObject saveFile = new JSONObject();
      JSONArray plantArray = new JSONArray();
      int plantID = 0;
      for(Reminder plant : reminders){
         plantArray.add(plantObject(plant, plantID));
         plantID++;
      }
      saveFile.put("date", dateObject);
      saveFile.put("plants", plantArray);


   }

   // NAME:        plantObject
   // INPUTS:      An instance of the Plant class, and an integer plantID
   // OUTPUT:      A JSONObject containing the plant's info
   // DESCRIPTION: Returns a JSONObject with a plant's data and integer plantID to it
 
   JSONObject plantObject(Reminder plant, int plantID){
      JSONObject thisObject = new JSONObject();
      thisObject.put("id", plantID);
      thisObject.put("name", plant.getNameString());
      thisObject.put("interval", plant.getDaysBetween());
      thisObject.put("icon", plant.getIcon());
      return thisObject;
   }
   
   JSONObject dateObject(){
      JSONObject thisObject = new JSONObject();
      thisObject.put("year", today.get(Calendar.YEAR));
      thisObject.put("month", today.get(Calendar.MONTH));
      thisObject.put("day", today.get(Calendar.DAY_OF_MONTH));
      return thisObject;
   }


   //Get functions

   String[] getDays(){
      return days;
   }
    
   GregorianCalendar getToday(){
      return today;
   }
   
   ArrayList<Reminder> getReminders(){
      return reminders;
   }
   
}