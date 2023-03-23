class Computer {

    // required
    String HDD;
    String RAM;
    // optional
    boolean isGraphicsCardEnabled;
    boolean isBluetoothEnabled;


    static class Builder {
        String HDD;
        String RAM;
        boolean isGraphicsCardEnabled;
        boolean isBluetoothEnabled;

        public Builder(String HDD, String RAM) {
            this.HDD = HDD;
            this.RAM = RAM;
        }

        Builder setGraphic(Boolean graphic) {
            this.isGraphicsCardEnabled = graphic;
            return this;
        }

        Builder setBluetooth(Boolean blue) {
            this.isBluetoothEnabled = blue;
            return this;
        }

        Computer build() {
            Computer comp = new Computer();
            comp.isBluetoothEnabled = this.isBluetoothEnabled;
            comp.isGraphicsCardEnabled = this.isGraphicsCardEnabled;
            return comp;

        }

    }
}

public class Main {
    public static void main(String[] args) {

        Computer comp = new Computer.Builder("2TB","16Gb")
                .setBluetooth(true)
                .build();

        Computer comp2 = new Computer.Builder("1TB","8Gb")
                .build();
    }
}