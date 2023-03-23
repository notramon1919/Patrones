public class Main {
    public static void main(String[] args) {
        new AlertDialog.Builder("Suscribirse", "Desea suscribirse a mi canal?")
                .setYes("Sí, suscribeme ahora mismo")
                .setNo("No, otro día")
                .show();
    }
}
