package com.una.serVices.config;

public class APIRoutes {

    public class Session {

        public static final String LOG_IN = "/login";
        public static final String LOG_OUT = "/logout";
    }

    public class RestAPI {

        public static final String GET_ALL = "/getAll";
        public static final String GET_BY_ID = "/{id}";

    }

    public class API {

        public static final String TYPE = "/api";
        public static final String VERSION_1 = "/v1";
        public static final String USERS_V1 = TYPE + VERSION_1 + "/user";
    }
}
