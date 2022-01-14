package arrays.roomsManagement;

public class Student {
 
    private String name;
    private String email;
    private int room;

    public Student(String name, String email, int room) {
        this.name = name;
        this.email = email;
        this.room = room;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getRoom() {
        return room;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return this.getRoom()
               + ": "
               + this.getName()
               + ", "
               + this.getEmail();
    }
}
