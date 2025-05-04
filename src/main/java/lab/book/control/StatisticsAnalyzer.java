package lab.book.control;

import lab.book.entity.Magazine;
import lab.book.entity.Novel;
import lab.book.entity.Publication;
import lab.book.entity.ReferenceBook;

import java.util.HashMap;
import java.util.Map;

public class StatisticsAnalyzer {

    public Map<String,Double> calculateAveragePriceByType(Publication[] publications){
        Map<String,Double> priceMap=new HashMap<>();
        Map<String,Integer> cntMap=new HashMap<>();

        for (Publication pub : publications) {
            String pubType = getPublicationType(pub);

            double totalPrice = priceMap.getOrDefault(pubType, 0.0);
            int count = cntMap.getOrDefault(pubType, 0);

            priceMap.put(pubType, totalPrice + pub.getPrice());
            cntMap.put(pubType, count + 1);
        }

        Map<String, Double> averageMap = new HashMap<>();
        for (String type : priceMap.keySet()) {
            double total = priceMap.get(type);
            int count = cntMap.get(type);
            if (count > 0) {
                averageMap.put(type, total / count);
            }
        }

        return averageMap;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> countMap = new HashMap<>();

        for (Publication pub : publications) {
            String pubType = getPublicationType(pub);
            countMap.put(pubType, countMap.getOrDefault(pubType, 0) + 1);
        }

        int total = publications.length;

        Map<String, Double> percentageMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            String type = entry.getKey();
            int count = entry.getValue();
            double percentage = (count * 100.0) / total;
            percentageMap.put(type, percentage);
        }

        return percentageMap;
    }

    public double calculatePublicationRatioByYear(Publication[] publications, String year){
        int cnt=0;
        for(Publication pub:publications){
            String pubYear=pub.getPublishDate().split("-")[0];
            if(pubYear.equals(year)) cnt++;
        }
        return (double) cnt /publications.length*100;
    }

    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) return "소설";
        if (pub instanceof Magazine) return "잡지";
        if (pub instanceof ReferenceBook) return "참고서";
        return "기타";
    }


}
