import javax.swing.text.html.HTMLEditorKit;
import java.sql.SQLOutput;

public class ManejadorEtiquetas   extends HTMLEditorKit.ParserCallback  {

    @Override
    public void handleText(char[] data, int pos) {

        String texto = new String( data );

        System.out.println( texto );
    }
}
