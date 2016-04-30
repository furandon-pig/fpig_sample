/* ObjectInitializer */

public class ObjectInitializer
{
  public int Id { get; set; }
  public string Name { get; set; }

  public string toString()
  {
    return this.Id + ", " + this.Name;
  }

  public ObjectInitializer()
  {
    System.Console.WriteLine("-> ObjectInitializer");
  }

  public static void Main()
  {
    // initialize an object
    var oi = new ObjectInitializer
    {
      Id = 1,
      Name = "apple"
    };
    System.Console.WriteLine(oi.toString());

    // initialize array objects
    ObjectInitializer[] ois =
    {
      new ObjectInitializer() { Id = 2, Name = "orage" },
      new ObjectInitializer() { Id = 3, Name = "grape" },
      new ObjectInitializer() { Id = 4, Name = "banana" }
    };
    foreach (ObjectInitializer o in ois)
    {
      System.Console.WriteLine(o.toString());
    }
  }
}

