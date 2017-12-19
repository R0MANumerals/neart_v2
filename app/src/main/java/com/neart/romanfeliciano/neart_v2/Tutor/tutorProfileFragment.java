package com.neart.romanfeliciano.neart_v2.Tutor;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neart.romanfeliciano.neart_v2.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class tutorProfileFragment extends Fragment {


    public tutorProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.tutor_fragment_profile, container, false);
    }

}
