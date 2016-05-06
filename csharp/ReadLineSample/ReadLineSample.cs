/* ReadLineSample.cs */

using System;

namespace FpigSample
{
  public class ReadLineSample
  {
    public static void Main()
    {
      string line;

      Console.Write("Ctrl-D to quit. > ");
      while ((line = Console.ReadLine()) != null)
      {
        Console.WriteLine(line);
        Console.Write("Ctrl-D to quit. > ");
      }
      Console.WriteLine("");
    }
  }
}

