package example.lgcode.launchstatus.network;

import java.util.List;

import example.lgcode.launchstatus.dtos.LaunchDTO;

/**
 * Created by leojg on 1/24/17.
 */

public class LaunchResponse {

    private Integer total;
    private List<LaunchDTO> launches;
    private Integer offest;
    private Integer count;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<LaunchDTO> getLaunches() {
        return launches;
    }

    public void setLaunches(List<LaunchDTO> launches) {
        this.launches = launches;
    }

    public Integer getOffest() {
        return offest;
    }

    public void setOffest(Integer offest) {
        this.offest = offest;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
