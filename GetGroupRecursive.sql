WITH RECURSIVE temp_table AS (
 SELECT g.group_id,
        g.parent_id,
        g.group_name,
        1 AS level,
        '/' || g.group_name AS path,
        array[row_number () over (order by g.group_name)] AS path_sort
   FROM groups g
  WHERE g.parent_id IS NULL

  UNION ALL

 SELECT g.group_id,
        g.parent_id,
        g.group_name,
        t.level + 1 AS level,
        t.path || '/' || g.group_name AS path,
        t.path_sort || row_number () 
			over (partition by g.parent_id order by g.group_name) AS path_sort
   FROM temp_table t,
        groups g
  WHERE g.parent_id = t.group_id
)
SELECT t.group_id,
       lpad ('', (t.level - 1) * 8) || t.group_name AS name,
       t.level
  FROM temp_table t
 ORDER BY path_sort