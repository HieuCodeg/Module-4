package com.hieucodeg.dao;

import com.hieucodeg.model.Medical;

import java.util.Arrays;
import java.util.List;

public class MedicalDao {
    private static Medical medical = new Medical();
    private static final List<String> listGender = Arrays.asList("Nam","Nữ","Khác");
    private static final List<String> listCountry = Arrays.asList("Việt Nam","Lào","CamPuChia","Mỹ","Pháp","Anh","Nga");

    private static final List<String> listTranfer = Arrays.asList("Máy bay","Tàu lửa","Ô tô", "Khác");

    private static final List<String> listProvince = Arrays.asList("Thừa Thiên Huế","Quảng Bình","Quảng Trị", "Đà Nẵng");
    private static final List<String> listDistrict = Arrays.asList("Hương Trà","TP Huế","Nam Đông", "A Lưới");
    private static final List<String> listTown = Arrays.asList("Tứ Hạ","Hương Văn","Hương Toàn", "Hương Chữ");



    static {

    }
    public static Medical getMedical(){
        return medical;
    }
    public static void updateMedical(Medical newMedical) {
        medical = newMedical;
    }
    public static List<String> getListGender(){
        return listGender;
    }
    public static List<String> getListCountry(){
        return listCountry;
    }
    public static List<String> getListTranfer(){
        return listTranfer;
    }
    public static List<String> getListProvince(){
        return listProvince;
    }
    public static List<String> getListDistrict(){
        return listDistrict;
    }
    public static List<String> getListTown(){
        return listTown;
    }

}
