import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import java.util.ArrayList;

public class ProcesaParrrafo  extends HTMLEditorKit.ParserCallback {

    private int contador ;
    private boolean inParagraph;

    public ProcesaParrrafo() {
        contador = 0;
        inParagraph = false;
        ArrayList text = new ArrayList();
    }

    @Override
    public void handleText(char[] data, int pos) {

        int contadorPalabras = 0;
        int TotalPalabras = 0;
        if( inParagraph ) {
            String texto = new String(data);

            // contador de palabras

            String[] palabras = texto.split("\\s");

            for (int i = 0; i < palabras.length; i++) {
                if (palabras.length != 0){
                    TotalPalabras = contadorPalabras + palabras.length;
                }
            }
            System.out.println("Total de palabras: " + TotalPalabras );
        }
        //System.out.println(texto);
    }

    @Override
    public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {
        if( t == HTML.Tag.P ) {
            inParagraph = true;
        }
    }

    @Override
    public void handleEndTag(HTML.Tag t, int pos) {
        if( t == HTML.Tag.P ) {
            inParagraph = false;
            contador++;
        }
        if( t == HTML.Tag.BODY ) {
            System.out.printf("Total de parrafos em documento: %d%n", contador);
        }
    }

}
