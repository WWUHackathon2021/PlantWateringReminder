import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.io.FileWriter;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import java.util.Calendar;
import java.io.IOException;
import java.io.FileNotFoundException;
import org.json.simple.parser.ParseException;

public class ReminderCalendar{

   //Stores all of the Reminders that this calendar handles
   ArrayList<Reminder> reminders;
   //Stores the generated list of reminders for each day
   String[][] days;
   //Stores the current date
   GregorianCalendar today;
   
   //Basic constructor
   ReminderCalendar(){
      reminders = new ArrayList<>();
      //The GregorianCalendar constructor sets its parameters to the current time
      today = new GregorianCalendar();
   }
   
   //Initializes days with the given number of days
   void setLength(int length){
      this.days = new String[length][2];
   }
   
   //Adds a reminder to the calendar
   void addReminder(Reminder reminder){
      reminders.add(reminder);
   }
   
   void updateOffsets(GregorianCalendar currentDay){
      //If same year, simply increment offset by difference in days
      //If different year, increment offset by difference in days (can be negative) + number of days from years, including leap years
      int lastYear = today.get(GregorianCalendar.YEAR);
      int days = currentDay.get(GregorianCalendar.DAY_OF_YEAR) - today.get(GregorianCalendar.DAY_OF_YEAR);
      while(lastYear != today.get(GregorianCalendar.YEAR)){
         days += 365;
         if(lastYear % 4 == 0 && (lastYear % 100 != 0 || lastYear % 100 == 0)){
            days++;
         }
      }
      incrementOffsets(days);
      today = currentDay;
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
                  days[dayIndex][1] = (days[dayIndex][1] != null ? days[dayIndex][1] : "") + check.getVerbString() + ", ";
                  dayIndex += check.getDaysBetween();
            }
        }
        GregorianCalendar temp = (GregorianCalendar)today.clone();
        for(int i = 0; i < days.length; i++){
           if(days[i][1] != null) days[i][1] = days[i][1].substring(0, days[i][1].length()-2);
           days[i][0] = temp.get(GregorianCalendar.DAY_OF_YEAR) + "";
           temp.add(GregorianCalendar.DAY_OF_YEAR, 1);
        }
   }

   //Saves data to JSON.
   void saveData(){
      JSONObject saveFile = new JSONObject();
      JSONArray plantArray = new JSONArray();
      JSONObject date = dateObject();
      for(Reminder plant : reminders){
         plantArray.add(plantObject(plant));
      }
      saveFile.put("date", date);
      saveFile.put("plants", plantArray);
      try (FileWriter file = new FileWriter("save.json")) {
         file.write(saveFile.toJSONString()); 
         file.flush();

     } catch (IOException e) {
         e.printStackTrace();
     }
   }
   
   void loadData(){
      JSONParser parser = new JSONParser();
      try(FileReader reader = new FileReader("save.json")){
         JSONObject in = (JSONObject)parser.parse(reader);
         JSONArray reminderArray = (JSONArray)in.get("plants");
         JSONObject date = (JSONObject)in.get("date");
         reminders = new ArrayList<>();
         for(Object check : reminderArray){
            JSONObject check2 = (JSONObject)check;
            reminders.add(new Plant((String)check2.get("name"), (int)(long)check2.get("interval"), (int)(long)check2.get("offset"), (int)(long)check2.get("icon")));
         }
         updateOffsets(new GregorianCalendar((int)(long)date.get("year"), (int)(long)date.get("month"), (int)(long)date.get("day")));
      } catch(IOException | ParseException e){
         e.printStackTrace();
      }
   }

   // NAME:        plantObject
   // INPUTS:      An instance of the Plant class, and an integer plantID
   // OUTPUT:      A JSONObject containing the plant's info
   // DESCRIPTION: Returns a JSONObject with a plant's data and integer plantID to it
 
   JSONObject plantObject(Reminder plant){
      JSONObject thisObject = new JSONObject();
      thisObject.put("name", plant.getNameString());
      thisObject.put("interval", plant.getDaysBetween());
      thisObject.put("offset", plant.getOffset());
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

   String[][] getDays(){
      return days;
   }
    
   GregorianCalendar getToday(){
      return today;
   }
   
   ArrayList<Reminder> getReminders(){
      return reminders;
   }
   
}