import java.util.Map;

public class Pelicula {

    Map<String, Object> result;

    //Obtiene el título para darle nombre al archivo próximamente.
    public String getTitle() {
        Map<String, Object> properties = (Map<String, Object>) result.get("properties");
        return properties.get("title").toString();
    }

    public String propiedades() {
        Map<String, Object> properties = (Map<String, Object>) result.get("properties");
        String producer = properties.get("producer").toString();
        String titulo = properties.get("title").toString();
        String episode_id = properties.get("episode_id").toString();
        String director = properties.get("director").toString();
        String release_date = properties.get("release_date").toString();

        return "producer='" + producer + '\'' +
                ", titulo='" + titulo + '\'' +
                ", episode_id='" + episode_id + '\'' +
                ", director='" + director + '\'' +
                ", release_date='" + release_date;
    }

}