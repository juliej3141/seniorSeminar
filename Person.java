import java.util.ArrayList;

public class Person {
  private String Id;
  /*
  private int first;  //[first, second, third, fourth, fifth]
  private int second;
  private int third;
  private int fourth;
  private int fifth;
  */
  //private int classroom;
  private ArrayList<Integer> prio;
  private ArrayList<Integer> schedule;

  public Person(String cId, int cfirst, int csecond, int cthird, int cfourth, int cfifth) { 
    Id = cId;
    /*first = cfirst;
    second = csecond;
    third = cthird;
    fourth = cfourth;
    fifth = cfifth;*/
    
    //classroom = cclass;

    //arraylist prio -> 
    prio = new ArrayList<Integer>();
    prio.add(cfirst);
    prio.add(csecond);
    prio.add(cthird);
    prio.add(cfourth);
    prio.add(cfifth);

    schedule = new ArrayList<Integer>();
  }

  //getter method returning prio  
  public ArrayList<Integer> getPrio(){
    return prio;
  }

  //method to remove a choice
  public void removeChoice(int choiceNum){
    prio.remove(choiceNum);
  }

  public String getId() {
    return Id;
  }
  /*
  public int getFirst() {
    return first;
  }

   public int getSecond() {
    return second;
  }

   public int getThird() {
    return third;
  }

   public int getFourth() {
    return fourth;
  }

   public int getFifth() {
    return fifth;
  }
  */
  // public int getClassroom() {
    //return classroom;
 // }

  public String toString() {
    return Id + " " + prio;
    //return Id + " " + first + " " + second + " " + third + " " + fourth + " " + fifth + "\n";
  }
}