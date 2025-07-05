package com.july.mymall.commodityservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpecCombinationGenerator {
    /**
     * 生成所有规格组合（如颜色+尺寸的笛卡尔积）
     * @param specOptions 规格选项列表，如[{"颜色":["红","蓝"]},{"尺寸":["S","M","L"]}]
     * @return 规格组合列表，如[{"颜色":"红","尺寸":"S"}, {"颜色":"红","尺寸":"M"}, ...]
     */
    public static List<Map<String, String>> generateCombinations(List<Map<String, List<String>>> specOptions) {
        List<Map<String, String>> result = new ArrayList<>();
        if (specOptions.isEmpty()) {
            return result;
        }

        // 递归生成笛卡尔积
        generate(specOptions, 0, new HashMap<>(), result);
        return result;
    }

    private static void generate(List<Map<String, List<String>>> specOptions, int index,
                                 Map<String, String> current, List<Map<String, String>> result) {
        if (index == specOptions.size()) {
            result.add(new HashMap<>(current));
            return;
        }

        Map<String, List<String>> spec = specOptions.get(index);
        String specName = spec.keySet().iterator().next();
        List<String> values = spec.get(specName);

        for (String value : values) {
            current.put(specName, value);
            generate(specOptions, index + 1, current, result);
            current.remove(specName);
        }
    }
}
