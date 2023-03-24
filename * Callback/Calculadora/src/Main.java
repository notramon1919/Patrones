class Calculadora {

    interface Callback {
        void resultadoInt(int acertado);
        void resultadoDouble(double acertado);
        void equivocado(String equivocado);
    }


    static void suma(Callback callback, int... numeros) {
        int resultado = 0;
        for (Integer numero : numeros) {
            if (resultado + numero > Integer.MAX_VALUE) {
                callback.equivocado("Error intger max value");
            } else {
                callback.resultadoDouble(resultado += numero);
            }
        }
    }
        static void divide ( int a, int b, Callback callback){
            if (b == 0) {
                callback.equivocado("Dividir por 0 no es de esta galaxia");
            } else if (a%b==0){
                callback.resultadoInt(a / b);
            } else {
                callback.resultadoDouble((double)a/b);
            }
        }
    }

    public class Main {
        public static void main(String[] args) {
//           Calculadora.suma(new Calculadora.Callback(){
//
//               @Override
//               public void resultado(int acertado) {
//                   System.out.println("La suma es: " + acertado);
//               }
//
//               @Override
//               public void equivocado(String equivocado) {
//                   System.out.println("Error :" + equivocado);
//               }
//           }, 1,2,10,6,7);

           Calculadora.divide(13, 2, new Calculadora.Callback() {
               @Override
               public void resultadoInt(int acertado) {
                   System.out.println("Tu puntucion exactaLa division es: " + acertado);
               }

               @Override
               public void resultadoDouble(double acertado) {
                   System.out.println("La division es: " + acertado);
               }

               @Override
               public void equivocado(String equivocado) {
                   System.out.println("Error: " + equivocado);
               }
           });
        }
}