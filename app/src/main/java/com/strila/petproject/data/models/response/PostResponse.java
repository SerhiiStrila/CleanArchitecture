package com.strila.petproject.data.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

import javax.annotation.Nullable;

/**
 * Created by Serhii Strila on 10/1/17
 */

public class PostResponse {

    @SerializedName("domain") @Expose private String domain;
    @SerializedName("preview") @Expose private Preview preview;
    @SerializedName("thumbnail_width") @Expose private long thumbnailWidth;
    @SerializedName("subreddit") @Expose private String subreddit;
    @SerializedName("selftext") @Expose private String selftext;
    @SerializedName("link_flair_text") @Expose private String linkFlairText;
    @SerializedName("id") @Expose private String id;
    @SerializedName("archived") @Expose private boolean archived;
    @SerializedName("clicked") @Expose private boolean clicked;
    @SerializedName("title") @Expose private String title;
    @SerializedName("num_crossposts") @Expose private long numCrossposts;
    @SerializedName("saved") @Expose private boolean saved;
    @SerializedName("can_mod_post") @Expose private boolean canModPost;
    @SerializedName("is_crosspostable") @Expose private boolean isCrosspostable;
    @SerializedName("pinned") @Expose private boolean pinned;
    @SerializedName("score") @Expose private long score;
    @SerializedName("over_18") @Expose private boolean over18;
    @SerializedName("hidden") @Expose private boolean hidden;
    @SerializedName("thumbnail") @Expose private String thumbnail;
    @SerializedName("subreddit_id") @Expose private String subredditId;
    @SerializedName("link_flair_css_class") @Expose private String linkFlairCssClass;
    @SerializedName("contest_mode") @Expose private boolean contestMode;
    @SerializedName("gilded") @Expose private long gilded;
    @SerializedName("downs") @Expose private long downs;
    @SerializedName("brand_safe") @Expose private boolean brandSafe;
    @SerializedName("removal_reason") @Expose private Object removalReason;
    @SerializedName("post_hint") @Expose private String postHint;
    @SerializedName("author_flair_text") @Expose private Object authorFlairText;
    @SerializedName("stickied") @Expose private boolean stickied;
    @SerializedName("can_gild") @Expose private boolean canGild;
    @SerializedName("thumbnail_height") @Expose private long thumbnailHeight;
    @SerializedName("parent_whitelist_status") @Expose private String parentWhitelistStatus;
    @SerializedName("name") @Expose private String name;
    @SerializedName("spoiler") @Expose private boolean spoiler;
    @SerializedName("permalink") @Expose private String permalink;
    @SerializedName("subreddit_type") @Expose private String subredditType;
    @SerializedName("locked") @Expose private boolean locked;
    @SerializedName("hide_score") @Expose private boolean hideScore;
    @SerializedName("created") @Expose private long created;
    @SerializedName("url") @Expose private String url;
    @SerializedName("whitelist_status") @Expose private String whitelistStatus;
    @SerializedName("quarantine") @Expose private boolean quarantine;
    @SerializedName("author") @Expose private String author;
    @SerializedName("created_utc") @Expose private Date createdAt;
    @SerializedName("subreddit_name_prefixed") @Expose private String subredditNamePrefixed;
    @SerializedName("ups") @Expose private long ups;
    @SerializedName("num_comments") @Expose private int numComments;
    @SerializedName("is_self") @Expose private boolean isSelf;
    @SerializedName("visited") @Expose private boolean visited;
    @SerializedName("is_video") @Expose private boolean isVideo;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public String getAuthor() {
        return author;
    }

    public Date getCreated() {
        return createdAt;
    }

    @Nullable
    public String getThumbnail() {
        return thumbnail;
    }

    public int getNumComments() {
        return numComments;
    }

    @Nullable
    public Preview getPreview() {
        return preview;
    }

    public static class Images {
        @SerializedName("source") @Expose private Image source;
        @SerializedName("resolutions") @Expose private List<Image> resolutions = null;
        @SerializedName("id") @Expose private String id;

        public Image getSource() {
            return source;
        }

        public List<Image> getImages() {
            return resolutions;
        }
    }

    public static class Image {

        @SerializedName("url") @Expose private String url;
        @SerializedName("width") @Expose private long width;
        @SerializedName("height") @Expose private long height;

        public String getUrl() {
            return url;
        }

    }

    public class Preview {

        @SerializedName("images") @Expose private List<Images> images = null;
        @SerializedName("enabled") @Expose private boolean enabled;

        public List<Images> getImages() {
            return images;
        }

    }

}
