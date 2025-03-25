package main.playground;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsLoopingChecks {
    public static void main(String[] args) {
        List<String> paths = Arrays.asList("home/usera/docs", "home/userb/music", "home");

//        intermediateMethods(paths);
        terminalMethodsInvocation(paths);
    }

    private static void intermediateMethods(List<String> paths) {
        Set<String> splitVals = paths.stream()
                .map(path -> {
                    System.out.println("Mapping: " + path);
                    return path.split("/");
                })
                .filter(hierarchy -> {
                    System.out.println("Filtering: " + Arrays.toString(hierarchy));
                    return hierarchy.length > 1;
                })
                .map(hierarchy -> {
                    System.out.println("Mapping to second last: " + Arrays.toString(hierarchy));
                    return hierarchy[hierarchy.length - 2];
                })
                .collect(Collectors.toSet());

        System.out.println(splitVals);
    }

    private static void terminalMethodsInvocation(List<String> paths) {
        paths.stream()
                .map(path -> {
                    System.out.println("Mapping: " + path);
                    return path.split("/");
                })
                .filter(hierarchy -> {
                    System.out.println("Filtering: " + Arrays.toString(hierarchy));
                    return hierarchy.length > 1;
                })
                .map(hierarchy -> {
                    System.out.println("Mapping to second last: " + Arrays.toString(hierarchy));
                    return hierarchy[hierarchy.length - 2];
                })
                .collect(Collectors.toList())
                .forEach(s -> System.out.println("Processed: " + s));
    }
}
