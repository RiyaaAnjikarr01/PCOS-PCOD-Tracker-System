package pcostracker.model;

public class SymptomEntry {
    private String username;
    private String symptom;
    private int severity;
    private String notes;

    // 🔸 Default constructor (required for DAO)
    public SymptomEntry() {}

    // 🔸 Parameterized constructor
    public SymptomEntry(String username, String symptom, int severity, String notes) {
        this.username = username;
        this.symptom = symptom;
        this.severity = severity;
        this.notes = notes;
    }

    // 🔸 Getters
    public String getUsername() { return username; }
    public String getSymptom() { return symptom; }
    public int getSeverity() { return severity; }
    public String getNotes() { return notes; }

    // 🔸 Setters (needed for DAO result)
    public void setUsername(String username) {
        this.username = username;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
