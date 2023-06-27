package assignments;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10_000_000_000_000L;
    private String processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    static List<String> stringArrayList = new ArrayList<>();

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, List<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        LocalProcessor.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listiterator(LinkedList<String> stringList) {
        stringArrayList = new ArrayList<>(stringList);
        for (String el : stringArrayList) {
            System.out.println(el.hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullnameProcessorgenerator(LinkedList<String> stringList) {
        StringBuilder stringBuilder = new StringBuilder(processorName);
        for (String el : stringList) {
            stringBuilder.append(el);
            stringBuilder.append(' ');
        }
        return stringBuilder.toString();
    }

    @ReadFullProcessorNameAnnotation
    public void readfullprocessorname(File file) {
        try {
            informationScanner = new Scanner(file);
            StringBuilder sb = new StringBuilder();
            while (informationScanner.hasNext()) {
                sb.append(informationScanner.nextLine());
            }
            processorName = sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            informationScanner.close();
        }
    }
}
