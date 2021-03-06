package com.lhf.springboot.location;


import org.apache.commons.lang3.StringUtils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LatitudeUtil
 * @Desc TODO
 * @Author liuhefei
 * @Date 2021/5/26 15:21
 **/
public class LatitudeUtil {

    public static final String KEY_1 = "ChwEVlrmoje34iED20piImPc";

    private static final double PI = 3.14159265;

    /**
     * 根据地址查坐标
     *
     * @param address 地址,格式:深圳市罗湖区火车站
     * @return
     */

    // @param key   申请ak（即获取密钥），若无百度账号则首先需要注册百度账号。
    public static Map<String, String> getGeocoderLatitude(String address) {
        BufferedReader in = null;
        if(!StringUtils.isNotEmpty(address)){
            return null;
        }

        try {
            address = URLEncoder.encode(address, "UTF-8");
            URL tirc = new URL("http://api.map.baidu.com/geocoder?address=" + address + "&output=json&key=" + KEY_1);
            in = new BufferedReader(new InputStreamReader(tirc.openStream(), "UTF-8"));
            String res;
            StringBuilder sb = new StringBuilder("");
            while ((res = in.readLine()) != null) {
                sb.append(res.trim());
            }
            String str = sb.toString();
            Map<String, String> map = new HashMap<String, String>();
            if (StringUtils.isNotEmpty(str)) {
                int lngStart = str.indexOf("lng\":");
                int lngEnd = str.indexOf(",\"lat");

                int latEnd = str.indexOf("},\"precise");
                if (lngStart > 0 && lngEnd > 0 && latEnd > 0)

                {
                    String lng = str.substring(lngStart + 5, lngEnd);
                    String lat = str.substring(lngEnd + 7, latEnd);
                    map.put("lng", lng);
                    map.put("lat", lat);
                    return map;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 计算地球上任意两点(经纬度)距离
     * *
     * * @param lon1
     * *            第一点经度
     * * @param lat1
     * *            第一点纬度
     * * @param lon2
     * *            第二点经度
     * * @param lat2
     * *            第二点纬度
     * * @return 返回距离 单位：千米
     */
    public static double getDistatce(double lon1, double lat1, double lon2, double lat2) {
        double R = 6371;
        double distance = 0.0;
        double dLat = (lat2 - lat1) * Math.PI / 180;
        double dLon = (lon2 - lon1) * Math.PI / 180;
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(lat1 * Math.PI / 180) * Math.cos(lat2 * Math.PI / 180) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        distance = (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))) * R;
        return distance;
    }

    /**
     * 计算地球上任意两点(经纬度)距离
     * *
     * * @param long1
     * *          第一点经度
     * * @param lat1
     * *            第一点纬度
     * * @param long2
     * *            第二点经度
     * * @param lat2
     * *            第二点纬度
     * * @return 返回距离 单位：米
     */
    public static double Distance(double long1, double lat1, double long2, double lat2) {
        double a, b, R;
        R = 6378137; // 地球半径
        lat1 = lat1 * Math.PI / 180.0;
        lat2 = lat2 * Math.PI / 180.0;
        a = lat1 - lat2;
        b = (long1 - long2) * Math.PI / 180.0;
        double d;
        double sa2, sb2;
        sa2 = Math.sin(a / 2.0);
        sb2 = Math.sin(b / 2.0);
        d = 2 * R * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1) * Math.cos(lat2) * sb2 * sb2));
        return d;
    }

    /**
     * 查找一定范围内的经纬度值
     * * 传入值： 经度 纬度   查找半径(m)
     * * 返回值：最小经度、纬度，最大经度、纬度   113.957541,22.549392 朗峰大厦
     */
    public static Map<String, Double> getAround(Double lon, Double lat, Double raidus) {
        Double PI = 3.14159265;    // 圆周率
        Double EARTH_RADIUS = 6378137d;
        // 地球半径
        Double RAD = Math.PI / 180.0;
        // 弧度
        Double longitude = lon;
        //经度
        Double latitude = lat;
        //纬度
        Double degree = (24901 * 1609) / 360.0;
        Double raidusMile = raidus;
        //距离
        Double dpmLat = 1 / degree;
        Double radiusLat = dpmLat * raidusMile;
        Double minLat = latitude - radiusLat;
        //最小纬度
        Double maxLat = latitude + radiusLat;
        //最大纬度
        Double mpdLng = degree * Math.cos(latitude * (PI / 180));
        Double dpmLng = 1 / mpdLng;
        Double radiusLng = dpmLng * raidusMile;
        Double minLng = longitude - radiusLng;
        //最小经度
        Double maxLng = longitude + radiusLng;
        //最大经度
        Map<String, Double> m = new HashMap<String, Double>();
        m.put("minLng", minLng);
        //最小经度
        m.put("minLat", minLat);
        //最小纬度
        m.put("maxLng", maxLng);
        //最大经度
        m.put("maxLat", maxLat);
        //最大纬度
        System.err.println("最小经度:" + minLng);
        System.err.println("最小纬度:" + minLat);
        System.err.println("最大经度:" + maxLng);
        System.err.println("最大纬度:" + maxLat);
        return m;
    }

    /**
     * 根据提供的经度和纬度、以及半径，取得此半径内的最大最小经纬度
     *  @param raidus 单位米 *
     *  @return minLat,minLng,maxLat,maxLng
     *
     */
    public static Double[] getAround(Double lat, Double lon, int raidus) {
        Double latitude = lat;//纬度
        Double longitude = lon;//经度
        Double degree = (24901 * 1609) / 360.0;//度
        double raidusMile = raidus;//半径
        Double dpmLat = 1 / degree;
        Double radiusLat = dpmLat * raidusMile;
        Double minLat = latitude - radiusLat;
        Double maxLat = latitude + radiusLat;
        Double mpdLng = degree * Math.cos(latitude * (PI / 180));
        Double dpmLng = 1 / mpdLng;
        Double radiusLng = dpmLng * raidusMile;
        Double minLng = longitude - radiusLng;
        Double maxLng = longitude + radiusLng;
        System.out.println(minLat+"   "+maxLat+"   "+minLng+"  "+maxLng);
        // System.out.println(&quot;[&quot;+minLat+&quot;,&quot;+minLng+&quot;,&quot;+maxLat+&quot;,&quot;+maxLng+&quot;]&quot;);
        return new Double[] { minLat,maxLat,minLng,maxLng };
    }

    /**
     *
     * @param lat_a 纬度1
     * @param lng_a 经度1
     * @param lat_b 纬度2
     * @param lng_b 经度2
     * @return
     */
    public static double getAngle1(double lat_a, double lng_a, double lat_b, double lng_b) {

        double y = Math.sin(lng_b-lng_a) * Math.cos(lat_b);
        double x = Math.cos(lat_a)*Math.sin(lat_b) - Math.sin(lat_a)*Math.cos(lat_b)*Math.cos(lng_b-lng_a);
        double brng = Math.atan2(y, x);

        brng = Math.toDegrees(brng);
        if(brng < 0){
            brng = brng +360;
        }
        return brng;

    }

    public static void main(String args[]) {
        Map<String, String> json = LatitudeUtil.getGeocoderLatitude("深圳罗湖火车站");
        //Map<String, String> json = LatitudeUtil.getGeocoderLatitude("tl");
        System.out.println("lng : " + json.get("lng"));
        System.out.println("lat : " + json.get("lat"));

        Map<String, String> json1 = LatitudeUtil.getGeocoderLatitude("深圳尚美国际大厦");
        //Map<String, String> json = LatitudeUtil.getGeocoderLatitude("tl");
        System.out.println("lng1 : " + json1.get("lng"));
        System.out.println("lat1 : " + json1.get("lat"));

        double d1 = getDistatce(113.993941, 22.596919, 114.156395, 22.581934);
        double d2 = Distance(113.993941, 22.596919, 114.156395, 22.581934);
        System.out.println("d1 -> " + d1 + ", d2 -> " + d2);
        double f = 111.234;
        BigDecimal bg = new BigDecimal(f);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);

        System.out.println(Distance(Double.valueOf(json.get("lng")), Double.valueOf(json.get("lat")), Double.valueOf(json1.get("lng")), Double.valueOf(json1.get("lat"))));

        System.out.println(getAngle1(113.993941, 22.596919, 114.156395, 22.581934));
    }
}
