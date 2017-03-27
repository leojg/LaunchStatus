package example.lgcode.launchstatus.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.otto.Bus;

import java.util.List;

import example.lgcode.launchstatus.R;
import example.lgcode.launchstatus.databinding.LaunchListItemBinding;
import example.lgcode.launchstatus.dtos.LaunchDTO;

/**
 * Created by leojg on 1/20/17.
 */

public class LaunchListAdapter extends RecyclerView.Adapter<LaunchListAdapter.LaunchListViewHolder> {

    private Bus bus;
    private List<LaunchDTO> launches;

    private int lastPosition = -1;

    public LaunchListAdapter(List<LaunchDTO> launches, Bus bus) {
        this.bus = bus;
        this.launches = launches;
    }

    @Override
    public LaunchListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.launch_list_item, parent, false);
        return new LaunchListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LaunchListViewHolder holder, int position) {
        final LaunchDTO launch = launches.get(position);
        holder.getBinding().setLaunch(launch);
        holder.getBinding().executePendingBindings();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bus.post(new OpenLaunchDetailEvent(launch));
            }
        });

        setAnimation(holder.itemView, position);

    }

    @Override
    public int getItemCount() {
        return launches.size();
    }

    class LaunchListViewHolder extends RecyclerView.ViewHolder {

        LaunchListItemBinding binding;

        public LaunchListViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public LaunchListItemBinding getBinding() {
            return binding;
        }

    }

    private void setAnimation(View view, int position) {
        if (position > lastPosition) {
            view.animate().cancel();
            view.setTranslationY(100);
            view.setAlpha(0);
            view.animate().alpha(1.0f).translationY(0).setDuration(200).setStartDelay(100);
            lastPosition = position;
        }
    }

    public class OpenLaunchDetailEvent {
        public final LaunchDTO launch;

        public OpenLaunchDetailEvent(LaunchDTO launch) {
            this.launch = launch;
        }
    }
}
