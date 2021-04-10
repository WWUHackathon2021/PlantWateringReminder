import java.util.Date;

interface Reminder{
    //Return the name of the reminder, like "Roses" or "Dog"
    String getNameString();
    //Return what is actually displayed in the calendar, like "Water roses" or "Feed dog"
    String getVerbString();
    //Return an array of Date objects between the start date and the end date, also given as Date objects
    Date[] getDates(Date start, Date end);
}