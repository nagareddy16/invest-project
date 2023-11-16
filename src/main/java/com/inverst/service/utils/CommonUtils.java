package com.inverst.service.utils;

import org.springframework.core.env.Environment;

import java.util.Arrays;

public class CommonUtils {

    public static boolean isProduction(Environment environment){
        if(null == environment){
            return false;
        }
        String[] activeProfiles = environment.getActiveProfiles();
        if(activeProfiles.length < 1){
            return false;
        }
        return Arrays.stream(activeProfiles).anyMatch(env -> env.startsWith(Constant.PRODUCTION_ENV_PREFIX));
    }
}
