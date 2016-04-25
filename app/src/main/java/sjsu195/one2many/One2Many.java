package sjsu195.one2many;

import com.parse.Parse;

/**
 * Created by Aqeel on 4/25/16.
 */
public class One2Many extends android.app.Application {
    @Override
    public void onCreate(){
        super.onCreate();

        ParseValues a = new ParseValues();

        Parse.initialize(new Parse.Configuration.Builder(this.getApplicationContext())
                .applicationId(a.getAppId())
                .clientKey(a.getClientKey())
                .server(a.getHost())
                .build()
        );
    }
}
