package com.example.builder;

public final class Computer {
    
    //required parameters 
    private final String cpu;
    private final int ramGB;

    //optional parameters
    private final String gpu;
    private final String storage;
    private final String motherboard;
    private final boolean hasWiFi;
    private final boolean hasBluetooth;
    private final String powerSupply;
    private final String cooling;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ramGB = builder.ramGB;
        this.gpu = builder.gpu;
        this.storage = builder.storage;
        this.motherboard = builder.motherboard;
        this.hasWiFi = builder.hasWiFi;
        this.hasBluetooth = builder.hasBluetooth;
        this.powerSupply = builder.powerSupply;
        this.cooling = builder.cooling;
    }


    //Getters
    public String getCpu() {return cpu;}
    public int getRamGB() {return ramGB;}
    public String getGpu() {return gpu;}
    public String getStorage() {return storage;}
    public String getMotherboard() {return motherboard;}
    public boolean hasWiFi() {return hasWiFi;}
    public boolean hasBluetooth() {return hasBluetooth;}
    public String getPowerSupply() {return powerSupply;}
    public String getCooling() {return cooling;}

    public static class Builder {
        //required parameters 
        private final String cpu;
        private final int ramGB;

        //optional parameters
        private String gpu = "Integrated Graphics";
        private String storage = "256GB SSD";
        private String motherboard = "Standard ATX";
        private boolean hasWiFi = false;
        private boolean hasBluetooth = false;
        private String powerSupply = "500W";
        private String cooling = "Air Cooling";

        public Builder(String cpu, int ramGB) {
            if(cpu == null || cpu.trim().isEmpty()) {
                throw new IllegalArgumentException("CPU specification is required");
            }
            if(ramGB < 1) {
                throw new IllegalArgumentException("RAM must be atleast 1GB");
            }
            this.cpu = cpu;
            this.ramGB = ramGB;
        }

        public Builder gpu(String gpu) {
            if (gpu !=null && !gpu.trim().isEmpty()) {
                this.gpu = gpu;
            }
            return this;
        }

        public Builder storage(String storage) {
            if (storage !=null && !storage.trim().isEmpty()) {
                this.storage = storage;
            }
            return this;
        }

        public Builder motherboard(String motherboard) {
            if(motherboard!= null && !motherboard.trim().isEmpty()){
                this.motherboard = motherboard;
            }
            return this;
        }

        public Builder withWiFi() {
            this.hasWiFi = true;
            return this;
        }
        public Builder withBluetooth() {
            this.hasBluetooth = true;
            return this;
        }

        public Builder powerSupply(String powerSupply) {
            if(powerSupply!= null && !powerSupply.trim().isEmpty()){
                this.powerSupply = powerSupply;
            }
            return this;
        }
        public Builder cooling(String cooling) {
            if(cooling!= null && !cooling.trim().isEmpty()){
                this.cooling = cooling;
            }
            return this;
        }

        public Computer build() {
            validateConfiguration();
            return new Computer(this);
        }

        private void validateConfiguration() {
            if(gpu.toLowerCase().contains("rtx") && powerSupply.matches("\\d+w")){
                int watts = Integer.parseInt(powerSupply.replaceAll("W", ""));
                if (watts < 650 ) {
                    throw new IllegalStateException("RTX GPUs require at least 650W per supply");
                }
            }

            if(cooling.toLowerCase().contains("air") && cpu.contains("i9")) {
                throw new IllegalStateException("i9 processors require liquid cooling");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Computer{cpu='%s', ramGB=%d, gpu='%s', storage='%s', " +
        "motherboard='%s', hasWiFi=%b, hasBluetooth=%b, " +
        "powerSupply='%s', cooling='%s'",
        cpu, ramGB, gpu, storage, motherboard, hasWiFi, hasBluetooth, powerSupply, cooling);
    }



}
