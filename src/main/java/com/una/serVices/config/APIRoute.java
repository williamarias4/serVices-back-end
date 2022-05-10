package com.una.serVices.config;

public class APIRoute {

    public class Session {

        public static final String LOG_IN = "/login";
        public static final String LOG_OUT = "/logout";
        public static final String GET_BY_USER_NAME = "/{user_name}";

    }

    public class RestAPI {

        public static final String GET_ALL = "/get-all";
        public static final String GET_BY_ID = "/{id}";
        public static final String GET_BY_USER_NAME = "/{user_name}";

    }

    public class API {

        public static final String TYPE = "/api";
        public static final String VERSION_1 = "/v1";
        public static final String USERS_V1 = TYPE + VERSION_1 + "/user";
        public static final String BUSINESS_PROFILE_V1 = TYPE + VERSION_1 + "/business-profile";
        public static final String WORK_EXPERIENCE_V1 = "/experience";
        public static final String JOB_V1 = TYPE + VERSION_1 + "/job";
    }
}
