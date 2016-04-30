/* AutoImplementProperty */

public class AutoImplementProperty
{
  public string Msg { get; set; }

  public static void Main()
  {
    var aip = new AutoImplementProperty();
    aip.Msg = "Hello,World.";

    System.Console.WriteLine(aip.Msg);
  }
}

