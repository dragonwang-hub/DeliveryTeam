package com.tg.team.delivery;

import com.tg.team.delivery.member.BA;
import com.tg.team.delivery.member.DEV;
import com.tg.team.delivery.member.QA;
import com.tg.team.delivery.story.Story;
import com.tg.team.delivery.story.StoryStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompanyTest {

    ArrayList<BA> BAs= new ArrayList<>();
    ArrayList<QA> QAs= new ArrayList<>();
    ArrayList<DEV> DEVs= new ArrayList<>();
    ArrayList<Story> StoryList= new ArrayList<>();

    @BeforeEach
    void prepData() {
        BA baOne = new BA("baOne");
        BAs.add(baOne);

        QA qaOne = new QA("qaOne");
        QAs.add(qaOne);

        DEV devOne = new DEV("devOne");
        DEVs.add(devOne);

        Story storyOne = new Story("cardOne", StoryStatus.READY);
        Story storyTwo = new Story("cardTwo", StoryStatus.DONE);
        StoryList.add(storyOne);
        StoryList.add(storyTwo);
    }

    @Test
    public void shouldAssignMemberAndStoryToTeam() {
//        given prep data

//        when call assign method
        Team team = Company.assign(BAs, QAs, DEVs, StoryList);
//        then combine a team with members and story
        assertAll("team has all props", () -> {
            assertEquals("baOne", team.getBAs().get(0).getName());
            assertEquals("qaOne", team.getQAs().get(0).getName());
            assertEquals("devOne", team.getDEVs().get(0).getName());

            assertEquals(2, team.getStoryList().size());
            assertEquals("cardOne", team.getStoryList().get(0).getTitle());
            assertEquals(StoryStatus.READY, team.getStoryList().get(0).getStoryStatus());
            assertEquals("cardTwo", team.getStoryList().get(1).getTitle());
            assertEquals(StoryStatus.DONE, team.getStoryList().get(1).getStoryStatus());
        });
    }
}
