package inactiveClasses;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

public class ReaderJSONFile {

    public static int cCounter = 0;

    public static void main(String[] args) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();

        FileReader reader = new FileReader("FileCities.json");

        Object object = jsonParser.parse(reader);

        JSONObject empJsonobj = (JSONObject) object;


        String fName = (String) empJsonobj.get("Name" + (++cCounter));
        //String test = (String) empJsonobj.get("Test");
        /*
        String fId = (String) empJsonobj.get("id");
        String fCode = (String) empJsonobj.get("code");
        String fTimezone = (String) empJsonobj.get("cod");
        String fVisibility = (String) empJsonobj.get("visibilty");
        String fDt = (String) empJsonobj.get("dt");

        Array fCoord = (Array) empJsonobjArray.get(Integer.parseInt("coord"));
        Array fWeather = (Array) empJsonobjArray.get(Integer.parseInt("weather"));
        Array fWind = (Array) empJsonobjArray.get(Integer.parseInt("wind"));
        Array fClouds = (Array) empJsonobjArray.get(Integer.parseInt("clouds"));
        Array fSys = (Array) empJsonobjArray.get(Integer.parseInt("sys"));
         */

        JSONObject fMain = (JSONObject) empJsonobj.get("Main" + cCounter);
        double temp = Double.parseDouble(String.valueOf(fMain.get("temp" + cCounter)));
        double feels_like = Double.parseDouble(String.valueOf(fMain.get("feels_like" + cCounter)));
        double temp_min = Double.parseDouble(String.valueOf(fMain.get("temp_min" + cCounter)));
        double temp_max = Double.parseDouble(String.valueOf(fMain.get("temp_max" + cCounter)));


        System.out.println("Current kind of temperature of " + fName + ":");
        //System.out.println("--> Test: " + test);
        System.out.println("--> temp: " + temp);
        System.out.println("--> feels_like: " + feels_like);
        System.out.println("--> temp_min: " + temp_min);
        System.out.println("--> temp_max: " + temp_max);

        //--> Secondo giro

        fName = (String) empJsonobj.get("Name" + (++cCounter));

        fMain = (JSONObject) empJsonobj.get("Main" + cCounter);
        temp = Double.parseDouble(String.valueOf(fMain.get("temp" + cCounter)));
        feels_like = Double.parseDouble(String.valueOf(fMain.get("feels_like" + cCounter)));
        temp_min = Double.parseDouble(String.valueOf(fMain.get("temp_min" + cCounter)));
        temp_max = Double.parseDouble(String.valueOf(fMain.get("temp_max" + cCounter)));


        System.out.println("Current kind of temperature of " + fName + ":");
        //System.out.println("--> Test: " + test);
        System.out.println("--> temp: " + temp);
        System.out.println("--> feels_like: " + feels_like);
        System.out.println("--> temp_min: " + temp_min);
        System.out.println("--> temp_max: " + temp_max);


        reader.close();

    }
}


//--> Vecchia classe
/*
 public class CreatingJSONDocument {

     public static int cityCounter = 0;
     private final AtomicLong counter = new AtomicLong();

     public void fileWriter(String name, double temp, double feels_like, double temp_min, double temp_max) throws IOException {

         //--> STATS/FILTRI su base oraria
         //--> metodo da fare con attenzione (WORK IN PROGRES)

         //--> Incremento cityCounter ad ogni chiamata del metodo
         ++cityCounter;

         LocalDateTime myDateObj = LocalDateTime.now();
         DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
         String formattedDate = myDateObj.format(myFormatObj);

         JSONObject citiesObj = new JSONObject();
         citiesObj.put("Name_" + cityCounter, name);
         citiesObj.put("Time_" + cityCounter, formattedDate);

         JSONObject listOfTemps = new JSONObject();
         listOfTemps.put("temp_" + cityCounter, temp);
         listOfTemps.put("feels_like_" + cityCounter, feels_like);
         listOfTemps.put("temp_min_" + cityCounter, temp_min);
         listOfTemps.put("temp_max_" + cityCounter, temp_max);

         citiesObj.put("Main_" + cityCounter, listOfTemps);

         //ObjectMapper mapper = new ObjectMapper();//--> legato al metodo secondario sottostante

         try {
             // Writing a file
             File file = new File("FileCities.json");
             BufferedWriter bufferedWriter = null;
             if (!file.exists()) {
                 file.createNewFile();
                 System.out.println("JSON file created:");
                 System.out.println("");
             }

             /*
              //--> Metodo alternativo per la scrittura dei dati nel file JSON
             // Create JSON
             final String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(citiesObj.toJSONString());
             // Content is appended (due to StandardOpenOption.APPEND)
             Files.write(new File("FileCities.json").toPath(), Arrays.asList(json), StandardOpenOption.APPEND);
             System.out.print(citiesObj);
 /*
             bufferedWriter = new BufferedWriter(new FileWriter(new File("FileCities.json"), true));
             bufferedWriter.write(MessageFormat.format("{0}\n", citiesObj.toJSONString()));
             bufferedWriter.close();
             //System.out.println();
             //System.out.println("--> File updated successfully.");

         } catch (IOException e) {
             System.out.println("ERROR");
             System.out.println("--> File not updated");
             e.printStackTrace();
         }
     }
 }
*/

//--> Classe originaria
/*
public class CreatingJSONDocument {
    public static void main(String args[]) {

        //Creating a JSONObject object
        JSONObject jsonObject = new JSONObject();

        //Inserting key-value pairs into the json object
        jsonObject.put("ID", "1");
        jsonObject.put("First_Name", "Shikhar");
        jsonObject.put("Last_Name", "Dhawan");
        jsonObject.put("Date_Of_Birth", "1981-12-05");
        jsonObject.put("Place_Of_Birth", "Delhi");
        jsonObject.put("Country", "India");
        try {
            FileWriter file = new FileWriter(".\\JsonFile\\Cities.json");
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("JSON file created: "+jsonObject);
    }
}
*/
