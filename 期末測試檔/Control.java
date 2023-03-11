import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
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
    }

    public void doShowPerPage() {
    }

    public void doSearch() {
    }

    public void doModify() {
    }

    public void doDelete() {
    }

    public void doAddContact() {
        String datas[] = dataManager.inputPeople(false);
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
    }

    public void doShowAllCatalog() {
    }

    public void doSetDisplayField() {
    }

    public void doSetViewPerpage() {
    }

    public void doSetOrder() {
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
