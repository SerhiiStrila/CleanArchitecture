package com.strila.petproject.data.models.mapper;

import com.strila.petproject.data.models.local.Post;
import com.strila.petproject.data.models.response.PostResponse;

import java.util.List;

/**
 * Created by Serhii Strila on 10/1/17
 */

public final class PostMapper {

    public static Post map(PostResponse postResponse) {
        Post.Builder builder = Post.newBuilder()
                .id(postResponse.getId())
                .title(postResponse.getTitle())
                .created(postResponse.getCreated())
                .commentsCount(postResponse.getNumComments())
                .author(postResponse.getAuthor())
                .thumb(postResponse.getThumbnail());
        if (postResponse.getPreview() != null) {
            List<PostResponse.Images> images = postResponse.getPreview().getImages();
            if (!images.isEmpty()) {
                PostResponse.Image image = images.get(0).getSource();
                if (image != null) {
                    builder.imgSource(image.getUrl());
                }
            }
        }
        return builder.build();
    }
}
