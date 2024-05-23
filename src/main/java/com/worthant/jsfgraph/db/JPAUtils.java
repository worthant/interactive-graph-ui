package com.worthant.jsfgraph.db;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Properties;
import lombok.Getter;

/**
 * Utility class for handling JPA EntityManagerFactory.
 */
public class JPAUtils {
    @Getter private static final EntityManagerFactory factory;

    static {
        try {
            Properties info = new Properties();
            info.put("jakarta.persistence.jdbc.driver",
                     "org.postgresql.Driver");
            info.put("jakarta.persistence.jdbc.url",
                     String.format("jdbc:postgresql://%s:5432/%s",
                                   System.getenv("DB_HOST"),
                                   System.getenv("POSTGRES_DB")));
            info.put("jakarta.persistence.jdbc.password",
                     System.getenv("POSTGRES_PASSWORD"));
            info.put("jakarta.persistence.jdbc.user",
                     System.getenv("POSTGRES_USER"));

            factory = Persistence.createEntityManagerFactory("default", info);
        } catch (Throwable ex) {
            System.err.println(
                "Something went wrong during initializing EclipseLink: " + ex);
            throw new ExceptionInInitializerError();
        }
    }
}
