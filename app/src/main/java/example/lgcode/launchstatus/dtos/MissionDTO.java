package example.lgcode.launchstatus.dtos;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by leojg on 3/1/17.
 */

public class MissionDTO implements Serializable {

    private String name;
    private String description;
    private AgencyDTO agency;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AgencyDTO getAgency() {
        return agency;
    }

    public void setAgency(AgencyDTO agency) {
        this.agency = agency;
    }
}
