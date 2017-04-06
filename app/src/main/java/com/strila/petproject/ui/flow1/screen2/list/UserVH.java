package com.strila.petproject.ui.flow1.screen2.list;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.strila.petproject.data.User;
import com.strila.petproject.databinding.ItemUserBinding;

/**
 * Created by Serhii Strila on 3/23/17
 */

public class UserVH extends RecyclerView.ViewHolder {

    private final ItemUserBinding mBinding;

    public UserVH(View itemView) {
        super(itemView);
        mBinding = DataBindingUtil.bind(itemView);
    }


    public void bind(User user) {
        mBinding.setUser(user);
    }
}
