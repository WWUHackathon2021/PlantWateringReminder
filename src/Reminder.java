import java.util.GregorianCalendar;

interface Reminder{
    //Return the name of the reminder, like "Roses" or "Dog"
    String getNameString();
    //Return what is actually displayed in the calendar, like "Water roses" or "Feed dog"
    String getVerbString();
    //Return an array of Calendar objects between the start date and the end date, also given as Calendar objects
    GregorianCalendar[] getDates(GregorianCalendar start, GregorianCalendar end);
    //Returns whether or not the particulary type of reminder is daily, or if time of day matters
    boolean isDaily();
}