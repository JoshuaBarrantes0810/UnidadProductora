
package cr.ac.una.landuna.Model;

import java.math.BigDecimal;

public class Plot {
    private String plotCode;
    private String plotName;
    private String plotLocation;
    private BigDecimal plotArea;
    private String soilType;
    private SoilState soilState;
    
    public Plot(String plotCode,String plotName,String plotLocation,BigDecimal plotArea,String soilType,SoilState soilState){
        this.plotCode=plotCode;
        this.plotName=plotName;
        this.plotLocation=plotLocation;
        this.plotArea=plotArea;
        this.soilType=soilType;
        this.soilState=soilState;
    }
    
    public void setPlotCode(String code){
        this.plotCode=code;
    }
    public void setPlotName(String name){
        this.plotName=name;
    }
    public void setPlotLocation(String location){
        this.plotLocation=location;
    }
    public void setPlotArea(BigDecimal area){
        this.plotArea=area;
    }
    public void setSoilType(String type){
        this.soilType=type;
    }
    public void setSoilState(SoilState state){
        this.soilState=state;
    }

    public String getPlotCode(){
        return this.plotCode;
    }
    public String getPlotName(){
        return this.plotName;
    }
    public String getLocation(){
        return this.plotLocation;
    }
    public BigDecimal getPlotArea(){
        return this.plotArea;
    }
    public String getSoilType(){
        return this.soilType;
    }
    public SoilState getSoilState(){
        return this.soilState;
    } 
}
