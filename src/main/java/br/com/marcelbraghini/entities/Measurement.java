package br.com.marcelbraghini.entities;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@RegisterForReflection
@MongoEntity(collection = "measurement")
public class Measurement {

    @BsonId
    public ObjectId objectId;

    @Size(max=5)
    public String temperature;

    @Size(max=5)
    public String moisture;

    public LocalDateTime dateTime = LocalDateTime.now();

    public Measurement() {
    }

    public Measurement(String temperature, String moisture) {
        this.temperature = temperature;
        this.moisture = moisture;
    }

    public ObjectId getObjectId() {
        return objectId;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getMoisture() {
        return moisture;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "temperature='" + temperature + '\'' +
                ", moisture='" + moisture + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
