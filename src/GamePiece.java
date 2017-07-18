import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

/**
 * Created by xxxian on 7/18/17.
 */
public class GamePiece {

    int positionX;
    int positionY;
    boolean frozen;
    String name;
    String color;
    int randoNum1;
    int randoNum2;

    public GamePiece() {
        positionX = 0;
        positionY = 0;
        frozen = false;
        name = "Luke";
        color = "Blue";
    }

    public void move(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void freeze() {
        frozen = true;
    }

    public void unfreeze() {
        frozen = false;
    }

    public void getInfo() {
        System.out.println("========== GAME PIECE ==========");
        System.out.println();
        System.out.println("Position-X: " + positionX + "\nPosition-Y: " + positionY + "\nFroze: " + frozen + "\nName: " + name + "\nColor: " + color);
        System.out.println();
    }

    public void gamePiece() {
        if (!frozen) {
            frozen = true;
        } else if (frozen) {
            unfreeze();
            move(0, 0);
        }
    }

    public void askFrozen() {
        System.out.println("Is it True that it's Frozen???");
        try {
            Scanner scan1 = new Scanner(System.in);
            boolean isItFrozen;
            isItFrozen = scan1.nextBoolean();
            gamePiece();
            getInfo();
            frozen = isItFrozen;
            if (!frozen == true) {
                genRandoNum();
                move(randoNum1, randoNum2);
                getInfo();
            }
        } catch (InputMismatchException ignore) {
            System.out.println("TRY PUTTING: True || False");

        }
    }

    public void genRandoNum() {
        Random count1 = new Random();
        randoNum1 = count1.nextInt(100);
        randoNum2 = count1.nextInt(100);
    }


}


