
using System.Windows.Forms;

public class MsgBox
{
  public static void Main()
  {
    MessageBox.Show(
        "こんにちは",
        "MessageBox sample",
        MessageBoxButtons.OK,
        MessageBoxIcon.Information
    );
  }
}

