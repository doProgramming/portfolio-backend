package product.IoT.dto;

public class Relay {

    private String name;
    private final long id;
    private String ReleyOn;
    private String ReleyOff;

    public Relay(String name, long id, String releyOff) {
        this.name = name;
        this.id = id;
        ReleyOff = releyOff;
    }

    public Relay(String name, String releyOn, long id) {
        this.name = name;
        this.id = id;
        ReleyOn = releyOn;
    }

    public String getReleyOn() {
        return ReleyOn;
    }

    public void setReleyOn(String releyOn) {
        ReleyOn = releyOn;
    }

    public String getReleyOff() {
        return ReleyOff;
    }

    public void setReleyOff(String releyOff) {
        ReleyOff = releyOff;
    }

    public Relay(long id, String name){
        this.id = id;
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public long getId(){
        return id;
    }
}
