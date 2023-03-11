

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Control {
    String verify;
    HashMap<String, String> accouts = new HashMap<>();
    Config config;
    DataManager dataManager;

    public Control() {
        config = new Config();
        this.getLoginInfo();
        this.loadVerify();
    }

    public void loadVerify() {
        this.verify = this.getVerify();
    }

    public void loadAllData() {
        dataManager = new DataManager();
        dataManager.config = config;
        dataManager.load();
    }

    public void doMainMenu() {
        doMainMenu(true);
    }
    
    public static HashMap<String,String> SetConfigMap(){
        HashMap<String,String> map = new HashMap<>();
        File configfile = new File("myconfig.txt");
        map.put("verify_string:",null);
        map.put("used_last_id:",null);
        map.put("show_sort_property:","id");
        map.put("show_sort_order:","acs");
        map.put("show_name:","true");
        map.put("show_phone:","true");
        map.put("show_catalog:","true");
        map.put("show_email:","true");
        map.put("show_birthday:","true");
        map.put("show_defalt_perpage:","5");
        return map;
    }

    public void doMainMenu(boolean showMainMenu) {
        if (showMainMenu) {
            System.out.println("****************************************\n" +
                    "[1].Show_all [2].Show_per_page [3].Show_by_catalog\n" +
                    "[4].Search [5].Modify [6].Delete [7].Add_contact\n" +
                    "[8].Add_catalog [9].Show_all_catalog [10].Set_display_field\n" +
                    "[11].Set_show_perpage [12].Set_order [13].Set_sort_by_field\n" +
                    "[14].Show_raw_data [15].Data_optimize [99].Exit_system\n" +
                    "****************************************\n");
        }
        int code = -1;
        try {
            code = Integer.valueOf(Main.scanner.nextLine());
        } catch (Exception e) {
        }
        boolean submenu = true;
        switch (code) {
            case 1:
                doShowAll();
                break;
            case 2:
                doShowPerPage();
                submenu = false;
                break;
            case 3:
                doShowByCatalog();
                submenu = false;
                break;
            case 4:
                doSearch();
                submenu = false;
                break;
            case 5:
                doModify();
                break;
            case 6:
                doDelete();
                break;
            case 7:
                doAddContact();
                break;
            case 8:
                doAddCatalog();
                break;
            case 9:
                doShowAllCatalog();
                break;
            case 10:
                doSetDisplayField();
                break;
            case 11:
                doSetViewPerpage();
                break;
            case 12:
                doSetOrder();
                break;
            case 13:
            	 doSetOrderByField();
                break;
            case 14:
            	doShowRawData();
               break;
            case 15:
            	doDataOptimize();
               break;
            case 99:
                System.exit(0);
                break;
            default:
                System.out.println("Error_wrong_command");
                System.out.println("Please_enter_again:");
                doMainMenu(false);
                break;
        }
        if (submenu) {
            System.out.println("[0].Go_back_to_main_menu [99].Exit_system");
            while (true) {
                try {
                    code = Integer.valueOf(Main.scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Error_wrong_command");
                    System.out.println("Please_enter_again:");
                    continue;
                }
                if (code == 99) {
                    System.exit(0);
                } else if (code == 0) {
                    break;
                }
                System.out.println("Error_wrong_command");
                System.out.println("Please_enter_again:");
            }

        }
    }

    public void doShowAll() {
        dataManager.printAllPeople();
    }

    public void doShowByCatalog() {
    	System.out.println("Catalogs:");
        int i = 0;
        String[] ascii = {"a", "b", "c", "d", "e", "f", "g", "h", "i","j",
                            "k","l","m","n","o","p","q","r", "s", "t","u",
                            "v","w","x","y","z"};
        for(Catalog c : dataManager.catalogs)
        {
            System.out.print("[" + ascii[i].charAt(0) + "]." + c.name + " ");
            i++;
        }
        System.out.println("\n[0].Go_back_to_main_menu [99].Exit_system");
        System.out.println("Input_catalog_to_show:");

        String cmd = Main.scanner.nextLine();
        while(true)
        {
            if(cmd.equals("0"))
                return;
            else if(cmd.equals("99"))
                System.exit(-1);
            else if(cmd.charAt(0)-'a' > dataManager.catalogs.size()-1)
            {
                System.out.println("Error_wrong_data\n"+
                            "Please_input_again:");
                cmd = Main.scanner.nextLine();
            }
            else{
                break;
            }
        }
        System.out.println(dataManager.getPeopleTitle(true, true, true, true, true));
        for(People p : dataManager.peoples)
        {
            if(p.catalog.equals(dataManager.catalogs.get(cmd.charAt(0)-'a').name))
            {
                p.print(true, true, true, true, true);
            }
        }
        System.out.println("[0].Go_back_to_main_menu [99].Exit_system");
        cmd = Main.scanner.nextLine();
        if(cmd.equals("0"))
            return;
        else if(cmd.equals("99"))
            System.exit(-1);
    }

    public void doShowPerPage() {
    	File config = new File("myconfig.txt");
        HashMap<String,String> configmap = new HashMap<>(SetConfigMap());
        try {
            Scanner scanconfig = new Scanner(config);
            while(scanconfig.hasNext()){
                String a = scanconfig.next();
                String b = scanconfig.next();
                if(configmap.containsKey(a)){
                    configmap.put(a,b);
                }
                else{
                    System.out.println("Error");
                }
                if(scanconfig.hasNextLine())
                    scanconfig.nextLine();
            }
            scanconfig.close();
            boolean show_name=false,show_phone=false,show_cat=false,show_email=false,show_birthday=false;
            String show_sort_order = "asc";
            int show_sort_property = 0;
            if(configmap.get("show_name:").equals("true")) {show_name = true;}
            else if(configmap.get("show_name:").equals("false")) {show_name = false;}
            else {System.out.println("Error");}
            if(configmap.get("show_phone:").equals("true")) {show_phone = true;}
            else if(configmap.get("show_phone:").equals("false")) {show_phone = false;}
            else {System.out.println("Error");}
            if(configmap.get("show_catalog:").equals("true")) {show_cat = true;}
            else if(configmap.get("show_catalog:").equals("false")) {show_cat = false;}
            else {System.out.println("Error");}
            if(configmap.get("show_email:").equals("true")) {show_email = true;}
            else if(configmap.get("show_email:").equals("false")) {show_email = false;}
            else {System.out.println("Error");}
            if(configmap.get("show_birthday:").equals("true")) {show_birthday = true;}
            else if(configmap.get("show_birthday:").equals("false")) {show_birthday = false;}
            else {System.out.println("Error");}
            if(configmap.get("show_sort_order:").equals("asc")) {show_sort_order ="asc";}
            else if(configmap.get("show_sort_order:").equals("des")) {show_sort_order = "des";}
            else System.out.println("Error");
            switch(configmap.get("show_sort_property:")){
                case "id":
                    show_sort_property = 0;
                    break;
                case "name":
                    show_sort_property = 1;
                    break;
                case "phone":
                    show_sort_property = 2;
                    break;
                case "catalog":
                    show_sort_property = 3;
                    break;
                case "email":
                    show_sort_property = 4;
                    break;
                case "birthday":
                    show_sort_property = 5;
                    break;
                default:
                    System.out.println("Error Property");
                    break;
            }
            int used_last_id = Integer.parseInt(configmap.get("used_last_id:"));
            int show_defalt_perpage = Integer.parseInt(configmap.get("show_defalt_perpage:"));
            System.out.println("Choose_show_per_page:");
            System.out.println("[3].3_data_per_page [5].5_data_per_page [10].10_data_per_page");
            System.out.println("[d].default [0].Go_back_to_main_menu [99].Exit_system");
            String choose;
            while(true){
                choose = Main.scanner.next();
                if(choose.equals("3")){
                    ShowPerPage(used_last_id,3,show_sort_order,show_sort_property,show_name,show_phone,show_cat,show_email,show_birthday);
                    Main.scanner.nextLine();
                    break;
                }
                else if(choose.equals("5")){
                    ShowPerPage(used_last_id,5,show_sort_order,show_sort_property,show_name,show_phone,show_cat,show_email,show_birthday);
                    Main.scanner.nextLine();
                    break;
                }
                else if(choose.equals("10")){
                    ShowPerPage(used_last_id,10,show_sort_order,show_sort_property,show_name,show_phone,show_cat,show_email,show_birthday);
                    Main.scanner.nextLine();
                    break;
                }
                else if(choose.equals("d")){
                    ShowPerPage(used_last_id,show_defalt_perpage,show_sort_order,show_sort_property,show_name,show_phone,show_cat,show_email,show_birthday);
                    Main.scanner.nextLine();
                    break;
                }
                else if(choose.equals("0")){
                	Main.scanner.nextLine();
                   break;
                }
                else if(choose.equals("99")){
                    System.exit(0);
                }
                else{
                    System.out.println("Error_wrong_command");
                    System.out.println("Please_enter_again:");
                }
            }
        } catch (FileNotFoundException e) {e.printStackTrace();}
    }

    public static void ShowPerPage(int lastid,int showpage,String show_sort_order,int show_sort_property,boolean show_name,boolean show_phone,boolean show_cat,boolean show_email,boolean show_birthday){
        if(lastid<=showpage){
            File datafile = new File("data.txt");

            try {
                Scanner scanfeild = new Scanner(datafile);
                List<String> fieldlist = new ArrayList<>();
                while(scanfeild.hasNext()){
                    for(int i=0;i<show_sort_property;i++){
                       scanfeild.next();
                    }
                    String a = scanfeild.next();
                    if(!fieldlist.contains(a)){
                        fieldlist.add(a);
                    }
                    for(int i=0;i<5-show_sort_property;i++){
                        scanfeild.next();
                    }
                    if(scanfeild.hasNextLine())
                        scanfeild.nextLine();
                }
                if(show_sort_property==0){
                    DecimalFormat idformat = new DecimalFormat("0000");
                    for(int i=0;i<fieldlist.size();i++){
                        fieldlist.set(i,idformat.format(Integer.parseInt(fieldlist.get(i))));
                    }
                }

                if(show_sort_property==4){
                    List<String> fieldcopy = new ArrayList<>(fieldlist);
                    List<String> emailupper = new ArrayList<>(fieldlist);
                    for(int i=0;i<emailupper.size();i++){
                        emailupper.set(i,emailupper.get(i).toUpperCase());
                    }
                    Collections.sort(emailupper);
                    for(int i=0;i<emailupper.size();i++){
                        for(int j=0;i<emailupper.size();j++){
                            if(fieldcopy.get(j).toUpperCase().equals(emailupper.get(i))){
                                fieldlist.set(i,fieldcopy.get(j));
                                break;
                            }
                        }
                    }
                    scanfeild.close();
                }
                else
                    Collections.sort(fieldlist);
                scanfeild.close();

                if(show_sort_order.equals("asc")){
                    for(int i=0;i<fieldlist.size();i++){
                        String list[] = new String[6];
                        Scanner listall = new Scanner(datafile);
                        while(listall.hasNext()){
                            for(int k=0;k<6;k++){
                                list[k] = listall.next();
                            }
                            DecimalFormat idformat = new DecimalFormat("0000");
                            list[0] = idformat.format(Integer.parseInt(list[0]));
                            if(list[show_sort_property].equals(fieldlist.get(i))){
                                System.out.print(list[0]+" ");
                                if(show_name) {System.out.printf("%-12s ",list[1]);}
                                if(show_phone) {System.out.printf("%-11s ",list[2]);}
                                if(show_cat) {System.out.printf("%-12s ",list[3]);}
                                if(show_email) {System.out.printf("%-24s ",list[4]);}
                                if(show_birthday) {System.out.printf("%-4s \r\n",list[5]);}
                            }
                            if(listall.hasNextLine())
                                listall.nextLine();
                        }
                        listall.close();
                    }
                }
                else if(show_sort_order.equals("des")){
                    for(int i=(fieldlist.size()-1);i>=0;i--){
                        String list[] = new String[6];
                        Scanner listall = new Scanner(datafile);
                        while(listall.hasNext()){
                            for(int k=0;k<6;k++){
                                list[k] = listall.next();
                            }
                            DecimalFormat idformat = new DecimalFormat("0000");
                            list[0] = idformat.format(Integer.parseInt(list[0]));
                            if(list[show_sort_property].equals(fieldlist.get(i))){
                                System.out.print(list[0]+" ");
                                if(show_name) {System.out.printf("%-12s ",list[1]);}
                                if(show_phone) {System.out.printf("%-11s ",list[2]);}
                                if(show_cat) {System.out.printf("%-12s ",list[3]);}
                                if(show_email) {System.out.printf("%-24s ",list[4]);}
                                if(show_birthday) {System.out.printf("%-4s \r\n",list[5]);}
                            }
                        }
                        listall.close();
                    }
                }
            } catch (FileNotFoundException e) {e.printStackTrace();}
            System.out.println("[0].Go_back_to_main_menu [99].Exit_system");
            while(true){
                String a = Main.scanner.next();
                if(a.equals("0")){
                    break;
                }
                else if(a.equals("99")) {System.exit(0);}
                else{
                    System.out.println("Error_wrong_command");
                    System.out.println("Please_enter_again:");
                }
            }
        }
        else{
            int pages = lastid/showpage;
            if(lastid%showpage>0) {pages++;}
            File data = new File("data.txt");
            List<String> fieldlist = new ArrayList<>(); 
            try {
                Scanner scandata = new Scanner(data);
                while(scandata.hasNext()){
                    for(int i=0;i<show_sort_property;i++){
                        scandata.next();
                    }
                    String a = scandata.next();
                    if(!fieldlist.contains(a))
                        fieldlist.add(a);
                    for(int i=(show_sort_property+1);i<6;i++){
                        scandata.next();
                    }
                    if(scandata.hasNextLine()){
                        scandata.nextLine();
                    }
                }
                if(show_sort_property==0){
                    DecimalFormat idformat = new DecimalFormat("0000");
                    for(int i=0;i<fieldlist.size();i++){
                        fieldlist.set(i,idformat.format(Integer.parseInt(fieldlist.get(i))));
                    }
                    Collections.sort(fieldlist);
                    scandata.close();
                }
                else if(show_sort_property==4){
                    List<String> fieldcopy = new ArrayList<>(fieldlist);
                    List<String> emailupper = new ArrayList<>(fieldlist);
                    for(int i=0;i<emailupper.size();i++){
                        emailupper.set(i,emailupper.get(i).toUpperCase());
                    }
                    Collections.sort(emailupper);
                    for(int i=0;i<emailupper.size();i++){
                        for(int j=0;i<emailupper.size();j++){
                            if(fieldcopy.get(j).toUpperCase().equals(emailupper.get(i))){
                                fieldlist.set(i,fieldcopy.get(j));
                                break;
                            }
                        }
                    }
                    scandata.close();
                }
                else {Collections.sort(fieldlist);}
                scandata.close();
            } catch (FileNotFoundException e) {e.printStackTrace();}
            List<String> smalllist = new ArrayList<>();
            int nowpage = 1;
            try {
                if(show_sort_order.equals("asc")){
                    for(int i=0;i<fieldlist.size();i++){
                        Scanner scandata = new Scanner(data);
                        String[] list = new String[6];
                        while(scandata.hasNext()){
                            for(int k=0;k<6;k++){
                                list[k] = scandata.next();
                            }
                            DecimalFormat idformat = new DecimalFormat("0000");
                            list[0] = idformat.format(Integer.parseInt(list[0]));
                            if(list[show_sort_property].equals(fieldlist.get(i))){
                                StringBuilder sb = new StringBuilder();
                                sb.append(list[0]+" "+list[1]);
                                for(int j=0;j<(13-list[1].length());j++){
                                    sb.append(" ");
                                }
                                sb.append(list[2]);
                                for(int j=0;j<(12-list[2].length());j++){
                                    sb.append(" ");
                                }
                                sb.append(list[3]);
                                for(int j=0;j<(13-list[3].length());j++){
                                    sb.append(" ");
                                }
                                sb.append(list[4]);
                                for(int j=0;j<(25-list[4].length());j++){
                                    sb.append(" ");
                                }
                                sb.append(list[5]);
                                if(sb.length()==72)
                                    smalllist.add(sb.toString());
                            }
                            if(scandata.hasNextLine())
                                scandata.nextLine();
                        }
                        scandata.close();
                    }
                }
                else if(show_sort_order.equals("des")){
                    for(int i=(fieldlist.size()-1);i>=0;i--){
                        Scanner scandata = new Scanner(data);
                        String[] list = new String[6];
                        while(scandata.hasNext()){
                            for(int k=0;k<6;k++){
                                list[k] = scandata.next();
                            }
                            DecimalFormat idformat = new DecimalFormat("0000");
                            list[0] = idformat.format(Integer.parseInt(list[0]));
                            if(list[show_sort_property].equals(fieldlist.get(i))){
                                StringBuilder sb = new StringBuilder();
                                sb.append(list[0]+" "+list[1]);
                                for(int j=0;j<(13-list[1].length());j++){
                                    sb.append(" ");
                                }
                                sb.append(list[2]);
                                for(int j=0;j<(12-list[2].length());j++){
                                    sb.append(" ");
                                }
                                sb.append(list[3]);
                                for(int j=0;j<(13-list[3].length());j++){
                                    sb.append(" ");
                                }
                                sb.append(list[4]);
                                for(int j=0;j<(25-list[4].length());j++){
                                    sb.append(" ");
                                }
                                sb.append(list[5]);
                                if(sb.length()==72)
                                    smalllist.add(sb.toString());
                            }
                            if(scandata.hasNextLine())
                                scandata.nextLine();
                        }
                        scandata.close();
                    }
                }
                boolean stopshowperpage = false;
                while(!stopshowperpage){
                    if(nowpage==1){
                        for(int i=0;i<showpage;i++){
                            System.out.println(smalllist.get(i));
                        }
                        System.out.println("[2].Next_page [0].Go_back_to_main_menu [99].Exit_system");
                        while(true){
                            String a = Main.scanner.next();
                            if(a.equals("2")){
                                nowpage ++;
                                break;
                            }
                            else if(a.equals("0")){
                                stopshowperpage = true;
                                break;
                            }
                            else if(a.equals("99")) {System.exit(0);}
                            else{
                                System.out.println("Error_wrong_command");
                                System.out.println("Please_enter_again:");
                            }
                        }
                    }
                    else if(nowpage==pages){
                        for(int i=(pages-1)*showpage;i<smalllist.size();i++){
                            System.out.println(smalllist.get(i));
                        }
                        System.out.println("[1].Last_page [0].Go_back_to_main_menu [99].Exit_system");
                        while(true){
                            String a = Main.scanner.next();
                            if(a.equals("1")){
                                nowpage --;
                                break;
                            }
                            else if(a.equals("0")){
                                stopshowperpage = true;
                                break;
                            }
                            else if(a.equals("99")) {System.exit(0);}
                            else{
                                System.out.println("Error_wrong_command");
                                System.out.println("Please_enter_again:");
                            }
                        }
                    }
                    else{
                        for(int i=(nowpage-1)*showpage;i<nowpage*showpage;i++){
                            System.out.println(smalllist.get(i));
                        }
                        System.out.println("[1].Last_page [2].Next_page [0].Go_back_to_main_menu [99].Exit_system");
                        while(true){
                            String a = Main.scanner.next();
                            if(a.equals("1")){
                                nowpage --;
                                break;
                            }
                            else if(a.equals("2")){
                                nowpage++;
                                break;
                            }
                            else if(a.equals("0")){
                                stopshowperpage = true;
                                break;
                            }
                            else if(a.equals("99")) {System.exit(0);}
                            else{
                                System.out.println("Error_wrong_command");
                                System.out.println("Please_enter_again:");
                            }
                        }
                    }
                }
            } catch (FileNotFoundException e) {e.printStackTrace();}
        }
    }

    public void doSearch() {
        ArrayList<People> output = new ArrayList<>(); 
        boolean flag = false;
        boolean count=true;
        while(true){
            System.out.println("Search by:\n"+
                    "[a].ID [b].Name [c].Birthday\n"+
                    "[0].Go_back_to_main_menu [99].Exit_system");
        
            String command = Main.scanner.nextLine();
            switch (command) {
                case "a":
                    while(true){
                        if(count) {
                        	System.out.println("Input_target:");
                    	}
                        int id = 0;
                        try {
                            id = Integer.parseInt(Main.scanner.nextLine());
                        } catch (Exception e) {
                            System.out.println("Error_wrong_data\n"+
                                "Please_input_again:");
                            count=false;
                            continue;
                        }
                        
                        if(id>9999||id<0) {
                        	System.out.println("Error_wrong_data\n"+
                                    "Please_input_again:");
                                count=false;
                                continue;
                        }
                        //System.out.println("Search_result:");
                        
                        for(People p : dataManager.peoples)
                        {
                            if(p.id == id)
                            {
                                //p.print(true, true, true, true, true);
                                output.add(p);
                                flag = true;
                            }    
                        }
                        break;
                    }
                    break;
                case "b":
                    while(true){
                        if(count) {
                        	System.out.println("Input_target:");
                    	}
                        String name = Main.scanner.nextLine();
                        if(name.matches("") || name.matches("^[0-9]*$"))
                        {
                            System.out.println("Error_wrong_data\n"+
                                "Please_input_again:");
                            count=false;
                            continue;
                        }
                        //System.out.println("Search_result:");
                        for(People p : dataManager.peoples)
                        {
                            if(p.name.equals(name)){
                                //p.print(true, true, true, true, true);
                                output.add(p);
                                flag = true;
                            }
                        }
                        break;
                    }
                    break;
                case "c":
                    while(true){
                        if(count) {
                        	System.out.println("Input_target:");
                    	}
                        String birth = Main.scanner.nextLine();
                        if(birth.matches("") || birth.matches("^[a-zA-Z]*$"))
                        {
                            System.out.println("Error_wrong_data\n"+
                                "Please_input_again:");
                            count=false;
                            continue;
                        }
                        //System.out.println("Search_result:");
                        for(People p : dataManager.peoples)
                        {
                            if(p.birthday.equals(birth)){
                                //p.print(true, true, true, true, true);
                                output.add(p);
                                flag = true;
                            }
                        }
                        break;
                    }
                    break;
                case "0":
                    return;
                case "99":
                    System.exit(-1);
                    break;
                default:
                    break;
            }
            if(!flag)
                System.out.println("Error_no_result");
            else{
                System.out.println("Search_result:");
                System.out.println(dataManager.getPeopleTitle(true, true, true, true, true));
                for(People p : output)
                {
                    p.print(true, true, true, true, true);
                }
            }
            output.clear();
            System.out.println("[1].Restart_search [0].Go_back_to_main_menu"+ 
                            " [99].Exit_system");
            String comd = Main.scanner.nextLine();
            
            if(comd.equals("1"))
                doSearch();
            else if(comd.equals("0"))
                doMainMenu();
            else if(comd.equals("99"))
                System.exit(-1);
        }
    }

    public void doModify() {
    	System.out.println("Input_ID_to_be_modified:");
        String mod_id = Main.scanner.nextLine();
        System.out.println("Search_result:");
        System.out.println(dataManager.getPeopleTitle(true, true, true, true, true));
        for(People p : dataManager.peoples)
        {
            if(p.id == Integer.parseInt(mod_id))
            {
                p.print(true, true, true, true, true);
                //break;
                System.out.println("New_name:");
                String new_name = Main.scanner.nextLine();
                if(new_name.isEmpty())
                    new_name = p.name;
                else
                    new_name = dataManager.checkName(new_name);
                System.out.println("New_phone:");
                String new_phone = Main.scanner.nextLine();
                if(new_phone.isEmpty())
                    new_phone = p.phone;
                else{
                    new_phone = dataManager.checkPhone(new_phone);
                }
                String[] ascii = {"a", "b", "c", "d", "e", "f", "g", "h", "i","j",
                            "k","l","m","n","o","p","q","r", "s", "t","u",
                            "v","w","x","y","z"};
                int i = 0;
                System.out.print("Catalogs:");
                for(Catalog c : dataManager.catalogs)
                {
                    System.out.print("[" + ascii[i].charAt(0) + "]." + c.name + " ");
                    i++;
                }
                System.out.println("\nNew_catalog:");
                String new_catalog = Main.scanner.nextLine();
                if(new_catalog.isEmpty())
                    new_catalog = p.catalog;
                else{
                    new_catalog = dataManager.checkCatalog(new_catalog);
                }
                System.out.println("New_email:");
                String new_email = Main.scanner.nextLine();
                if(new_email.isEmpty())
                    new_email = p.email;
                else{
                    new_email = dataManager.checkEmail(new_email);
                }
                System.out.println("New_birthday:");
                String new_birth = Main.scanner.nextLine();
                if(new_birth.isEmpty())
                    new_birth = p.birthday;
                else{
                    new_birth = dataManager.checkBirth(new_birth);
                }
                People per = new People(Integer.parseInt(mod_id),new_name,new_phone,new_catalog,new_email,new_birth);
                dataManager.peoples.set(Integer.parseInt(mod_id)-1, per);
                dataManager.savePeople();
                System.out.println("Modify_data_success");
                break;
            }
        }
    }

    public void doDelete() {
    	boolean flag = false;
        People del_p = new People();
        System.out.println("Input_ID_to_be_deleted:");
        String del_id = Main.scanner.nextLine();
        while(true)
        {
            if(!del_id.matches("[0-9]*$"))
            {
                System.out.println("Error_no_such_data");
                System.out.println("Input_ID_to_be_deleted:");
                del_id = Main.scanner.nextLine();
                continue;
            }
            for(People p : dataManager.peoples)
            {
                if(p.id == Integer.parseInt(del_id))
                {
                    flag = true;
                    del_p.equals(p);
                }
            }
            if(!flag){
                System.out.println("Error_no_such_data");
                System.out.println("Input_ID_to_be_deleted:");
                del_id = Main.scanner.nextLine();
                continue;
            }
            else{
                dataManager.peoples.remove(Integer.parseInt(del_id)-1);
                dataManager.savePeople();
                System.out.println("Delete_data_success");
                break;
            }
        }
    }

    public void doAddContact() {
    	String datas[] = dataManager.inputPeople();
        int id = Math.max(config.getInt("used_last_id"), dataManager.peoples.get(dataManager.peoples.size() - 1).id);
        id++;
        People people = new People(id, datas[0], datas[1], datas[2], datas[3], datas[4]);
        dataManager.peoples.add(people);
        dataManager.savePeople();
        config.confgis.put("used_last_id", id + "");
        config.save();
        System.out.println("Add_contact_success");
    }

    public void doAddCatalog() {
    	boolean add_cat = false;
        String new_cat = "";
        while(!add_cat)
        {
            System.out.println("Please_input_new_catalog:");
            new_cat = Main.scanner.nextLine();
            if(new_cat.charAt(0)>='a' && new_cat.charAt(0)<='z')
            {
                new_cat = new_cat.substring(0,1).toUpperCase() + new_cat.substring(1);
            }
            add_cat = dataManager.AddCat(new_cat);
        }
        dataManager.catalogs.add(new Catalog(new_cat));
        Collections.sort(dataManager.catalogs, new Comparator<Catalog>() {
            @Override
            public int compare(Catalog cat1, Catalog cat2){
                return cat1.name.compareTo(cat2.name);
            }
        });
        try {
                PrintWriter writer = new PrintWriter("catalog.txt");
                for(Catalog cat : dataManager.catalogs)
                {
                    writer.println(cat.name);
                }
                writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void doShowAllCatalog() {
    	System.out.println("[Catalog]");
        for(Catalog cat : dataManager.catalogs)
        {
            System.out.println(cat.name);
        }
    }

    public void doSetDisplayField() {
    	boolean show_name = config.getBoolean("show_name");
        boolean show_phone = config.getBoolean("show_phone");
        boolean show_catalog = config.getBoolean("show_catalog");
        boolean show_email = config.getBoolean("show_email");
        boolean show_birthday = config.getBoolean("show_birthday");
        String name ,phone,catalog,email,birth;
        
        if(show_name) {name = "1";}
        else {name = "0";}
        if(show_phone) {phone = "1";}
        else {phone = "0";}
        if(show_catalog) {catalog = "1";}
        else {catalog = "0";}
        if(show_email) {email = "1";}
        else {email = "0";}
        if(show_birthday) {birth = "1";}
        else {birth = "0";}
        
        System.out.println("[1].Show_name:"+name+ " [2].Show_phone:"+phone+ 
                " [3].Show_cat:"+catalog+" [4].Show_email:"+email+" [5].Show_bd:"+birth+"\n");
        System.out.println("New_show_name(0/1):");
        name = Main.scanner.nextLine();
        System.out.println("New_show_phone(0/1):");
        phone = Main.scanner.nextLine();
        System.out.println("New_show_cat(0/1):");
        catalog = Main.scanner.nextLine();
        System.out.println("New_show_email(0/1):");
        email = Main.scanner.nextLine();
        System.out.println("New_show_bd(0/1):");
        birth = Main.scanner.nextLine();
        
        if(name.equals("1")) {show_name = true;}
        else {show_name = false;}
        if(phone.equals("1")) {show_phone = true;}
        else {show_phone = false;}
        if(catalog.equals("1")) {show_catalog = true;}
        else {show_catalog = false;}
        if(email.equals("1")) {show_email = true;}
        else {show_email = false;}
        if(birth.equals("1")) {show_birthday = true;}
        else {show_birthday = false;}
        
        config.confgis.put("show_name", show_name + "");
        config.confgis.put("show_phone", show_phone + "");
        config.confgis.put("show_catalog", show_catalog + "");
        config.confgis.put("show_email", show_email + "");
        config.confgis.put("show_birthday", show_birthday + "");
        config.save();
        
        System.out.println("\n[1].Show_name:"+name+ " [2].Show_phone:"+phone+ 
                " [3].Show_cat:"+catalog+" [4].Show_email:"+email+" [5].Show_bd:"+birth+"\n");
        
    }

    public void doSetViewPerpage() {
    	File config = new File("myconfig.txt");
        HashMap<String,String> configmap = new HashMap<>(SetConfigMap());
        try {
            Scanner scanconfig = new Scanner(config);
            while(scanconfig.hasNext()){
                String a = scanconfig.next();
                String b = scanconfig.next();
                if(configmap.containsKey(a)){
                    configmap.put(a,b);
                }
                else{
                    System.out.println("Error config");
                }
                if(scanconfig.hasNextLine()){
                    scanconfig.nextLine();
                }
            }
            System.out.println("show_defalt_perpage:"+configmap.get("show_defalt_perpage:"));
            System.out.println("new_show_defalt_perpage:");
            int cin = Main.scanner.nextInt();
            configmap.put("show_defalt_perpage:",Integer.toString(cin));
            PrintWriter rewrite = new PrintWriter("myconfig.txt");
            for(Object key: configmap.keySet()){
                rewrite.write(key+" "+configmap.get(key)+"\r\n");
            }
            System.out.println("show_defalt_perpage:"+configmap.get("show_defalt_perpage:"));
            Main.scanner.nextLine();
            scanconfig.close();
            
            rewrite.close();
        } catch (FileNotFoundException e) {e.printStackTrace();}
    }

    public void doSetOrder() {
    	System.out.println("show_sort_order:"+dataManager.config.confgis.get("show_sort_order"));
    	System.out.println("Please_input_new_sort_order:");
    	while(true) {
    		String input=Main.scanner.nextLine();
    		if(input.equals("asc")) {
    			dataManager.config.confgis.replace("show_sort_order", input);
    			break;
    		}
    		else if(input.equals("des")){
    			dataManager.config.confgis.replace("show_sort_order", input);
    			break;
    		}
    		else {
    			System.out.println("Error_wrong_data\n"+"Please_input_again");
    			continue;
    		}
    	}
		dataManager.config.save();
		System.out.println("show_sort_order:"+dataManager.config.confgis.get("show_sort_order"));
    }
    
    public void doSetOrderByField() {

        System.out.println("[1].ID [2].Name [3].Phone [4].Cat [5].Email [6].Bd");
        System.out.println("[0].Go_back_to_main_menu [99].Exit_system");
        String select;
        while(true){
            select = Main.scanner.nextLine();
            switch(select){
                case "1":
                	dataManager.config.confgis.replace("show_sort_field","id");
                	dataManager.config.save();
                    System.out.println("Sorted_by:ID");
                    dataManager.setorder();
                    break;
                case "2":
                	dataManager.config.confgis.replace("show_sort_field","name");
                	dataManager.config.save();
                    System.out.println("Sorted_by:Name");
                    dataManager.setorder();
                    break;
                case "3":
                	dataManager.config.confgis.replace("show_sort_field","phone");
                	dataManager.config.save();
                    System.out.println("Sorted_by:Phone");
                    dataManager.setorder();
                    break;
                case "4":
                	dataManager.config.confgis.replace("show_sort_field","cat");
                	dataManager.config.save();
                    System.out.println("Sorted_by:Cat");
                    dataManager.setorder();
                    break;
                case "5":
                	dataManager.config.confgis.replace("show_sort_field","email");
                	dataManager.config.save();
                    System.out.println("Sorted_by:Email");
                    dataManager.setorder();
                    break;
                case "6":
                	dataManager.config.confgis.replace("show_sort_field","bd");
                	dataManager.config.save();
                    System.out.println("Sorted_by:Bd");
                    dataManager.setorder();
                    break;
                case "0":
                    return;
                case "99":
                    System.exit(0);
                default:
                	System.out.println("Error_wrong_command\n"+
                		        "Please_enter_again:");
                    break;
            }
            break;
        }
    }
    
    public void doShowRawData() {
    	
    	boolean show_name = config.getBoolean("show_name");
        boolean show_phone = config.getBoolean("show_phone");
        boolean show_catalog = config.getBoolean("show_catalog");
        boolean show_email = config.getBoolean("show_email");
        boolean show_birthday = config.getBoolean("show_birthday");
        
        System.out.println(dataManager.getPeopleTitle(show_name, show_phone, show_catalog, show_email, show_birthday));
        for(People p : dataManager.peoples)
        {
            p.print(show_name, show_phone, show_catalog, show_email, show_birthday);
        }
    }
    
    public void doDataOptimize() {
    	String select;
    	System.out.println("Please_confirm_data_optimize_y_or_n:");
    	while(true) {
    		select = Main.scanner.nextLine();
    		switch(select){
    			case "y":case"Y":
    				dataManager.config.confgis.replace("show_sort_field","id");
    				dataManager.config.save();
    				dataManager.setorder();
    				System.out.println("Data_optimize_success");
    				dataManager.peoples.clear();
    				dataManager.loadPeoples();
    				break;
    			case "0":
    				return;
    			case "99":
    				System.exit(0);   
    			default:
    				System.out.println("Data_optimize_denied");
    				break;
        	}
    		break;
    	}
    }

    public static String formatString(String v, int length) {
        String a = v + "                       ";
        return a.substring(0, length) + " ";
    }

    public static String formatNumber(int v, int length) {
        String a = "0000" + v;
        return a.substring(a.length() - length, a.length()) + " ";
    }

    public void doLogin() {
        int errorCount = 0;
        while (true) {
            System.out.println("Account:");
            String inputAccout = Main.scanner.nextLine();
            System.out.println("Password:");
            String inputPassword = Main.scanner.nextLine();
            System.out.println("Verify_string:" + this.verify);
            System.out.println("Input_Verify_string:");
            String inputVerify = Main.scanner.nextLine();
            if (!this.login(inputAccout, inputPassword) || !verify.equals(inputVerify)) {
                errorCount++;
                System.out.println("Error_wrong_account_password_or_verify_string");
                if (errorCount >= 3) {
                    System.exit(0);
                }
                continue;
            }
            break;
        }
        System.out.println("Login_success");
    }

    public boolean login(String acc, String pw) {
        String password = accouts.get(acc);
        return password != null && password.equals(pw);
    }

    public void getLoginInfo() {
        try {
            Scanner sc = new Scanner(new File("accout.txt"));
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String data[] = line.split(" ");
                accouts.put(data[0], data[1]);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getVerify() {
        return config.getString("verify_string");
    }
}
