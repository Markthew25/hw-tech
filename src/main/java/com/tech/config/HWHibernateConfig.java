package com.tech.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.tech.entity.Item;


@EnableWebMvc
@ComponentScan(basePackages="com.tech")
public class HWHibernateConfig {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {

			try {

				Configuration config = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties

				Properties settings = new Properties();

				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hwtechnical?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "create-drop");

				config.setProperties(settings);

				// Add JPA entity mappings
				config.addAnnotatedClass(Item.class);

				ServiceRegistry serviceReg = new StandardServiceRegistryBuilder()
						.applySettings(config.getProperties())
						.build();

				sessionFactory = config.buildSessionFactory(serviceReg);

			} catch (Exception e) {
				System.out.println("Error in HWHibernateConfig: " + e);
			}

		}

		return sessionFactory;

	}

}
