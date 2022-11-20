package com.una.serVices.config;

public class ComponentConfig {

    public class Version {
        public static final String V_1 = "V1";
        public static final String V_2 = "V2";
    }

    public class ComponentDAO {
        public static final String USER = "UserDAO";
        public static final String ROLE = "RoleDao";
        public static final String BUSINESS_PROFILE = "BusinessProfileDao";
        public static final String WORK_EXPERIENCE = "WorkExperienceDao";
        public static final String JOB = "JobDao";
        public static final String PERSON = "PersonDao";
        public static final String USER_RECORD = "UserRecordDao";
        public static final String JOB_HIRED_RECORD = "JobHiredRecordDao";

    }

    public class DAO {
        public static final String USER_V_1 = ComponentDAO.USER + Version.V_1;
        public static final String ROLE_V_1 = ComponentDAO.ROLE + Version.V_1;
        public static final String BUSINESS_PROFILE_V_1 = ComponentDAO.BUSINESS_PROFILE + Version.V_1;
        public static final String WORK_EXPERIENCE_V_1 = ComponentDAO.WORK_EXPERIENCE + Version.V_1;
        public static final String JOB_V_1 = ComponentDAO.JOB + Version.V_1;
        public static final String PERSON_V_1 = ComponentDAO.PERSON + Version.V_1;
        public static final String USER_RECORD_V_1 = ComponentDAO.USER_RECORD + Version.V_1;
        public static final String JOB_HIRED_RECORD_V_1 = ComponentDAO.JOB_HIRED_RECORD + Version.V_1;

        public static final String USER_V_2 = ComponentDAO.USER + Version.V_2;
        public static final String ROLE_V_2 = ComponentDAO.ROLE + Version.V_2;
        public static final String BUSINESS_PROFILE_V_2 = ComponentDAO.BUSINESS_PROFILE + Version.V_2;
        public static final String WORK_EXPERIENCE_V_2 = ComponentDAO.WORK_EXPERIENCE + Version.V_2;
        public static final String JOB_V_2 = ComponentDAO.JOB + Version.V_2;
        public static final String PERSON_V_2 = ComponentDAO.PERSON + Version.V_2;
        public static final String USER_RECORD_V_2 = ComponentDAO.USER_RECORD + Version.V_2;
        public static final String JOB_HIRED_RECORD_V_2 = ComponentDAO.JOB_HIRED_RECORD + Version.V_2;

    }

    public class Service {
        public static final String USER = "UserService";
        public static final String BUSINESS_PROFILE = "BusinessProfileService";
        public static final String WORK_EXPERIENCE = "WorkExperienceService";
        public static final String PERSON = "PersonService";
        public static final String USER_RECORD = "UserRecordService";
        public static final String JOB_HIRED_RECORD = "JobHiredRecordService";
        public static final String JOB = "JobService";

    }

    public class Mapper {
        public static final String SPRING = "spring";
    }
}
