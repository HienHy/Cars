package entities;

public class Classes {
    private Integer id;
    private String name;
    private String room;

    public Classes(Integer id, String name, String room) {
        this.id = id;
        this.name = name;
        this.room = room;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
