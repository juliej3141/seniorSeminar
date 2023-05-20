import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;

//replit not reading file
public class SeniorSeminar{
  //id. name. presenter, val
  ArrayList<Person> peopleList = new ArrayList<Person>();
  ArrayList<Seminar> seminarList = new ArrayList<Seminar>();
  int[][] chart = new int[5][5];
  //int[][] priority = new int[18][5];
  int[] prio = new int[19];
  int[] sortedPrio = new int[19];
  int[] sortedSession = new int[19];
  int rowCount;
  
  public void setPrio() {

    for (int i = 1; i < 19; i++){
      prio[i] = 0;
      sortedSession[i] = 0;
    }
    
    /*
    for (int i = 0; i < 18; i++) {
      for (int j = 0; j < 5; j++) {
        priority[i][j] = 0;
      }
    } // set prio t o 0
    */
    
    /*
    for (int p = 0; p < 5; p++) {
      for (int q = 0; q < peopleList.size(); q++) {
        if (peopleList.get(q).getFirst() != 0) {
          if (p == 0) {
            priority[peopleList.get(q).getFirst() - 1][p]+=1;
          } //w1
          if (p == 1) {
            priority[peopleList.get(q).getSecond() - 1][p]+=1;
          } //w2
          if (p == 2) {
            priority[peopleList.get(q).getThird() - 1][p]+=1;
          } //w3
          if (p == 3) {
            priority[peopleList.get(q).getFourth() - 1][p]+=1;
          } //w4
          if (p == 4) {
            priority[peopleList.get(q).getFifth() - 1][p]+=1;
          } //w5
        } //if
      } //for ppl
    } //for rows
    */

    //for ecah person
    for(int i = 0; i < peopleList.size(); i++){
      //get the arraylist
      ArrayList<Integer> choices = peopleList.get(i).getPrio();
        //for each value in the arraylist
        for(int j = 0; j < choices.size(); j++){
          prio[choices.get(j)] += (5 - j);
          //add points
            //index 0 + 5pts, index 1  + 4 pts.....
        }
    }
    
    /*
    for (int k = 0; k < 18; k++) {
      for (int r = 0; r < 5; r++) {
        System.out.print(" " + priority[k][r]);
      } //print for col
      System.out.print("\n");
    } //print for rows
    */

    
    for (int i = 1; i < 19; i++){
      System.out.print(" " + prio[i]);
    }
  }

  
  //print out arraylist of all seniors, email, 5 choices
  public void printA() {
    System.out.print(peopleList);
  } //close print

  //adds email, senors name, 5 seminar choices into peopleList array from student.txt
  public void load() { 
   try {
      File myObj = new File("students.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String[] arr = data.split(",");  //  ["12", "last", "first", "12"]
                      //Integer.parseInt(arr[0])
        //parse data into varibales, pass to person constructor
         //email, String name, int first, int second, third, fourth, fifth
        Person p1 = new Person(arr[0], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), Integer.parseInt(arr[5]), Integer.parseInt(arr[6])); //each person become array
        peopleList.add(p1);
      }
     myReader.close();
     
     File myObj2 = new File("seniorSeminar.csv");
     Scanner myReader2 = new Scanner(myObj2);
     while (myReader2.hasNextLine()) {
        String data = myReader2.nextLine();
        String[] arr2 = data.split(",");  //  ["12", "last", "first", "12"]
                      //Integer.parseInt(arr[0])
        //parse data into varibales, pass to person constructor
         //id, String name, presenter, val
        Seminar s1 = new Seminar(Integer.parseInt(arr2[0]), arr2[1], arr2[2], Integer.parseInt(arr2[3])); 
        seminarList.add(s1);
      }
      myReader2.close();
    }
     
    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } //cloe cathch 
  } //close load

  public void run(){
    int p;
    sortedPrio = prio;
    Arrays.sort(sortedPrio); //sorts sortedPrio in ascending order
    System.out.print("\n");
    for (int j = 0; j < 19; j++){
      System.out.print(" " + sortedPrio[j]);
    }
    
    //sorts sortedPrio in descending order
    for (int i = 1; i < sortedPrio.length / 2; i++) {
      p = sortedPrio[i];
      sortedPrio[i] = sortedPrio[sortedPrio.length - i - 1];
      sortedPrio[sortedPrio.length - i - 1] = p;
    }

    System.out.print("\n");
    for (int j = 0; j < 19; j++){
      System.out.print(" " + sortedPrio[j]);
    }

    //keeps adding 75-fix

    /*
    for(int j = 0; j < 5; j++) {  //j is column 
      rowCount = 0; //initialize & reset for each col rowCount
      for(int i = ((j*5)+rowCount); i < 19; i++) { //j*5 
        int temp = sortedPrio[i];
        for (int l = 0; l < 19; l++) { // l is index of session id
          if (prio[l] == temp) { 
          chart[rowCount][j] = l;
          }
        }
        rowCount++;
      }
    }
    /*
    for (int x = 0; x < 5; x++) {
      for (int y = 0; y < 5; y++) {
        System.out.print(" " + chart[x][y]);
      }
      System.out.print("\n");
    }
    */
      //need to find 5 most popular in  prio
      //place the most popular at chart[i][0], chart[i][1]....
      //go through each student and place them into a seminar
    
        //get the students choices and whichever of the top 5 most popular comes first within the students choices the student will be placed into that class
        //however, if that class already has 16 people, place it in the next one that comes first
        //if the student doesnt have have a top 5 choice, place into the least popular class (5th in popularity)

//1, 2, 7, 15, 16
      //once u place the stuednet into the class, you have to remove the chocie in the student
    
      //at the end you ahve to run setPrio() again to recounr the priority
        
    //}
  }
  

}
  