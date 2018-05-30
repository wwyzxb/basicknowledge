INSERT OVERWRITE TABLE wxb.test
(
SELECT xcontext['loc_city'] AS NAME,
COUNT ( DISTINCT xcontext['imei']) AS num
FROM cn_nubia_browser.profile
WHERE
appid='7f20555fecf84a469f506053fea77f22' AND xcontext['loc_country']='中国'
GROUP BY xcontext['loc_city']
UNION
SELECT
xcontext['loc_province'] AS NAME,
COUNT ( DISTINCT xcontext['imei']) AS num
FROM cn_nubia_browser.profile WHERE
appid='7f20555fecf84a469f506053fea77f22' AND xcontext['loc_country']='中国'
GROUP BY xcontext['loc_province'])


INSERT OVERWRITE TABLE cn_nubia_browser.area_user_cnt
SELECT
  xcontext['loc_city']             AS name,
  count(DISTINCT xcontext['imei']) AS num
FROM cn_nubia_browser.profile
WHERE appid = '7f20555fecf84a469f506053fea77f22'
      AND xcontext['loc_country'] = '中国'
GROUP BY xcontext['loc_city']



INSERT OVERWRITE TABLE cn_nubia_browser.wxb_test
SELECT
  xcontext['loc_city']             AS name,
  count(DISTINCT xcontext['imei']) AS num
FROM cn_nubia_browser.profile
WHERE appid = '7f20555fecf84a469f506053fea77f22'
      AND xcontext['loc_country'] = '中国'
GROUP BY xcontext['loc_city'];