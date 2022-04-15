public class Student extends Course 
{
    private int Id;
    private String Fullname;
    private String Address;
    private String Mobile;
    private int Stage;
    private final String Department = "ISE";

    public Student(){}
    public Student(int id, String fullname, String address, String mobile, int stage){
        setId(id);
        setFullname(fullname);
        setAddress(address);
        setMobile(mobile);
        setStage(stage);
    }

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getFullname() {
        return Fullname;
    }
    public void setFullname(String fullname) {
        Fullname = fullname;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public String getMobile() {
        return Mobile;
    }
    public void setMobile(String mobile) {
        Mobile = mobile;
    }
    public int getStage() {
        return Stage;
    }
    public void setStage(int stage) {
        Stage = stage;
    }
    public String getDepartment() {
        return Department;
    }
    
    @Override
    public String toString(){
        return getId() + "," +getFullname() + "," + getAddress() + "," +getMobile() + "," + getStage() + "," + getDepartment();
    }
}
