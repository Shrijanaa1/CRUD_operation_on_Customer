package com.example.CustomerCRUD.controller;

import com.example.CustomerCRUD.model.Customer;

import com.example.CustomerCRUD.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

//    get all employees
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> customers = customerService.getAllCustomer();
        return ResponseEntity.ok(customers);
    }

//    @GetMapping("/customers")
//    public List<Customer>getAllCustomer() {
//        return customerService.getAllCustomer();
//    }


     //crate/add new employee
    @PostMapping("/customers")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer addCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(addCustomer, HttpStatus.CREATED);
    }


    //get customer by ID
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomerById(@PathVariable Long id, @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomerById(id, customer);

        if (updatedCustomer != null) {
            return ResponseEntity.ok(updatedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCustomerById(@PathVariable("id") Long id) {
        customerService.deleteCustomerById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}

//Instead of this now you have to do :(for image)

//    @PostMapping(value = {"/customers"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
//    public Customer addCustomer(@RequestPart("customer") Customer customer,
//                                @RequestPart("imageFile") MultipartFile[] file){
////        return customerService.addCustomer(customer);
//
//        //we have to add try-catch block cus uploadImage method throws IOException.
//        try {
//            Set<ImageModel> images = uploadImage(file);
//            customer.setCustomerImages(images);
//            return customerService.addCustomer(customer);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }

//    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
//        //We have used set of image model, so we have to use set
//        Set<ImageModel> imageModels = new HashSet<>();
//
//        for(MultipartFile file: multipartFiles){
//          ImageModel imageModel = new ImageModel(
//              file.getOriginalFilename(),
//              file.getContentType(),
//              file.getBytes()
//            );
//
//          //the model is added to the set defined above.
//          imageModels.add(imageModel);
//        }
//
//        return imageModels;
//    }



//    @DeleteMapping("/customers/{id}")
//    public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable Long id){
//        Customer customer = customerRepo.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee doesn't exist with id: "+ id));
//
//        customerRepo.delete(customer);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted",Boolean.TRUE);
//        return ResponseEntity.ok(response);
//    }


//    //delete customer by ID
//    @DeleteMapping("/customers/{id}")
//    public String deleteCustomerById(@PathVariable("id") Long id){
//        return customerService.deleteCustomerById(id)   ;
//    }


//    //image upload
//    public ResponseEntity<ImageUploadResponse>uploadImage(@RequestParam("image")MultipartFile file) throws IOException{
//        customerService.sav
//    }