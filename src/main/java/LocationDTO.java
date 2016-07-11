import java.sql.Date;

/**
 * Created by yzhao on 7/11/16.
 */
public class LocationDTO {
    private int id;
    private String country;
    private String state;
    private String city;
    private String zipcode;
    private double latitude;
    private double longitude;
    private int metrocode;
    private int areacode;
    private int gmt_offset;
    private int cbsa_code;
    private int csa_code;
    private int md_code;
    private String md_title;
    private int income;
    private int political_affiliation;
    private String ethnicity;
    private double rent_owned;
    private String education;
    private Date modification_ts;

    public int getAreacode() {
        return areacode;
    }

    public void setAreacode(int areacode) {
        this.areacode = areacode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getMetrocode() {
        return metrocode;
    }

    public void setMetrocode(int metrocode) {
        this.metrocode = metrocode;
    }

    public int getGmt_offset() {
        return gmt_offset;
    }

    public void setGmt_offset(int gmt_offset) {
        this.gmt_offset = gmt_offset;
    }

    public int getCbsa_code() {
        return cbsa_code;
    }

    public void setCbsa_code(int cbsa_code) {
        this.cbsa_code = cbsa_code;
    }

    public int getCsa_code() {
        return csa_code;
    }

    public void setCsa_code(int csa_code) {
        this.csa_code = csa_code;
    }

    public int getMd_code() {
        return md_code;
    }

    public void setMd_code(int md_code) {
        this.md_code = md_code;
    }

    public String getMd_title() {
        return md_title;
    }

    public void setMd_title(String md_title) {
        this.md_title = md_title;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getPolitical_affiliation() {
        return political_affiliation;
    }

    public void setPolitical_affiliation(int political_affiliation) {
        this.political_affiliation = political_affiliation;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public double getRent_owned() {
        return rent_owned;
    }

    public void setRent_owned(double rent_owned) {
        this.rent_owned = rent_owned;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Date getModification_ts() {
        return modification_ts;
    }

    public void setModification_ts(Date modification_ts) {
        this.modification_ts = modification_ts;
    }
}
