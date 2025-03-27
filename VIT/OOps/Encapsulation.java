package OOps;
class Patient {
    private String medicine;  // Private data, cannot be accessed directly
    
    public void setMedicine(String med) {  // Controlled access
        this.medicine = med;
    }
    
    public String getMedicine() {
        return medicine;
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        Patient p = new Patient();
        p.setMedicine("Paracetamol");  // Doctor prescribes medicine
        System.out.println("Prescribed Medicine: " + p.getMedicine());
    }
}


// Encapsulation (Data Hiding and Controlled Access)
// 🔹 Real-Life Example: Medical Prescription (Doctor & Patient)
// When you visit a doctor, they prescribe medicine based on your condition.

// You (patient) can only consume the medicine.

// You cannot change the formula (restricted access).

// Only the doctor (authorized person) can prescribe or change it.

// This is Encapsulation, where sensitive data (medicine formula) is hidden from the patient and only accessible through controlled methods (doctor’s prescription).