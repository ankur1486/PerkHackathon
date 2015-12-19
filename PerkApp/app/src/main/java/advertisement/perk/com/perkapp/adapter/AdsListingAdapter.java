/**
 * Copyright Altimetrik ${2015}. All rights reserved.
 * <p/>
 * This software is the confidential and proprietary information
 * of Altimetrik. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms and conditions
 * entered into with Altimetrik.
 * <p/>
 * Id: ${TransactionHistoryListAdapter}, v 1.0
 * <p/>
 * Date Author Changes
 * ${date}, ${agoel}, Created
 */
package advertisement.perk.com.perkapp.adapter;

/**
 * Created by Agoel on 01-12-2015.
 */

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseObject;
import com.squareup.picasso.Picasso;

import java.util.List;

import advertisement.perk.com.perkapp.R;
import advertisement.perk.com.perkapp.screens.AdDetailActivity;


/**
 * LocateAddressListAdapter
 */
public class AdsListingAdapter extends RecyclerView.Adapter<AdsListingAdapter.AdsViewHolder> {
    // activity context
    private final Context mContext;
    // list data transactionDetails
//    private List<Advertisement> mDataset;
    List<ParseObject> parseData;

    public AdsListingAdapter(Context context, List<ParseObject> adsList) {

        mContext = context;
        parseData = adsList;

    }

    // Create new views (invoked by the layout manager)
    @Override
    public AdsViewHolder onCreateViewHolder(ViewGroup parent,
                                            int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_ads_detail, parent, false);
        // set the view's size, margins, paddings and layout parameters
        AdsViewHolder vh = new AdsViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(AdsViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final ParseObject advertisement = parseData.get((position));

        if (advertisement != null) {

            if (!TextUtils.isEmpty(advertisement.get("Image").toString())) {

                holder.adImaView.setVisibility(View.VISIBLE);

                Picasso.with(mContext)
                        .load(advertisement.get("Image").toString())
                        .resize(350, 200)
                        .into(holder.adImaView);

            } else {
                holder.adImaView.setVisibility(View.GONE);
            }

            if (!TextUtils.isEmpty(advertisement.get("ShortDescription").toString())) {
                holder.adTitle_Text.setText(advertisement.get("ShortDescription").toString());
            }

            if (!TextUtils.isEmpty(advertisement.get("ExpiresOn").toString())) {
                holder.adExpires_Text.setText(advertisement.get("ExpiresOn").toString());
            }

            holder.card_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(mContext, AdDetailActivity.class);

                    intent.putExtra("title", advertisement.get("ShortDescription").toString());
                    intent.putExtra("description", advertisement.get("LongDescription").toString());
                    intent.putExtra("imgurl", advertisement.get("Image").toString());
                    Bundle bundle = ActivityOptions.makeScaleUpAnimation(v, 0, 0, v.getWidth(), v.getHeight()).toBundle();
                    mContext.startActivity(intent, bundle);
                }
            });
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return parseData.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class AdsViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case

        public ImageView adImaView;
        public TextView adTitle_Text;
        public TextView adExpires_Text;

        public CardView card_view;

        //----------------------------------values --------------
        public AdsViewHolder(View v) {
            super(v);

            adImaView = (ImageView) v.findViewById(R.id.advertisement_imgView);
            adTitle_Text = (TextView) v.findViewById(R.id.ad_Title_textview);
            adExpires_Text = (TextView) v.findViewById(R.id.ad_expires_textview);

            card_view = (CardView) v.findViewById(R.id.card_view);
        }
    }

}
