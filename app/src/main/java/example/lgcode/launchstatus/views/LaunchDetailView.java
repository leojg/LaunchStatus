package example.lgcode.launchstatus.views;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.squareup.otto.Bus;

import org.joda.time.DateTime;

import example.lgcode.launchstatus.R;
import example.lgcode.launchstatus.databinding.ActivityLaunchDetailBinding;
import example.lgcode.launchstatus.dtos.LaunchDTO;
import example.lgcode.launchstatus.dtos.MissionDTO;

/**
 * Created by leojg on 3/2/17.
 */

public class LaunchDetailView implements View.OnClickListener {

    private Bus bus;
    private ActivityLaunchDetailBinding binding;

    AppCompatActivity activity;

    public LaunchDetailView(AppCompatActivity activity, Bus bus) {
        this.bus = bus;

        this.activity = activity;
        binding = DataBindingUtil.setContentView(activity,R.layout.activity_launch_detail);

        activity.setSupportActionBar(binding.detailToolbar);

        setHomeAsUpEnabled(true);
    }

    public void updateView(LaunchDTO launch) {
        //for now just show the first one
        MissionDTO missionDTO = launch.getMissions().get(0);

        binding.setLaunch(launch);
        binding.setView(this);

        //binding.agencyData.setLabel("Agency");
        //binding.agencyData.setValue(missionDTO.getAgency().getName());

        //binding.launchWindowData.setLabel("Launch Window");
        //binding.launchWindowData.setValue(m);

        binding.rocketData.setLabel("Rocket");
        binding.rocketData.setValue(launch.getRocket().getName());

        binding.locationData.setLabel("Location");
        binding.locationData.setValue(launch.getLocation().getName());

    }

    public void openVidURL(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivity(intent.createChooser(intent, "Play this video with:"));
        }
    }

//    private String formatLaunchWindow(DateTime start, DateTime end) {
//
//    }

    public void setHomeAsUpEnabled(boolean showHomeAsUp) {

        ActionBar actionBar = activity.getSupportActionBar();

        binding.detailToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onBackPressed();
            }
        });
        actionBar.setDisplayHomeAsUpEnabled(showHomeAsUp);
    }

    @Override
    public void onClick(View view) {
        bus.post(new OpenVidURLEvent());
    }

    public class OpenVidURLEvent {}
}
