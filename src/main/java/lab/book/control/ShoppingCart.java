package lab.book.control;

import lab.book.entity.Magazine;
import lab.book.entity.Novel;
import lab.book.entity.Publication;
import lab.book.entity.ReferenceBook;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Publication> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Publication Item){
        items.add(Item);
        System.out.println(Item.getTitle()+"을 장바구니에 추가했습니다.");
    }

    public void removeItem(String title){
        boolean isRemoved=items.removeIf(item->item.getTitle().equals(title));

        if(isRemoved){
            System.out.println(title+"을 장바구니에서 제거하였습니다.");
        }else{
            System.out.println(title+"을 장바구니에서 찾지 못했습니다.");
        }
    }

    public void displayCart(){
        items.forEach(item-> System.out.println(item.toString()));
    }

    public int calculateTotalPrice(){
        int total=items.stream().mapToInt(Publication::getPrice).sum();

        return total;
    }

    public int calculateDiscountedPrice() {
        int total = 0;

        for (Publication item : items) {
            double discount = 1.0;

            if (item instanceof Magazine) {
                discount = 0.9;
            } else if (item instanceof Novel) {
                discount = 0.85;
            } else if (item instanceof ReferenceBook) {
                discount = 0.8;
            }

//            item.getPrice()*discount는 double로 처리됨.
            total += (int)(item.getPrice() * discount);
        }

        return total;
    }

    public void printStatistics() {
        int magazineCount = 0;
        int novelCount = 0;
        int referenceBookCount = 0;
        int otherCount = 0;

        for (Publication item : items) {
            if (item instanceof Magazine) {
                magazineCount++;
            } else if (item instanceof Novel) {
                novelCount++;
            } else if (item instanceof ReferenceBook) {
                referenceBookCount++;
            } else {
                otherCount++;
            }
        }

        System.out.println("장바구니 통계:");
        System.out.println("Magazine 수량: " + magazineCount);
        System.out.println("Novel 수량: " + novelCount);
        System.out.println("ReferenceBook 수량: " + referenceBookCount);
        System.out.println("기타 수량: " + otherCount);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // 다양한 출판물 추가
        cart.addItem(new Magazine("Vogue", "2024-05", 120, 12000, "Monthly"));
        cart.addItem(new Novel("빠삐용", "1970-03", 500, 15000, "Henri Charrière", "Biography"));
        cart.addItem(new ReferenceBook("Java Programming", "2022-09", 800, 35000, "Computer Science"));
        cart.addItem(new Novel("빠삐용", "1970-03", 500, 15000, "Henri Charrière", "Biography"));
        cart.addItem(new Magazine("National Geographic", "2024-04", 100, 13000, "Monthly"));

        // 장바구니 내용 출력
        System.out.println("\n=== 장바구니 내용 ===");
        cart.displayCart();

        // 총 가격 출력
        int totalPrice = cart.calculateTotalPrice();
        System.out.println("\n총 가격: " + totalPrice + "원");

        // 할인 적용된 가격 출력
        int discountedPrice = cart.calculateDiscountedPrice();
        System.out.println("할인 적용 가격: " + discountedPrice + "원");

        // 통계 출력
        System.out.println("\n=== 장바구니 통계 ===");
        cart.printStatistics();

        // '빠삐용' 항목 제거
        cart.removeItem("빠삐용");

        // 변경된 장바구니 내용 다시 출력
        System.out.println("\n=== 변경된 장바구니 내용 ===");
        cart.displayCart();
    }

}
