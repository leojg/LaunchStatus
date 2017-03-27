package example.lgcode.launchstatus.dtos;

import java.io.Serializable;

/**
 * Created by leojg on 1/26/17.
 */

public class RocketDTO implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
