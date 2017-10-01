package com.strila.petproject.ui.main.posts.list;

import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.strila.petproject.R;
import com.strila.petproject.data.models.local.Post;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Serhii Strila on 3/23/17
 */

class PostVH extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_title) TextView txtTitle;
    @BindView(R.id.txt_author) TextView txtAuthor;
    @BindView(R.id.img_thumb) ImageView imgThumb;
    @BindView(R.id.txt_time) TextView txtTime;
    @BindView(R.id.txt_comments) TextView txtComments;

    private Post post;
    private PostItemClickListener listener;

    PostVH(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void setListener(PostItemClickListener listener) {
        this.listener = listener;
    }

    void bind(Post post) {
        this.post = post;
        txtTitle.setText(post.getTitle());
        txtAuthor.setText(post.getAuthor());
        txtTime.setText(DateUtils.getRelativeTimeSpanString(post.getCreatedDate().getTime(),
                System.currentTimeMillis(), DateUtils.MINUTE_IN_MILLIS, DateUtils.FORMAT_ABBREV_RELATIVE));
        if (post.getThumb() != null) {
            imgThumb.setVisibility(View.VISIBLE);
            Picasso.with(itemView.getContext())
                    .load(post.getThumb())
                    .placeholder(R.drawable.ic_filter_hdr_black_24dp)
                    .into(imgThumb);
        } else {
            imgThumb.setVisibility(View.GONE);
        }
        txtComments.setText(itemView.getResources().getString(R.string.comments, post.getCommentsCount()));
    }

    @OnClick(R.id.img_thumb)
    void onImageClick(View view) {
        if (listener != null && post != null) {
            listener.onImageClick(view, post.getImgSource());
        }
    }
}
