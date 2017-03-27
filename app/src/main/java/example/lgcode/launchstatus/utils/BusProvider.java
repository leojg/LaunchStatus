package example.lgcode.launchstatus.utils;

import com.squareup.otto.Bus;

/**
 * Created by leojg on 11/9/16.
 */
public class BusProvider {

    private static final Bus BUS = new Bus("launchStatus");

    public static Bus getInstance() {
        return BUS;
    }

    private BusProvider() {
    }
}
