package base;

public enum FuelType {
    /**
     * Тип топлива
     */
    GASOLINE("GASOLINE"),
    ELECTRICITY("ELECTRICITY"),
    ALCOHOL("ALCOHOL"),
    PLASMA("PLASMA"),
    ANTIMATTER("ANTIMATTER");
    String name;
    FuelType(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
