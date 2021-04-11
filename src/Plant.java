import java.util.ArrayList;

public class Plant implements Reminder{
   //Name of plant
   private String name;
   //Type of plant
   private String type;
   //Days between watering
   private int daysBetweenWater;
   //Days since last time reminder triggered
   //0 = today/never/etc. 1 = yesterday, so on
   private int offset;
   //ID of icon
   private int icon;

   //Basic constructor
   Plant(String name, String type, int daysBetweenWater, int offset, int icon){
      this.name = name;
      this.type = type;
      this.daysBetweenWater = daysBetweenWater;
      this.offset = offset;
      this.icon = icon;
   }
    
   //Offset functions
   
   public void incrementOffset(){
      offset = (offset + 1) % daysBetweenWater;
   }
   
   public void setOffset(int offset){
      this.offset = offset % daysBetweenWater;
   }
   
   //Get functions
   
   public String getNameString(){
     return name;
   }
    
   public String getVerbString(){
     return "Water " + name;
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

   public String getType() {return type;}
}