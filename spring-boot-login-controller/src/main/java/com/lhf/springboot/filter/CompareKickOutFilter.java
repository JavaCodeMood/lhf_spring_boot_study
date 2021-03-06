package com.lhf.springboot.filter;

import com.lhf.springboot.utils.JWTUtil;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RBucket;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: CompareKickOutFilter
 * @Author: liuhefei
 * @Description: 时间戳踢出
 * @Date: 2019/7/3 11:07
 */
public class CompareKickOutFilter extends KickOutFilter {

    @Override
    public boolean isAccessAllowed(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String token = request.getHeader("Authorization");
        String username = JWTUtil.getUsername(token);
        String userKey = PREFIX + username;

        RBucket<String> bucket = redissonClient.getBucket(userKey);
        String redisToken = bucket.get();

        if(token.equals(redisToken)){
            return true;
        }else if(StringUtils.isBlank(redisToken)){
            bucket.set(token);
        }else {
            Long redisTokenUnixTime = JWTUtil.getClaim(redisToken, "createTime").asLong();
            Long tokenUnixTime = JWTUtil.getClaim(token, "createTime").asLong();

            //token > redisToken 则覆盖
            if(tokenUnixTime.compareTo(redisTokenUnixTime) > 0){
                bucket.set(token);
            }else {
                //注销当前token
                userInfoService.logout(token);
                sendJsonResponse(response, 4001, "您的账号已在其他设备登录");
                return false;
            }
        }

        return true;
    }
}
