package com.example.PlaceFinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiServiceExporter;

@SpringBootApplication
public class RMIServer {
    @Bean
    DBManager DBManagerService() {
        return new DBManagerImpl();
    }

    //@Bean(name = "a")
    //UserDetailsService UserDetailsService() { return new UserDetailsManagerImpl(); }

    @Bean
    RmiServiceExporter dbServiceExporter(DBManager implementation) {
        // Expose a service via RMI. Remote object URL is rmi://<HOST>:<PORT>/<SERVICE_NAME>

        Class<DBManager> serviceInterface = DBManager.class;
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName(serviceInterface.getSimpleName()); //set service name
        exporter.setService(implementation); //set service
        exporter.setServiceInterface(serviceInterface);
        exporter.setRegistryPort(1099);

        return exporter;
    }

    /*@Bean
    RmiServiceExporter loginServiceExporter(@Qualifier("a") UserDetailsService implementation) {
        Class<UserDetailsService> serviceInterface = UserDetailsService.class;
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName("LoginService"); //set service name
        exporter.setService(implementation); //set service
        exporter.setServiceInterface(serviceInterface);
        exporter.setRegistryPort(1099);

        return exporter;
    }*/

    public static void main(String[] args) {
        if(System.getSecurityManager()==null)
            System.setSecurityManager(new SecurityManager());

        //System.setProperty("java.security.policy","file:/home/riccardo/Scrivania/PlaceFinder/RemoteServer/myprogram.policy");
        System.out.println("[SECURITY POLICY]: "+System.getProperty("java.security.policy"));
        SpringApplication.run(RMIServer.class, args);
    }
}
