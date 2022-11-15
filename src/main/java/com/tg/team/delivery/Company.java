package com.tg.team.delivery;

import java.util.*;
import java.util.ArrayList;

public class Company {
    static public String assign(String BAs, String  QAs, String DEVs, String  StoryList){
        String team = BAs + QAs + DEVs + StoryList;
        return  team;
    }
}
