package com.example.restservice.equipmentData;

import lombok.Getter;

@Getter
public class SQL_queries {

    private static final String recursiveGroup =
            "WITH RECURSIVE temp_table AS (" +
            " SELECT g.id," +
            "        g.parent_id," +
            "        g.name," +
            "        1 AS level," +
            "        '/' || g.name AS path," +
            "        array[row_number () over (order by g.name)] AS path_sort" +
            "   FROM groups g" +
            "  WHERE g.parent_id IS NULL" +
            "" +
            "  UNION ALL" +
            "" +
            " SELECT g.id," +
            "        g.parent_id," +
            "        g.name," +
            "        t.level + 1 AS level," +
            "        t.path || '/' || g.name AS path," +
            "        t.path_sort || row_number () " +
            "over (partition by g.parent_id order by g.name) AS path_sort" +
            "   FROM temp_table t," +
            "        groups g" +
            "  WHERE g.parent_id = t.id" +
            ")" +
            "SELECT t.id," +
            "       lpad ('', (t.level - 1) * 8) || t.name AS name," +
            "       t.level" +
            "  FROM temp_table t" +
            " ORDER BY path_sort";

    public static final String getRecursiveGroup() {
        return recursiveGroup;
    }
}
