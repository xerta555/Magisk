package com.topjohnwu.magisk.obfuscate;

import java.util.HashMap;
import java.util.Map;

import static com.topjohnwu.magisk.DynAPK.Data;

public class Mapping {
    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("a.x", "androidx.work.impl.background.systemjob.SystemJobService");
    }

    public static String get(String name) {
        String n = map.get(name);
        return n != null ? n : name;
    }

    public static Data data() {
        Map<String, String> componentMap = new HashMap<>(map.size());
        for (Map.Entry<String, String> e : map.entrySet()) {
            componentMap.put(e.getValue(), e.getKey());
        }
        Data data = new Data();
        data.componentMap = componentMap;
        return data;
    }

}
