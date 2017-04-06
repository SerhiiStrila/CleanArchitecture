package com.strila.petproject.utils;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public abstract class EndlessListener extends RecyclerView.OnScrollListener {

    // The minimum amount of items to have below your current scroll position before
    // loading more.
    private static final int VISIBLE_THRESHOLD = 5;

    // FIXME: 3/23/17 hardcoded 1 item count for adapter footer
    private int previousTotal = 1; // The total number of items in the dataset after the last load

    // True if we are still waiting for the last set of data to load.
    private boolean loading;

    private int mCurrentPage = 1;

    private LinearLayoutManager mLinearLayoutManager;

    public EndlessListener(LinearLayoutManager linearLayoutManager) {
        mLinearLayoutManager = linearLayoutManager;
        loading = true;
    }

    public void reload() {
        previousTotal = 1;
        loading = false;
        mCurrentPage = 1;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if (!mLinearLayoutManager.getReverseLayout() && dy < 0 || mLinearLayoutManager.getReverseLayout() && dy > 0) {
            return;
        }
        int totalItemCount = mLinearLayoutManager.getItemCount();
        if (loading && totalItemCount > previousTotal) {
            loading = false;
            previousTotal = totalItemCount;
        }
        if (!loading && mLinearLayoutManager.findLastVisibleItemPosition() >= totalItemCount - VISIBLE_THRESHOLD) {
            loading = true;
            mCurrentPage++;
            onLoadMore(mCurrentPage);
        }

    }

    public abstract void onLoadMore(int currentPage);
}