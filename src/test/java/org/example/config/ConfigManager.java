package org.example.config;

public class ConfigManager {

    private final static String ORANGEHRM_URL = System.getenv("ORANGEHRM_URL");
    private final static String ORANGEHRM_USERNAME = System.getenv("ORANGEHRM_USERNAME");
    private final static String ORANGEHRM_PASSWORD = System.getenv("ORANGEHRM_PASSWORD");

    public static String getUrl(){
        if( ORANGEHRM_URL == null){
            throw new RuntimeException("OrangeHRM URL is not set");
        }
        return ORANGEHRM_URL;
    }

    public static String getUsername(){
        if(ORANGEHRM_USERNAME == null){
            throw new RuntimeException("OrangeHRM Username is not set");
        }
        return ORANGEHRM_USERNAME;
    }

    public static String getPassword(){
        if(ORANGEHRM_PASSWORD == null){
            throw new RuntimeException("OrangeHRM Password is not set");
        }
        return ORANGEHRM_PASSWORD;
    }

}
