package com.moringaschool.myspace.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.moringaschool.myspace.models.Apods;
import com.moringaschool.myspace.R;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ApodsDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class ApodsDetailFragment extends Fragment implements View.OnClickListener{
    @BindView(R.id.imageView) ImageView mImageLabel;
    @BindView(R.id.copyright) TextView mCopyright;
    @BindView(R.id.date) TextView mDate;
    @BindView(R.id.explanation) TextView mExplanation;
    @BindView(R.id.hdurl) TextView mHdurl;
    @BindView(R.id.media_type) TextView mMedia_type;
    @BindView(R.id.service_version) TextView mService_version;
    @BindView(R.id.title) TextView mTitle;
    @BindView(R.id.url) TextView mUrl;

    private Apods mApods;
    public ApodsDetailFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     //     * @param param1 Parameter 1.
     //     * @param param2 Parameter 2.
     * @return A new instance of fragment ApodsDetailFragment.
     */

    public static ApodsDetailFragment newInstance (Apods apods){
        ApodsDetailFragment apodsDetailFragment = new ApodsDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("apods", Parcels.wrap(apods));
        apodsDetailFragment.setArguments(args);
        return apodsDetailFragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApods = Parcels.unwrap(getArguments().getParcelable("apods"));
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.apod_detail_fragment, container, false);
        ButterKnife.bind(this, view);

        List<String> Apods = new ArrayList<>();

        mCopyright.setText(mApods.getCopyright());
        mDate.setText(mApods.getDate());
        mExplanation.setText(mApods.getExplanation());
        mHdurl.setText(mApods.getHdurl());
        mMedia_type.setText(mApods.getMediaType());
        mService_version.setText(mApods.getServiceVersion());
        mTitle.setText(mApods.getTitle());
        mUrl.setText(mApods.getUrl());

        //Setting up of Implicit intent
//        mUrl.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mUrl) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
            Uri.parse(String.valueOf(mUrl.getUrls())));
            startActivity(webIntent);
        }
    }
}

