/* CSShell.cs */

using System;

namespace FpigSample
{
  public class ReadLineSample
  {
    private static void ExecuteCommand(string cmd, string arg)
    {
        var p = new System.Diagnostics.Process();

        p.StartInfo.FileName = cmd;

        p.StartInfo.UseShellExecute = false;
        p.StartInfo.RedirectStandardOutput = true;
        p.StartInfo.RedirectStandardInput = false;

        p.StartInfo.CreateNoWindow = true;
        p.StartInfo.Arguments = arg;

        p.Start();

        string res = p.StandardOutput.ReadToEnd();

        p.WaitForExit();
        p.Close();

        System.Console.Write(res);
    }

    public static void Main()
    {
      string line;

      Console.Write("Ctrl-D to quit. > ");
      while ((line = Console.ReadLine()) != null)
      {
        ExecuteCommand(line, "");
        Console.Write("Ctrl-D to quit. > ");
      }
      Console.WriteLine("");
    }
  }
}

