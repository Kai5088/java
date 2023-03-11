public class People {
    public int id;
    public String name, birthday, phone, catalog, email;

    public People(String raw) {
        String[] datas = raw.split("  ");
        this.id = Integer.valueOf(datas[0].trim());
        this.name = datas[1].trim();
        this.phone = datas[2].trim();
        this.catalog = datas[3].trim();
        this.email = datas[4].trim();
        this.birthday = datas[5].trim();
    }

    public People(int id, String name, String phone, String catalog, String email, String birthday) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.catalog = catalog;
        this.email = email;
        this.birthday = birthday;
    }

    public void print(boolean name, boolean phone, boolean catalog, boolean email, boolean birthday) {
        String out = "";
        out += Control.formatNumber(this.id, 4);
        if (name) {
            out += Control.formatString(this.name, 12);
        }
        if (phone) {
            out += Control.formatString(this.phone, 11);
        }
        if (catalog) {
            out += Control.formatString(this.catalog, 12);
        }
        if (email) {
            out += Control.formatString(this.email, 24);
        }
        if (birthday) {
            out += Control.formatString(this.birthday, 4);
        }
        System.out.println(out.trim());
    }

    public String getRaw() {
        return this.id + "  " + this.name + "  " + this.phone + "  " + this.catalog + "  " + this.email + "  " + this.birthday;
    }
}
