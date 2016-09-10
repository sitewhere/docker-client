/*
 * Copyright (c) 2015 Spotify AB.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.spotify.docker.client.messages.swarm;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.spotify.docker.client.messages.mount.Mount;

@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public class ContainerSpec {

    @JsonProperty("Image")
    private String image;

    @JsonProperty("Labels")
    private Map<String, String> labels;

    @JsonProperty("Command")
    private ImmutableList<String> command;

    @JsonProperty("Args")
    private ImmutableList<String> args;

    @JsonProperty("Env")
    private ImmutableList<String> env;

    @JsonProperty("Dir")
    private String dir;

    @JsonProperty("User")
    private String user;

    @JsonProperty("Groups")
    private ImmutableList<String> groups;

    @JsonProperty("TTY")
    private Boolean tty;

    @JsonProperty("Mounts")
    private ImmutableList<Mount> mounts;

    @JsonProperty("StopGracePeriod")
    private Long stopGracePeriod;

    public String image() {
        return image;
    }

    public Map<String, String> labels() {
        return labels;
    }

    public List<String> command() {
        return command;
    }

    public List<String> args() {
        return args;
    }

    public List<String> env() {
        return env;
    }

    public String dir() {
        return dir;
    }

    public String user() {
        return user;
    }

    public List<String> groups() {
        return groups;
    }

    public Boolean tty() {
        return tty;
    }

    public List<Mount> mounts() {
        return mounts;
    }

    public Long stopGracePeriod() {
        return stopGracePeriod;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final ContainerSpec that = (ContainerSpec) o;

        return Objects.equals(this.image, that.image) && Objects.equals(this.labels, that.labels)
                && Objects.equals(this.command, that.command)
                && Objects.equals(this.args, that.args) && Objects.equals(this.env, that.env)
                && Objects.equals(this.dir, that.dir) && Objects.equals(this.user, that.user)
                && Objects.equals(this.groups, that.groups) && Objects.equals(this.tty, that.tty)
                && Objects.equals(this.mounts, that.mounts)
                && Objects.equals(this.stopGracePeriod, that.stopGracePeriod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image, labels, command, args, env, dir, user, groups, tty, mounts,
                stopGracePeriod);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("image", image).add("labels", labels)
                .add("command", command).add("args", args).add("env", env).add("dir", dir)
                .add("user", user).add("groups", groups).add("tty", tty).add("mounts", mounts)
                .add("stopGracePeriod", stopGracePeriod).toString();
    }
}
