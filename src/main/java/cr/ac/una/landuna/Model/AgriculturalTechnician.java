package cr.ac.una.landuna.Model;

public enum AgriculturalTechnician {
    FITOTECNIA("Fitotecnia"),
    HORTICULTURA("HORTICULTURA"),
    FRUTICULTURA("FRUTICULTURA"),
    ABONO("ABONO"),
    RIEGOS("RIEGOS"),
    LIMPIEZA("LIMPIEZA");
    
    private String specialty;
    
    private AgriculturalTechnician(String specialty){
        this.specialty=specialty;
    }
    
    public String getSpecialty(){
        return this.specialty;
    }
    
    @Override
    public String toString(){
        return specialty;
    }
}
