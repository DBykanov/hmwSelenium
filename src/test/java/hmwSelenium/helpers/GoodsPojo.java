package hmwSelenium.helpers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoodsPojo {
    private String name;
    private String availability;
  //  @JsonProperty("Code")
    private String code;

    public String getName() {
        return name;
    }

    public String getAvailability() {
        return availability;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public GoodsPojo(String name, String availability, String code) {
        this.name = name;
        this.availability = availability;
        this.code = code;
    }
    public GoodsPojo() {

    }
}
