package Enums;

public enum Etat {
    ENCOURS("En cours"),
    TERMINE("Terminé"),
    ANNULE("Annulé");

    private final String dbValue;

    Etat(String dbValue) {
        this.dbValue = dbValue;
    }

    public String getDbValue() {
        return dbValue;
    }

    public static Etat fromDbValue(String dbValue) {
        for (Etat etat : values())
            if (etat.getDbValue().equals(dbValue))
                return etat;
        throw new IllegalArgumentException("Unknown database value: " + dbValue);
    }
}

