package com.amitraj.themoviedbapp.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amitraj.themoviedbapp.R;
import com.amitraj.themoviedbapp.databinding.FragmentDevelopedByBinding;
import com.amitraj.themoviedbapp.ui.BaseFragment;

/**
 * Created by AmitRaj on 16-Sep-17.
 */

public class FragmentDevelopedBy extends BaseFragment {
    public FragmentDevelopedBy(){}

    public static FragmentDevelopedBy newInstance() {
        Bundle args = new Bundle();
        FragmentDevelopedBy fragment = new FragmentDevelopedBy();
        fragment.setArguments(args);
        return fragment;
    }
    FragmentDevelopedByBinding mBinding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_developed_by,container,false);
        return mBinding.getRoot();
    }
}
