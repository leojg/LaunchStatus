package example.lgcode.launchstatus.models;

import android.os.AsyncTask;

import com.squareup.otto.Bus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import example.lgcode.launchstatus.dtos.LaunchDTO;
import example.lgcode.launchstatus.dtos.LaunchListResultDTO;
import example.lgcode.launchstatus.network.LaunchClient;
import example.lgcode.launchstatus.network.LaunchResponse;

/**
 * Created by leojg on 1/20/17.
 */

public class LaunchStatusModel {

    private Bus bus;
    private LaunchClient client;
    private Integer currentCount;
    private List<LaunchDTO> launches;
    private Integer total;
    private Integer currentOffset = 0;
    private Integer OFFSET = 10;

    public LaunchStatusModel(Bus bus) {
        this.bus = bus;
        launches = new ArrayList<>();
        client = new LaunchClient();
        fetchLaunchStatus();
    }

    public List<LaunchDTO> getLaunches() {
        return launches;
    }

    public Integer getCurrentCount() {
        return currentCount;
    }

    public void fetchLaunchStatus() {

            new AsyncTask<Void, Void, Void>() {

                @Override
                protected Void doInBackground(Void... voids) {
                    try {

                        LaunchListResultDTO launchListResult = client.fetchLaunches(currentOffset);

                        if (total == null) {
                            total = launchListResult.getTotal();
                        }

                        currentCount = launchListResult.getCount();

                        for (LaunchDTO launch : launchListResult.getLaunches()) {
                            launches.add(launch);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                }


                @Override
                protected void onPostExecute(Void aVoid) {
                    super.onPostExecute(aVoid);
                    currentOffset += OFFSET;
                    bus.post(new LaunchesFetchedEvent());
                }
            }.execute();

    }

    public class LaunchesFetchedEvent {}

}
