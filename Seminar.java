public class Seminar {
  private int id;
  private String name;
  private String present;
  private int val;

  public Seminar(int cId, String cName, String cPresent, int cVal) {
    id = cId;
    name = cName;
    present = cPresent;
    val = cVal;
  }
  public void setVal(int newVal) {
    val = newVal;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPresent() {
    return present;
  }

  public int val() {
    return val;
  }
}