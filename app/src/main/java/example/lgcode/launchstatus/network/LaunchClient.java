package example.lgcode.launchstatus.network;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import example.lgcode.launchstatus.dtos.LaunchDTO;
import example.lgcode.launchstatus.dtos.LaunchListResultDTO;
import example.lgcode.launchstatus.utils.DateProvider;

/**
 * Created by leojg on 1/24/17.
 */

public class LaunchClient {

    private LaunchService launchService;

    public LaunchClient() {
        launchService = ServiceGenerator.createService(LaunchService.class);
    }

    public LaunchListResultDTO fetchLaunches(Integer offset) throws IOException {
            LaunchResponse response = launchService.getLaunchs(offset, DateProvider.getCurrentDate()).execute().body();
            List<LaunchDTO> launchIds = response.getLaunches();

            LaunchListResultDTO launchListResult = new LaunchListResultDTO(
                    new ArrayList<LaunchDTO>(launchIds.size()), response.getTotal(), response.getCount());

            for (LaunchDTO launchId: launchIds) {
                LaunchDTO launchDTO = getLaunchData(launchId.getId());
                launchListResult.getLaunches().add(launchDTO);
            }

            return launchListResult;
    }

    private LaunchDTO getLaunchData(Integer id) throws IOException {
        LaunchResponse response = launchService.getLaunch(id).execute().body();
        LaunchDTO launch = response.getLaunches().get(0);

        return launch;
    }
}
