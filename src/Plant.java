import java.util.ArrayList;

public class Plant implements Reminder{
   private String name;
   private int daysBetweenWater;
   //Days since last time reminder triggered
   private int offset;
   private int icon;

   //Basic constructor
   Plant(String name, int daysBetweenWater, int offset, int icon){
      this.name = name;
      this.daysBetweenWater = daysBetweenWater;
      this.offset = offset;
      this.icon = icon;
   }
    
   //Return the name of the plant
   public String getNameString(){
     return name;
   }
    
   //Return "Water " + getNameString()
   public String getVerbString(){
     return "Water " + name;
   }
   
   public void incrementOffset(){
      offset = (offset + 1) % daysBetweenWater;
   }
   
   public void setOffset(int offset){
      this.offset = offset % daysBetweenWater;
   }
   
   public int getDaysBetween(){
     return daysBetweenWater;
   }
    
   public int getOffset(){
     return offset;
   }
   
   public int getIcon(){
      return icon;
   }
}