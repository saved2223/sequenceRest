package com.example.sequencerest.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DataService {
    private final ArrayList<Integer> sourceData = new ArrayList<>();

    public void readFile(String filePath){
        try {
            BufferedReader in = new BufferedReader(new FileReader(filePath));
            String s;
            while ((s = in.readLine()) !=null){
                this.sourceData.add(Integer.parseInt(s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Integer findMax(){
        return Collections.max(this.sourceData);
    }

    public Integer findMin(){
        return Collections.min(this.sourceData);
    }

    public Integer findMedian(){
      return this.sourceData.stream()
               .sorted()
               .collect(Collectors.collectingAndThen(
                       Collectors.toList(),
                       values ->{
                           int count = values.size();
                           if(count % 2 == 0){
                               return (values.get(count/2 -1)) + values.get(count/2)/2;
                           }
                           else {
                               return values.get(count/2);
                           }
                       }
               ));
    }

    public Double findAvg(){
        return this.sourceData.stream()
                .mapToInt(value -> value)
                .average().orElse(0);
    }

    private boolean compareInCaseOfOrder(int v1, int v2, String order){
        return switch (order) {
            case "asc" -> v1 > v2;
            case "desc" -> v1 < v2;
            default -> false;
        };
    }

    public List<Stack<Integer>> findLongestSequence(String order){
        if(this.sourceData.size() == 1){
            Stack<Integer> resultStack = new Stack<>();
            resultStack.push(this.sourceData.get(0));
            List<Stack<Integer>> resultList = new ArrayList<>();
            resultList.add(resultStack);
            return resultList;
        }

        @AllArgsConstructor
        class SequenceWrapper{
            @Getter
            public Stack<Integer> values;
            @Getter
            public Integer length;
        }
        List<SequenceWrapper> subSequences = new ArrayList<>();
        Stack<Integer> sequence = new Stack<>();
        sequence.push(this.sourceData.get(0));
        for(Integer val: this.sourceData.subList(1, this.sourceData.size())){
            if(compareInCaseOfOrder(val, sequence.peek(), order)){
                sequence.push(val);
                if(val.equals(this.sourceData.get(this.sourceData.size()-1))){
                    Stack<Integer> stackToAdd = new Stack<>();
                    stackToAdd.addAll(sequence);
                    subSequences.add(new SequenceWrapper(stackToAdd, sequence.size()));
                }
            }
            else {
                Stack<Integer> stackToAdd = new Stack<>();
                stackToAdd.addAll(sequence);
                subSequences.add(new SequenceWrapper(stackToAdd, sequence.size()));
                sequence.clear();
                sequence.push(val);
            }
        }
        Integer maxLength = Collections.max(subSequences, Comparator.comparing(SequenceWrapper::getLength)).getLength();
        return subSequences.stream()
                .filter(
                        s -> Objects.equals(s.getLength(), maxLength))
                .map(SequenceWrapper::getValues)
                .collect(Collectors.toList());
    }

}
