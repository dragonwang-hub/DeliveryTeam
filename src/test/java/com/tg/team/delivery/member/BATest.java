package com.tg.team.delivery.member;

import com.tg.team.delivery.story.Story;
import com.tg.team.delivery.story.StoryStatus;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BATest {

    @Test
    public void shouldCreateStoryCardToList() {
//        given ba and story requirement
        BA baOne = new BA("baOne");
        String newCardTitle = "newCardTitle";
        ArrayList<Story> initStorys = new ArrayList<>();
//        when create one card
        ArrayList<Story> newestStoryList = baOne.createStoryCard(newCardTitle, initStorys); // the story list should get from team props, but too complex.
//        then
        assertAll("team has all props", () -> {
            assertEquals(1, newestStoryList.size());
            assertEquals("newCardTitle", newestStoryList.get(0).getTitle());
            assertEquals(StoryStatus.READY, newestStoryList.get(0).getStoryStatus());
        });
    }

    @Test
    public void shouldCreateMultipleStoryCardToList() {
//        given ba and story requirement
        BA baOne = new BA("baOne");
        String newCardTitle = "newCardTitle";
        String newCardTitleTwo = "newCardTitleTwo";
        List<String> newCards = List.of(newCardTitle, newCardTitleTwo);
        ArrayList<Story> initStorys = new ArrayList<>();
//        when create one card
        ArrayList<Story> newestStoryList = baOne.createStoryCard(newCards, initStorys); // the story list should get from team props, but too complex.
//        then
        assertAll("team has all props", () -> {
            assertEquals(2, newestStoryList.size());
            assertEquals("newCardTitle", newestStoryList.get(0).getTitle());
            assertEquals("newCardTitleTwo", newestStoryList.get(1).getTitle());
            assertEquals(StoryStatus.READY, newestStoryList.get(0).getStoryStatus());
        });
    }
}
