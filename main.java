import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<List<String>> taco = new ArrayList();
    for (int i = 0; i<=2; i++){
      List l = new ArrayList(); 
      for (int j = 0; j<=2; j++){
        l.add(" ");
      }
      taco.add(l);
    }
    
    String winChecker = "X";
    Boolean gameOver = false;


    burrito(taco,scanner);
  }
  public static void createBoard(List<List<String>> taco){
    for(int i = 0; i <3;i++){
      for(int o = 0; o <3; o++){
        System.out.print(taco.get(i).get(o));
        if(o!=2){
          System.out.print("|");
        }
      }
      if(i!=2){
        System.out.println("");
        System.out.println("- - -");
      }
    }
  }

  public static void burrito(List<List<String>> taco, Scanner scanner){
    System.out.print("\033[H\033[2J");
    System.out.flush();
    System.out.print("What move do you want to do? (x,y)");
    String move = scanner.nextLine();
    int moveCol = Integer.parseInt(String.valueOf(move.charAt(0)));
    int moveRow = Integer.parseInt(String.valueOf(move.charAt(2)));
    taco.get(moveRow).set(moveCol,"O");
    createBoard(taco);
  }


  //https://tictactoefree.com/tips/how-to-win-tic-tac-toe-if-you-go-second#:~:text=If%20your%20opponent%20begins%20with,to%20maneuver%20in%20subsequent%20moves.
  public static void theCooksRecipe(List<List<String>> taco, String finalMove){
    //  0  1  2
    //0 x| x| x
    //1 xyeah|  | x
    //2 x| x| x

    // for i in range
    System.out.print("\033[H\033[2J");
    System.out.flush();
    //taking the middle pos
    if(!stomachFull(taco,1,1)){
      taco.get(1).set(1, "X");
    }
    //Checking for any potential blocks or winning moves
    else if(choiceOfMeat(taco,"X") == null){
      if(choiceOfMeat(taco,"O") == null){
        break;
      }else{
        taco.get(choiceOfMeat(taco,"O").get(0)).set(choiceOfMeat(taco,"O").get(1),"X");
      }
    }else{
      taco.get(choiceOfMeat(taco,"X").get(0)).set(choiceOfMeat(taco,"X").get(1),"X");
    }
    createBoard(taco);
  }
