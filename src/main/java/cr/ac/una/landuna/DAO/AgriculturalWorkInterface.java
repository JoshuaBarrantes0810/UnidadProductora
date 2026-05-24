/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.landuna.DAO;

import cr.ac.una.landuna.Model.AgriculturalWork;
import java.util.List;

public interface AgriculturalWorkInterface {
    boolean insertTypeWork(AgriculturalWork work);
    boolean updateWork(AgriculturalWork work);
    boolean deleteWork(AgriculturalWork work);
    List<AgriculturalWork> displayWorks();
    AgriculturalWork findWork(String code);
}
