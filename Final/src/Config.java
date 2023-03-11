import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Config {
    HashMap<String,String> confgis = new HashMap<>();
    public Config(){
        loadConfig();
    }

    public String getString(String key){
        String value = confgis.get(key);
        if(value != null){
            return value;
        }
        return null;
    }

    public int getInt(String key){
        String value = confgis.get(key);
        if(value != null){
            return Integer.valueOf(value);
        }
        return 0;
    }

    public boolean getBoolean(String key){
        String value = confgis.get(key);
        if(value != null){
            return value.equals("true");
        }
        return true;
    }

    public void loadConfig(){
        try {
            Scanner sc = new Scanner(new File("myconfig.txt"));
            while (sc.hasNext()){
                String line = sc.nextLine();
                String data[] = line.split(":");
                confgis.put(data[0].trim(),data[1].trim());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void save(){
        String out = "";
        for(String key : confgis.keySet()){
            out += key+": "+confgis.get(key)+"\n";
        }
        out = out.trim();
        try {
            FileWriter fw = new FileWriter(new File("myconfig.txt"));
            fw.write(out);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
