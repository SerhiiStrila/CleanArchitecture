package com.strila.petproject.ui.main.posts;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.strila.petproject.R;
import com.strila.petproject.data.models.local.Post;
import com.strila.petproject.ui.base.BaseFragment;
import com.strila.petproject.ui.main.posts.list.PostAdapter;
import com.strila.petproject.ui.main.posts.list.PostItemClickListener;
import com.strila.petproject.utils.EndlessListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Serhii Strila on 1/11/17
 */

public final class PostListFragment extends BaseFragment<PostListContract.Presenter>
        implements PostListContract.View, PostItemClickListener {

    private static final String POSITION_FROM_TOP = "POSITION_FROM_TOP";

    @Inject PostListContract.Presenter presenter;

    @BindView(R.id.rv_photos) RecyclerView rvPhotos;

    private PostAdapter postAdapter;
    private Unbinder unbind;
    private LinearLayoutManager layoutManager;
    private Parcelable parcelable;

    public static PostListFragment newInstance() {
        PostListFragment fragment = new PostListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            parcelable = savedInstanceState.getParcelable(POSITION_FROM_TOP);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_list, container, false);
        unbind = ButterKnife.bind(this, view);
        initList();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState == null) {
            presenter.reload();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        parcelable = layoutManager.onSaveInstanceState();
        outState.putParcelable(POSITION_FROM_TOP, parcelable);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbind.unbind();
    }

    @Override
    public void addPosts(List<Post> posts) {
        postAdapter.addItems(posts);
        if (parcelable != null) {
            layoutManager.onRestoreInstanceState(parcelable);
            parcelable = null;
        }
    }

    @Override
    public void setPosts(List<Post> posts) {
        postAdapter.setItems(posts);
        if (parcelable != null) {
            layoutManager.onRestoreInstanceState(parcelable);
            parcelable = null;
        }
    }

    @Override
    public void showLoading(boolean loading) {
        postAdapter.setLoadingVisibility(loading);
    }

    @Override
    protected PostListContract.Presenter getPresenter() {
        return presenter;
    }

    private void initList() {
        postAdapter = new PostAdapter();
        postAdapter.setListener(this);
        layoutManager = new LinearLayoutManager(getActivity());
        rvPhotos.setLayoutManager(layoutManager);
        rvPhotos.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        rvPhotos.setAdapter(postAdapter);
        rvPhotos.addOnScrollListener(new EndlessListener(layoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                presenter.loadMore();
            }
        });
    }

    @Override
    public void onImageClick(View view, String imageUrl) {
        presenter.showImage(view, imageUrl);
    }
}
