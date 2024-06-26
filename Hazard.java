import java.util.Random;

import java.util.Random;
import java.util.Scanner;
public class Hazard{
   //////////////////
   // Properties
   //////////////////
   int yCor;
   int xCor;
   String type;

   // getHazard. Have hazard type accessor method. 
   //////////////////
   // Constructors
   //////////////////
   public Hazard(String type,int x, int y){
      this.type = type;
      this.xCor = x;
      this.yCor = y;
      if(type.equals("Bat")){
         this.type = "B";
      } else if(type.equals("Pit")){
         this.type = "P";
      }
   }
   ///////////////////
   // Methods
   ///////////////////
   public String getHazard(){
      return this.type;
   }
   public int getXPosition(){
      return this.xCor;
   }

   public int getYPosition(){
      return this.yCor;
   }

   public void batCarry(Random random, Player player){
         System.out.println("You ran into a bat");
         Random ran = new Random();

         int newX = ran.nextInt(5);
         int newY = ran.nextInt(4);

         player.updateXPosition(newX);
         player.updateYPosition(newY);

         System.out.println("New Cave: Position Updated");
   }
   /// Wait for Laksh
   public void pitTrivia(Scanner scanner, Trivia trivia, Player player){
      Scanner console = new Scanner(System.in);
      Random ran = new Random();

         System.out.println("You fell into a pit!");
         System.out.println("Answer these trivia questions to survive!!!");
         String question = trivia.getQuestion();
         String playerAnswer = console.next();
        

      if( trivia.checkAnswer(question) == false){
         System.out.println("INCORRECT");
            player.die();
      } else{
         System.out.println("You survived :)");
         player.updateXPosition(ran.nextInt(0));
         player.updateYPosition(ran.nextInt(2));
      }
         
   }

}