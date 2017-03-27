package example.lgcode.launchstatus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.squareup.otto.Bus;

import example.lgcode.launchstatus.models.LaunchStatusModel;
import example.lgcode.launchstatus.presenters.LaunchStatusPresenter;
import example.lgcode.launchstatus.utils.BusProvider;
import example.lgcode.launchstatus.views.LaunchStatusView;

public class LaunchStatusActivity extends AppCompatActivity {

    private Bus bus = BusProvider.getInstance();
    private LaunchStatusPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new LaunchStatusPresenter(
                new LaunchStatusView(this, bus),
                new LaunchStatusModel(bus)
        );
    }

    @Override
    protected void onStart() {
        super.onStart();
        bus.register(presenter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        bus.unregister(presenter);
    }
}
