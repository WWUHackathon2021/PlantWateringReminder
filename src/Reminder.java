import java.util.GregorianCalendar;

interface Reminder{
    //Return the name of the reminder, like "Roses" or "Dog"
    String getNameString();
    //Return what is actually displayed in the calendar, like "Water roses" or "Feed dog"
    String getVerbString();
    //Returns the amount of days between the reminder's occurences
    int getDaysBetween();
    //Returns the current value of offset
    int getOffset();
}