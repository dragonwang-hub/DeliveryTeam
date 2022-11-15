package com.tg.team.delivery.story;

public class Story {
    String title;
    StoryStatus storyStatus;

    public StoryStatus getStoryStatus() {
        return storyStatus;
    }

    public void setStoryStatus(StoryStatus storyStatus) {
        this.storyStatus = storyStatus;
    }

    public Story(String title, StoryStatus storyStatus) {
        this.title = title;
        this.storyStatus = storyStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Story(String title) {
        this.title = title;
    }
}
