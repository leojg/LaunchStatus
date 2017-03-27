package example.lgcode.launchstatus.utils;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import example.lgcode.launchstatus.R;

/**
 * Created by leojg on 1/20/17.
 */

public class LaunchStatusUtils {

    @BindingAdapter("bind:colorStatus")
    public static void setBackgroundColorFromStatus(View view, Integer status) {

        Context context = view.getContext();

        switch (status) {
            case 1:
                view.setBackgroundColor(ContextCompat.getColor(context,R.color.statusOk));
                break;
            case 2:
                view.setBackgroundColor(ContextCompat.getColor(context,R.color.statusNotOk));
                break;
            case 3:
                view.setBackgroundColor(ContextCompat.getColor(context,R.color.statusSuccess));
                break;
            case 4:
                view.setBackgroundColor(ContextCompat.getColor(context,R.color.statusFail));
                break;
        }
    }

    @BindingAdapter("bind:textStatus")
    public static void setTextFromStatus(TextView view, Integer status) {
        Context context = view.getContext();
        switch (status) {
            case 1:
                view.setText("Ok");
                view.setTextColor(ContextCompat.getColor(context, R.color.statusOk));
                break;
            case 2:
                view.setText("Not Ok");
                view.setTextColor(ContextCompat.getColor(context, R.color.statusNotOk));
                break;
            case 3:
                view.setText("Success");
                view.setTextColor(ContextCompat.getColor(context, R.color.statusSuccess));
                break;
            case 4:
                view.setText("Fail");
                view.setTextColor(ContextCompat.getColor(context, R.color.statusFail));
                break;
        }
    }

}
