package com.strila.petproject.data.models.local;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by Serhii Strila on 10/1/17
 */

@Entity
public class Post {

    @PrimaryKey private String id;
    @ColumnInfo(name = "title") private String title;
    @ColumnInfo(name = "author") private String author;
    @ColumnInfo(name = "created") private long created;
    @ColumnInfo(name = "thumb") private String thumb;
    @ColumnInfo(name = "img_source") private String imgSource;
    @ColumnInfo(name = "comments_count") private int commentsCount;

    public Post() {
    }

    private Post(Builder builder) {
        id = builder.id;
        title = builder.title;
        author = builder.author;
        created = builder.created;
        thumb = builder.thumb;
        imgSource = builder.imgSource;
        commentsCount = builder.commentsCount;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public Date getCreatedDate() {
        return new Date(created);
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getImgSource() {
        return imgSource;
    }

    public void setImgSource(String imgSource) {
        this.imgSource = imgSource;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public static final class Builder {
        private String id;
        private String title;
        private String author;
        private long created;
        private String thumb;
        private String imgSource;
        private int commentsCount;

        private Builder() {
        }

        @Nonnull
        public Builder id(@Nonnull String val) {
            id = val;
            return this;
        }

        @Nonnull
        public Builder title(@Nonnull String val) {
            title = val;
            return this;
        }

        @Nonnull
        public Builder author(@Nonnull String val) {
            author = val;
            return this;
        }

        @Nonnull
        public Builder created(@Nonnull Date val) {
            created = val.getTime();
            return this;
        }

        @Nonnull
        public Builder thumb(@Nullable String val) {
            thumb = val;
            return this;
        }

        @Nonnull
        public Builder imgSource(@Nullable String val) {
            imgSource = val;
            return this;
        }

        @Nonnull
        public Builder commentsCount(int val) {
            commentsCount = val;
            return this;
        }

        @Nonnull
        public Post build() {
            return new Post(this);
        }
    }
}
