package com.weather;

import com.weather.service.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private CityRepository cityRepository;

    private static Logger getLog() {
        return log;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {

        getLog().info("Creating tables");

        // ID, NAME, LONGITUDE, LATITUDE, COUNTRYCODE
        getJdbcTemplate().execute("DROP TABLE CITY IF EXISTS");
        getJdbcTemplate().execute("CREATE TABLE CITY(" +
                "ID INT, NAME VARCHAR(255), LATITUDE DECIMAL(8,6), LONGITUDE DECIMAL(9,6), COUNTRY_CODE VARCHAR(255))");

        int i = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Felipe\\IdeaProjects\\weatherChallenge\\src\\main\\resources\\city_list.txt"))) {
            String line = bufferedReader.readLine();

            while (line != null) {
                if (i != 0) {

                    // Split up the line into an array of it's elements
                    List<Object[]> cityData = Stream.of(line)
                            .map(name -> name.split("\t"))
                            .collect(Collectors.toList());

                    // Uses JdbcTemplate's batchUpdate operation to bulk load data
                    getJdbcTemplate().batchUpdate("INSERT INTO CITY (ID, NAME, LATITUDE, LONGITUDE, COUNTRY_CODE) VALUES (?, ?, ?, ?, ?)", cityData);

                }
                if (i % 5000 == 0) {
                    getLog().info(String.format("Inserting %s cities", i));
                }
                line = bufferedReader.readLine();
                i++;
            }
        }

        /*
        getLog().info("Querying all cities");
        getJdbcTemplate().query(
                "SELECT * FROM CITY",
                (rs, rowNum) -> new City(rs.getInt("ID"), rs.getString("NAME"), rs.getDouble("LATITUDE"), rs.getDouble("LONGITUDE"), rs.getString("COUNTRY_CODE"))
        ).forEach(city -> getLog().info(city.toString()));
        */
        getLog().info(String.format("Inserted %s cities", i));
        getLog().info("Done with creating tables");
    }
}
