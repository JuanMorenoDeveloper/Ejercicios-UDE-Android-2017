package ude.edu.uy.ejemplourlconnectionrestclient;

public class RestDataDto {

    private int id;
    private String type;
    private String quote;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "RestDataDto{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", quote='" + quote + '\'' +
                '}';
    }
}
