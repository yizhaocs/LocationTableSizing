import java.sql.Date;

/**
 * Created by yzhao on 7/11/16.
 */
public class LocationDTO {
    private Integer id;
    private String country;
    private String state;
    private String city;
    private String zipcode;
    private Double latitude;
    private Double longitude;
    private Integer metrocode;
    private Integer areacode;
    private Integer gmt_offset;
    private Integer cbsa_code;
    private Integer csa_code;
    private Integer md_code;
    private String md_title;
    private Integer income;
    private Integer political_affiliation;
    private String ethnicity;
    private Double rent_owned;
    private String education;
    private Date modification_ts;

    public Integer getAreacode() {
        return areacode;
    }

    public void setAreacode(Integer areacode) {
        this.areacode = areacode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getMetrocode() {
        return metrocode;
    }

    public void setMetrocode(Integer metrocode) {
        this.metrocode = metrocode;
    }

    public Integer getGmt_offset() {
        return gmt_offset;
    }

    public void setGmt_offset(Integer gmt_offset) {
        this.gmt_offset = gmt_offset;
    }

    public Integer getCbsa_code() {
        return cbsa_code;
    }

    public void setCbsa_code(Integer cbsa_code) {
        this.cbsa_code = cbsa_code;
    }

    public Integer getCsa_code() {
        return csa_code;
    }

    public void setCsa_code(Integer csa_code) {
        this.csa_code = csa_code;
    }

    public Integer getMd_code() {
        return md_code;
    }

    public void setMd_code(Integer md_code) {
        this.md_code = md_code;
    }

    public String getMd_title() {
        return md_title;
    }

    public void setMd_title(String md_title) {
        this.md_title = md_title;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    public Integer getPolitical_affiliation() {
        return political_affiliation;
    }

    public void setPolitical_affiliation(Integer political_affiliation) {
        this.political_affiliation = political_affiliation;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public Double getRent_owned() {
        return rent_owned;
    }

    public void setRent_owned(Double rent_owned) {
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
