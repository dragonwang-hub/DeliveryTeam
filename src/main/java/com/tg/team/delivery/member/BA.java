package com.tg.team.delivery.member;

import com.tg.team.delivery.story.Story;
import com.tg.team.delivery.story.StoryStatus;

import java.util.*;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BA extends Member {

    public BA(String name) {
        super(name);
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
        if (devOne.devStatus.equals(DEVStatus.BUSY)) {
            throw new RuntimeException("DEV is busy now, please pick other one.");
        }
        initStorys.forEach(card -> {
            if (card.getTitle().equals(newCardTitle)) {
                devOne.setStory(card);
                devOne.setDevStatus(DEVStatus.BUSY);
                card.setStoryStatus(StoryStatus.DEVELOP);
            }
        });
        return initStorys;
    }

    public ArrayList<Story> assignCardToAllFreeDev(ArrayList<DEV> allDEVs, List<String> cardsNeedToBeDeveloped, ArrayList<Story> initStorys) {
        List<DEV> freeDEVs = allDEVs.stream().filter(dev -> dev.devStatus.equals(DEVStatus.FREE)).collect(Collectors.toList());
        int willBeAssignCardNumber = Math.min(freeDEVs.size(), cardsNeedToBeDeveloped.size());

        ArrayList<String> cardsCanBeDeveloped = new ArrayList<>(cardsNeedToBeDeveloped.subList(0, willBeAssignCardNumber));
        Queue<DEV> devsWillHaveCard = new LinkedList<>(freeDEVs.subList(0, willBeAssignCardNumber));
        allDEVs.removeAll(devsWillHaveCard);
        initStorys.forEach(card -> {
            if (cardsCanBeDeveloped.contains(card.getTitle())) {
//                这种问题是自己给自己挖坑了，如何保证进来的是所有DEV和所有STORY，还要保证更新了所有DEV和STORY的状态
                DEV devRandom = devsWillHaveCard.poll();
                devRandom.setStory(card);
                devRandom.setDevStatus(DEVStatus.BUSY);
                card.setStoryStatus(StoryStatus.DEVELOP);

                allDEVs.add(devRandom);

                cardsCanBeDeveloped.remove(card.getTitle());
            }
        });
        return initStorys;
    }
}
