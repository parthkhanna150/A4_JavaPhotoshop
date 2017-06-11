public class Image
{
  //Declaring variables without assigning values
  private String metadata;
  private int maxRange;
  private Pixel[][] data;
  private int width;
  private int height;
  
  public Image(String metadata, int maxRange, Pixel[][] data)//constructor
  {
    
    this.data = new Pixel[data.length][data[0].length];//giving size to the class's data array
    if(maxRange<0)
      throw new IllegalArgumentException("Max range cannot be negative");
    this.metadata = metadata;
    this.maxRange = maxRange;
    for(int i=0; i<data.length; i++)
    {
      for(int j=0; j<data[i].length; j++)
      {
      this.data[i][j] = data[i][j];//filling the class' data array
      }
    }
    this.height=this.data.length;//initialising other variables
    this.width=this.data[0].length;
  }
  //get methods to access private variables
  public String getMetadata()
  {
    return metadata;
  }
  
  public int getMaxRange()
  {
    return maxRange;
  }
  
  public int getWidth()
  {
    return this.data[0].length;
  }
  
  public int getHeight()
  {
    return this.data.length;
  }
  
  public Pixel getPixel(int i, int j)
  {
    return data[i][j];
  }
  //Flip-image method below
  public void flip(boolean horizontal)
  {
    Pixel temp[][]=new Pixel[height][width];
    if(horizontal)//if true flips horizontally
    {
      for(int i=0; i<height; i++)
      {
        for(int j=0; j<width; j++)
        {
        temp[i][j] = data[i][j];
        }
      }
      for(int i=0; i<height; i++)
      {
        for(int j=0; j<width; j++)
        {
          this.data[i][j]=temp[i][width-1-j];//change of index values causes the flip
        }
      }
    }
    else
    { 
      for(int i=0; i<height; i++)
      {
        for(int j=0; j<width; j++)
        {
        temp[i][j] = data[i][j];
        }
      }
      for(int i=0; i<height; i++)
      {
        for(int j=0; j<width; j++)
        {
        this.data[i][j] = temp[(height-1)-i][j];//change of index values causes the flip
        }
      } 
    }      
  }
  //toGrey method below
  public void toGrey()
  {
    for(int i=0; i<height; i++)
    {
        for(int j=0; j<width; j++)
        {
          int avg = this.data[i][j].grey();//stores the value of at this.data[i][j] into avg after calling grey method
          Pixel g = new Pixel(avg);
          this.data[i][j]=g;//assigns the grey-ed values
        }
    }
  }
  //crop method below
  public void crop(int startX, int startY, int endX, int endY)//takes 4 inputs for the crop image dimensions
  {
    this.height=endX-startX;
    this.width=endY-startY;
    if(startY<0 || startX<0 || startY>endY || startX>endX)
      throw new IllegalArgumentException("Wrong input for crop");
    Pixel temp[][] = new Pixel[endX-startX][endY-startY];//[2][2]
    for(int i=0; i<(endX-startX); i++)//0,1
    {
        for(int j=0; j<(endY-startY); j++)//0,1
        {
          temp[i][j] = data[i+startY][j+startX];
        }
    }
    this.data = temp;
  }
}