package com.tg.team.delivery;

import com.tg.team.delivery.interfact.MemberFilter;
import com.tg.team.delivery.member.BA;
import com.tg.team.delivery.member.DEV;
import com.tg.team.delivery.member.Member;
import com.tg.team.delivery.member.QA;
import com.tg.team.delivery.story.Story;

import java.util.ArrayList;

public class Team {
    ArrayList<BA> BAs;
    ArrayList<QA> QAs;
    ArrayList<DEV> DEVs;

    ArrayList<Story> StoryList;

    public ArrayList<BA> getBAs() {
        return BAs;
    }

    public void setBAs(ArrayList<BA> BAs) {
        this.BAs = BAs;
    }

    public ArrayList<QA> getQAs() {
        return QAs;
    }

    public void setQAs(ArrayList<QA> QAs) {
        this.QAs = QAs;
    }

    public ArrayList<DEV> getDEVs() {
        return DEVs;
    }

    public void setDEVs(ArrayList<DEV> DEVs) {
        this.DEVs = DEVs;
    }

    public ArrayList<Story> getStoryList() {
        return StoryList;
    }

    public void setStoryList(ArrayList<Story> storyList) {
        StoryList = storyList;
    }

    public Team(ArrayList<BA> BAs, ArrayList<QA> QAs, ArrayList<DEV> DEVs, ArrayList<Story> storyList) {
        this.BAs = BAs;
        this.QAs = QAs;
        this.DEVs = DEVs;
        StoryList = storyList;
    }

    ArrayList<Member> members;

    public Team(ArrayList<Member> members) {
        this.members = members;
    }

    public ArrayList<Member> getMembers(MemberFilter memberFilter) {
        ArrayList<Member> result = new ArrayList<>();
        members.forEach(member -> {
            if (memberFilter.test(member)) {
                result.add(member);
            }
        });
        return result;
    }
}
