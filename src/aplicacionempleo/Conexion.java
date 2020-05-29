/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionempleo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Carlos Nuila
 */
public class Conexion {

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public Conexion() {
    }

    public void conectar() {
        this.mongoClient = new MongoClient(
                new MongoClientURI(
                        "mongodb+srv://eagle:aldisparo@cluster0-g2ngr.mongodb.net/test?authSource=admin&replicaSet=Cluster0-shard-0&readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=true"
                )
        );
        this.database = mongoClient.getDatabase("proyecto");
    }

    public void setColeccion(String nombreColeccion) {
        this.collection = database.getCollection("personas");
    }

    public void insertar(Document doc) {
        this.collection.insertOne(doc);
    }

    public void cerrarConexion() {
        this.mongoClient.close();
    }

}
