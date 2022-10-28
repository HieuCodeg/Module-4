package com.hieucodeg.dao;

import com.hieucodeg.model.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationDao {
    private static Configuration configuration = new Configuration();
    private static List<String> listLanguages = new ArrayList<>();
    private static List<Integer> listPageSize = new ArrayList<>();
    static {
       configuration.setLanguages("English");
       configuration.setPageSize(25);
       configuration.setSpamsFillter(true);
       configuration.setSignature("Thor    King, Asgard");
       listLanguages.add("English");
        listLanguages.add("Vietnamese");
        listLanguages.add("Japanese");
        listLanguages.add("Chinese");
        listPageSize.add(5);
        listPageSize.add(10);
        listPageSize.add(15);
        listPageSize.add(25);
        listPageSize.add(50);
        listPageSize.add(100);
    }

    public static Configuration getConfiguration(){
        return configuration;
    }
    public static void updateConfi(Configuration confi) {
        configuration = confi;
    }
    public static List<String> getListLanguages() {
        return listLanguages;
    }
    public static List<Integer> getListPageSize() {
        return listPageSize;
    }
}
