package com.strila.petproject.ui.flow1.screen2.list;

import android.support.annotation.NonNull;
import android.support.v7.util.SortedList;
import android.support.v7.widget.util.SortedListAdapterCallback;
import android.view.View;

import com.strila.petproject.R;
import com.strila.petproject.data.models.User;
import com.strila.petproject.utils.UltimateAdapter;

/**
 * Created by Serhii Strila on 3/23/17
 */

public class UserAdapter extends UltimateAdapter<UserVH> implements UltimateAdapter.FooterInterface {

    public static final int FOOTER_VIEW_TYPE = 1;
    public static final int FOOTER_COUNT = 1;
    private static final int DATA_VIEW_TYPE = 0;

    private boolean mFooterVisibility;

    private SortedList<User> mItems = new SortedList<>(User.class, new SortedListAdapterCallback<User>(this) {
        @Override
        public int compare(User user1, User user2) {
            return user1.getCreatedAt().compareTo(user2.getCreatedAt());
        }

        @Override
        public boolean areContentsTheSame(User oldItem, User newItem) {
            return oldItem.getCreatedAt().equals(newItem.getCreatedAt());
        }

        @Override
        public boolean areItemsTheSame(User item1, User item2) {
            return item1.getId() == item2.getId();
        }
    });

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
        return mItems.size();
    }

    @Override
    public int getDataViewResId(int viewType) {
        return R.layout.item_user;
    }

    @Override
    public long getDataId(int dataPosition) {
        return mItems.get(dataPosition).hashCode();
    }

    @Override
    public int getDataViewType(int dataPosition) {
        return DATA_VIEW_TYPE;
    }

    @NonNull
    @Override
    public UserVH getDataViewHolder(@NonNull View v, int dataViewType) {
        return new UserVH(v);
    }

    @Override
    public void bindDataVH(@NonNull UserVH vh, int dataPosition) {
        vh.bind(mItems.get(dataPosition));
    }

    public void setLoadingVisibility(boolean visible) {
        if (!withFooter() || mFooterVisibility == visible) {
            return;
        }
        mFooterVisibility = visible;
        try {
            notifyItemChanged(mItems.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addItem(User user) {
        mItems.add(user);
    }
}
