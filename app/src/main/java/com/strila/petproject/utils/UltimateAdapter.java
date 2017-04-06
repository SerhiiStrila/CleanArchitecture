package com.strila.petproject.utils;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Serhii Strila on 18.11.15
 */
public abstract class UltimateAdapter<T extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_MAX_COUNT = 1000;
    private static final int HEADER_VIEW_TYPE_OFFSET = 0;
    private static final int FOOTER_VIEW_TYPE_OFFSET = HEADER_VIEW_TYPE_OFFSET + VIEW_TYPE_MAX_COUNT;
    private static final int CONTENT_VIEW_TYPE_OFFSET = FOOTER_VIEW_TYPE_OFFSET + VIEW_TYPE_MAX_COUNT;

    private LayoutInflater mLayoutInflater;

    private int headerItemCount;
    private int contentItemCount;
    private int footerItemCount;

    public interface HeaderInterface {

        int getHeaderItemCount();

        HeaderVH getHeaderVH(View v, int type);

        @LayoutRes
        int getHeaderViewResId(int type);

        void bindHeaderVH(HeaderVH vh, int position);

        int getHeaderViewType(int position);

        long getHeaderItemId(int position);
    }

    public interface FooterInterface {

        int getFooterItemCount();

        FooterVH getFooterVH(View v, int type);

        @LayoutRes
        int getFooterViewResId(int type);

        void bindFooterVH(FooterVH vh, int position);


        int getFooterViewType(int position);

        long getFooterItemId(int position);
    }

    public UltimateAdapter() {
        setHasStableIds(true);
    }

    @Override
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mLayoutInflater == null) {
            mLayoutInflater = LayoutInflater.from(parent.getContext());
        }
        if (viewType >= HEADER_VIEW_TYPE_OFFSET && viewType < HEADER_VIEW_TYPE_OFFSET + VIEW_TYPE_MAX_COUNT) {
            HeaderInterface headerInterface = getThisHeader();
            int type = viewType - HEADER_VIEW_TYPE_OFFSET;
            return headerInterface.getHeaderVH(getViewById(headerInterface.getHeaderViewResId(type), parent), type);
        } else if (viewType >= FOOTER_VIEW_TYPE_OFFSET && viewType < FOOTER_VIEW_TYPE_OFFSET + VIEW_TYPE_MAX_COUNT) {
            FooterInterface footerInterface = getThisFooter();
            int type = viewType - FOOTER_VIEW_TYPE_OFFSET;
            return footerInterface.getFooterVH(getViewById(footerInterface.getFooterViewResId(type), parent), type);
        } else if (viewType >= CONTENT_VIEW_TYPE_OFFSET && viewType < CONTENT_VIEW_TYPE_OFFSET + VIEW_TYPE_MAX_COUNT) {
            int type = viewType - CONTENT_VIEW_TYPE_OFFSET;
            return getDataViewHolder(getViewById(getDataViewResId(type), parent), type);
        } else {
            // This shouldn't happen as we check that the viewType provided by the client is valid.
            throw new IllegalStateException();
        }
    }

    @Override
    public final void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (withHeader() && position < headerItemCount) {
            // bind header
            getThisHeader().bindHeaderVH((HeaderVH) holder, getHeaderPosition(position));
        } else if (contentItemCount > 0 && position - headerItemCount < contentItemCount) {
            // bind data
            bindDataVH((T) holder, getDataPosition(position));
        } else if (withFooter()) {
            // bind footer
            getThisFooter().bindFooterVH((FooterVH) holder, getFooterPosition(position));
        }
    }

    @Override
    public final int getItemViewType(int position) {
        if (withHeader() && position < headerItemCount) {
            return validateViewType(getThisHeader().getHeaderViewType(position)) + HEADER_VIEW_TYPE_OFFSET;
        } else if (contentItemCount > 0 && position - headerItemCount < contentItemCount) {
            return validateViewType(getDataViewType(position - headerItemCount)) + CONTENT_VIEW_TYPE_OFFSET;
        } else {
            return validateViewType(getThisFooter().getFooterViewType(position - headerItemCount - contentItemCount))
                    + FOOTER_VIEW_TYPE_OFFSET;
        }
    }

    @Override
    public long getItemId(int position) {
        if (withHeader() && position < headerItemCount) {
            return getThisHeader().getHeaderItemId(getHeaderPosition(position));
        } else if (contentItemCount > 0 && position - headerItemCount < contentItemCount) {
            return getDataId(getDataPosition(position));
        } else {
            return getThisFooter().getFooterItemId(getFooterPosition(position));
        }
    }

    @Override
    public final int getItemCount() {
        if (withHeader()) {
            headerItemCount = getThisHeader().getHeaderItemCount();
        }
        if (withFooter()) {
            footerItemCount = getThisFooter().getFooterItemCount();
        }
        contentItemCount = getDataItemCount();
        return headerItemCount + contentItemCount + footerItemCount;
    }

    public int getItemType(int realPosition) {
        int viewType = getItemViewType(realPosition);
        if (viewType >= HEADER_VIEW_TYPE_OFFSET && viewType < HEADER_VIEW_TYPE_OFFSET + VIEW_TYPE_MAX_COUNT) {
            return viewType - HEADER_VIEW_TYPE_OFFSET;
        } else if (viewType >= FOOTER_VIEW_TYPE_OFFSET && viewType < FOOTER_VIEW_TYPE_OFFSET + VIEW_TYPE_MAX_COUNT) {
            return viewType - FOOTER_VIEW_TYPE_OFFSET;
        } else if (viewType >= CONTENT_VIEW_TYPE_OFFSET && viewType < CONTENT_VIEW_TYPE_OFFSET + VIEW_TYPE_MAX_COUNT) {
            return viewType - CONTENT_VIEW_TYPE_OFFSET;
        } else {
            // This shouldn't happen as we check that the viewType provided by the client is valid.
            throw new IllegalStateException();
        }
    }

    public boolean withFooter() {
        return this instanceof FooterInterface;
    }

    public boolean withHeader() {
        return this instanceof HeaderInterface;
    }

    public abstract int getDataItemCount();

    @LayoutRes
    public abstract int getDataViewResId(int viewType);

    public abstract long getDataId(int dataPosition);

    public abstract int getDataViewType(int dataPosition);

    @NonNull
    public abstract T getDataViewHolder(@NonNull View v, int dataViewType);

    public abstract void bindDataVH(@NonNull T vh, int dataPosition);

    public boolean hasData() {
        return getDataItemCount() > 0;
    }

    private int getHeaderPosition(int absolutePosition) {
        return absolutePosition;
    }

    private int getDataPosition(int absolutePosition) {
        int result = absolutePosition;
        if (withHeader()) {
            result -= headerItemCount;
        }
        return result;
    }

    private int getFooterPosition(int absolutePosition) {
        int result = absolutePosition;
        if (withHeader()) {
            result -= headerItemCount;
        }
        result -= contentItemCount;
        return result;
    }

    private int validateViewType(int viewType) {
        if (viewType < 0 || viewType >= VIEW_TYPE_MAX_COUNT) {
            throw new IllegalStateException("viewType must be between 0 and " + VIEW_TYPE_MAX_COUNT);
        }
        return viewType;
    }

    private View getViewById(@LayoutRes int id, ViewGroup parent) {
        return mLayoutInflater.inflate(id, parent, false);
    }

    private FooterInterface getThisFooter() {
        return (FooterInterface) this;
    }

    private HeaderInterface getThisHeader() {
        return (HeaderInterface) this;
    }

    public abstract static class FooterVH extends RecyclerView.ViewHolder {

        public FooterVH(View itemView) {
            super(itemView);
        }

        public abstract void hideFooter(boolean hide);
    }

    public abstract static class HeaderVH extends RecyclerView.ViewHolder {

        public HeaderVH(View itemView) {
            super(itemView);
        }

        public abstract void hideHeader(boolean hide);

    }

}