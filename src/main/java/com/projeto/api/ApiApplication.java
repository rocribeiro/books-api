package com.projeto.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		try {
            // Carregar o driver do H2
            Class.forName("org.h2.Driver");

            // Conectar ao banco de dados em memória
            Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");

            // Execute operações no banco de dados, crie tabelas, etc.

            // Fechar a conexão quando não for mais necessário
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
	}

}

