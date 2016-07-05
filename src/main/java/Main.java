import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.lang.Thread;


public class Main {

    private static SmartHome mySmartHome;
    private static AirConditioner airConditioner;
    private static CookingOven cookingOven;
    private static WaterHeater waterHeater;
    private static BufferedReader br;
    
    public static void readFile() {
        try {
            br = new BufferedReader(new FileReader("/projects/assignment02/src/main/input.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
               // process the line
               List<String> items = Arrays.asList(line.split(" "));
               
               // Line must have 3 space-separated or comma-separated inputs
               if(items.size() < 3) {
                   //System.out.println(line);
                   //break;
                   //System.out.println("Size = " + items.size());
                   //System.out.println("Inside < 3 if. Continuing...");
                   continue;
               }
               
               String applianceName = items.get(0);
               String statusString = items.get(1);
               Status status;
               if(statusString.equals("ON")) {
                   status = Status.ON;
               } else {
                   status = Status.OFF;
               }
               String timeString = items.get(2);
               Integer time = Integer.parseInt(timeString);
               
               Event event = new Event(status, time);
               
               if(applianceName.contains("AC")) {
                   // add event to eventQueue of AirConditioner
                   System.out.println("READ: AC");
                   System.out.println(event.getStatus());
                   System.out.println(event.getTime());
                   System.out.println("=========");
                   airConditioner.addEvent(event);
               } else if(applianceName.contains("OVEN")) {
                   // add event to eventQueue of CookingOven
                   cookingOven.addEvent(event);
               } else if(applianceName.contains("WH")) {
                   // add event to eventQueue of WaterHeater
                   waterHeater.addEvent(event);
               } else {
                   // Unrecognized appliance in input
                   System.out.println("Unknown appliance: " + applianceName);
                   
               }
               
            }
        }

        catch(IOException e) { // Handle IO Exception
            System.out.println(e.getMessage());
        }
        
        finally {
            

        }
    }
    
    public static SmartHome getSmartHome() {
        return mySmartHome;
    }
    
    public static void simulate() {
        
        try {
            mySmartHome.printStatus();
            while(true) {
                mySmartHome.incrementTimer();
                if(mySmartHome.eventChange()) {
                    mySmartHome.printStatus();    
                }
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e) {
            // handle InterruptedException
        }
    }

    public static void main(String[] args) {
        // create instance of smart home
        mySmartHome = new SmartHome();
        
        // create instance of appliance 1
        airConditioner = new AirConditioner();
        
        // create instance of appliance 2
        cookingOven = new CookingOven();
        
        // create instance of appliance 3
        waterHeater = new WaterHeater();
        
        // add all appliances to smart home instance
        mySmartHome.addAppliance(airConditioner);
        mySmartHome.addAppliance(cookingOven);
        mySmartHome.addAppliance(waterHeater);
        
        // read commands from file and events to respective queues
        readFile();
        
        // start time ticker
        simulate();
    }
    

}
