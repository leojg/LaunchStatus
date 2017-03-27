package example.lgcode.launchstatus.network;

import example.lgcode.launchstatus.dtos.LaunchDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by leojg on 1/24/17.
 */

public interface LaunchService {

    @GET("launch?fields=id")
    Call<LaunchResponse> getLaunchs(@Query("offset") Integer offset, @Query("startdate") String date);

    @GET("launch/{launchId}")
    Call<LaunchResponse> getLaunch(@Path("launchId") Integer id);

}
