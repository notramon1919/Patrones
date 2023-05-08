import java.util.concurrent.ThreadLocalRandom;

class Termometro {

    private float temperatura;

    void start(){
        while (true) {
            temperatura = ThreadLocalRandom.current().nextFloat()*50;
            System.out.println("Temperatura: " + temperatura);

            // notificar a los observadores la temperatura

            try { Thread.sleep(1000); } catch (Exception ignored) { }
        }
    }
}

class Termostato {
    String lugar;
    float maximo;

    public Termostato(String lugar, float maximo) {
        this.lugar = lugar;
        this.maximo = maximo;
    }

    public void update(float temperatura) {
        if (temperatura > maximo) {
            abrir();
        } else {
            cerrar();
        }
    }

    void abrir(){
        System.out.println("Termostato [" + lugar + "] abierto");
    }
    void cerrar(){
        System.out.println("Termostato [" + lugar + "] cerrado");
    }
}

public class Main {
    public static void main(String[] args) {
        Termometro termometro = new Termometro();

        Termostato t1 = new Termostato("cocina", 30);
        Termostato t2 = new Termostato("salon", 20);
        Termostato t3 = new Termostato("habitacion", 26);

        // añadir los termostatos como observadores del termometro

        termometro.start();
    }
}