package example.lgcode.launchstatus.dtos;

import java.io.Serializable;
import java.util.List;

/**
 * Created by leojg on 2/15/17.
 */

public class LaunchListResultDTO implements Serializable {
    private List<LaunchDTO> launches;
    private Integer total;
    private Integer count;

    public LaunchListResultDTO(List<LaunchDTO> launches, Integer total, Integer count) {
        this.launches = launches;
        this.total = total;
        this.count = count;
    }

    public List<LaunchDTO> getLaunches() {
        return launches;
    }

    public void setLaunches(List<LaunchDTO> launches) {
        this.launches = launches;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
