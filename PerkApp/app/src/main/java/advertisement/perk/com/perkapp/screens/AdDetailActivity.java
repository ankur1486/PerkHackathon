package advertisement.perk.com.perkapp.screens;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import advertisement.perk.com.perkapp.R;

public class AdDetailActivity extends BaseActivity {

    private String mTitle = "";
    private String mDescription = "";
    private String mImgUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_detail);

        mTitle = getIntent().getStringExtra("title");
        mDescription = getIntent().getStringExtra("description");
        mImgUrl = getIntent().getStringExtra("imgurl");

        setActionBar(R.string.app_name, false, false);

        initUiComponenets();

    }

    /**
     * initialize ui componenst
     */
    private void initUiComponenets() {
        ImageView imageView = (ImageView) findViewById(R.id.addetail_image);

        Picasso.with(AdDetailActivity.this)
                .load(mImgUrl)
                .into(imageView);

        TextView titleTextView = (TextView) findViewById(R.id.ad_detail_title_Textview);
        titleTextView.setText(mTitle);

        TextView descriptionTextView = (TextView) findViewById(R.id.ad_description_textView);
        descriptionTextView.setText(mDescription);


    }

    @Override
    public void onDialogButtonClick(DialogInterface dialog, int which, int alertCode) {

    }
}
