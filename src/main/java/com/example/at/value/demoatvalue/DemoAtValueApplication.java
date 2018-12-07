package com.example.at.value.demoatvalue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@SpringBootApplication
public class DemoAtValueApplication implements CommandLineRunner {

//    message.welcome=Welcome
//    admin.users.email=kido@admin.com,skt@admin.com,nugu@admin.com
//    who.am.i=#{systemProperties['host.name']}
//    host.name=hello

    @Value("just set value")
    private String justValue;

    @Value("${message.welcome}")
    private String welcome;

    @Value("${admin.users.email}")
    private String adminUsersCSV;

    @Value("${admin.users.email}")
    private String[] adminUsersArray;

    @Value("#{'${admin.users.email}'.split(',')}")
    private List<String> adminUsersList;

    @Value("#{systemProperties['user.name']}")
    private String userNameSystemSepl;

    @Value("${who.am.i}")
    private String whoami;

    @Value("${user.name}")
    private String userNameWhat;

    @Value("${test.unknown:defaultValue}")
    private String defaultValue;

    @Value("#{systemProperties['unknown'] ?: 'defaultValueSepl'}")
    private String defaultValueSepl;

    @Value("#{'${my.age}' + 10}")
    private int myAge;

    @Value("#{new Integer('${my.age}') + 10}")
    private int myAgeInt;

    @Value("#{new java.text.SimpleDateFormat('yyyy-MM-dd HH:mm:ss').parse('${to.day}')}")
    private Date today;

    public static void main(String[] args) {
        SpringApplication.run(DemoAtValueApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("1. [just value] -------------------------------------------------");
        System.out.println(">>> justValue: " + justValue);

        System.out.println("2. [property] -------------------------------------------------");
        System.out.println(">>> welcome: " + welcome);

        System.out.println("3. [property csv] -------------------------------------------------");
        System.out.println(">>> adminUsersCSV: " + adminUsersCSV);

        System.out.println("4. [csv to array] -------------------------------------------------");
        System.out.println(">>> adminUsersArray Start: ");
        Stream.of(adminUsersArray).forEach(System.out::println);
        System.out.println(">>> adminUsersArray End: ");

        System.out.println("5. [csv to list] -------------------------------------------------");
        System.out.println(">>> adminUsersList Start: ");
        adminUsersList.forEach(System.out::println);
        System.out.println(">>> adminUsersList End: ");

        System.out.println("6. [SPEL system properties] -------------------------------------------------");
        System.out.println(">>> userNameSystemSepl: " + userNameSystemSepl);

        System.out.println("7. [Using SPEL in properties file] -------------------------------------------------");
        System.out.println(">>> whoami: " + whoami);

        System.out.println("8. [systemProperties first] -------------------------------------------------");
        System.out.println(">>> userNameWhat: " + userNameWhat);

        System.out.println("9. [default if absent property] -------------------------------------------------");
        System.out.println(">>> defaultValue: " + defaultValue);

        System.out.println("10. [default SPEL] -------------------------------------------------");
        System.out.println(">>> defaultValueSepl: " + defaultValueSepl);

        System.out.println("11. [SPEL Operation int] -------------------------------------------------");
        System.out.println(">>> myAge: " + myAge);

        System.out.println("12. [SPEL Operation int correct] -------------------------------------------------");
        System.out.println(">>> myAgeInt: " + myAgeInt);

        System.out.println("13. [SPEL Operation date] -------------------------------------------------");
        System.out.println(">>> today: " + today);
    }
}
