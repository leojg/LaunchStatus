package example.lgcode.launchstatus.dtos;

import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.List;

/**
 * Created by leojg on 1/20/17.
 */

public class LaunchDTO implements Serializable {

    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("wsstamp")
    private DateTime windowStart;
    @SerializedName("westamp")
    private DateTime windowEnd;
    @SerializedName("location")
    private LocationDTO location;
    @SerializedName("rocket")
    private RocketDTO rocket;
    @SerializedName("status")
    private Integer status;
    @SerializedName("missions")
    private List<MissionDTO> missions;
    @SerializedName("vidURLs")
    private List<String> vidURLs;

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

    public DateTime getWindowStart() {
        return windowStart;
    }

    public void setWindowStart(DateTime windowStart) {
        this.windowStart = windowStart;
    }

    public DateTime getWindowEnd() {
        return windowEnd;
    }

    public void setWindowEnd(DateTime windowEnd) {
        this.windowEnd = windowEnd;
    }

    public RocketDTO getRocket() {
        return rocket;
    }

    public void setRocket(RocketDTO rocket) {
        this.rocket = rocket;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }

    public List<MissionDTO> getMissions() {
        return missions;
    }

    public void setMissions(List<MissionDTO> missions) {
        this.missions = missions;
    }


    public List<String> getVidURLs() {
        return vidURLs;
    }

    public void setVidURLs(List<String> vidURLs) {
        this.vidURLs = vidURLs;
    }
}
