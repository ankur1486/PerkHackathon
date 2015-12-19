package advertisement.perk.com.perkapp.screens.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import advertisement.perk.com.perkapp.R;
import advertisement.perk.com.perkapp.adapter.AdsListingAdapter;
import advertisement.perk.com.perkapp.circlerefresh.CircleRefreshLayout;
import advertisement.perk.com.perkapp.model.Advertisement;
import advertisement.perk.com.perkapp.screens.BaseV4Fragment;

/**
 * landing screen with listing of ads
 */
public class AdsListFragment extends BaseV4Fragment {

    private CircleRefreshLayout mRefreshLayout;
    private boolean mIsRefreshing = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ads_listing, null);

        initUiComponents(view);
        return view;
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_ads_listing);
//
//        setActionBar(R.string.app_name, false, false);
//
//        initUiComponents(view);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//    }

    private void initUiComponents(View view) {
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.ads_listing_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerViewDialogFragment newFragment = new DatePickerFragment();
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<Advertisement> madvertisementArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Advertisement advertisement = new Advertisement();
            advertisement.setDescription("Ads one :" + i);
            advertisement.setHeading("");

            madvertisementArrayList.add(advertisement);
        }

        AdsListingAdapter mAdapter = new AdsListingAdapter(getActivity(), madvertisementArrayList);
        mRecyclerView.setAdapter(mAdapter);

        mRefreshLayout = (CircleRefreshLayout) view.findViewById(R.id.refresh_layout);
        mRefreshLayout.setOnRefreshListener(new CircleRefreshLayout.OnCircleRefreshListener() {
            @Override
            public void completeRefresh() {
                mIsRefreshing = true;
                mRefreshLayout.finishRefreshing();
            }

            @Override
            public void refreshing() {

            }
        });
    }

    @Override
    public void onDialogButtonClick(DialogInterface dialog, int which, int alertCode) {

    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                finish();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

}
