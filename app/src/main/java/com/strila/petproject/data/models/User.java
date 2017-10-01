package com.strila.petproject.data.models;

import java.util.Date;

/**
 * Created by Serhii Strila on 3/23/17
 */

public class User {

    private long id;
    private String name;
    private Date createdAt;

    private User(Builder builder) {
        id = builder.id;
        name = builder.name;
        createdAt = builder.createdAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public static final class Builder {

        private long id;
        private String name;
        private Date createdAt;

        private Builder() {
        }

        public Builder id(long val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder createdAt(Date val) {
            createdAt = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
