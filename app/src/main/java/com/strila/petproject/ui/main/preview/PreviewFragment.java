package com.strila.petproject.ui.main.preview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.RequestCreator;
import com.strila.petproject.R;
import com.strila.petproject.ui.base.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Serhii Strila on 1/11/17
 */

public final class PreviewFragment extends BaseFragment<PreviewContract.Presenter>
        implements PreviewContract.View {

    public static final String IMAGE_URL_ARG = "IMAGE_URL";

    @Inject PreviewContract.Presenter presenter;

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.img_thumb) ImageView imgThumb;

    private Unbinder unbind;
    private String imageUrl;

    public static PreviewFragment newInstance(String imageUrl) {
        PreviewFragment fragment = new PreviewFragment();
        Bundle args = new Bundle();
        args.putString(IMAGE_URL_ARG, imageUrl);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            imageUrl = getArguments().getString(IMAGE_URL_ARG);
        } else {
            imageUrl = savedInstanceState.getString(IMAGE_URL_ARG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_preview, container, false);
        unbind = ButterKnife.bind(this, view);
        initToolbar();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.updateImage(imageUrl);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(IMAGE_URL_ARG, imageUrl);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbind.unbind();
    }

    @Override
    protected PreviewContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void showImage(RequestCreator image) {
        image.into(imgThumb);
    }

    private void initToolbar() {
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(view -> getActivity().onBackPressed());
    }

    @OnClick(R.id.img_thumb)
    void onClickImage() {
        presenter.openUrl(imageUrl);
    }
}
