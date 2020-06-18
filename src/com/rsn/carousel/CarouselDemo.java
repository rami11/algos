package com.rsn.carousel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarouselDemo {

    private List<Integer> elements;
    private Integer mainElement;
    private List<Integer> thumbnailList;

    public CarouselDemo(List<Integer> elements) {
        thumbnailList = new ArrayList<>();
        this.elements = new ArrayList<>(elements);

        // first rotation
        System.out.println(this.elements);
        rotateRight();
        System.out.println("First rotation");
        System.out.println("Main Element: " + mainElement);
        System.out.println("Thumbnail List:");
        System.out.println(thumbnailList);

        System.out.println();

        // second rotation
        System.out.println(this.elements);
        rotateRight();
        System.out.println("Second rotation");
        System.out.println("Main Element: " + mainElement);
        System.out.println("Thumbnail List:");
        System.out.println(thumbnailList);
    }

    public static void main(String[] args) {
        /*CarouselDemo demo = new CarouselDemo(Arrays.asList(1, 2, 3, 4, 5, 6));*/
        CarouselDemo demo = new CarouselDemo(Arrays.asList(1, 2));
    }

    public void rotateRight() {
        if (elements == null || elements.isEmpty()) {
            mainElement = -1;
            thumbnailList = Collections.emptyList();
            return;
        }
        Integer head = elements.get(0);
        mainElement = head;
        elements.remove(head);
        elements.add(head);

        thumbnailList.clear();

        for (int i = 0; i < 4 && i < elements.size(); i++) {
            Integer el = elements.get(i);
            if (!el.equals(mainElement)) {
                thumbnailList.add(el);
            }
        }
    }
}
