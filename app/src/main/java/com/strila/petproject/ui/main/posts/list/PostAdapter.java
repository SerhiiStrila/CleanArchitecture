package com.strila.petproject.ui.main.posts.list;

import android.support.annotation.NonNull;
import android.view.View;

import com.strila.petproject.R;
import com.strila.petproject.data.models.local.Post;
import com.strila.petproject.utils.UltimateAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serhii Strila on 3/23/17
 */

public class PostAdapter extends UltimateAdapter<PostVH> implements UltimateAdapter.FooterInterface {

    public static final int FOOTER_VIEW_TYPE = 1;
    public static final int FOOTER_COUNT = 1;
    private static final int DATA_VIEW_TYPE = 0;

    private boolean mFooterVisibility;

    private List<Post> items = new ArrayList<>();
    private PostItemClickListener listener;

    @Override
    public int getFooterItemCount() {
        return FOOTER_COUNT;
    }

    @Override
    public FooterVH getFooterVH(View v, int type) {
        return new LoadingFooterVH(v);
    }

    @Override
    public int getFooterViewResId(int type) {
        return R.layout.item_loading_footer;
    }

    @Override
    public void bindFooterVH(FooterVH vh, int position) {
        vh.hideFooter(false);
    }

    @Override
    public int getFooterViewType(int position) {
        return FOOTER_VIEW_TYPE;
    }

    @Override
    public long getFooterItemId(int position) {
        return position;
    }

    @Override
    public int getDataItemCount() {
        return items.size();
    }

    @Override
    public int getDataViewResId(int viewType) {
        return R.layout.item_post;
    }

    @Override
    public long getDataId(int dataPosition) {
        return items.get(dataPosition).hashCode();
    }

    @Override
    public int getDataViewType(int dataPosition) {
        return DATA_VIEW_TYPE;
    }

    @NonNull
    @Override
    public PostVH getDataViewHolder(@NonNull View v, int dataViewType) {
        PostVH vh = new PostVH(v);
        vh.setListener(listener);
        return vh;
    }

    @Override
    public void bindDataVH(@NonNull PostVH vh, int dataPosition) {
        vh.bind(items.get(dataPosition));
    }

    public void setLoadingVisibility(boolean visible) {
        if (!withFooter() || mFooterVisibility == visible) {
            return;
        }
        mFooterVisibility = visible;
        try {
            notifyItemChanged(items.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addItems(List<Post> posts) {
        items.addAll(posts);
        notifyDataSetChanged();
    }

    public void setItems(List<Post> posts) {
        items.addAll(posts);
        notifyDataSetChanged();
    }

    public void setListener(PostItemClickListener listener) {
        this.listener = listener;
    }
}
