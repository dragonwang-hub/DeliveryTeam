package com.tg.team.delivery.member;

import com.tg.team.delivery.story.Story;
import com.tg.team.delivery.story.StoryStatus;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QATest {
    @Test
    public void shouldRemoveTwoCardsAtOnceWhenFinishedTestWork() {
//        given init story list and qa
        QA qaOne = new QA("qaOne");
        String doneCardTitle = "doneCardTitle";
        String doneCardTitleTwo = "doneCardTitleTwo";
        List<String> doneCards = List.of(doneCardTitle, doneCardTitleTwo);

        ArrayList<Story> storyList = new ArrayList<>();
        storyList.add(new Story("doneCardTitle", StoryStatus.TEST));
        storyList.add(new Story("doneCardTitleTwo", StoryStatus.TEST));
        storyList.add(new Story("doneCardTitleThree", StoryStatus.TEST));

//        when finished two card test work
        ArrayList<Story> newestStoryList = qaOne.removeCards(doneCards, storyList);

//        then two cards will be removed from list
        assertAll("shouldRemoveTwoCardsAtOnceWhenFinishedTestWork", () -> {
            assertEquals(1, newestStoryList.size());
            assertEquals("doneCardTitleThree", newestStoryList.get(0).getTitle());
        });
    }
}
