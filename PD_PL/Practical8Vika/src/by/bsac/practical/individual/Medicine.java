package by.bsac.practical.individual;

public class Medicine {
    private String name;
    private String pharm;
    private String group;
    private String analogs;
    private String versions;
    private String certificate;
    private String packagee;
    private String dosage;

    public  Medicine(){

    }

    public Medicine(String name, String pharm, String group, String analogs, String versions, String certificate, String packagee, String dosage) {
        this.name = name;
        this.pharm = pharm;
        this.group = group;
        this.analogs = analogs;
        this.versions = versions;
        this.certificate = certificate;
        this.packagee = packagee;
        this.dosage = dosage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPharm() {
        return pharm;
    }

    public void setPharm(String pharm) {
        this.pharm = pharm;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAnalogs() {
        return analogs;
    }

    public void setAnalogs(String analogs) {
        this.analogs = analogs;
    }

    public String getVersions() {
        return versions;
    }

    public void setVersions(String versions) {
        this.versions = versions;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getPackagee() {
        return packagee;
    }

    public void setPackagee(String packagee) {
        this.packagee = packagee;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    @Override
    public String toString() {
        return "Препарат{" +
                "название='" + name + '\'' +
                ", фирма='" + pharm + '\'' +
                ", группа='" + group + '\'' +
                ", аналоги='" + analogs + '\'' +
                ", вид='" + versions + '\'' +
                ", свидетельство='" + certificate + '\'' +
                ", упаковка='" + packagee + '\'' +
                ", дозировка='" + dosage + '\'' +
                '}';
    }
}
