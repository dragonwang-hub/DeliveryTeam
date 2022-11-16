package com.tg.team.delivery.member;

import com.tg.team.delivery.story.Story;
import com.tg.team.delivery.story.StoryStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QA {

    String name;

    public QA(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Story> removeCards(List<String> doneCards, ArrayList<Story> storyList) {
        storyList.stream()
                .filter(card -> doneCards.contains(card.getTitle()))
                .forEach(card -> card.setStoryStatus(StoryStatus.DONE));
        return (ArrayList<Story>) storyList.stream()
                .filter(card -> !doneCards.contains(card.getTitle())).collect(Collectors.toList());
    }
}
