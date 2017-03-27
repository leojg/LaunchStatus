package example.lgcode.launchstatus.views;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Animatable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import example.lgcode.launchstatus.LaunchDetailActivity;
import example.lgcode.launchstatus.R;
import example.lgcode.launchstatus.adapters.LaunchListAdapter;
import example.lgcode.launchstatus.databinding.ActivityLaunchStatusBinding;
import example.lgcode.launchstatus.dtos.LaunchDTO;

/**
 * Created by leojg on 1/20/17.
 */
public class LaunchStatusView {

    Bus bus;
    ActivityLaunchStatusBinding binding;

    AppCompatActivity activity;

    private boolean isLoading;
    private int pageSize;


    public LaunchStatusView(AppCompatActivity activity, final Bus bus) {

        this.bus = bus;

        this.activity = activity;

        binding = DataBindingUtil.setContentView(activity,R.layout.activity_launch_status);
        binding.launchList.setLayoutManager(new LinearLayoutManager(activity));
        binding.launchList.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

                if (!isLoading) {
                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                            && firstVisibleItemPosition >= 0
                            && totalItemCount >= pageSize) {

                        isLoading = true;
                        binding.progressBar.setVisibility(View.VISIBLE);
                        bus.post(new LaunchesRequestEvent());

                    }
                }
            }
        });
    }

    public void setAdapter(LaunchListAdapter adapter) {
        binding.launchList.setAdapter(adapter);
    }

    public void updateList(Integer currentPageSize) {
        binding.progressBar.setVisibility(View.GONE);
        binding.launchList.getAdapter().notifyDataSetChanged();
        isLoading = false;
        pageSize = currentPageSize;
    }

    public void openLaunchDetailActivity(LaunchDTO launchDTO) {
        Intent intent = new Intent(activity, LaunchDetailActivity.class);
        intent.putExtra("launch", launchDTO);
        activity.startActivity(intent);
    }

    public class LaunchesRequestEvent {}
}
