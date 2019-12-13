package com.hgs.data.configurations;

import java.util.concurrent.TimeUnit;

public final class Configuration {
    private static final TimeUnit timeUnit = TimeUnit.HOURS;
    private static TokenWeb token;
    private static String tokenString;

    public static int getTimeOut() {
        return 2;
    }

    public static Boolean getIsAuthentication() {
        return false;
    }

    public static void setToken(TokenWeb token) {
        Configuration.token = token;
        tokenString = token.getStatus_code()+" "+ token.getStatus_message();
    }

    public static String getTokenString() {
        return tokenString;
    }

    public static String getBaseUrl() {

        return "https://api.themoviedb.org/4/list/1";
    }

    public static TimeUnit getTimeUnit() {
        return timeUnit;
    }
}
