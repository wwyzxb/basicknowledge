//package openapi;
//
//import com.google.common.collect.ImmutableMap;
//import com.google.common.collect.Maps;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.nubia.stat.openapi.sdk.OpenApiClient;
//import com.nubia.stat.openapi.sdk.OpenApiClientException;
//import okhttp3.ResponseBody;
//import openapi.vo.Job;
//import openapi.vo.JobState;
//import openapi.vo.QueryLog;
//import openapi.vo.result.ExeResult;
//import openapi.vo.result.OssResult;
//import openapi.vo.result.PollingResult;
//import org.apache.commons.io.FileUtils;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.net.URI;
//import java.net.URL;
//import java.util.Map;
//import java.util.UUID;
//import java.util.concurrent.TimeUnit;
//
///**
// * @Author: wuxiaobing
// * @Date 2018/9/17
// **/
//public class RecommendService {
//
//    private static OpenApiClient client() {
//        return OpenApiClient.builder().setHost("http://openapi-udclassloader.niudatastats.nubia.com").setDomain("demo").setServiceName("open_api_demo").setPrivateKeyFileName("open_api_demo_pri.pem").setServiceKeyId("v1").setConnectTimeout(5000).setReadTimeout(60000).build();
//    }
//
//    private static final Gson GSON = new GsonBuilder().create();
//
//    private static final String DEMO_QUERY_SQL = "select * from cn_nubia_neostore.recom_guess_you_like_app_phoenix ";
//
//    private static final String EXECUTE_API = "/custom_query/api/execute.do";
//    private static final String POLL_API = "/custom_query/api/updates/polling.do";
//    private static final String DOWNLOAD_CSV_API = "/custom_query/%s.do";
//    private static final String OSS_ADDR_API = "/custom_query/api/download/%s.do";
//
//
//    public static String doExecute(String sql) throws IOException, OpenApiClientException {
//        Map<String, Object> paramsMap = Maps.newHashMap();
//        paramsMap.put("query", sql);
//        String response = client().doPostForm(EXECUTE_API, paramsMap);
//        ExeResult result = GSON.fromJson(response, ExeResult.class);
//        return result.getData().getUuid().toString();
//    }
//
//
//    public static Job doPolling(String uuid) throws IOException, OpenApiClientException, InterruptedException {
//        PollingResult result;
//        Map<String, Object> paramsMap = Maps.newHashMap();
//        paramsMap.put("uuid", uuid);
//        while (true) {
//            String response = client().doPostForm(POLL_API, paramsMap);
//            result = GSON.fromJson(response, PollingResult.class);
//            TimeUnit.SECONDS.sleep(1);
//            if (JobState.FINISHED == result.getData().getState()) {
//                break;
//            }
//        }
//        return result.getData();
//    }
//
//    public static void doGetOSSAddr(String filePath) throws IOException, OpenApiClientException {
//        String uri = String.format(OSS_ADDR_API, filePath);
//        String result = client().doGet(uri, ImmutableMap.<String, Object>builder().build());
//        OssResult ossResult = GSON.fromJson(result, OssResult.class);
//        String ossInternalAddr = ossResult.getData();
//        String ossAddr = ossInternalAddr.replace("-internal", "");
////        System.out.println(ossAddr);
//        writeToCsv(ossAddr);
//    }
//
//    public static void doGetFile(String filePath) throws IOException {
//        String uri = String.format(DOWNLOAD_CSV_API, filePath);
//        ResponseBody responseBody = client().doGetRespBody(uri, ImmutableMap.<String, Object>builder().build());
//        writeToCsv(responseBody);
//    }
//
//    public static void writeToCsv(ResponseBody responseBody) throws IOException {
//        String filePath = String.format("D:\\file\\%s.csv", UUID.randomUUID().toString());
//        File file = new File(filePath);
//        FileOutputStream fos = new FileOutputStream(file);
//        int bt;
//        while ((bt = responseBody.byteStream().read()) != -1) {
//            fos.write(bt);
//        }
//    }
//
//    public static void writeToCsv(String url) throws IOException {
//        String filePath = String.format("D:\\file\\%s.csv", UUID.randomUUID().toString());
//        File file = new File(filePath);
//        URL ossUrl = new URL(url);
//        FileUtils.copyURLToFile(ossUrl, file);
//    }
//
//    public static void handleQueryProcedure(String sql, QueryLog queryLog) {
//        queryLog.setEntireExeStartTime(System.currentTimeMillis());
//        try {
//            //查询
//            queryLog.setQueryStartTime(System.currentTimeMillis());
//            String uuid = doExecute(sql);
//            Job job = doPolling(uuid);
//            URI location = job.getOutput().getLocation();
//            queryLog.setQueryFinishedTime(System.currentTimeMillis());
//
//            //下载文件
//            queryLog.setWriteFileStartTime(System.currentTimeMillis());
//            doGetFile(location.getPath());
////            doGetOSSAddr(location.getPath());
//            queryLog.setWriteFileFinishedTime(System.currentTimeMillis());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (OpenApiClientException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        queryLog.setEntireExeFinishedTime(System.currentTimeMillis());
//    }
//
//    public static void printLog(QueryLog queryLog) {
//        System.out.println(String.format("********************QueryNum:%d--start********************", queryLog.getQueryNum()));
//        System.out.println(String.format("condition is:[%s]", queryLog.getCondition()));
//        System.out.println(String.format("the time consumption of query:[%ds]", TimeUnit.MILLISECONDS.toSeconds(queryLog.getQueryFinishedTime() - queryLog.getQueryStartTime())));
//        System.out.println(String.format("the time consumption of writeFile:[%ds]", TimeUnit.MILLISECONDS.toSeconds(queryLog.getWriteFileFinishedTime() - queryLog.getWriteFileStartTime())));
//        System.out.println(String.format("********************QueryNum:%d--end*******************\r\n\r\n", queryLog.getQueryNum()));
//    }
//
//    public static void main(String[] args) {
//        int limitNum = 50000;
//        int offsetNum = 0;
//        Long startTime = System.currentTimeMillis();
//        for (int i = 0; i < 1; i++) {
//            QueryLog queryLog = new QueryLog();
//            String condition = String.format(" limit %d offset %d", limitNum, offsetNum);
//            String querySql = DEMO_QUERY_SQL + condition;
//
//            queryLog.setQueryNum(i + 1);
//            queryLog.setCondition(condition);
//            handleQueryProcedure(querySql, queryLog);
//            printLog(queryLog);
//
//            offsetNum += limitNum;
//        }
//        Long endTime = System.currentTimeMillis();
//        System.out.println(String.format("the total time consumption is:[%ds]", TimeUnit.MILLISECONDS.toSeconds(endTime - startTime)));
//    }
//
//}
