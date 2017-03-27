package example.lgcode.launchstatus.presenters;

import com.squareup.otto.Subscribe;

import example.lgcode.launchstatus.models.LaunchDetailModel;
import example.lgcode.launchstatus.views.LaunchDetailView;

/**
 * Created by leojg on 3/2/17.
 */
public class LaunchDetailPresenter {

    LaunchDetailView view;
    LaunchDetailModel model;

    public LaunchDetailPresenter(LaunchDetailView view, LaunchDetailModel model) {
        this.view = view;
        this.model = model;

        view.updateView(model.getLaunch());

    }

    @Subscribe
    public void OnOpenVidURL(LaunchDetailView.OpenVidURLEvent e) {
        //dostuff
        String vidUrl = model.getLaunch().getVidURLs().get(0);
        view.openVidURL(vidUrl);


    }


}
