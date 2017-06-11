import java.io.*;//import io package
public class Comp202Photoshop// class with main method
{
  public static void main(String args[])
  {
    String fileInputName = args[0];//command-line arguments
    String fileOutputName = args[1]; 
    String format = args[2];
    String operation = args[3];
    try//try block
    {
    Image img = ImageFileUtilities.readImage(fileInputName);//storing the 'read' image
    //the following checks input and performs relevant operations
    if(operation.equals("-cr"))
    {
      int startX = Integer.parseInt(args[4]);
      int startY = Integer.parseInt(args[5]);
      int endX = Integer.parseInt(args[6]);
      int endY = Integer.parseInt(args[7]);
      img.crop(startX, startY, endX, endY);
    }
    else if(operation.equals("-fh"))
    {
      img.flip(true);
    }
    else if(operation.equals("-fv"))
    {
      img.flip(false);
    }     
    else if(operation.equals("-gs"))
    {
      img.toGrey();
    }
    else
    {
      System.out.println("Incorrect operation!");
    }
    if(format.equalsIgnoreCase("pnm"))
    {
      ImageFileUtilities.writePnm(fileOutputName, img);
    }
    else if(format.equalsIgnoreCase("pgm"))
    {
      ImageFileUtilities.writePgm(fileOutputName, img);
    }
    else//If user inputs other than pgm or pnm
    {
      System.out.println("File format not found!");
    }
    }
    catch(FileNotFoundException e)//if the file doesnt exist, error caught
    {
      System.out.println("File not found!");
    }
    catch(IOException e)//Input Output exception caught
    {
      System.out.println("Wrong Input");
    }
  }
}