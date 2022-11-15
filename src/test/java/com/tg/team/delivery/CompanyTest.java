package com.tg.team.delivery;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompanyTest {

    @Test
    public void shouldAssignMemberAndStoryToTeam() {

        String team = Company.assign("BAs", "QAs", "Devs", "StoryList");
        assertEquals("BAsQAsDevsStoryList", team);
    }
}
