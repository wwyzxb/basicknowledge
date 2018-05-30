SELECT
  res_id          AS res_id,
  res_type        AS res_type,
  res_name        AS res_name,
  classify        AS classify,
  res_from        AS res_from,
  exposure_pv     AS exposure_pv,
  res_click       AS res_click,
  try_use_click   AS try_use_click,
  try_use_train   AS try_use_train,
  buy_click       AS buy_click,
  buy_succ        AS buy_succ,
  buy_succ_rate   AS buy_succ_rate,
  nouse_buy_train AS nouse_buy_train,
  use_buy_train   AS use_buy_train,
  down_count      AS down_count
FROM (SELECT
        res_id_a                                                  AS res_id,
        res_type_a                                                AS res_type,
        res_name                                                  AS res_name,
        res_category_name                                         AS classify,
        res_src_name                                              AS res_from,
        exposure_pv                                               AS exposure_pv,
        res_click                                                 AS res_click,
        res_down_click                                            AS down_count,
        res_try_click                                             AS try_use_click,
        (CASE WHEN exposure_pv IS NULL OR exposure_pv = 0
          THEN 0
         ELSE round(1.0 * down_count / exposure_pv, 4) END)       AS try_use_train,
        res_buy_click                                             AS buy_click,
        res_buy_succ                                              AS buy_succ,
        (CASE WHEN buy_click IS NULL OR buy_click = 0
          THEN 0
         ELSE round(1.0 * buy_succ / buy_click, 4) END)           AS buy_succ_rate,
        (CASE WHEN res_click IS NULL OR res_click = 0
          THEN 0
         ELSE round(1.0 * res_notry_buy_succ / res_click, 4) END) AS nouse_buy_train,
        (CASE WHEN res_click IS NULL OR res_click = 0
          THEN 0
         ELSE round(1.0 * res_try_buy_succ / res_click, 4) END)   AS use_buy_train,
        res_notry_buy_succ                                        AS res_notry_buy_succ,
        res_try_buy_succ                                          AS res_try_buy_succ
      FROM (SELECT
              res_id                   AS res_id_a,
              res_type                 AS res_type_a,
              sum(exposure_pvs)        AS exposure_pv,
              sum(res_clicks)          AS res_click,
              sum(res_down_clicks)     AS res_down_click,
              sum(res_try_clicks)      AS res_try_click,
              sum(res_buy_clicks)      AS res_buy_click,
              sum(res_buy_succs)       AS res_buy_succ,
              sum(res_notry_buy_succs) AS res_notry_buy_succ,
              sum(res_try_buy_succs)   AS res_try_buy_succ
            FROM cn_nubia_thememanager.p_res_down_stat
            WHERE ds >= '2017-04-24' AND ds <= '2018-04-24' AND res_type = 1 AND 1 = 1 AND (CASE WHEN 1 = 2
              THEN 1 = 1
                                                                                            ELSE version_id = 1 END)
            GROUP BY res_id, res_type) a
        JOIN (SELECT
                res_id   AS res_id_b,
                res_type AS res_type_b,
                res_name,
                res_category_name,
                res_src_name
              FROM cn_nubia_thememanager.p_res_mapping
              WHERE res_type = 1 AND 1 = 1 AND res_pay_type = 1 AND 1 = 1 AND 1 = 1 AND 1 = 1
              GROUP BY res_id, res_type, res_name, res_category_name, res_src_name) b
          ON a.res_id_a = b.res_id_b AND a.res_type_a = b.res_type_b) aa
ORDER BY exposure_pv DESC;