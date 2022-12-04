package com.tg.team.delivery;

import com.tg.team.delivery.exception.MemberRoleExceedException;
import com.tg.team.delivery.interfact.MemberFilter;
import com.tg.team.delivery.interfact.MemberNumberRule;
import com.tg.team.delivery.interfact.MemberNumberRuleNew;
import com.tg.team.delivery.member.BA;
import com.tg.team.delivery.member.DEV;
import com.tg.team.delivery.member.Member;
import com.tg.team.delivery.member.QA;
import com.tg.team.delivery.story.Story;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

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

    MemberNumberRule memberNumberRule = (members, numberLimit) -> {
        if (members.size() >= numberLimit) { // == only
            throw new MemberRoleExceedException("This role already exceed number.");
        }
    };

    Map<String, Integer> memberNumber = new HashMap<>() {
        {
            put("BA", 2);
            put("QA", 1);
            put("DEV", 3);
        }
    };

    public void add(Member newMember) {
        ArrayList<Member> currentMembers = getMembers(member -> member.getClass().equals(newMember.getClass()));

        memberNumberRule.consumer(currentMembers, memberNumber.get(newMember.getClass().getSimpleName()));

        members.add(newMember);
    }

    // refactor add method
    public static Map<String, List<MemberNumberRuleNew>> TeamMemberRules = new HashMap<>();

    public void addMember(Member newMember) {
        String newMemberRole = newMember.getClass().getSimpleName();

        if (TeamMemberRules.get(newMemberRole).stream().anyMatch(rule -> rule.test(newMember, this))) {
            throw new MemberRoleExceedException("This role already exceed number.");
        }
        members.add(newMember);
    }
}
