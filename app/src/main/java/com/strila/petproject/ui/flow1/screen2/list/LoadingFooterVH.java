package com.strila.petproject.ui.flow1.screen2.list;

import android.databinding.DataBindingUtil;
import android.view.View;

import com.strila.petproject.databinding.ItemLoadingFooterBinding;
import com.strila.petproject.utils.UltimateAdapter;

/**
 * Created by Serhii Strila on 3/23/17
 */

public class LoadingFooterVH extends UltimateAdapter.FooterVH {

    private final ItemLoadingFooterBinding mBinding;

    public LoadingFooterVH(View itemView) {
        super(itemView);
        mBinding = DataBindingUtil.bind(itemView);
    }

    @Override
    public void hideFooter(boolean hide) {
        mBinding.setShow(!hide);
        mBinding.executePendingBindings();
    }
}
