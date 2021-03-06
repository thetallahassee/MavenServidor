package com.example.MavenServidor;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Arrays;

@SpringBootApplication
public class MavenServidorApplication {
	public static MongoDatabase db;
	public static void main(String[] args) throws IOException {
		SpringApplication.run(MavenServidorApplication.class, args);

        /*Servidor serv = new Servidor(); //Se crea el servidor

        System.out.println("Iniciando servidor\n");
        serv.startServer();*/


        MongoClient mongoClient= conectarBBDD();
		//db = mongoClient.getDatabase("demografia"); //se conecta a la BBDD y si no la crea
        db = mongoClient.getDatabase("demografia");

		/*CiudadesControlle r ciudades = new CiudadesController();
		System.out.println("EL LISTADO: "+ ciudades.list());*/
	}

	private static MongoClient conectarBBDD() {
		String user = "user2"; // the user name
		String database = "admin"; // the name of the database in which the user is defined
		String password = "user2"; // the password as a character array

		MongoCredential credential = MongoCredential.createCredential(user, database, password.toCharArray());
		MongoClient mongoClient = new MongoClient(new ServerAddress("192.168.1.133:27017", 27017), Arrays.asList(credential));
		System.out.println("conexion OK");
		return mongoClient;
	}
}
