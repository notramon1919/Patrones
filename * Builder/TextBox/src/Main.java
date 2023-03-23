import java.sql.SQLOutput;

class TextBox {
    String texto;
    int ancho, alto;

    static class Builder {
        String texto;
        int ancho, alto;

        Builder setTexto(String texto){
            this.texto = texto;
            return this;
        }

        Builder setAncho(int ancho){
            this.ancho = ancho;
            return this;
        }

        Builder setAlto (int alto){
            this.alto = alto;
            return this;
        }

        TextBox build(){
            TextBox textbox = new TextBox();
            textbox.texto = this.texto;
            textbox.alto = this.alto;
            textbox.ancho = this.ancho;

            boolean cerrar = false;
            if (alto < 0 | ancho < 0){
                System.out.println("Alto o ancho no es mayor de 0");
                cerrar = true;
            } else if(ancho < texto.length()) {
                System.out.println("El campo ancho es menor al tamaño del texto");
                cerrar = true;
            } else if (texto.isEmpty() == false){
                if (alto < 1){
                    System.out.println("El alto debe ser igual o mayor de uno");
                    cerrar = true;
                }
            } else if (texto == null){
                System.out.println("Texto nunca debe ser null");
                cerrar = true;
            }
                return textbox;

        }


    }

    @Override
    public String toString() {
        return ancho + "x" + alto + "\n" +
                "┏" + "━".repeat(ancho) + "┓\n" +
                ("┃" + " ".repeat(ancho) + "┃\n").repeat((alto - 1) / 2) +
                (alto > 0 ? "┃" + " ".repeat((ancho - texto.length() + 1) / 2) + texto + " ".repeat((ancho - texto.length()) / 2) + "┃\n" : "") +
                ("┃" + " ".repeat(ancho) + "┃\n").repeat(alto / 2) +
                "┗" + "━".repeat(ancho) + "┛\n";
    }
}

public class Main {
    public static void main(String[] args) {

         TextBox textBox = new TextBox.Builder()
                .setAlto(2)
                .setAncho(5)
                .setTexto("Alexis")
                .build();

        System.out.println(textBox.toString());
    }
}

