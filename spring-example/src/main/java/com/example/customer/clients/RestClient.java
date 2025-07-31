package com.example.customer.clients;


import com.example.customer.config.DatabaseConfig;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class RestClient implements InitializingBean, DisposableBean {

    private DatabaseConfig databaseConfig;

    public RestClient(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
        System.out.println("""
      constructor executed
      """);
    }

    public void setDatabaseConfig(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
        System.out.println("""
      setter executed
      """);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("""
      destroy executed
      """);
    }

    public void myDestroy() throws Exception {
        System.out.println("""
      myDestroy executed
      """);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("""
      afterPropertiesSet executed
      """);
    }

    public void myInit(){
        System.out.println("""
      myInit executed
      """);
    }
}

