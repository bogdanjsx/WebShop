/*import java.util.Map;
import android.util.Log;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class ServerConnection 
{   
    private AsyncHttpClient client = new AsyncHttpClient();
    public String URL = "adresa:port/api";
    static ServerConnection instance;

    public static ServerConnection sharedInstance()
    {
        if( instance == null )
        {
            instance = new ServerConnection();
        }

        return instance;
    }

    public void getRequest(String path,Map<String,String> params, AsyncHttpResponseHandler handle)
    {
        String requestParams = "?";

        for(Map.Entry<String, String> entry : params.entrySet())
        {
            requestParams += entry.getKey() + "=" + entry.getValue() + "&";
        }

        Log.d("MY_DEBUG","Making request at :" +URL + path + requestParams);
        client.get(URL + path + requestParams, handle);

    }

    public void postRequest(String path,RequestParams params, AsyncHttpResponseHandler handler)
    {
        Log.d("MY_DEBUG","Making request at :" +URL + path);
        client.post(URL + path,params,handler);
    }   
}*/