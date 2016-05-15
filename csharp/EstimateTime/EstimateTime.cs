/* EstimateTime.cs */

using System.Diagnostics;  // Stopwatch class

namespace FpigSample
{
  public class EstimateTime
  {
    public void Estimate(string str)
    {
      //var watch = new System.Diagnostics.Stopwatch();
      var watch = new Stopwatch();
      var max = 100000;
  
      watch.Start();
      for (var i = 0; i < max; i++) {
        try
        {
          var v = int.Parse(str);
          v++;  // XXX
        }
        catch
        {
          // do nothing
        }
      }
      watch.Stop();
  
      var result  = watch.ElapsedMilliseconds;
      var avg = (float)result / max;
  
      System.Console.WriteLine("avg= {0}", avg);
    }

    public static void Main()
    {
      var et = new EstimateTime();

      System.Console.WriteLine("-> parse '10'");
      et.Estimate("10");

      System.Console.WriteLine("-> parse null (trap exception)");
      et.Estimate(null);
    }
  }
}

