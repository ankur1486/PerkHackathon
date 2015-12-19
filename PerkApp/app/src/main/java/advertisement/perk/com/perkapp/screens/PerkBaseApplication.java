package advertisement.perk.com.perkapp.screens;

import android.app.Application;
import android.content.Context;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;

/**
 * Created by Agoel on 19-12-2015.
 */
public class PerkBaseApplication extends Application {

    private static Context mAppContext = null;

    private static PerkBaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        System.out.println("------PerkBaseApplication-  onCreate");
        try {
            mAppContext = getApplicationContext();
        } catch (Exception e) {
            e.printStackTrace();
        }


        instance = this;

//        Parse.initialize(getAppContext(), getResources().getString(R.string.parse_app_id), getResources().getString(R.string.parse_client_key));

        init();
        Parse.initialize(this);
        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);
        ParseObject.registerSubclass(ParseUser.class);


    }

    /**
     * create a application instance
     */
    private void init() {
        if (instance == null) {
            instance = PerkBaseApplication.this;
        }
    }

    public static PerkBaseApplication getInstance() {
        return instance;
    }

    public static Context getAppContext() {
        return mAppContext;
    }

}
