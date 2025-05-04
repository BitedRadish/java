package lab.book.control;

import lab.book.entity.Magazine;
import lab.book.entity.Novel;
import lab.book.entity.Publication;
import lab.book.entity.ReferenceBook;

import java.util.Map;

public class ManageBook {

    public static void main(String[] args) {
        // 1️⃣ 출판물 배열 생성 및 초기화
        Publication[] publications = new Publication[] {
                new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월"),
                new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"),
                new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"),
                new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"),
                new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학"),
                new Novel("소년이온다", "2014-05-01", 216, 15000, "한강", "장편소설"),
                new Novel("작별하지않는다", "2021-09-09", 332, 15120, "한강", "장편소설")
        };

        // 2️⃣ 출판물 정보 출력
        System.out.println("==== 도서 정보 출력 ====");
        for (int i = 0; i < publications.length; i++) {
            System.out.println((i + 1) + ". " + publications[i]);
        }

        // 3️⃣ 3번째 도서 가격 변경
        Publication target = publications[2];
        int oldPrice = target.getPrice();
        modifyPrice(target);
        int newPrice = target.getPrice();
        int diff = oldPrice - newPrice;

        System.out.println("\n==== 가격 변경 ====");
        System.out.printf("%s 변경 전 가격: %,d원\n", target.getTitle(), oldPrice);
        System.out.printf("%s 변경 후 가격: %,d원\n", target.getTitle(), newPrice);
        System.out.printf("차액: %,d원\n", diff);

        // 4️⃣ 통계 분석 실행
        StatisticsAnalyzer analyzer = new StatisticsAnalyzer();
        Map<String, Double> avgPrice = analyzer.calculateAveragePriceByType(publications);
        Map<String, Double> distribution = analyzer.calculatePublicationDistribution(publications);
        double year2007Ratio = analyzer.calculatePublicationRatioByYear(publications, "2007");

        System.out.println("\n===== 출판물 통계 분석 =====");
        System.out.println("1. 타입별 평균 가격:");
        avgPrice.forEach((type, avg) -> System.out.printf("   - %s: %,.0f원\n", type, avg));

        System.out.println("\n2. 출판물 유형 분포:");
        distribution.forEach((type, percent) -> System.out.printf("   - %s: %.2f%%\n", type, percent));

        System.out.printf("\n3. 2007년에 출판된 출판물 비율: %.2f%%\n", year2007Ratio);
        System.out.println("=============================");
    }

    // 5️⃣ modifyPrice 메서드
    public static void modifyPrice(Publication pub) {
        int price = pub.getPrice();
        if (pub instanceof Magazine) {
            pub.setPrice((int)(price * 0.6));  // 40% 할인
        } else if (pub instanceof Novel) {
            pub.setPrice((int)(price * 0.8));  // 20% 할인
        } else if (pub instanceof ReferenceBook) {
            pub.setPrice((int)(price * 0.9));  // 10% 할인
        }
    }
}
