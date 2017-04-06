package com.strila.petproject.ui.flow1.screen2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.strila.petproject.data.User;
import com.strila.petproject.databinding.FragmentFragment2Binding;
import com.strila.petproject.di.base.fragment.HasFragmentSubComponentBuilders;
import com.strila.petproject.ui.base.BaseFragment;
import com.strila.petproject.ui.flow1.screen2.list.UserAdapter;
import com.strila.petproject.utils.EndlessListener;

import javax.inject.Inject;

/**
 * Created by Serhii Strila on 1/11/17
 */

public final class Fragment2 extends BaseFragment<Fragment2Contract.Presenter> implements Fragment2Contract.View,
        Fragment2Contract.Listener {

    private static final int DEFAULT_COLUMN_NUMBERS = 3;

    @Inject Fragment2Contract.Presenter presenter;

    private FragmentFragment2Binding mBinding;
    private UserAdapter mUserAdapter;

    public static Fragment2 newInstance() {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        mBinding = FragmentFragment2Binding.inflate(inflater, container, false);
        mBinding.setListener(this);
        initList();
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.loadMore();
    }

    @Override
    public void onNextClick() {
        presenter.next();
    }

    @Override
    public void addUser(User user) {
        mUserAdapter.addItem(user);
    }

    @Override
    public void showLoading(boolean loading) {
        mUserAdapter.setLoadingVisibility(loading);
    }

    @Override
    protected void setupFragmentComponent(HasFragmentSubComponentBuilders builders) {
        ((Fragment2Component.Builder) builders.getFragmentComponentBuilder(Fragment2.class))
                .fragment(this)
                .build()
                .inject(this);
    }

    @Override
    protected Fragment2Contract.Presenter getPresenter() {
        return presenter;
    }

    private void initList() {
        RecyclerView recyclerView = mBinding.rvPhotos;
        mUserAdapter = new UserAdapter();
        recyclerView.setAdapter(mUserAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), DEFAULT_COLUMN_NUMBERS);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (mUserAdapter.getItemType(position)) {
                    case UserAdapter.FOOTER_VIEW_TYPE:
                        return layoutManager.getSpanCount();
                    default:
                        return 1;
                }
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new EndlessListener(layoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                presenter.loadMore();
            }
        });
    }
}
