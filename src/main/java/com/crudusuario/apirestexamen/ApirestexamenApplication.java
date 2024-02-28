package com.crudusuario.apirestexamen;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.crudusuario.apirestexamen.clases.ExpresionesRegulares;
import com.crudusuario.apirestexamen.respository.ExpresionesRegularesRepository;
 

@SpringBootApplication
public class ApirestexamenApplication {
        
	@Autowired
	private ExpresionesRegularesRepository expresionesRegularesRepository;

    @Value("${idRegularExpresion}")
    private String idRegularExpresion;

    @Value("${nombreRegularExpresion}")
    private String nombreRegularExpresion;

    @Value("${regularExp}")
    private String regularExp;


	public static void main(String[] args) {
		SpringApplication.run(ApirestexamenApplication.class, args);
 
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) { 
            Statement statement = connection.createStatement();
 
            String createTableSQLUsuario = "DROP TABLE IF EXISTS usuarios; " + 
									"CREATE TABLE usuarios (" +
                                    "id VARCHAR(100)," +
                                    "name VARCHAR(50) NOT NULL," +
                                    "email VARCHAR(50), " +
									"password VARCHAR(50) , " +
									"created DATETIME , " +
									"modified DATETIME , " +
									"last_login DATETIME, " +
									"token Text , " +
									"isActive tinyint " +
									")"; 

			String createTableSQLTelefono = "DROP TABLE IF EXISTS telefono; " +
									"CREATE TABLE telefono (" +
									"idUsuario VARCHAR(100)," +
									"number VARCHAR(50) NOT NULL," +
									"cityCode VARCHAR(50), " +
									"countryCode VARCHAR(50) " +
									")";

			String createTableSQLRegularExpresion = 
						"DROP TABLE IF EXISTS ExpresionesRegulares; " +  
						"CREATE TABLE ExpresionesRegulares (" + 
						"id INT PRIMARY KEY, " + 
						"nombre VARCHAR(50), " +
						"expresionRegular VARCHAR(255));";
 
            statement.executeUpdate(createTableSQLUsuario);
            statement.executeUpdate(createTableSQLTelefono);
            statement.executeUpdate(createTableSQLRegularExpresion); 
 
            System.out.println("Tabla creada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        } 

	}

    @PostConstruct
    public void init() {
        // http://localhost:8080/swagger-ui.html
        ExpresionesRegulares expresionRegular = new ExpresionesRegulares();
        expresionRegular.setId(Integer.parseInt(idRegularExpresion));
        expresionRegular.setNombre(nombreRegularExpresion);
        expresionRegular.setExpresionRegular(regularExp);

        expresionesRegularesRepository.save(expresionRegular);
    }

}
