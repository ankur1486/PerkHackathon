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

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import advertisement.perk.com.perkapp.R;
import advertisement.perk.com.perkapp.model.Advertisement;
import advertisement.perk.com.perkapp.screens.AdDetailActivity;


/**
 * LocateAddressListAdapter
 */
public class AdsListingAdapter extends RecyclerView.Adapter<AdsListingAdapter.AdsViewHolder> {
    // activity context
    private final Context mContext;
    // list data transactionDetails
    private List<Advertisement> mDataset;

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdsListingAdapter(Context context, List<Advertisement> myDataset) {

        mDataset = myDataset;
        mContext = context;
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
        final Advertisement advertisement = mDataset.get(position);

        if (advertisement != null) {

            if (!TextUtils.isEmpty(advertisement.getDescription())) {
                holder.centreName_Text.setText(advertisement.getDescription());
            }
//            if (!TextUtils.isEmpty(transaction.getType()getDate())) {

            Random rand = new Random();

            // nextInt is normally exclusive of the top value,
            // so add 1 to make it inclusive
            int randomNum = rand.nextInt((100000 - 0) + 1) + 0;

            holder.centreAddress_Text.setText("Ads ID :" + randomNum);

            holder.card_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.d("TAG", "onClick() called with: " + "v = [" + v + "]");

                    Intent intent = new Intent(mContext, AdDetailActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class AdsViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case

        public TextView centreName_Text;
        public TextView centreAddress_Text;

        public TextView balance_textview;
        public TextView txn_date_textview;

        public CardView card_view;

        //----------------------------------values --------------
        public AdsViewHolder(View v) {
            super(v);
            centreName_Text = (TextView) v.findViewById(R.id.centre_name_textview);
            centreAddress_Text = (TextView) v.findViewById(R.id.centre_address_textview);

            balance_textview = (TextView) v.findViewById(R.id.balance_textview);
            txn_date_textview = (TextView) v.findViewById(R.id.txn_date_textview);

            card_view = (CardView) v.findViewById(R.id.card_view);
        }
    }

}
