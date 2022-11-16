package com.tg.team.delivery.member;

import com.tg.team.delivery.story.Story;

public class DEV {

    String name;
    DEVStatus devStatus;

    public DEV(String name, DEVStatus devStatus, Story story) {
        this.name = name;
        this.devStatus = devStatus;
        this.story = story;
    }

    Story story;

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public DEV(String name, DEVStatus devStatus) {
        this.name = name;
        this.devStatus = devStatus;
    }

    public DEV(String name) {
        this.name = name;
    }

    public DEVStatus getDevStatus() {
        return devStatus;
    }

    public void setDevStatus(DEVStatus devStatus) {
        this.devStatus = devStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
