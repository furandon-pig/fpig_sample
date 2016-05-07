/* LinqSample.cs */

using System;
using System.Collections.Generic;
using System.Linq;

namespace FpigSample
{
  public class MyModel
  {
    public int Id { get; set; }
    public String Name { get; set; }
    public string toString()
    {
      return this.Id + "," + this.Name;
    }
  }

  public class LinqSample
  {
    public static void Main()
    {
      var data = new List<MyModel>()
      {
        new MyModel { Id = 1, Name = "apple" },
        new MyModel { Id = 2, Name = "orange" }
      };

      var d1 = new MyModel();
      d1.Id = 3;
      d1.Name = "grape";
      data.Add(d1);

      data.Add(new MyModel { Id = 4, Name = "banana" });

      // listup all data
      foreach(MyModel m in data)
      {
        System.Console.WriteLine(m.toString());
      }
      System.Console.WriteLine("---");

      // query expression
      var result = data.Where(d => d.Id == 2);
      foreach (var r in result)
      {
        System.Console.WriteLine(r.Id + " " + r.Name);
      }
    }
  }
}

