package main.playground;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


public class StreamsReduction {


    public static void main(String[] args) {
        Map<String, Map<String, Object>> categoriesMap = Map.of(
                "QA-30", Map.of(
                        "paths", List.of("JDProducts/Parts/tillageparts/QA-30"),
                        "channelCode", "Ecommerce",
                        "categoryName", Map.of(),
                        "parentCategoryCodes", List.of("tillageparts")
                ),
                "qa-25k-new", Map.of(
                        "paths", List.of("JDProducts/Parts/tillageparts/qa-25k-new"),
                        "channelCode", "Ecommerce",
                        "categoryName", Map.of(
                                "en-CA", "QA 25k new",
                                "en-GB", "QA 25k new",
                                "en-US", "QA 25k new"
                        ),
                        "parentCategoryCodes", List.of("tillageparts")
                ),
                "ClutchesComponents", Map.of(
                        "paths", List.of("JDProducts/Parts/DrivetrainParts/ClutchesComponents"),
                        "channelCode", "Ecommerce",
                        "categoryName", Map.of(
                                "en-CA", "Clutches Assemblies & Parts ",
                                "en-US", "Clutches Assemblies & Parts ",
                                "fr-CA", "Composants des embrayages",
                                "pt-BR", "Embreagens e Componentes"
                        ),
                        "parentCategoryCodes", List.of("DrivetrainParts")
                )
        );

        List<String> catNameList = new ArrayList<>();
        for (Map.Entry<String, Map<String, Object>> entry : categoriesMap.entrySet()) {
            if (Objects.nonNull(entry.getValue())) {
                if (entry.getValue().containsKey("categoryName")) {
                    Map<String, String> categoryNameMap = (Map<String, String>) entry.getValue().get("categoryName");
                    if (Objects.nonNull(categoryNameMap)) {
                        String categoryName = categoryNameMap.get("en-US");
                        if(Objects.nonNull(categoryName) && !categoryName.isEmpty()) {
                            catNameList.add(categoryName);
                        }
                    }
                }
            }
        }

        List<String> categoryNames = categoriesMap.values().stream()
                .filter(Objects::nonNull)
                .map(category -> (Map<String, String>) category.get("categoryName"))
                .filter(Objects::nonNull)
                .map(categoryNameMap -> categoryNameMap.get("en-US"))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());


        List<String> categoryRelationsList = categoriesMap.values().stream()
                .filter(Objects::nonNull)
                .map(category -> (List<String>) category.get("paths"))
                .flatMap(List::stream)
                .map(path -> getCategoryRelation(path))
                .collect(Collectors.toList());

        System.out.println(formatMultiValuedFieldsList(categoryRelationsList));
    }

    public static String getCategoryRelation(String path) {
        if (Objects.isNull(path) || path.isEmpty()) {
            return "";
        }

        int beginIndex = path.lastIndexOf("/", path.lastIndexOf("/") - 1) + 1;
        return path.substring(beginIndex);
    }

    public static String formatMultiValuedFieldsList(List<String> categoryRelationsList) {
        return categoryRelationsList.stream()
                .filter(path -> Objects.nonNull(path) && !path.isEmpty())
                .collect(Collectors.joining("|"));
    }
}
