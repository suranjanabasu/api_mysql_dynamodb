//package com.springjwt.apijwt.configuration;
//
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.vault.core.VaultTemplate;
//import org.springframework.vault.support.VaultResponseSupport;
//
//import javax.sql.DataSource;
//
//@Configuration
//@DependsOn("VaultConfiguration")
//public class DataSourceConfig {
//
////    @Bean
////    public DataSource getDataSource() {
////        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
////        dataSourceBuilder.driverClassName("org.h2.Driver");
////        dataSourceBuilder.url("jdbc:h2:file:~/test");
////        MySecretData mySecretData =  getSecrets();
////        dataSourceBuilder.username(mySecretData.getUsername());
//
//        //todo: get the password from vault
//        //dataSourceBuilder.password(mySecretData.getPassword());
////        return dataSourceBuilder.build();
////    }
//
//    @Bean
//    public DataSource getDataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
//
//        dataSourceBuilder.url("jdbc:mysql://localhost:3306/db_example");
//        MySecretData mySecretData =  getSecrets();
//        dataSourceBuilder.username(mySecretData.getUsername());
//
//        //todo: get the password from vault
//        dataSourceBuilder.password(mySecretData.getPassword());
//        return dataSourceBuilder.build();
//    }
//
//    private MySecretData getSecrets() {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
//                VaultConfiguration.class);
//
//        context.start();
//
//        VaultTemplate vaultTemplate = context.getBean(VaultTemplate.class);
//        VaultResponseSupport<MySecretData> responseSecretData = vaultTemplate.read(
//                "secret/mysqlDatasource", MySecretData.class);
//
//        context.stop();
//        return responseSecretData.getData();
//
//    }
//
//    static public class MySecretData {
//
//        String username;
//        String password;
//
//        public String getUsername() {
//            return username;
//        }
//
//        public void setUsername(String username) {
//            this.username = username;
//        }
//
//        public String getPassword() {
//            return password;
//        }
//
//        public void setPassword(String password) {
//            this.password = password;
//        }
//    }
//
//}
