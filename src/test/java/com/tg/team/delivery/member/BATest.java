package com.tg.team.delivery.member;

import com.tg.team.delivery.story.Story;
import com.tg.team.delivery.story.StoryStatus;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertAll("shouldCreateStoryCardToList", () -> {
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
        assertAll("shouldCreateMultipleStoryCardToList", () -> {
            assertEquals(2, newestStoryList.size());
            assertEquals("newCardTitle", newestStoryList.get(0).getTitle());
            assertEquals("newCardTitleTwo", newestStoryList.get(1).getTitle());
            assertEquals(StoryStatus.READY, newestStoryList.get(0).getStoryStatus());
        });
    }

    @Test
    public void shouldNotCreateMoreThanThreeStoryCardAtOnceToList() {
//        given ba and story requirement
        BA baOne = new BA("baOne");
        String newCardTitle = "newCardTitle";
        String newCardTitleTwo = "newCardTitleTwo";
        String newCardTitleThree = "newCardTitleThree";
        String newCardTitleFour = "newCardTitleFour";
        List<String> newCards = List.of(newCardTitle, newCardTitleTwo, newCardTitleThree, newCardTitleFour);
        ArrayList<Story> initStorys = new ArrayList<>();
//        when create one card
        ArrayList<Story> newestStoryList = baOne.createStoryCard(newCards, initStorys); // the story list should get from team props, but too complex.
//        then
        assertAll("shouldNotCreateMoreThanThreeStoryCardAtOnceToList", () -> {
            assertEquals(3, newestStoryList.size());
            assertEquals("newCardTitle", newestStoryList.get(0).getTitle());
            assertEquals("newCardTitleTwo", newestStoryList.get(1).getTitle());
            assertEquals(StoryStatus.READY, newestStoryList.get(0).getStoryStatus());
        });
    }

    @Test
    public void shouldAssignStoryCardAToDev() {
//        given ba and story requirement and dev
        BA baOne = new BA("baOne");
        DEV devOne = new DEV("devOne", DEVStatus.FREE);
        String newCardTitle = "newCardTitle";

        ArrayList<Story> initStorys = new ArrayList<>();
        initStorys.add(new Story("newCardTitle", StoryStatus.READY));
        initStorys.add(new Story("doneCardTitleTwo", StoryStatus.TEST));
        initStorys.add(new Story("doneCardTitleThree", StoryStatus.TEST));
//        when create one card
        ArrayList<Story> newestStoryList = baOne.assignStoryCard(devOne, newCardTitle, initStorys); // the story list should get from team props, but too complex.
//        then
        assertAll("shouldAssignStoryCardAToDev", () -> {
            assertEquals(3, newestStoryList.size());
            assertEquals("newCardTitle", newestStoryList.get(0).getTitle());
            assertEquals(StoryStatus.DEVELOP, newestStoryList.get(0).getStoryStatus());
        });
    }

    @Test
    public void shouldThrowExceptionWhenAssignStoryCardAToDevButDevIsBusy() {
//        given ba and story requirement and busy dev
        BA baOne = new BA("baOne");
        DEV devOne = new DEV("devOne", DEVStatus.BUSY);
        String newCardTitle = "newCardTitle";

        ArrayList<Story> initStorys = new ArrayList<>();
        initStorys.add(new Story("newCardTitle", StoryStatus.READY));
        initStorys.add(new Story("doneCardTitleTwo", StoryStatus.TEST));
        initStorys.add(new Story("doneCardTitleThree", StoryStatus.TEST));
//        when create one card
//        then throw exception
        assertThrows(RuntimeException.class, () -> {
            baOne.assignStoryCard(devOne, newCardTitle, initStorys);
        }, "DEV is busy now, please pick other one.");
    }
}
