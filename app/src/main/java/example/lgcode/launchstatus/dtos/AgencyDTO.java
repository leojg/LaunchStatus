package example.lgcode.launchstatus.dtos;

import java.io.Serializable;

/**
 * Created by leojg on 3/2/17.
 */

public class AgencyDTO implements Serializable {

    private Integer id;
    private String name;
    private String countryCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
