package com.tg.team.delivery;

import com.tg.team.delivery.member.BA;
import com.tg.team.delivery.member.DEV;
import com.tg.team.delivery.member.QA;
import com.tg.team.delivery.story.Story;

import java.util.ArrayList;

public class Company {
    static public Team assign(ArrayList<BA> BAs, ArrayList<QA> QAs, ArrayList<DEV> DEVs, ArrayList<Story> StoryList) {
        Team teamTG = new Team(BAs, QAs, DEVs, StoryList);
        return teamTG;
    }
}
