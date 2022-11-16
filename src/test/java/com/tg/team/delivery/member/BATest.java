package com.tg.team.delivery.member;

import com.tg.team.delivery.story.Story;
import com.tg.team.delivery.story.StoryStatus;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
}
