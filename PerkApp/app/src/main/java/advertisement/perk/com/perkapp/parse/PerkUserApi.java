package advertisement.perk.com.perkapp.parse;

import android.util.Log;

import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

/**
 * Created by Agoel on 19-12-2015.
 */
public class PerkUserApi {

    // The callback interface
    public interface Callback {

        void loginSuccess(ParseUser user);

        void loginFailed(String phone);

        void getUserSuccess(ParseUser user);

        void getUserFailed(String str);
    }

    Callback callback;

    public PerkUserApi(Callback callback) {
        this.callback = callback;

    }

    public void getParseUser(final String email) {
        //ParseUser user = ParseUser.getCurrentUser();
        ParseQuery<ParseUser> query = ParseUser.getQuery();
        query.whereEqualTo("username", email);
        Log.i("Inside Get User", "getUser ");

        query.getFirstInBackground(new GetCallback<ParseUser>() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {
                if (e == null) {
                    Log.i("getFirstInBackground", "e==null ");
                    if (callback != null) {
                        callback.getUserSuccess(parseUser);
                    }
                } else {
                    Log.i("getFirstInBackground", "else ");
                    if (callback != null) {
                        callback.getUserFailed(email);
                    }
                }
            }
        });
    }

    public void loginParse(final String email, String password) {
        Log.i("Inside Login", "login ");
        ParseUser.logInInBackground(email, password, new LogInCallback() {
            public void done(ParseUser parseUser, ParseException e) {
                ParseUser user = parseUser;
                Log.i("Parse User", "Parse User " + user.getUsername());
                if (user != null) {
                    // Hooray! The user is logged in.
                    if (callback != null) {
                        callback.loginSuccess(user);
                    }
                } else {
                    // Signup failed. Look at the ParseException to see what happened.
                    if (callback != null) {
                        callback.loginFailed(email);
                    }
                }
            }
        });
    }
}
