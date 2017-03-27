package example.lgcode.launchstatus.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import org.joda.time.DateTime;

import java.io.IOException;
import java.security.Timestamp;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by leojg on 1/24/17.
 */

public class ServiceGenerator {

    private static final String BASE_URL = "https://launchlibrary.net/1.2/";

    public static <S> S createService(Class<S> serviceClass) {

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        HttpUrl url = request
                                .url()
                                .newBuilder()
                                .build();
                        request = request.newBuilder()
                                .addHeader("Accept", "application/json")
                                .url(url)
                                .build();
                        return chain.proceed(request);
                    }
                })
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(DateTime.class, new DateTypeAdapter()).create();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient)
                .build()
                .create(serviceClass);
    }

    private static class DateTypeAdapter extends TypeAdapter<DateTime> {

        @Override
        public void write(JsonWriter out, DateTime value) throws IOException {
            if (value != null) {
                out.value(value.getMillis() / 1000);
            } else {
                out.nullValue();
            }
        }

        @Override
        public DateTime read(JsonReader in) throws IOException {
            if (in != null ) {
                return new DateTime(in.nextLong() / 1000);
            } else {
                return null;
            }
        }
    }

}
