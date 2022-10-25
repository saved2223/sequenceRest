package com.example.sequencerest.controller;

import com.example.sequencerest.service.DataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DataController {

    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @PutMapping(value = "/enterPath")
    public void enterPath(@RequestParam String filePath){
        dataService.readFile(filePath);
    }

    @GetMapping(value = "/getMinValue")
    public ResponseEntity<String> getMinValue(){
        return ResponseEntity.ok("min value: " + dataService.findMin());
    }

    @GetMapping(value = "/getMaxValue")
    public ResponseEntity<String> getMaxValue(){
        return ResponseEntity.ok("max value: " + dataService.findMax());
    }

    @GetMapping(value = "/getMedian")
    public ResponseEntity<String> getMedian(){
        return ResponseEntity.ok("median: " + dataService.findMedian());
    }

    @GetMapping(value = "/getAverage")
    public ResponseEntity<String> getAvg(){
        return ResponseEntity.ok( "average: " +dataService.findAvg());
    }

    @GetMapping(value = "/getLongestAscendingSequence")
    public ResponseEntity<String> getLongestAscendingSequence(){
        return ResponseEntity.ok( "longest ascending sequence: " + dataService.findLongestSequence("asc"));
    }

    @GetMapping(value = "/getLongestDescendingSequence")
    public ResponseEntity<String> getLongestDescendingSequence(){
        return ResponseEntity.ok("longest descending sequence: " + dataService.findLongestSequence("desc"));
    }

}
