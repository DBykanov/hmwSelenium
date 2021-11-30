package hmwSelenium.helpers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoodsPojo {

    private String name;
    private String availability;
    @JsonProperty("code")
    private String pseudoCode;

    public String getName() {
        return name;
    }

    public String getAvailability() {
        return availability;
    }

    public String getPseudoCode() {
        return pseudoCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setPseudoCode(String pseudoCode) {
        this.pseudoCode = pseudoCode;
    }
}
