package example.lgcode.launchstatus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.squareup.otto.Bus;

import example.lgcode.launchstatus.dtos.LaunchDTO;
import example.lgcode.launchstatus.models.LaunchDetailModel;
import example.lgcode.launchstatus.presenters.LaunchDetailPresenter;
import example.lgcode.launchstatus.utils.BusProvider;
import example.lgcode.launchstatus.views.LaunchDetailView;

/**
 * Created by leojg on 3/2/17.
 */

public class LaunchDetailActivity extends AppCompatActivity {
    private Bus bus = BusProvider.getInstance();
    private LaunchDetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        LaunchDTO launch = (LaunchDTO) intent.getSerializableExtra("launch");

        presenter = new LaunchDetailPresenter(
                new LaunchDetailView(this, bus),
                new LaunchDetailModel(launch, bus)
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
