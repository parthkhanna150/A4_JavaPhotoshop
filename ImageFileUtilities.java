import java.util.Scanner;//scanner class imported
import java.io.*;
public class ImageFileUtilities
{

  /*TESTING 
  * public static void main(String[] args){
    Pixel[][] values;
    try
    {
      Image testing = readImage("./catskype.pnm");
      writePnm("./catskype_pnm", testing);
      writePgm("./catskype_pgm", testing);
    }     
    catch(IOException e){
      e.printStackTrace();
    }
}*/
 
  public static void writePnm(String outName, Image img1) throws IOException{
    //writes files
    FileWriter fw = new FileWriter(outName); //creates a file writer
    BufferedWriter bw = new BufferedWriter(fw); //creates a buffered writer
    bw.write("P3 \n");//format code printed
    bw.write(img1.getMetadata() + "\n");//metadata printed

    int height = img1.getHeight();
    int width = img1.getWidth();
    bw.write(width + " " + height + "\n");// width height printed
    bw.write(""+img1.getMaxRange() + "\n");//prints max range
    for(int i=0; i<height; i++){
      for(int j=0; j<width; j++){
        bw.write(img1.getPixel(i, j).getRed() + " " + img1.getPixel(i, j).getGreen() + " " + img1.getPixel(i, j).getBlue());
        bw.write(" ");
      }
      bw.write("\n");
    }
    bw.close();
    fw.close();
  }
    public static void writePgm(String outName, Image img1) throws IOException{
    //writes files

    FileWriter fw = new FileWriter(outName); //creates a file writer
    BufferedWriter bw = new BufferedWriter(fw); //creates a buffered writer
    bw.write("P2 \n");
    bw.write(img1.getMetadata() + "\n");
    int height = img1.getHeight();//getting values of private attributes using the get methods
    int width = img1.getWidth();
    bw.write(width + " " + height + "\n");
    bw.write(""+img1.getMaxRange() + "\n");
    img1.toGrey();//converts image to grey scale
    for(int i=0; i<height; i++){
      for(int j=0; j<width; j++){
        bw.write(img1.getPixel(i, j).getRed()+"");
        bw.write(" ");//space between 2 color pixels
      }
      bw.write("\n");//next line
    }
    
    bw.close();//closes bufferedwriter
    fw.close();//closes file writer
  }
  public static Image readImage(String filename) throws IOException
  {
    Scanner sc = new Scanner(new File(filename));
    //Scanner s = new Scanner(System.in);
    Pixel[][] values;
    String s = sc.nextLine();
    String metadata = "";
    while(sc.hasNext("#"))
    {
       metadata += sc.nextLine(); //metadata accounted for
    }
    int width = sc.nextInt();
    int height = sc.nextInt();
    int max = sc.nextInt();
    if(s.equals("P3"))//reading the first line of the file
    {
      values = new Pixel[height][width];//an array declared of pixel type
      for(int i=0; i<values.length; i++)
      {
        for(int j=0; j<values[i].length; j++)
      {
          Pixel pix = new Pixel(sc.nextInt(), sc.nextInt(), sc.nextInt());//calls pixel constructor initialising the color values
          values[i][j] = pix;//passing values
      }
    }
    }
    else if(s.equals("P2"))
    {
      values = new Pixel[height][width];
    for(int i=0; i<values.length; i++)
    {
      for(int j=0; j<values[i].length; j++)
      {
        Pixel pix = new Pixel(sc.nextInt());
        values[i][j] = pix;
      }
    }
    }
    else
      throw new IllegalArgumentException();
    sc.close();
    Image image = new Image(metadata, max, values);//passing an Image object to variable image
    return image;//returns an image
  }
}