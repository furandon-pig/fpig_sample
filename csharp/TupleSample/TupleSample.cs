/* TupleSample.cs */

/*
 * Tupleクラス
 * https://msdn.microsoft.com/ja-jp/library/system.tuple(v=vs.110).aspx
 */

using System;

namespace FpigSample
{
  public class TupleSample
  {
    public static void Main()
    {
      var Id = 1;
      var myTuple = Tuple.Create(Id++, "hello", DateTime.Now);

      Console.WriteLine(myTuple.Item1);
      Console.WriteLine(myTuple.Item2);
      Console.WriteLine(myTuple.Item3);

      Console.WriteLine(myTuple.Item1.GetType());
      Console.WriteLine(myTuple.Item2.GetType());
      Console.WriteLine(myTuple.Item3.GetType());
    }
  }
}

