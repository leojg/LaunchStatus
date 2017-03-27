package example.lgcode.launchstatus.presenters;

import com.squareup.otto.Subscribe;

import example.lgcode.launchstatus.adapters.LaunchListAdapter;
import example.lgcode.launchstatus.dtos.LaunchDTO;
import example.lgcode.launchstatus.models.LaunchStatusModel;
import example.lgcode.launchstatus.utils.BusProvider;
import example.lgcode.launchstatus.views.LaunchStatusView;

/**
 * Created by leojg on 1/20/17.
 */

public class LaunchStatusPresenter {

    LaunchStatusView view;
    LaunchStatusModel model;

    public LaunchStatusPresenter(LaunchStatusView view, LaunchStatusModel model) {
        this.view = view;
        this.model = model;

        this.view.setAdapter(new LaunchListAdapter(model.getLaunches(), BusProvider.getInstance()));

    }

    @Subscribe
    public void onLaunchesRequested(LaunchStatusView.LaunchesRequestEvent event) {
        model.fetchLaunchStatus();
    }

    @Subscribe
    public void onLaunchesFetched(LaunchStatusModel.LaunchesFetchedEvent event) {
        view.updateList(model.getCurrentCount());
    }

    @Subscribe
    public void OnOpenLaunchDetail(LaunchListAdapter.OpenLaunchDetailEvent e) {
        LaunchDTO launch = e.launch;
        view.openLaunchDetailActivity(launch);
    }
}
