import java.util.GregorianCalendar;

interface Reminder{
    //Return the name of the reminder, like "Roses" or "Dog"
    String getNameString();
    //Return what is actually displayed in the calendar, like "Water roses" or "Feed dog"
    String getVerbString();
    //Increments the value of offset
    void incrementOffset();
    //Returns the amount of days between the reminder's occurences
    int getDaysBetween();
    //Sets the value of offset (value of offset must be less than value of getDaysBetween, but the function will
    //handle numbers larger than this
    void setOffset(int offset);
    //Returns the current value of offset
    int getOffset();
    //Returns the type of icon this Reminder uses
    int getIcon();
}