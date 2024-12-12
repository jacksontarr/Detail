// package com.detail.api.detailapi.persistence;

// import java.io.File;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.Map;
// import java.util.TreeMap;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Component;

// import com.detail.api.detailapi.model.Car;
// import com.fasterxml.jackson.databind.ObjectMapper;

// @Component
// public class DetailListFileDAO implements DetailListDAO {
//     Map<Integer,Car> detailList;
//     private ObjectMapper objectMapper;
//     private String filename;

//     public DetailListFileDAO(@Value("${detailList.file}") String filename, ObjectMapper objectMapper) throws IOException {
//         this.filename = filename;
//         this.objectMapper = objectMapper;
//         load();
//     }

//     private Car[] getDetailListArray() {
//         return getDetailListArray(null);
//     }

//     private boolean save() throws IOException {
//         Car[] detailListArray = getDetailListArray();

//         objectMapper.writeValue(new File(filename),detailListArray);
//         return true;
//     }

//     private boolean load() throws IOException {
//         this.detailList = new TreeMap<>();

//         Car[] detailListArray = objectMapper.readValue(new File(filename),Car[].class);

//         for (Car car : detailListArray) {
//             detailList.put(car.getStockNumber(),car);
//         }
//         return true;
//     }

//     private Car[] getDetailListArray(String containsText) {
//         ArrayList<Car> detailListArrayList = new ArrayList<>();

//         for (Car car : detailList.values()) {
//             if (containsText == null || car.getName().contains(containsText)) {
//                 detailListArrayList.add(car);
//             }
//         }

//         Car[] detailListArray = new Car[detailListArrayList.size()];
//         detailListArrayList.toArray(detailListArray);
//         return detailListArray;
//     }

//     @Override
//     public Car[] getDetailList() throws IOException {
//         synchronized(detailList) {
//             return getDetailListArray();
//         }
//     }

//     @Override
//     public Car[] findCar(String search) throws IOException {
//         synchronized(detailList) {
//             return getDetailListArray(search);
//         }
//     }

//     @Override
//     public Car getCar(int id) throws IOException {
//         synchronized(detailList){
//             if(detailList.containsKey(id))
//                 return detailList.get(id);
//             else   
//                 return null;
//         }
//     }

//     @Override
//     public Car createCar(Car car) throws IOException {
//         synchronized(detailList){
//             Car newCar = new Car(nextId(), car.getName(), car.getType(), car.getPrice(), car.getServings());
//             detailList.put(newCar.getStockNumber(), newCar);
//             save();
//             return newCar;
//         }
//     }

//     @Override
//     public Car updateCar(Car car) throws IOException {
//         synchronized(detailList) {
//             if (!detailList.containsKey(car.getStockNumber())) {
//                 return null;  // car does not exist
//             }
//             detailList.put(car.getStockNumber(), car);
//             save(); // may throw an IOException
//             return car;
//         }
//     }

//     @Override
//     public boolean deleteCar(int id) throws IOException {
//         synchronized(detailList){
//             if(detailList.containsKey(id))
//             {
//                 detailList.remove(id);
//                 return save();
//             }
//             else
//                 return false;
//         }
//     }
// }
