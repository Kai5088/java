import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DataManager {
    ArrayList<People> peoples = new ArrayList<>();
    ArrayList<Catalog> catalogs = new ArrayList<>();
    public Config config;

    public void load() {
        loadPeoples();
        loadCatalogs();
    }

    public void printAllPeople() {
        boolean show_name = config.getBoolean("show_name");
        boolean show_phone = config.getBoolean("show_phone");
        boolean show_catalog = config.getBoolean("show_catalog");
        boolean show_email = config.getBoolean("show_email");
        boolean show_birthday = config.getBoolean("show_birthday");

        System.out.println(getPeopleTitle(show_name, show_phone, show_catalog, show_email, show_birthday));
        for (People people : getSortedList()) {
            people.print(show_name, show_phone, show_catalog, show_email, show_birthday);
        }
    }

    public ArrayList<People> getSortedList() {
        ArrayList<People> out = new ArrayList<>(peoples);
        Collections.sort(out, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                String orderby = config.getString("show_sort_property");
                boolean asc = config.getString("show_sort_order").equalsIgnoreCase("asc");
                if (orderby.equalsIgnoreCase("id")) {
                    if (asc) {
                        return o1.id - o2.id;
                    } else {
                        return o2.id - o1.id;
                    }
                }
                if (orderby.equalsIgnoreCase("name")) {
                    if (asc) {
                        return o1.name.compareTo(o2.name);
                    } else {
                        return o2.name.compareTo(o1.name);
                    }
                }
                if (orderby.equalsIgnoreCase("phone")) {
                    if (asc) {
                        return o1.phone.compareTo(o2.phone);
                    } else {
                        return o2.phone.compareTo(o1.phone);
                    }
                }
                if (orderby.equalsIgnoreCase("catalog")) {
                    if (asc) {
                        return o1.catalog.compareTo(o2.catalog);
                    } else {
                        return o2.catalog.compareTo(o1.catalog);
                    }
                }
                if (orderby.equalsIgnoreCase("email")) {
                    if (asc) {
                        return o1.email.compareTo(o2.email);
                    } else {
                        return o2.email.compareTo(o1.email);
                    }
                }
                if (orderby.equalsIgnoreCase("birthday")) {
                    if (asc) {
                        return o1.birthday.compareTo(o2.birthday);
                    } else {
                        return o2.birthday.compareTo(o1.birthday);
                    }
                }
                return 0;
            }
        });
        return out;
    }

    public String getPeopleTitle(boolean show_name, boolean show_phone, boolean show_catalog, boolean show_email, boolean show_birthday) {
        String title = Control.formatString("[ID]", 4);
        if (show_name) {
            title += Control.formatString("[Name]", 12);
        }
        if (show_phone) {
            title += Control.formatString("[Phone]", 11);
        }
        if (show_catalog) {
            title += Control.formatString("[Catalog]", 12);
        }
        if (show_email) {
            title += Control.formatString("[Email]", 24);
        }
        if (show_birthday) {
            title += "[BD]";
        }
        return title;
    }

    public void loadCatalogs() {
        try {
            Scanner sc = new Scanner(new File("catalog.txt"));
            while (sc.hasNext()) {
                String line = sc.nextLine();
                catalogs.add(new Catalog(line));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void loadPeoples() {
        try {
            Scanner sc = new Scanner(new File("data.txt"));
            while (sc.hasNext()) {
                String line = sc.nextLine();
                peoples.add(new People(line));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String selectCatalog(boolean back, boolean n) {
        int i = 0;
        System.out.print("Catalogs:");
        String o = "";
        for (Catalog catalog : catalogs) {
            o += ("[" + (i + 1) + "]." + catalog.name + " ");
            i++;
        }
        o = o.trim();
        System.out.print(o + "\n");
        if (back) {
            System.out.println("[0].Main_menu [99].Exit_system");
        }
        if (n) {
            System.out.println("New_catalog:");
        } else {
            System.out.println("Catalog:");
        }
        try {
            int input = Integer.valueOf(Main.scanner.nextLine());
            if (input == 0) {
                return null;
            }
            if (input == 99) {
                System.exit(0);
            }
            return catalogs.get(input - 1).name;
        } catch (Exception e) {
            return "";
        }
    }

    public String[] inputPeople(boolean n) {
        String[] cols = new String[]{(n ? "New_name" : "Name"), (n ? "New_phone" : "Phone_number")};
        ArrayList<String> datas = new ArrayList<>();
        String[] data1 = getInput(cols);
        for (String a : data1) {
            datas.add(a);
        }
        String catalogName = selectCatalog(false, n);
        String[] cols2 = new String[]{(n ? "New_email" : "Email"), (n ? "New_birthday" : "Birthday")};
        String[] data2 = getInput(cols2);
        datas.add(catalogName);
        for (String a : data2) {
            datas.add(a);
        }
        return datas.toArray(new String[datas.size()]);
    }

    public String[] getInput(String[] cols, String[] can, String error) {
        String[] inputs = new String[cols.length];
        out:
        for (int i = 0; i < cols.length; i++) {
            String col = cols[i];
            System.out.println(col + ":");
            inputs[i] = Main.scanner.nextLine();
            if (can != null) {
                for (String c : can) {
                    if (c.equals(inputs[i])) {
                        continue out;
                    }
                }
                System.out.println(error);
                i--;
            }
        }
        return inputs;
    }

    public String[] getInput(String[] cols) {
        return getInput(cols, null, null);
    }

    public void savePeople() {
        String out = "";
        for (People people : peoples) {
            out += people.getRaw() + "\n";
        }
        out = out.trim();
        try {
            FileWriter fw = new FileWriter(new File("data.txt"));
            fw.write(out);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
