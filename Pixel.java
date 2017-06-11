public class Pixel
{
  //private attributes
  private int red;
  private int green;
  private int blue;

  public Pixel(int red, int green, int blue)//constructor for initialisation when 3 values are passed
  {
    if(red > 255 || red < 0 || green > 255 || green < 0 || blue > 255 || blue < 0)
      throw new IllegalArgumentException("Out of range!!");
    this.red = red;
    this.green = green;
    this.blue = blue;
  }
  
  public Pixel (int intensity)//constructor for initialisation when one value is passed
  {
    if(intensity > 255 || intensity < 0)
      throw new IllegalArgumentException("Out of range!!");
    this.red = intensity;
    this.green = intensity;
    this.blue = intensity;
  }
  /*Testing
   *public void print()
  {
    System.out.println(getRed() + " " + getGreen() + " " + getBlue() + " " + grey());
  }*/
  //get methods to allow conditional access to the private variables
  public int getRed()
  {
    return red;
  }
  
  public int getGreen()
  {
    return green;
  }
  
  public int getBlue()
  {
    return blue;
  }
  
  public int grey()
  {
    return (int)((blue + green + red) / 3);
  }
  /*public static void main(String args[])
  {
   Pixel p = new Pixel(213, 222, 11);
   p.print();
  }*/  
}
