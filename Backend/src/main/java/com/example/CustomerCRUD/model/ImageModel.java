//package com.example.CustomerCRUD.model;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@Entity
//@Table(name = "Image_Model")
//public class ImageModel {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private String name;
//    private String type;
//
//    //containes column with bytes of picture... very lengthy so we have to specify length of the column
////    @Column(length = 50000000)
//    private byte[] picByte;
//
//    public ImageModel(String name, String type, byte[] picByte) {
//        this.name = name;
//        this.type = type;
//        this.picByte = picByte;
//    }
//
//
//}
