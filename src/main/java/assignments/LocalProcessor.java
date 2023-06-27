package assignments;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

@Getter
@Setter
public class LocalProcessor {
    public static LinkedList<String> stringArrayList = new LinkedList<>();
    private static String ProcessorVersion;
    private Scanner informationscanner;
    private String processorName;
    private Long period = 10_000_000_000_000L;
    private Integer valueofCheap;

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationscanner, LinkedList<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        ProcessorVersion = processorVersion;
        this.valueofCheap = valueOfCheap;
        this.informationscanner = informationscanner;
        LocalProcessor.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listiterator(LinkedList<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        for (String el : stringArrayList) {
            System.out.println(el.hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullnameProcessorgenerator(LinkedList<String> stringList) {
        StringBuilder stringBuilder = new StringBuilder(processorName);
        for (String el: stringList) {
            stringBuilder.append(" ").append(el);
        }
        return stringBuilder.toString();
    }

    @ReadFullProcessorNameAnnotation
    public void readfullprocessorname(File file) throws FileNotFoundException {
        informationscanner = new Scanner(file);
        StringBuilder stringBuilder = new StringBuilder(ProcessorVersion);
        while (informationscanner.hasNext()) {
            stringBuilder.append(informationscanner.nextLine());
        }
        ProcessorVersion = stringBuilder.toString();
    }
}
