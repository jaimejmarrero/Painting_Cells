import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        String command = "";
        Scanner scannerIn = new Scanner(System.in);
        Painting paint = null;

        System.out.print("Enter the height of your painting: ");
        int row = Integer.parseInt(scannerIn.nextLine());

        System.out.print("Enter how wide your painting will be: ");
        int column = Integer.parseInt(scannerIn.nextLine());

        paint = new Painting(row, column);

        while(true) {
            System.out.print("Enter a valid color (or erase); Enter done to exit: ");
            String color = scannerIn.nextLine();

            if(color.equals("done")) break;

            if(!color.equals("erase") && !PaintingCell.colorExists(color)) {
                System.out.println("You entered an invalid color");
                continue;
            }

            try {
                System.out.print("Enter a valid row: ");
                int r = Integer.parseInt(scannerIn.nextLine());

                System.out.print("Enter a valid column: ");
                int c = Integer.parseInt(scannerIn.nextLine());

                if(!paint.checkBounds(r, c)) {
                    System.out.println("You entered an invalid row/column...Try again");
                    continue;
                }

                if(color.equals("erase")) {
                    paint.erase(r, c);
                }
                else {
                    paint.paint(r, c, color);
                }

                System.out.println(paint);
            }
            catch(NumberFormatException ex)  {
                // Display a warning message and do not modify the image.
                System.out.println("You entered an invalid parameter.");
            }
        }

        System.out.println(paint);
    }

}
