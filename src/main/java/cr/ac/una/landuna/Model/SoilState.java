package cr.ac.una.landuna.Model;

public enum SoilState {
   DISPONIBLE("DISPONIBLE"),
   EN_PRODUCCION("EN_PRODUCCION"),
   EN_DESCANSO("EN_DESCANSO");
   
   private final String soilState;
   private SoilState(String state){
       this.soilState = state; 
   }
   public String getSoilState(){
       return this.soilState;
   } 
}
