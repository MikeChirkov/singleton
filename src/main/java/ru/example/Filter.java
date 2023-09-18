package ru.example;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем фильтрацию");
        List<Integer> result = new ArrayList<>();
        source.forEach(
                val -> {
                    if (val > threshold) {
                        result.add(val);
                        logger.log("Элемент \"" + val + "\" проходит");
                    } else {
                        logger.log("Элемент \"" + val + "\" не проходит");
                    }
                }
        );
        logger.log(String.format("Прошло фильтр %d элемента из %d", result.size(), source.size()));
        return result;
    }
}
