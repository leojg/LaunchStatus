package example.lgcode.launchstatus.models;

import com.squareup.otto.Bus;

import example.lgcode.launchstatus.dtos.LaunchDTO;

/**
 * Created by leojg on 3/3/17.
 */

public class LaunchDetailModel {

    private LaunchDTO launch;
    private Bus bus;

    public LaunchDetailModel(LaunchDTO launch, Bus bus) {
        this.launch = launch;
        this.bus = bus;
    }

    public LaunchDTO getLaunch() {
        return launch;
    }
}
