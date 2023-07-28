package com.vietnew360.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration // Đánh dấu class này là một file cấu hình Spring
@EnableJpaRepositories(basePackages = {"com.vietnew360.repository"})// Sử dụng annotation @EnableJpaRepositories để quét và quản lý các repository 
                                                                      //(các interface xử lý truy vấn dữ liệu) trong package 
@EnableTransactionManagement // cho phép tự động quản lý giao dịch trong ứng dụng. Điều này đảm bảo rằng các thao
								// tác trên cơ sở dữ liệu được thực hiện theo các giao dịch, bao gồm việc kết
								// nối, đóng kết nối và ghi nhận thay đổi (commit).
public class JPAConfig {
	/*
	 * entityManagerFactory(): Phương thức này tạo và cấu hình đối tượng
	 * LocalContainerEntityManagerFactoryBean. Nó thiết lập nguồn dữ liệu
	 * (dataSource), tên đơn vị bền vững (persistenceUnitName), JpaVendorAdapter
	 * (đối tác cung cấp JPA, trong trường hợp này sử dụng
	 * HibernateJpaVendorAdapter), và các thuộc tính JPA bổ sung
	 * (additionalProperties).
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() { // cấu hình và tạo EntityManagerFactory,
																			// EntityManagerFactory là một giao diện
																			// quản lý các đối tượng liên quan đến JPA
																			// như Entity, EntityManager,
																			// và các thao tác CRUD trên cơ sở dữ liệu.
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPersistenceUnitName("persistence-data");
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		return em;
	}
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager; //để quản lý giao dịch sử dụng EntityManagerFactory đã được cấu hình.
	}
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();// trả một bean được sử dụng để xử lý ngoại lệ trong quá trình giao dịch.
	}

	@Bean
	public DataSource dataSource() {// Phương thức này tạo và cấu hình đối tượng DataSource, đại diện cho nguồn dữ
									// liệu (database) mà ứng dụng sử dụng.
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}

	/*
	 * Phương thức này trả về một đối tượng Properties, chứa các thuộc tính cấu hình
	 * cho Hibernate, một trong số đó là thuộc tính "hibernate.hbm2ddl.auto" để xác
	 * định cách Hibernate xử lý schema (cấu trúc cơ sở dữ liệu). Trong ví dụ này,
	 * thuộc tính được đặt là "none" để Hibernate không tự động tạo hoặc cập nhật
	 * schema.
	 */
	Properties additionalProperties() {
		Properties properties = new Properties();
		 //properties.setProperty("hibernate.hbm2ddl.auto", "update");
		// properties.setProperty("hibernate.hbm2ddl.auto", "create");
		properties.setProperty("hibernate.hbm2ddl.auto", "none");
		//properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
		return properties;
	}
}
