package advertisement.perk.com.perkapp.parse;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

/**
 * Created by Agoel on 19-12-2015.
 */
public class GetAdsApi {

    public interface Callback {
        public void getAdsSuccess(List<ParseObject> adsList);

        public void getAdsFailed(String s);
    }

    Callback callback;

    public GetAdsApi(Callback callback) {
        this.callback = callback;

    }

    public void getAdvertisementList() {
        final ParseUser user = ParseUser.getCurrentUser();
        ParseQuery<ParseObject> query = ParseQuery.getQuery("advertisements");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> userAdList, ParseException e) {
                if (e == null) {
                    Log.d("Groups", "Retrieved " + userAdList.size() + " groups");
                    callback.getAdsSuccess(userAdList);
                } else {
                    Log.d("Groups", "Error: " + e.getMessage());
                    callback.getAdsFailed(e.getMessage());
                }
            }
        });
    }

}
