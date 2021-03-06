package fact.it.apt_themeparkservice.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "themeparks")
public class Themepark {
    @Id
    private String id;
    private String name;
    private String address;
    private int capacity;
    private String themeparkCode;

    public Themepark(String id, String name, String address, int capacity, String themeparkCode) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.themeparkCode = themeparkCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getThemeparkCode() {
        return themeparkCode;
    }

    public void setThemeparkCode(String themeparkCode) {
        this.themeparkCode = themeparkCode;
    }
}
