import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ReminderCalendar{

   //Stores all of the Reminders that this calendar handles
   ArrayList<Reminder> reminders;
   //Stores the generated list of reminders for each day
   String[] days;
   //Stores the first day shown on the calendar
      
   //Basic constructor
   ReminderCalendar(){
      reminders = new ArrayList<>();
   };
   
   //Initializes days with the given number of days
   void setLength(int length){
      this.days = new String[length];
   }
   
   void addReminder(Reminder reminder){
      reminders.add(reminder);
   }
   
   //Updates the days array, according to the current reminders and range of days
   void generateCalendar(){
        int dayIndex;
        for(Reminder check : reminders){
            dayIndex = check.getDaysBetween() - check.getOffset();
            while(dayIndex < days.length){
                  days[dayIndex] = check.getVerbString() + (dayIndex + 1) + "\n";
                  dayIndex += check.getDaysBetween();
            }
        }
   }

  String[] getDays(){
      return days;
   }
   
}