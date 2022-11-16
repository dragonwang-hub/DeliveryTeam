package com.tg.team.delivery.member;

import com.tg.team.delivery.story.Story;
import com.tg.team.delivery.story.StoryStatus;

import java.util.*;
import java.util.ArrayList;

public class BA {

    String name;

    public BA(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Story> createStoryCard(String newCardTitle, ArrayList<Story> initStorys) {
        Story story = new Story(newCardTitle, StoryStatus.READY);
        initStorys.add(story);
        return initStorys;
    }

    public ArrayList<Story> createStoryCard(List<String> newCards, ArrayList<Story> initStorys) {
        newCards.stream().filter(card -> newCards.indexOf(card) <= 2).forEach(card -> {
            Story story = new Story(card, StoryStatus.READY);
            initStorys.add(story);
        });
        return initStorys;
    }

    public ArrayList<Story> assignStoryCard(DEV devOne, String newCardTitle, ArrayList<Story> initStorys) {
        initStorys.forEach(card -> {
            if (card.getTitle().equals(newCardTitle)) {
                devOne.setStory(card);
                devOne.setDevStatus(DEVStatus.BUSY);
                card.setStoryStatus(StoryStatus.DEVELOP);
            }
        });
        return initStorys;
    }
}
